package finalp.project.service;

import finalp.project.dao.VinificationBlendDao;
import finalp.project.entity.VinificationBlend;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VinificationBlendService {

    private final VinificationBlendDao vinificationBlendDao;

    public VinificationBlendService(VinificationBlendDao vinificationBlendDao) {
        this.vinificationBlendDao = vinificationBlendDao;
    }

    public List<VinificationBlend> getAllVinificationBlends() {
        return vinificationBlendDao.findAll();
    }

    public VinificationBlend getVinificationBlendById(String vinificationBlendId) {
        return vinificationBlendDao.findById(vinificationBlendId)
            .orElseThrow(() -> new RuntimeException("Vinification Blend not found: " + vinificationBlendId));
    }
    
    public VinificationBlend saveVinificationBlend(VinificationBlend vinificationBlend) {
        if (vinificationBlend.getVinificationBlendId() == null || vinificationBlend.getVinificationBlendId().trim().isEmpty()) {
            throw new IllegalArgumentException("Vinification Blend ID must be provided.");
        }
        return vinificationBlendDao.save(vinificationBlend);
    }

    public List<VinificationBlend> saveAllVinificationBlends(List<VinificationBlend> vinificationBlends) {
        vinificationBlends.forEach(blend -> {
            if (blend.getVinificationBlendId() == null || blend.getVinificationBlendId().trim().isEmpty()) {
                throw new IllegalArgumentException("Vinification Blend ID must be provided for all records.");
            }
            System.out.println("Processing Blend ID: " + blend.getVinificationBlendId() +
                               ", Bottle ID: " + blend.getWineCellar().getBottleId() +
                               ", Vinification ID: " + blend.getVinification().getVinificationId() +
                               ", Percentage: " + blend.getPercentage());
        });
        return vinificationBlendDao.saveAll(vinificationBlends);
    }

    public void deleteVinificationBlend(String vinificationBlendId) {
        vinificationBlendDao.deleteById(vinificationBlendId);
    }
}
