package action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import common.PizzaConstants;
import process.OrderProcess;

import com.opensymphony.xwork2.ActionSupport;
import common.UnexpectedException;

import dao.OrderPizzaToppingsInfo;
import dao.OrderPizzasInfo;
import dao.PizzaOrderInfo;
import dao.ToppingInfo;

public class PlaceOrderAction extends ActionSupport implements SessionAware {

	static final Logger log = Logger.getLogger(PlaceOrderAction.class);

	private PizzaOrderInfo pizzaOrderInfo;

	private OrderProcess orderProcess;

	private Map session;

	private String userRole;

	private String userFullName;

	public String execute() {

		userRole = (String) session.get("userRole");
		userFullName = (String) session.get("userFullName");
		return SUCCESS;
	}

	/**
	 * Save the ordered pizzas in the database
	 * 
	 * @return
	 * @throws
	 */
	public String placeOrder() throws UnexpectedException {
		pizzaOrderInfo = new PizzaOrderInfo();
		userRole = (String) session.get("userRole");
		Long userId = (Long) session.get("userId");
		Long customerUserId = (Long) session.get("customerUserId");
		Long deliveryAddrId = (Long) session.get("deliveryAddrId");
		if (PizzaConstants.UserRole.ROLE_CONSUMER.equals(userRole)) {
			pizzaOrderInfo.setUserId(userId);
		} else if (PizzaConstants.UserRole.ROLE_BPO.equals(userRole)) {
			pizzaOrderInfo.setUserId(customerUserId);
		}
		pizzaOrderInfo.setDeliveryAddressId(deliveryAddrId);
		pizzaOrderInfo.setOrderCreationDate(new Date());
		pizzaOrderInfo.setStatus(PizzaConstants.Order.STATUS_PLACED);

		String deliveryChoice = (String) session.get("deliveryChoice");
		if (PizzaConstants.DeliveryChoice.HOME_DELIVERY.equals(deliveryChoice)) {
			pizzaOrderInfo.setHomeDelivery(true);
		}
		orderProcess = new OrderProcess();
		try {
			orderProcess.saveUpdatePizzaOrder(pizzaOrderInfo);
			List<OrderPizzasInfo> orderedPizzaDataList = (List<OrderPizzasInfo>) session
					.get("orderedPizzaDataList");
			if (orderedPizzaDataList != null) {
				for (OrderPizzasInfo orderPizzasInfo : orderedPizzaDataList) {
					orderPizzasInfo.setOrderId(pizzaOrderInfo.getOrderId());
					orderProcess.saveUpdateOrderPizza(orderPizzasInfo);
					List<ToppingInfo> toppingsList = orderPizzasInfo
							.getTopingsList();
					if (toppingsList != null) {
						OrderPizzaToppingsInfo orderPizzaToppingsInfo;
						for (ToppingInfo toppingInfo : toppingsList) {
							orderPizzaToppingsInfo = new OrderPizzaToppingsInfo();
							orderPizzaToppingsInfo
									.setOrderPizzasInfo(orderPizzasInfo);
							orderPizzaToppingsInfo.setToppingId(toppingInfo
									.getToppingId());
							orderProcess
									.saveUpdateOrderPizzaToppingsInfo(orderPizzaToppingsInfo);
						}
					}
				}
			}
			session.remove("orderedPizzaDataList");

		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"), e);
		} catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"), e);
		}
		return SUCCESS;
	}

	public OrderProcess getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(OrderProcess orderProcess) {
		this.orderProcess = orderProcess;
	}

	public PizzaOrderInfo getPizzaOrderInfo() {
		return pizzaOrderInfo;
	}

	public void setPizzaOrderInfo(PizzaOrderInfo pizzaOrderInfo) {
		this.pizzaOrderInfo = pizzaOrderInfo;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
}
