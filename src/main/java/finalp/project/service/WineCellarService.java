package finalp.project.service;

import finalp.project.dao.WineCellarDao;
import finalp.project.dao.VinificationDao;
import finalp.project.dao.VinificationBlendDao;
import finalp.project.entity.WineCellar;
import finalp.project.entity.Vinification;
import finalp.project.entity.VinificationBlend;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineCellarService {

    private final WineCellarDao wineCellarDao;
    private final VinificationDao vinificationDao;
    private final VinificationBlendDao vinificationBlendDao;

    public WineCellarService(WineCellarDao wineCellarDao, VinificationDao vinificationDao, VinificationBlendDao vinificationBlendDao) {
        this.wineCellarDao = wineCellarDao;
        this.vinificationDao = vinificationDao;
        this.vinificationBlendDao = vinificationBlendDao;
    }

    public WineCellar saveWineCellar(WineCellar wineCellar) {
        if (wineCellar.getVinification() == null) {
            // Handle blended wine
            double blendedAlcoholPercentage = calculateBlendedAlcoholPercentage(wineCellar.getBottleId());
            wineCellar.setAlcoholPercentage(blendedAlcoholPercentage);
        } else {
            // Single-variety wine
            Vinification vinification = vinificationDao.findById(wineCellar.getVinification().getVinificationId())
                    .orElseThrow(() -> new RuntimeException(
                            "Vinification record not found for ID: " + wineCellar.getVinification().getVinificationId()));
            wineCellar.setAlcoholPercentage(vinification.getAlcoholPercentage());
        }

        return wineCellarDao.save(wineCellar);
    }

    private double calculateBlendedAlcoholPercentage(String bottleId) {
        List<VinificationBlend> blends = vinificationBlendDao.findByBottleId(bottleId);
        if (blends.isEmpty()) {
            throw new RuntimeException("No blends found for Bottle ID: " + bottleId);
        }

        double blendedAlcohol = 0.0;

        for (VinificationBlend blend : blends) {
            Vinification vinification = blend.getVinification();
            blendedAlcohol += (blend.getPercentage() / 100.0) * vinification.getAlcoholPercentage();
        }

        return Math.round(blendedAlcohol * 100.0) / 100.0; // Round to 2 decimals
    }

    public List<WineCellar> getAllWineCellars() {
        return wineCellarDao.findAll();
    }

    public WineCellar getWineCellarById(String bottleId) {
        return wineCellarDao.findById(bottleId).orElseThrow(() -> new RuntimeException("Bottle not found: " + bottleId));
    }

    public List<WineCellar> saveAllWineCellars(List<WineCellar> wineCellars) {
        wineCellars.forEach(this::saveWineCellar); // Use the existing save logic for each WineCellar
        return wineCellarDao.saveAll(wineCellars);
    }
    
    public WineCellar updateWineCellar(String bottleId, WineCellar updatedWineCellar) {
        WineCellar existingWineCellar = wineCellarDao.findById(bottleId)
                .orElseThrow(() -> new RuntimeException("Bottle not found: " + bottleId));

        // Update the properties
        existingWineCellar.setBottleVolume(updatedWineCellar.getBottleVolume());
        existingWineCellar.setVinification(updatedWineCellar.getVinification());

        // Fetch the related vinification record to calculate ABV
        if (updatedWineCellar.getVinification() != null) {
            Vinification vinification = vinificationDao.findById(updatedWineCellar.getVinification().getVinificationId())
                    .orElseThrow(() -> new RuntimeException("Vinification not found: " + updatedWineCellar.getVinification().getVinificationId()));

            // Recalculate the alcohol percentage
            double startingBrix = vinification.getBrix();
            double abvFromBrix = startingBrix * 0.55;
            double poundsSugarAdded = vinification.getPoundsSugarAdded();
            double gallonsWine = vinification.getGallons();
            double abvFromSugar = (poundsSugarAdded / gallonsWine) * 1.0;

            double alcoholPercentage = abvFromBrix + abvFromSugar;
            existingWineCellar.setAlcoholPercentage(Math.round(alcoholPercentage * 100.0) / 100.0);
        }

        return wineCellarDao.save(existingWineCellar);
    }
    
    public void deleteWineCellar(String bottleId) {
        WineCellar existingWineCellar = wineCellarDao.findById(bottleId)
                .orElseThrow(() -> new RuntimeException("Bottle not found: " + bottleId));
        wineCellarDao.delete(existingWineCellar);
    }
}
