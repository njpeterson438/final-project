package finalp.project.controller.model;

import finalp.project.entity.VinificationBlend;
import finalp.project.service.VinificationBlendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vinification-blends")
public class VinificationBlendController {

    private final VinificationBlendService vinificationBlendService;

    public VinificationBlendController(VinificationBlendService vinificationBlendService) {
        this.vinificationBlendService = vinificationBlendService;
    }

    @GetMapping
    public List<VinificationBlend> getAllVinificationBlends() {
        return vinificationBlendService.getAllVinificationBlends();
    }

    @GetMapping("/{vinificationBlendId}")
    public ResponseEntity<VinificationBlend> getVinificationBlendById(@PathVariable String vinificationBlendId) {
        try {
            VinificationBlend vinificationBlend = vinificationBlendService.getVinificationBlendById(vinificationBlendId);
            return ResponseEntity.ok(vinificationBlend);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<List<VinificationBlend>> saveVinificationBlends(@RequestBody List<VinificationBlend> vinificationBlends) {
        vinificationBlends.forEach(blend -> 
            System.out.println("Processing blend: " + blend.getVinificationBlendId() + ", " +
                               "Bottle ID: " + blend.getWineCellar().getBottleId() + ", " +
                               "Vinification ID: " + blend.getVinification().getVinificationId() + ", " +
                               "Percentage: " + blend.getPercentage()));
        return ResponseEntity.ok(vinificationBlendService.saveAllVinificationBlends(vinificationBlends));
    }

    @PostMapping("/single")
    public ResponseEntity<VinificationBlend> saveSingleVinificationBlend(@RequestBody VinificationBlend vinificationBlend) {
        return ResponseEntity.ok(vinificationBlendService.saveVinificationBlend(vinificationBlend));
    }

    @DeleteMapping("/{vinificationBlendId}")
    public void deleteVinificationBlend(@PathVariable String vinificationBlendId) {
        vinificationBlendService.deleteVinificationBlend(vinificationBlendId);
    }
}
