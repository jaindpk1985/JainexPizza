package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOPPINGS")
public class ToppingInfo implements Serializable {
	private Long toppingId;

	private String toppingName;

	private int toppingBasePrice;

	private Boolean isVeg;

	@Column(name = "TOPPING_BASE_PRICE", nullable = false)
	public int getToppingBasePrice() {
		return toppingBasePrice;
	}

	@Id
	@Column(name = "TOPPING_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getToppingId() {
		return toppingId;
	}

	@Column(name = "TOPPING_NAME", nullable = false)
	public String getToppingName() {
		return toppingName;
	}

	public void setToppingBasePrice(int toppingBasePrice) {
		this.toppingBasePrice = toppingBasePrice;
	}

	public void setToppingId(Long toppingId) {
		this.toppingId = toppingId;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}

	@Column(name = "TOPPING_IS_VEG", nullable = false)
	public Boolean getIsVeg() {
		return isVeg;
	}

	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}

}
