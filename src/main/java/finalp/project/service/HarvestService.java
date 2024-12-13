package finalp.project.service;

import finalp.project.dao.HarvestDao;
import finalp.project.entity.Harvest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestService {

    private final HarvestDao harvestDao;

    public HarvestService(HarvestDao harvestDao) {
        this.harvestDao = harvestDao;
    }

    public List<Harvest> getAllHarvests() {
        return harvestDao.findAll();
    }

    public Harvest getHarvestById(String harvestId) {
        return harvestDao.findById(harvestId).orElseThrow(() -> new RuntimeException("Harvest not found: " + harvestId));
    }

    public Harvest saveHarvest(Harvest harvest) {
        if (harvest.getHarvestId() == null || harvest.getHarvestId().isEmpty()) {
            throw new IllegalArgumentException("Harvest ID must be provided.");
        }
        System.out.println("Saving Harvest with ID: " + harvest.getHarvestId());
        return harvestDao.save(harvest);
    }

    public void deleteHarvest(String harvestId) {
        harvestDao.deleteById(harvestId);
    }

    public List<Harvest> saveAllHarvests(List<Harvest> harvests) {
        if (harvests == null || harvests.isEmpty()) {
            throw new IllegalArgumentException("The harvest list cannot be empty.");
        }
        
        harvests.forEach(harvest -> {
            if (harvest.getHarvestId() == null || harvest.getHarvestId().isEmpty()) {
                throw new IllegalArgumentException("Harvest ID must be provided for all records.");
            }
            System.out.println("Processing Harvest with ID: " + harvest.getHarvestId());
        });

        return harvestDao.saveAll(harvests);
    }
}
