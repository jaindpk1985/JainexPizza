package action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import common.PizzaConstants;
import process.OrderProcess;
import process.PizzaProcess;
import process.UserProfileProcess;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import common.UnexpectedException;

import dao.AddressInfo;
import dao.OrderPizzaToppingsInfo;
import dao.OrderPizzasInfo;
import dao.PizzaData;
import dao.PizzaOrderInfo;
import dao.ToppingInfo;

public class CustomerOrdersAction extends ActionSupport implements Preparable,
		SessionAware {

	static final Logger log = Logger.getLogger(CustomerOrdersAction.class);

	private OrderProcess orderProcess;

	private List<PizzaOrderInfo> pizzaOrderDatas;

	private PizzaOrderInfo orderInfo;

	private List<OrderPizzasInfo> orderPizzasInfoList;

	private Long orderId;

	private String userRole;

	private Long userId;

	private Long totalOrderPrice;

	private AddressInfo deliveryAddressInfo;

	private Map session;
	
	private String userFullName;

	/*
	 * Get the order data from the DB (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 * 
	 */
	public void prepare() throws UnexpectedException {

		orderProcess = new OrderProcess();
		userFullName = (String) session.get("userFullName");
		userRole = (String) session.get("userRole");
		userId = (Long) session.get("userId");

		try {
			if ("Consumer".equals(userRole) && userId != null) {
				pizzaOrderDatas = orderProcess
						.getCustomerOrdersByUserId(userId);
			} else {
				pizzaOrderDatas = orderProcess.getCustomerOrders();
			}
			if (pizzaOrderDatas != null && pizzaOrderDatas.size() > 0) {
				Collections.reverse(pizzaOrderDatas);
			}
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
	}

	/**
	 * Set the status of order as completed
	 * 
	 * @return
	 */
	public String completeOrder() throws UnexpectedException {
		try {
			if (orderId != null) {
				PizzaOrderInfo pizzaOrderInfo = orderProcess
						.getOrderInfoByOrderId(orderId);
				pizzaOrderInfo.setStatus(PizzaConstants.Order.STATUS_COMPLETED);
				orderProcess.saveUpdatePizzaOrder(pizzaOrderInfo);
			}
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		} catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
		return SUCCESS;
	}

	/**
	 * Get detail information of order
	 * 
	 * @return
	 */
	public String orderDetail() throws UnexpectedException {
		try {
			if (orderId != null) {
				orderInfo = orderProcess.getOrderInfoByOrderId(orderId);
				orderPizzasInfoList = orderProcess
						.getOrderPizzasInfoByOrderId(orderId);
				Long deliveryAddrId = orderInfo.getDeliveryAddressId();
				UserProfileProcess userProfileProcess = new UserProfileProcess();
				if (deliveryAddrId != null) {
					deliveryAddressInfo = userProfileProcess
							.findAddressInfoByAddressId(deliveryAddrId);
				}
			}
			totalOrderPrice = new Long(0);
			List<ToppingInfo> toppingInfoList = new ArrayList<ToppingInfo>();
			if (orderPizzasInfoList != null) {
				PizzaProcess pizzaProcess = new PizzaProcess();
				for (OrderPizzasInfo orderPizzasInfo : orderPizzasInfoList) {
					totalOrderPrice += orderPizzasInfo.getTotalPizzaPrice();
					PizzaData pizzaData = pizzaProcess
							.getPizzaById(orderPizzasInfo.getPizzaId());
					orderPizzasInfo.setPizzaName(pizzaData.getPizzaName());
					List<OrderPizzaToppingsInfo> orderPizzaToppingsInfoList = orderProcess
							.getOrderPizzaToppingsInfoByOrdPizzaInfo(orderPizzasInfo);
					if (orderPizzaToppingsInfoList != null) {
						toppingInfoList = new ArrayList<ToppingInfo>();
						for (OrderPizzaToppingsInfo OrderPizzaToppingsInfo : orderPizzaToppingsInfoList) {
							ToppingInfo toppingInfo = pizzaProcess
									.getToppingById(OrderPizzaToppingsInfo
											.getToppingId());
							toppingInfoList.add(toppingInfo);
						}
						orderPizzasInfo.setTopingsList(toppingInfoList);
					}

				}
			}

		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
		return SUCCESS;
	}

	public OrderProcess getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(OrderProcess orderProcess) {
		this.orderProcess = orderProcess;
	}

	public List<PizzaOrderInfo> getPizzaOrderDatas() {
		return pizzaOrderDatas;
	}

	public void setPizzaOrderDatas(List<PizzaOrderInfo> pizzaOrderDatas) {
		this.pizzaOrderDatas = pizzaOrderDatas;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public PizzaOrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(PizzaOrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public List<OrderPizzasInfo> getOrderPizzasInfoList() {
		return orderPizzasInfoList;
	}

	public void setOrderPizzasInfoList(List<OrderPizzasInfo> orderPizzasInfoList) {
		this.orderPizzasInfoList = orderPizzasInfoList;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(Long totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	public AddressInfo getDeliveryAddressInfo() {
		return deliveryAddressInfo;
	}

	public void setDeliveryAddressInfo(AddressInfo deliveryAddressInfo) {
		this.deliveryAddressInfo = deliveryAddressInfo;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

}
