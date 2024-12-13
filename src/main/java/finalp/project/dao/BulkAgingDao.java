package finalp.project.dao;

import finalp.project.entity.BulkAging;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BulkAgingDao extends JpaRepository<BulkAging, Long> {

	Optional<BulkAging> findById(Long bulkAgingId);
}
