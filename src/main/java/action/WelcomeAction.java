package action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import process.LoginProcess;
import process.PizzaProcess;
import process.RatingProcess;

import com.opensymphony.xwork2.ActionSupport;
import common.UnexpectedException;

import dao.LoginData;
import dao.PizzaData;
import dao.ToppingInfo;

public class WelcomeAction extends ActionSupport implements SessionAware {

	static final Logger log = Logger.getLogger(WelcomeAction.class);

	private String userName;

	private String password;

	private LoginProcess loginProcess;

	private PizzaProcess pizzaProcess;

	private RatingProcess ratingProcess;

	private LoginData loginData;

	private PizzaData pizzaData;

	private List<PizzaData> vegPizzas;

	private ToppingInfo toppingInfo;

	private List<ToppingInfo> vegToppings;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;

	private Map session;

	/*
	 * Get the pizza and topping data from the DB
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		ratingProcess = new RatingProcess();
		pizzaProcess = new PizzaProcess();

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
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
		}

		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	public LoginProcess getLoginProcess() {
		return loginProcess;
	}

	public void setLoginProcess(LoginProcess loginProcess) {
		this.loginProcess = loginProcess;
	}

	public PizzaData getPizzaData() {
		return pizzaData;
	}

	public void setPizzaData(PizzaData pizzaData) {
		this.pizzaData = pizzaData;
	}

	public ToppingInfo getToppingInfo() {
		return toppingInfo;
	}

	public void setToppingInfo(ToppingInfo toppingInfo) {
		this.toppingInfo = toppingInfo;
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

	/**
	 * @param session
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
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

}
