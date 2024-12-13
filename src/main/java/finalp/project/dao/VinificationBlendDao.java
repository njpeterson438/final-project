package finalp.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import finalp.project.entity.VinificationBlend;

public interface VinificationBlendDao extends JpaRepository<VinificationBlend, String> {
    // Custom query using JPQL
    @Query("SELECT vb FROM VinificationBlend vb WHERE vb.wineCellar.bottleId = :bottleId")
    List<VinificationBlend> findByBottleId(@Param("bottleId") String bottleId);

    // Optional: Query for vinificationId in a similar way
    @Query("SELECT vb FROM VinificationBlend vb WHERE vb.vinification.vinificationId = :vinificationId")
    List<VinificationBlend> findByVinificationId(@Param("vinificationId") String vinificationId);
}

