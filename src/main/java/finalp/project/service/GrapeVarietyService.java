package finalp.project.service;

import finalp.project.dao.GrapeVarietyDao;
import finalp.project.entity.GrapeVariety;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrapeVarietyService {

    private final GrapeVarietyDao grapeVarietyDao;

    public GrapeVarietyService(GrapeVarietyDao grapeVarietyDao) {
        this.grapeVarietyDao = grapeVarietyDao;
    }

    public List<GrapeVariety> getAllGrapeVarieties() {
        return grapeVarietyDao.findAll();
    }

    public GrapeVariety getGrapeVarietyById(String varietyId) {
        return grapeVarietyDao.findById(varietyId).orElseThrow(() -> new RuntimeException("Grape variety not found: " + varietyId));
    }

    public GrapeVariety saveGrapeVariety(GrapeVariety grapeVariety) {
        return grapeVarietyDao.save(grapeVariety);
    }
    
    public List<GrapeVariety> saveAll(List<GrapeVariety> grapeVarieties) {
        return grapeVarietyDao.saveAll(grapeVarieties);
    }

    public void deleteGrapeVariety(String varietyId) {
        grapeVarietyDao.deleteById(varietyId);
    }

    public List<GrapeVariety> saveAllGrapeVarieties(List<GrapeVariety> grapeVarieties) {
        return grapeVarietyDao.saveAll(grapeVarieties);
    }
}
