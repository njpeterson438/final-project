package finalp.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "harvest")
public class Harvest {

    @Id
    @JsonProperty("harvest_id")
    @Column(name = "harvest_id", length = 50, nullable = false)
    private String harvestId;

    @JsonProperty("year")
    @Column(name = "year", nullable = false)
    private Integer year;

    @JsonProperty("variety")
    @ManyToOne
    @JoinColumn(name = "variety_id", nullable = false)
    private GrapeVariety variety;

    @JsonProperty("location")
    @Column(name = "location", length = 100)
    private String location;

    @JsonProperty("harvest_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "harvest_date")
    private java.time.LocalDate harvestDate;

    @JsonProperty("crush_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "crush_date")
    private java.time.LocalDate crushDate;

    @JsonProperty("pounds")
    @Column(name = "pounds", nullable = false)
    private Double pounds;

    // Getters and Setters
    public String getHarvestId() {
        return harvestId;
    }

    public void setHarvestId(String harvestId) {
        this.harvestId = harvestId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public GrapeVariety getVariety() {
        return variety;
    }

    public void setVariety(GrapeVariety variety) {
        this.variety = variety;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public java.time.LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(java.time.LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public java.time.LocalDate getCrushDate() {
        return crushDate;
    }

    public void setCrushDate(java.time.LocalDate crushDate) {
        this.crushDate = crushDate;
    }

    public Double getPounds() {
        return pounds;
    }

    public void setPounds(Double pounds) {
        this.pounds = pounds;
    }
}
