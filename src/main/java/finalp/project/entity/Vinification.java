package finalp.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vinification")
public class Vinification {

    @Id
    @Column(name = "vinification_id", length = 50, nullable = false)
    @JsonProperty("vinification_id")
    private String vinificationId;

    @ManyToOne
    @JoinColumn(name = "harvest_id", nullable = false)
    @JsonProperty("harvest")
    private Harvest harvest;

    @Column(name = "wine_style", length = 50)
    @JsonProperty("wine_style")
    private String wineStyle;

    @Column(name = "gallons")
    @JsonProperty("gallons")
    private Double gallons;

    @Column(name = "ph_level")
    @JsonProperty("pH_level")
    private Double pHLevel;

    @Column(name = "must_temperature")
    @JsonProperty("must_temperature")
    private Double mustTemperature;

    @Column(name = "original_gravity")
    @JsonProperty("original_gravity")
    private Double originalGravity;

    @Column(name = "brix")
    @JsonProperty("brix")
    private Double brix;

    @Column(name = "inoculation_date")
    @JsonProperty("inoculation_date")
    private LocalDate inoculationDate;

    @Column(name = "maceration")
    @JsonProperty("maceration")
    private Boolean maceration;

    @Column(name = "chaptalization")
    @JsonProperty("chaptalization")
    private Boolean chaptalization;

    @Column(name = "pounds_sugar_added")
    @JsonProperty("pounds_sugar_added")
    private Double poundsSugarAdded;

    @Column(name = "yeast_strand", length = 50)
    @JsonProperty("yeast_strand")
    private String yeastStrand;

    @Column(name = "malolactic_fermentation")
    @JsonProperty("malolactic_fermentation")
    private Boolean malolacticFermentation;

    // Getters and Setters
    public String getVinificationId() {
        return vinificationId;
    }

    public void setVinificationId(String vinificationId) {
        this.vinificationId = vinificationId;
    }

    public Harvest getHarvest() {
        return harvest;
    }

    public void setHarvest(Harvest harvest) {
        this.harvest = harvest;
    }

    public String getWineStyle() {
        return wineStyle;
    }

    public void setWineStyle(String wineStyle) {
        this.wineStyle = wineStyle;
    }

    public Double getGallons() {
        return gallons;
    }

    public void setGallons(Double gallons) {
        this.gallons = gallons;
    }

    public Double getPHLevel() {
        return pHLevel;
    }

    public void setPHLevel(Double pHLevel) {
        this.pHLevel = pHLevel;
    }

    public Double getMustTemperature() {
        return mustTemperature;
    }

    public void setMustTemperature(Double mustTemperature) {
        this.mustTemperature = mustTemperature;
    }

    public Double getOriginalGravity() {
        return originalGravity;
    }

    public void setOriginalGravity(Double originalGravity) {
        this.originalGravity = originalGravity;
    }

    public Double getBrix() {
        return brix;
    }

    public void setBrix(Double brix) {
        this.brix = brix;
    }

    public LocalDate getInoculationDate() {
        return inoculationDate;
    }

    public void setInoculationDate(LocalDate inoculationDate) {
        this.inoculationDate = inoculationDate;
    }

    public Boolean getMaceration() {
        return maceration;
    }

    public void setMaceration(Boolean maceration) {
        this.maceration = maceration;
    }

    public Boolean getChaptalization() {
        return chaptalization;
    }

    public void setChaptalization(Boolean chaptalization) {
        this.chaptalization = chaptalization;
    }

    public Double getPoundsSugarAdded() {
        return poundsSugarAdded;
    }

    public void setPoundsSugarAdded(Double poundsSugarAdded) {
        this.poundsSugarAdded = poundsSugarAdded;
    }

    public String getYeastStrand() {
        return yeastStrand;
    }

    public void setYeastStrand(String yeastStrand) {
        this.yeastStrand = yeastStrand;
    }

    public Boolean getMalolacticFermentation() {
        return malolacticFermentation;
    }

    public void setMalolacticFermentation(Boolean malolacticFermentation) {
        this.malolacticFermentation = malolacticFermentation;
    }

	public Double getAlcoholPercentage() {
		// TODO Auto-generated method stub
		return null;
	}
}
