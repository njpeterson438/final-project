package finalp.project.controller.model;

import finalp.project.entity.Harvest;
import finalp.project.service.HarvestService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvests")
public class HarvestController {

    private final HarvestService harvestService;

    public HarvestController(HarvestService harvestService) {
        this.harvestService = harvestService;
    }

    @GetMapping
    public List<Harvest> getAllHarvests() {
        return harvestService.getAllHarvests();
    }

    @GetMapping("/{harvestId}")
    public Harvest getHarvestById(@PathVariable String harvestId) {
        return harvestService.getHarvestById(harvestId);
    }

//    Validate harvest id
    private void validateHarvest(Harvest harvest) {
        if (harvest.getHarvestId() == null || harvest.getHarvestId().isEmpty()) {
            throw new IllegalArgumentException("Harvest ID must be provided.");
        }
    }

//    Saving multiple entries
    @PostMapping
    public ResponseEntity<List<Harvest>> saveHarvests(@RequestBody List<Harvest> harvests) {
        harvests.forEach(this::validateHarvest);
        return ResponseEntity.ok(harvestService.saveAllHarvests(harvests));
    }

//    Saving a single entry
    @PostMapping("/single")
    public ResponseEntity<Harvest> saveSingleHarvest(@RequestBody Harvest harvest) {
        validateHarvest(harvest);
        return ResponseEntity.ok(harvestService.saveHarvest(harvest));
    }


    @DeleteMapping("/{harvestId}")
    public void deleteHarvest(@PathVariable String harvestId) {
        harvestService.deleteHarvest(harvestId);
    }
}
