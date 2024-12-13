package finalp.project.controller.model;

import finalp.project.entity.Vinification;
import finalp.project.service.VinificationService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vinifications")
public class VinificationController {

    private final VinificationService vinificationService;

    public VinificationController(VinificationService vinificationService) {
        this.vinificationService = vinificationService;
    }

    @GetMapping
    public List<Vinification> getAllVinifications() {
        return vinificationService.getAllVinifications();
    }

    @GetMapping("/{vinificationId}")
    public ResponseEntity<Vinification> getVinificationById(@PathVariable String vinificationId) {
        return ResponseEntity.ok(vinificationService.getVinificationById(vinificationId));
    }

    @PostMapping
    public ResponseEntity<List<Vinification>> saveVinifications(@RequestBody List<@Valid Vinification> vinifications) {
        vinifications.forEach(vinification -> {
            if (vinification.getVinificationId() == null || vinification.getVinificationId().isEmpty()) {
                throw new IllegalArgumentException("Vinification ID must be provided for all records.");
            }
        });
        return ResponseEntity.ok(vinificationService.saveAllVinifications(vinifications));
    }

    @DeleteMapping("/{vinificationId}")
    public ResponseEntity<Void> deleteVinification(@PathVariable String vinificationId) {
        vinificationService.deleteVinification(vinificationId);
        System.out.println("Deleted Vinification with ID: " + vinificationId);
        return ResponseEntity.noContent().build();
    }
}

