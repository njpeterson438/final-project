package finalp.project.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bulk_aging")
public class BulkAging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bulk_aging_id", nullable = false)
    private Long bulkAgingId; // Synthetic primary key

    @ManyToOne
    @JoinColumn(name = "vinification_id", nullable = false)
    private Vinification vinification; // Reference to vinification

    @Column(name = "capacity_gallons", nullable = false)
    private Double capacityGallons = 5.0; // Default to 5 gallons

    @Column(name = "start_date")
    private LocalDate startDate; // Start date of aging

    @Column(name = "notes")
    private String notes; // Optional notes

    // Getters and Setters
    public Long getBulkAgingId() {
        return bulkAgingId;
    }

    public void setBulkAgingId(Long bulkAgingId) {
        this.bulkAgingId = bulkAgingId;
    }

    public Vinification getVinification() {
        return vinification;
    }

    public void setVinification(Vinification vinification) {
        this.vinification = vinification;
    }

    public Double getCapacityGallons() {
        return capacityGallons;
    }

    public void setCapacityGallons(Double capacityGallons) {
        this.capacityGallons = capacityGallons;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}