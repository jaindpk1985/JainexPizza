package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PREFERENCES")
public class UserPreferencesInfo implements Serializable {
	private Long userId;

	private Long pizzaId;

	private Long userIdPizzaId;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserIdPizzaId() {
		return userIdPizzaId;
	}

	public void setUserIdPizzaId(Long userIdPizzaId) {
		this.userIdPizzaId = userIdPizzaId;
	}

	@Column(name = "USER_ID", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "PIZZA_ID", nullable = false)
	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

}
