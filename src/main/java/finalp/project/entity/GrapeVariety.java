package finalp.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GrapeVariety {

    @Id
    @JsonProperty("variety_id")
    @Column(name = "variety_id", length = 50, nullable = false)
    private String varietyId;

    @JsonProperty("variety_name")
    @Column(name = "variety_name", length = 50)
    private String varietyName;

    @JsonProperty("grape_color")
    @Column(name = "grape_color", length = 50)
    private String grapeColor;

    @JsonProperty("primary_use")
    @Column(name = "primary_use", length = 20)
    private String primaryUse;

    @JsonProperty("wine_color")
    @Column(name = "wine_color", length = 20)
    private String wineColor;

    @JsonProperty("variety_origin")
    @Column(name = "variety_origin", length = 150)
    private String varietyOrigin;

    @JsonProperty("parents")
    @Column(name = "parents", length = 150)
    private String parents;

    @JsonProperty("pseudonym_tested_as")
    @Column(name = "pseudonym_tested_as", length = 150)
    private String pseudonymTestedAs;
    
    @JsonProperty("year_released")
    @Column(name = "year_released", length = 4)
    private String yearReleased;

    @JsonProperty("harvest_season")
    @Column(name = "harvest_season", length = 50)
    private String harvestSeason;

    @JsonProperty("usda_hardiness_zone")
    @Column(name = "usda_hardiness_zone", length = 50)
    private String usdaHardinessZone;

    @JsonProperty("sulfur_sensitivity")
    @Column(name = "sulfur_sensitivity", length = 50)
    private String sulfurSensitivity;

    @JsonProperty("vine_vigor")
    @Column(name = "vine_vigor", length = 20)
    private String vineVigor;

    @JsonProperty("growth_habit")
    @Column(name = "growth_habit", length = 20)
    private String growthHabit;

    @JsonProperty("suggested_distance_between_vines")
    @Column(name = "suggested_distance_between_vines", length = 50)
    private String suggestedDistanceBetweenVines;

    @JsonProperty("vine_training_system")
    @Column(name = "vine_training_system", length = 50)
    private String vineTrainingSystem;

    @JsonProperty("bud_break")
    @Column(name = "bud_break", length = 50)
    private String budBreak;

    @JsonProperty("black_rot")
    @Column(name = "black_rot", length = 50)
    private String blackRot;

    @JsonProperty("downy_mildew")
    @Column(name = "downy_mildew", length = 50)
    private String downyMildew;

    @JsonProperty("powdery_mildew")
    @Column(name = "powdery_mildew", length = 50)
    private String powderyMildew;

    @JsonProperty("botrytis")
    @Column(name = "botrytis", length = 50)
    private String botrytis;


    // Getters and Setters
    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getGrapeColor() {
        return grapeColor;
    }

    public void setGrapeColor(String grapeColor) {
        this.grapeColor = grapeColor;
    }

    public String getPrimaryUse() {
        return primaryUse;
    }

    public void setPrimaryUse(String primaryUse) {
        this.primaryUse = primaryUse;
    }

    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    public String getVarietyOrigin() {
        return varietyOrigin;
    }

    public void setVarietyOrigin(String varietyOrigin) {
        this.varietyOrigin = varietyOrigin;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getPseudonymTestedAs() {
        return pseudonymTestedAs;
    }

    public void setPseudonymTestedAs(String pseudonymTestedAs) {
        this.pseudonymTestedAs = pseudonymTestedAs;
    }

    public String getHarvestSeason() {
        return harvestSeason;
    }

    public void setHarvestSeason(String harvestSeason) {
        this.harvestSeason = harvestSeason;
    }

    public String getUsdaHardinessZone() {
        return usdaHardinessZone;
    }

    public void setUsdaHardinessZone(String usdaHardinessZone) {
        this.usdaHardinessZone = usdaHardinessZone;
    }

    public String getSulfurSensitivity() {
        return sulfurSensitivity;
    }

    public void setSulfurSensitivity(String sulfurSensitivity) {
        this.sulfurSensitivity = sulfurSensitivity;
    }

    public String getVineVigor() {
        return vineVigor;
    }

    public void setVineVigor(String vineVigor) {
        this.vineVigor = vineVigor;
    }

    public String getGrowthHabit() {
        return growthHabit;
    }

    public void setGrowthHabit(String growthHabit) {
        this.growthHabit = growthHabit;
    }

    public String getSuggestedDistanceBetweenVines() {
        return suggestedDistanceBetweenVines;
    }

    public void setSuggestedDistanceBetweenVines(String suggestedDistanceBetweenVines) {
        this.suggestedDistanceBetweenVines = suggestedDistanceBetweenVines;
    }

    public String getVineTrainingSystem() {
        return vineTrainingSystem;
    }

    public void setVineTrainingSystem(String vineTrainingSystem) {
        this.vineTrainingSystem = vineTrainingSystem;
    }

    public String getBudBreak() {
        return budBreak;
    }

    public void setBudBreak(String budBreak) {
        this.budBreak = budBreak;
    }

    public String getBlackRot() {
        return blackRot;
    }

    public void setBlackRot(String blackRot) {
        this.blackRot = blackRot;
    }

    public String getDownyMildew() {
        return downyMildew;
    }

    public void setDownyMildew(String downyMildew) {
        this.downyMildew = downyMildew;
    }

    public String getPowderyMildew() {
        return powderyMildew;
    }

    public void setPowderyMildew(String powderyMildew) {
        this.powderyMildew = powderyMildew;
    }

    public String getBotrytis() {
        return botrytis;
    }

    public void setBotrytis(String botrytis) {
        this.botrytis = botrytis;
    }
    
    public String getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }
}
