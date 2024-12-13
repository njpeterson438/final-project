package finalp.project.dao;

import finalp.project.entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestDao extends JpaRepository<Harvest, String> {
}
