package dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class PizzaOrderInfo implements Serializable {
	private Long orderId;

	private Date orderCreationDate;

	private String status;

	private boolean homeDelivery;

	private Long userId;

	private Long paymentId;

	private Long offerId;
	
	private Long deliveryAddressId;

	@Column(name = "HOME_DELIVERY")
	public boolean isHomeDelivery() {
		return homeDelivery;
	}

	@Column(name = "CREATED_DATE", nullable = false)
	public Date getOrderCreationDate() {
		return orderCreationDate;
	}

	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getOrderId() {
		return orderId;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setHomeDelivery(boolean homeDelivery) {
		this.homeDelivery = homeDelivery;
	}

	public void setOrderCreationDate(Date orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "USER_ID", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "OFFER_ID")
	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	@Column(name = "PAYMENT_ID")
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	
	@Column(name = "DELIVERY_ADDRESS_ID")
	public Long getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(Long deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

}
