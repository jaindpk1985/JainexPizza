package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_PIZZAS_TOPPINGS")
public class OrderPizzaToppingsInfo implements Serializable {
	private Long orderPizzaToppingsId;

	private OrderPizzasInfo orderPizzasInfo;

	private Long toppingId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_PIZZA_TOPPINGS_ID")
	public Long getOrderPizzaToppingsId() {
		return orderPizzaToppingsId;
	}

	public void setOrderPizzaToppingsId(Long orderPizzaToppingsId) {
		this.orderPizzaToppingsId = orderPizzaToppingsId;
	}

	@OneToOne
	@JoinColumn(name = "ORDER_PIZZA_ID")
	public OrderPizzasInfo getOrderPizzasInfo() {
		return orderPizzasInfo;
	}

	public void setOrderPizzasInfo(OrderPizzasInfo orderPizzasInfo) {
		this.orderPizzasInfo = orderPizzasInfo;
	}

	@Column(name = "TOPPING_ID")
	public Long getToppingId() {
		return toppingId;
	}

	public void setToppingId(Long toppingId) {
		this.toppingId = toppingId;
	}

}
