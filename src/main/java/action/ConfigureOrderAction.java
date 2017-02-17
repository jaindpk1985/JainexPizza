package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import org.json.JSONObject;

import common.PizzaConstants;
import process.PizzaProcess;
import process.RatingProcess;
import process.UserPreferencesProcess;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import common.UnexpectedException;

import dao.OrderPizzasInfo;
import dao.PizzaData;
import dao.PizzaOrderInfo;
import dao.ToppingInfo;
import dao.UserPreferencesInfo;

public class ConfigureOrderAction extends ActionSupport implements
		SessionAware, Preparable {

	static final Logger log = Logger.getLogger(ConfigureOrderAction.class);

	private List<PizzaData> vegPizzas;

	private List<ToppingInfo> vegToppings;

	private PizzaProcess pizzaProcess;

	private RatingProcess ratingProcess;

	private PizzaOrderInfo pizzaOrderInfo;

	private OrderPizzasInfo orderedPizzaData;

	private List<String> sizeList;

	private List<Integer> quantityList;

	private JSONObject jsonObject;

	private List<String> deliverChoices;

	private List<OrderPizzasInfo> orderedPizzaDataList;

	private String toppings;

	private List<String> orderedPizzaNames;

	private List<Long> orderedPizzaQuantities;

	private List<Long> orderedPizzaPrices;

	private int index;

	private Long totalOrderPrice;

	private Map session;

	private String userRole;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;

	private UserPreferencesProcess userPreferencesProcess;

	private List<PizzaData> prefPizzaDataList;

	private String deliveryChoice;
	
	private String userFullName;

	/*
	 * Initialize the process classes and static data; (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() {
		ratingProcess = new RatingProcess();
		pizzaProcess = new PizzaProcess();
		userPreferencesProcess = new UserPreferencesProcess();

		sizeList = new ArrayList<String>();
		sizeList.add(PizzaConstants.Pizza.PIZZA_SMALL);
		sizeList.add(PizzaConstants.Pizza.PIZZA_MEDIUM);
		sizeList.add(PizzaConstants.Pizza.PIZZA_LARGE);
		quantityList = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			quantityList.add(i);
		}
		quantityList.add(15);
		quantityList.add(20);
		deliverChoices = new ArrayList<String>();
		deliverChoices.add(PizzaConstants.DeliveryChoice.HOME_DELIVERY);
		deliverChoices.add(PizzaConstants.DeliveryChoice.PICK_UP);
		deliveryChoice = PizzaConstants.DeliveryChoice.PICK_UP;
		userFullName = (String) session.get("userFullName");

	}

	/*
	 * Get the Pizza data, topping data and preferences data from the DB
	 * (non-Javadoc) Show the existing pizzas and toppings information
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws UnexpectedException {
		try {

			vegPizzas = pizzaProcess.getPizzaByCategory(true);
			for (PizzaData pizzaData : vegPizzas) {
				ratingProcess.setPizzaRates(pizzaData);
			}

			nonVegPizzas = pizzaProcess.getPizzaByCategory(false);

			for (PizzaData pizzaData : nonVegPizzas) {
				ratingProcess.setPizzaRates(pizzaData);
			}

			vegToppings = pizzaProcess.getToppingsByCategory(true);

			nonVegToppings = pizzaProcess.getToppingsByCategory(false);

			orderedPizzaDataList = (List<OrderPizzasInfo>) session
					.get("orderedPizzaDataList");

			totalOrderPrice = new Long(0);
			if (orderedPizzaDataList != null) {
				for (OrderPizzasInfo tempOrderedPizzaData : orderedPizzaDataList) {
					totalOrderPrice += tempOrderedPizzaData
							.getTotalPizzaPrice();
				}
			}

			userRole = (String) session.get("userRole");
			if ("Consumer".equals(userRole)) {
				Long userId = (Long) session.get("userId");

				prefPizzaDataList = new ArrayList<PizzaData>();
				List<UserPreferencesInfo> userPreferencesInfos = userPreferencesProcess
						.getUserPreferencesByUserId(userId);

				if (userPreferencesInfos != null) {
					PizzaData prefPizzaData;
					for (UserPreferencesInfo preferencesInfo : userPreferencesInfos) {
						prefPizzaData = pizzaProcess
								.getPizzaById(preferencesInfo.getPizzaId());
						prefPizzaDataList.add(prefPizzaData);
					}
				}
				for (PizzaData pizzaData : prefPizzaDataList) {
					ratingProcess.setPizzaRates(pizzaData);
				}
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
	 * Add selected pizza to the shopping cart
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String addPizzaInOrder() throws UnexpectedException {
		try {
			Long pizzaId = orderedPizzaData.getPizzaId();
			if (pizzaId != null) {
				PizzaData pizzaData = pizzaProcess.getPizzaById(pizzaId);
				orderedPizzaData.setPizzaName(pizzaData.getPizzaName());
				ratingProcess.setPizzaRates(pizzaData);
				int totalPrice = 0;
				if (PizzaConstants.Pizza.PIZZA_SMALL.equals(orderedPizzaData
						.getOrderSize())) {
					totalPrice = pizzaData.getSmallPrice();
				} else if (PizzaConstants.Pizza.PIZZA_MEDIUM
						.equals(orderedPizzaData.getOrderSize())) {
					totalPrice = pizzaData.getMediumPrice();
				} else if (PizzaConstants.Pizza.PIZZA_LARGE
						.equals(orderedPizzaData.getOrderSize())) {
					totalPrice = pizzaData.getLargePrice();
				}

				String[] toppingIds = getToppings().split(",");
				if (toppingIds != null && toppingIds.length > 0) {
					List<ToppingInfo> toppingsList = orderedPizzaData
							.getTopingsList();
					if (toppingsList == null) {
						toppingsList = new ArrayList<ToppingInfo>();
					}
					for (String topping : toppingIds) {
						if (!"".equals(topping)) {
							Long toppingId = new Long(topping);
							ToppingInfo toppingInfo = pizzaProcess
									.getToppingById(toppingId);
							toppingsList.add(toppingInfo);
							totalPrice += toppingInfo.getToppingBasePrice();
						}
					}
					orderedPizzaData.setTopingsList(toppingsList);
				}
				totalPrice = totalPrice
						* (orderedPizzaData.getQuantity()).intValue();
				orderedPizzaData.setTotalPizzaPrice(new Long(totalPrice));

			}

			orderedPizzaDataList = (List<OrderPizzasInfo>) session
					.get("orderedPizzaDataList");
			if (orderedPizzaDataList == null) {
				orderedPizzaDataList = new ArrayList<OrderPizzasInfo>();
			}

			orderedPizzaDataList.add(orderedPizzaData);

			session.put("orderedPizzaDataList", orderedPizzaDataList);
			createShoppingCartData();
		} catch (NumberFormatException e) {
			log.error("A NumberFormat exception has occured :", e);
			throw new UnexpectedException("An internal error has occured",e);
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
	 * recreate the shopping cart info after selecting pizza
	 * 
	 * @throws UnexpectedException
	 */
	public void createShoppingCartData() throws UnexpectedException {
		try {
			jsonObject = new JSONObject();
			pizzaProcess = new PizzaProcess();
			orderedPizzaNames = new ArrayList<String>();
			orderedPizzaQuantities = new ArrayList<Long>();
			orderedPizzaPrices = new ArrayList<Long>();
			totalOrderPrice = new Long(0);
			for (OrderPizzasInfo tempOrderedPizzaData : orderedPizzaDataList) {
				PizzaData pizzaData = pizzaProcess
						.getPizzaById(tempOrderedPizzaData.getPizzaId());
				orderedPizzaNames.add(pizzaData.getPizzaName());
				orderedPizzaQuantities.add(tempOrderedPizzaData.getQuantity());
				orderedPizzaPrices.add(tempOrderedPizzaData
						.getTotalPizzaPrice());
				totalOrderPrice += tempOrderedPizzaData.getTotalPizzaPrice();
			}
			jsonObject.put("orderedPizzaNames", orderedPizzaNames);
			jsonObject.put("orderedPizzaQuantities", orderedPizzaQuantities);
			jsonObject.put("orderedPizzaPrices", orderedPizzaPrices);
			jsonObject.put("orderedPizzaDataList", orderedPizzaDataList);
			jsonObject.put("totalOrderPrice", totalOrderPrice);
		} /*
			 * catch (JSONException e) { log.error("A JSON exception has occured
			 * :", e); throw new UnexpectedException("An internal error has
			 * occured",e); }
			 */catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		} catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
	}

	/**
	 * Delete the pizza from the shopping cart
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String deletePizzaInOrder() throws UnexpectedException {

		try {
			orderedPizzaDataList = (List<OrderPizzasInfo>) session
					.get("orderedPizzaDataList");
			if (orderedPizzaDataList != null) {
				orderedPizzaDataList.remove(index);
			}
			session.put("orderedPizzaDataList", orderedPizzaDataList);

			createShoppingCartData();
		} catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
		return SUCCESS;
	}

	public PizzaProcess getPizzaProcess() {
		return pizzaProcess;
	}

	public void setPizzaProcess(PizzaProcess pizzaProcess) {
		this.pizzaProcess = pizzaProcess;
	}

	public RatingProcess getRatingProcess() {
		return ratingProcess;
	}

	public void setRatingProcess(RatingProcess ratingProcess) {
		this.ratingProcess = ratingProcess;
	}

	public List<PizzaData> getVegPizzas() {
		return vegPizzas;
	}

	public void setVegPizzas(List<PizzaData> vegPizzas) {
		this.vegPizzas = vegPizzas;
	}

	public List<ToppingInfo> getVegToppings() {
		return vegToppings;
	}

	public void setVegToppings(List<ToppingInfo> vegToppings) {
		this.vegToppings = vegToppings;
	}

	public PizzaOrderInfo getPizzaOrderInfo() {
		return pizzaOrderInfo;
	}

	public void setPizzaOrderInfo(PizzaOrderInfo pizzaOrderInfo) {
		this.pizzaOrderInfo = pizzaOrderInfo;
	}

	public List<Integer> getQuantityList() {
		return quantityList;
	}

	public void setQuantityList(List<Integer> quantityList) {
		this.quantityList = quantityList;
	}

	public List<String> getSizeList() {
		return sizeList;
	}

	public void setSizeList(List<String> sizeList) {
		this.sizeList = sizeList;
	}

	public OrderPizzasInfo getOrderedPizzaData() {
		return orderedPizzaData;
	}

	public void setOrderedPizzaData(OrderPizzasInfo orderedPizzaData) {
		this.orderedPizzaData = orderedPizzaData;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public List<String> getDeliverChoices() {
		return deliverChoices;
	}

	public void setDeliverChoices(List<String> deliverChoices) {
		this.deliverChoices = deliverChoices;
	}

	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	public List<OrderPizzasInfo> getOrderedPizzaDataList() {
		return orderedPizzaDataList;
	}

	public void setOrderedPizzaDataList(
			List<OrderPizzasInfo> orderedPizzaDataList) {
		this.orderedPizzaDataList = orderedPizzaDataList;
	}

	public List<String> getOrderedPizzaNames() {
		return orderedPizzaNames;
	}

	public void setOrderedPizzaNames(List<String> orderedPizzaNames) {
		this.orderedPizzaNames = orderedPizzaNames;
	}

	public List<Long> getOrderedPizzaPrices() {
		return orderedPizzaPrices;
	}

	public void setOrderedPizzaPrices(List<Long> orderedPizzaPrices) {
		this.orderedPizzaPrices = orderedPizzaPrices;
	}

	public List<Long> getOrderedPizzaQuantities() {
		return orderedPizzaQuantities;
	}

	public void setOrderedPizzaQuantities(List<Long> orderedPizzaQuantities) {
		this.orderedPizzaQuantities = orderedPizzaQuantities;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Long getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(Long totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<PizzaData> getNonVegPizzas() {
		return nonVegPizzas;
	}

	public void setNonVegPizzas(List<PizzaData> nonVegPizzas) {
		this.nonVegPizzas = nonVegPizzas;
	}

	public List<ToppingInfo> getNonVegToppings() {
		return nonVegToppings;
	}

	public void setNonVegToppings(List<ToppingInfo> nonVegToppings) {
		this.nonVegToppings = nonVegToppings;
	}

	public List<PizzaData> getPrefPizzaDataList() {
		return prefPizzaDataList;
	}

	public void setPrefPizzaDataList(List<PizzaData> prefPizzaDataList) {
		this.prefPizzaDataList = prefPizzaDataList;
	}

	public UserPreferencesProcess getUserPreferencesProcess() {
		return userPreferencesProcess;
	}

	public void setUserPreferencesProcess(
			UserPreferencesProcess userPreferencesProcess) {
		this.userPreferencesProcess = userPreferencesProcess;
	}

	public String getDeliveryChoice() {
		return deliveryChoice;
	}

	public void setDeliveryChoice(String deliveryChoice) {
		this.deliveryChoice = deliveryChoice;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

}
