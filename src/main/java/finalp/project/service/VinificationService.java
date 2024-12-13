package finalp.project.service;

import jakarta.validation.Valid;
import finalp.project.dao.VinificationDao;
import finalp.project.entity.Vinification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinificationService {

    private final VinificationDao vinificationDao;

    public VinificationService(VinificationDao vinificationDao) {
        this.vinificationDao = vinificationDao;
    }

    public List<Vinification> getAllVinifications() {
        return vinificationDao.findAll();
    }

    public Vinification getVinificationById(String vinificationId) {
        return vinificationDao.findById(vinificationId)
                .orElseThrow(() -> new RuntimeException("Vinification not found: " + vinificationId));
    }

    public Vinification saveVinification(Vinification vinification) {
        if (vinification.getVinificationId() == null || vinification.getVinificationId().isEmpty()) {
            throw new IllegalArgumentException("Vinification ID must be provided.");
        }
        return vinificationDao.save(vinification);
    }

    public List<Vinification> saveAllVinifications(List<Vinification> vinifications) {
        vinifications.forEach(vinification -> {
            if (vinification.getVinificationId() == null || vinification.getVinificationId().isEmpty()) {
                throw new IllegalArgumentException("Vinification ID must be provided for all records.");
            }
        });
        return vinificationDao.saveAll(vinifications);
    }

    public void deleteVinification(String vinificationId) {
        vinificationDao.deleteById(vinificationId);
    }
}

