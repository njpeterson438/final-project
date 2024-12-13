package finalp.project.controller.model;

import finalp.project.entity.BulkAging;
import finalp.project.service.BulkAgingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bulk-aging")
public class BulkAgingController {

    private final BulkAgingService bulkAgingService;

    public BulkAgingController(BulkAgingService bulkAgingService) {
        this.bulkAgingService = bulkAgingService;
    }

    @GetMapping
    public List<BulkAging> getAllBulkAging() {
        return bulkAgingService.getAllBulkAging();
    }

    @GetMapping("/{bulkAgingId}")
    public ResponseEntity<BulkAging> getBulkAgingById(@PathVariable Long bulkAgingId) {
        return ResponseEntity.ok(bulkAgingService.getBulkAgingById(bulkAgingId));
    }

    @PostMapping
    public ResponseEntity<List<BulkAging>> saveBulkAgingBatch(@RequestBody List<BulkAging> bulkAgingList) {
        return ResponseEntity.ok(bulkAgingService.saveAllBulkAging(bulkAgingList));
    }

    @DeleteMapping("/{bulkAgingId}")
    public void deleteBulkAging(@PathVariable Long bulkAgingId) {
        bulkAgingService.deleteBulkAging(bulkAgingId);
    }
}
