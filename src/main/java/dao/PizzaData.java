package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PIZZA")
public class PizzaData implements Serializable {
	private Long pizzaId;

	private String pizzaName;

	private int basePrice;

	private Boolean isVeg;

	private String pizzaImageName;

	private String description;

	private int smallPrice;

	private int mediumPrice;

	private int largePrice;

	private String status;

	@Column(name = "PIZZA_BASE_PRICE")
	public int getBasePrice() {
		return basePrice;
	}

	@Column(name = "PIZZA_IS_VEG")
	public Boolean getIsVeg() {
		return isVeg;
	}

	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}

	@Id
	@Column(name = "PIZZA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getPizzaId() {
		return pizzaId;
	}

	@Column(name = "PIZZA_IMAGE")
	public String getPizzaImageName() {
		return pizzaImageName;
	}

	@Column(name = "PIZZA_NAME", nullable = false)
	public String getPizzaName() {
		return pizzaName;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public void setPizzaImageName(String pizzaImage) {
		this.pizzaImageName = pizzaImageName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	@Column(name = "PIZZA_DESC")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public int getLargePrice() {
		return largePrice;
	}

	public void setLargePrice(int largePrice) {
		this.largePrice = largePrice;
	}

	@Transient
	public int getMediumPrice() {
		return mediumPrice;
	}

	public void setMediumPrice(int mediumPrice) {
		this.mediumPrice = mediumPrice;
	}

	@Transient
	public int getSmallPrice() {
		return smallPrice;
	}

	public void setSmallPrice(int smallPrice) {
		this.smallPrice = smallPrice;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
