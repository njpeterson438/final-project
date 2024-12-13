package finalp.project.service;

import finalp.project.dao.BulkAgingDao;
import finalp.project.entity.BulkAging;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkAgingService {

    private final BulkAgingDao bulkAgingDao;

    public BulkAgingService(BulkAgingDao bulkAgingDao) {
        this.bulkAgingDao = bulkAgingDao;
    }

    public List<BulkAging> getAllBulkAging() {
        return bulkAgingDao.findAll();
    }

    public BulkAging getBulkAgingById(Long bulkAgingId) {
        return bulkAgingDao.findById(bulkAgingId)
                .orElseThrow(() -> new RuntimeException("Bulk aging record not found: " + bulkAgingId));
    }

    public BulkAging saveBulkAging(BulkAging bulkAging) {
        return bulkAgingDao.save(bulkAging);
    }

    public void deleteBulkAging(Long bulkAgingId) {
        bulkAgingDao.deleteById(bulkAgingId);
    }

    /**
     * Save a list of BulkAging entities in a batch.
     * 
     * @param bulkAgingList List of BulkAging entities to save
     * @return List of saved BulkAging entities
     */
    public List<BulkAging> saveAllBulkAging(List<BulkAging> bulkAgingList) {
        if (bulkAgingList == null || bulkAgingList.isEmpty()) {
            throw new IllegalArgumentException("Bulk aging list cannot be empty.");
        }
        return bulkAgingDao.saveAll(bulkAgingList);
    }
}
