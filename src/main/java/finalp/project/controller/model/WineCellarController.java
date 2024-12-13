package finalp.project.controller.model;

import finalp.project.entity.WineCellar;
import finalp.project.service.WineCellarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wine-cellars")
public class WineCellarController {

    private final WineCellarService wineCellarService;

    public WineCellarController(WineCellarService wineCellarService) {
        this.wineCellarService = wineCellarService;
    }

    @GetMapping
    public List<WineCellar> getAllWineCellars() {
        return wineCellarService.getAllWineCellars();
    }

    @GetMapping("/{bottleId}")
    public WineCellar getWineCellarById(@PathVariable String bottleId) {
        return wineCellarService.getWineCellarById(bottleId);
    }

    @PostMapping
    public ResponseEntity<List<WineCellar>> saveWineCellars(@RequestBody List<WineCellar> wineCellars) {
        // Validate input: ensure each WineCellar has a non-null Bottle ID
        wineCellars.forEach(wineCellar -> {
            if (wineCellar.getBottleId() == null || wineCellar.getBottleId().isEmpty()) {
                throw new IllegalArgumentException("Bottle ID must be provided for all records.");
            }
        });

        List<WineCellar> savedWineCellars = wineCellarService.saveAllWineCellars(wineCellars);
        return ResponseEntity.ok(savedWineCellars);
    }
    
    @PutMapping("/{bottleId}")
    public ResponseEntity<WineCellar> updateWineCellar(@PathVariable String bottleId, @RequestBody WineCellar updatedWineCellar) {
        return ResponseEntity.ok(wineCellarService.updateWineCellar(bottleId, updatedWineCellar));
    }

    @DeleteMapping("/{bottleId}")
    public ResponseEntity<Void> deleteWineCellar(@PathVariable String bottleId) {
        wineCellarService.deleteWineCellar(bottleId);
        return ResponseEntity.noContent().build();
    }
}
