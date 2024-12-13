package finalp.project.dao;

import finalp.project.entity.Vinification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinificationDao extends JpaRepository<Vinification, String> {
}
