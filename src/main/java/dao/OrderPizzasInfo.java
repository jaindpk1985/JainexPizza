package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORDER_PIZZAS")
public class OrderPizzasInfo implements Serializable {
	private Long orderPizzaId;

	private Long orderId;

	private Long pizzaId;

	private String orderSize;

	private Long quantity;

	private Long totalPizzaPrice;

	private List<ToppingInfo> topingsList;

	private String pizzaName;

	@Column(name = "PIZZA_QUANTITY")
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Id
	@Column(name = "ORDER_PIZZAS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getOrderPizzaId() {
		return orderPizzaId;
	}

	@Column(name = "PIZZA_SIZE")
	public String getOrderSize() {
		return orderSize;
	}

	public void setOrderPizzaId(Long orderPizzaId) {
		this.orderPizzaId = orderPizzaId;
	}

	public void setOrderSize(String orderSize) {
		this.orderSize = orderSize;
	}

	@Column(name = "PIZZA_ID")
	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	@Column(name = "TOTAL_PIZZA_PRICE")
	public Long getTotalPizzaPrice() {
		return totalPizzaPrice;
	}

	public void setTotalPizzaPrice(Long totalPizzaPrice) {
		this.totalPizzaPrice = totalPizzaPrice;
	}

	@Transient
	public List<ToppingInfo> getTopingsList() {
		return topingsList;
	}

	public void setTopingsList(List<ToppingInfo> topingsList) {
		this.topingsList = topingsList;
	}

	@Column(name = "ORDER_ID")
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	@Transient
	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

}
