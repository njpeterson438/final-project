package finalp.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "wine_cellar")
public class WineCellar {

    @Id
    @Column(name = "bottle_id", length = 50, nullable = false)
    @JsonProperty("bottle_id")
    private String bottleId;

    @ManyToOne
    @JoinColumn(name = "vinification_id")
    @JsonProperty("vinification")
    private Vinification vinification;

    @Column(name = "bottle_volume")
    @JsonProperty("bottle_volume")
    private Double bottleVolume;

    @Column(name = "alcohol_percentage")
    @JsonProperty("alcohol_percentage")
    private Double alcoholPercentage;

    // Getters and Setters

    public String getBottleId() {
        return bottleId;
    }

    public void setBottleId(String bottleId) {
        this.bottleId = bottleId;
    }

    public Vinification getVinification() {
        return vinification;
    }

    public void setVinification(Vinification vinification) {
        this.vinification = vinification;
    }

    public Double getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(Double bottleVolume) {
        this.bottleVolume = bottleVolume;
    }

    public Double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(Double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }
}
