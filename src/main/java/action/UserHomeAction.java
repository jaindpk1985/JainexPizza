package action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import process.PizzaProcess;
import process.RatingProcess;

import com.opensymphony.xwork2.ActionSupport;
import common.UnexpectedException;

import dao.PizzaData;
import dao.ToppingInfo;

public class UserHomeAction extends ActionSupport implements SessionAware {

	static final Logger log = Logger.getLogger(UserHomeAction.class);

	private PizzaData pizzaData;

	private List<PizzaData> vegPizzas;

	private ToppingInfo toppingInfo;

	private List<ToppingInfo> vegToppings;

	private PizzaProcess pizzaProcess;

	private RatingProcess ratingProcess;

	private String userRole;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;

	private Map session;

	private String userFullName;
	/*
	 * Show the existing pizzas and topping information from the DB
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws UnexpectedException {

		ratingProcess = new RatingProcess();
		pizzaProcess = new PizzaProcess();
		userFullName = (String)session.get("userFullName");
		
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

			userRole = (String) session.get("userRole");
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}

		return SUCCESS;
	}

	public PizzaData getPizzaData() {
		return pizzaData;
	}

	public void setPizzaData(PizzaData pizzaData) {
		this.pizzaData = pizzaData;
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

	public ToppingInfo getToppingInfo() {
		return toppingInfo;
	}

	public void setToppingInfo(ToppingInfo toppingInfo) {
		this.toppingInfo = toppingInfo;
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

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
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
}
