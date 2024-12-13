package finalp.project.controller.model;

import finalp.project.entity.GrapeVariety;
import finalp.project.service.GrapeVarietyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grape-varieties")
public class GrapeVarietyController {

    private final GrapeVarietyService grapeVarietyService;

    public GrapeVarietyController(GrapeVarietyService grapeVarietyService) {
        this.grapeVarietyService = grapeVarietyService;
    }

    @GetMapping
    public List<GrapeVariety> getAllGrapeVarieties() {
        return grapeVarietyService.getAllGrapeVarieties();
    }

    @GetMapping("/{varietyId}")
    public ResponseEntity<GrapeVariety> getGrapeVarietyById(@PathVariable String varietyId) {
        GrapeVariety grapeVariety = grapeVarietyService.getGrapeVarietyById(varietyId);
        return ResponseEntity.ok(grapeVariety);
    }

 // Handle a single GrapeVariety
    @PostMapping("/single")
    public GrapeVariety saveGrapeVariety(@RequestBody GrapeVariety grapeVariety) {
        return grapeVarietyService.saveGrapeVariety(grapeVariety);
    }

    // Handle a list of GrapeVariety
    @PostMapping("/list")
    public List<GrapeVariety> saveGrapeVarieties(@RequestBody List<GrapeVariety> grapeVarieties) {
        return grapeVarietyService.saveAllGrapeVarieties(grapeVarieties);
    }

    @DeleteMapping("/{varietyId}")
    public void deleteGrapeVariety(@PathVariable String varietyId) {
        grapeVarietyService.deleteGrapeVariety(varietyId);
    }
}
