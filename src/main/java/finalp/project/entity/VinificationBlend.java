package finalp.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "vinification_blend")
public class VinificationBlend {

    @Id
    @Column(name = "vinification_blend_id", length = 50, nullable = false)
    @JsonProperty("vinification_blend_id")
    private String vinificationBlendId;

    @ManyToOne
    @JoinColumn(name = "vinification_id", nullable = false)
    @JsonProperty("vinification")
    private Vinification vinification;

    @ManyToOne
    @JoinColumn(name = "bottle_id", nullable = false)
    @JsonProperty("bottle")
    private WineCellar wineCellar;

    @Column(name = "percentage", nullable = false)
    @JsonProperty("percentage")
    private Double percentage;

    // Getters and Setters
    public String getVinificationBlendId() {
        return vinificationBlendId;
    }

    public void setVinificationBlendId(String vinificationBlendId) {
        this.vinificationBlendId = vinificationBlendId;
    }

    public Vinification getVinification() {
        return vinification;
    }

    public void setVinification(Vinification vinification) {
        this.vinification = vinification;
    }

    public WineCellar getWineCellar() {
        return wineCellar;
    }

    public void setWineCellar(WineCellar wineCellar) {
        this.wineCellar = wineCellar;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

	public Object map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
