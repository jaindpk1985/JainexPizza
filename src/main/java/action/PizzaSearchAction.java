package action;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import process.PizzaProcess;
import process.RatingProcess;
import com.opensymphony.xwork2.ActionSupport;
import common.UnexpectedException;
import dao.PizzaData;
import dao.ToppingInfo;

public class PizzaSearchAction extends ActionSupport implements SessionAware {

	static final Logger log = Logger.getLogger(PizzaSearchAction.class);
	
	private String key;

	private PizzaData pizzaData;

	private List<PizzaData> vegPizzas;

	private ToppingInfo toppingInfo;

	private List<ToppingInfo> vegToppings;

	private PizzaProcess pizzaProcess;

	private RatingProcess ratingProcess;

	private String userRole;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;

	private String searchBy;

	private Map session;

	private String userFullName;

	/**
	 * Search all pizza list having the name given by user
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String getSearchedPizza() throws UnexpectedException {

		userRole = (String) session.get("userRole");
		userFullName = (String) session.get("userFullName");
		if (!StringUtils.isEmpty(key)) {

			ratingProcess = new RatingProcess();
			pizzaProcess = new PizzaProcess();

			try {
				if ("Name".equals(searchBy)) {
					vegPizzas = pizzaProcess.getPizzaByCategoryAndName(true,
							key);
				} else {
					vegPizzas = pizzaProcess.getPizzaByCategoryAndContent(true,
							key);
				}

				for (PizzaData pizzaData : vegPizzas) {
					ratingProcess.setPizzaRates(pizzaData);
				}
				if ("Name".equals(searchBy)) {
					nonVegPizzas = pizzaProcess.getPizzaByCategoryAndName(
							false, key);
				} else {
					nonVegPizzas = pizzaProcess.getPizzaByCategoryAndContent(
							false, key);
				}
				for (PizzaData pizzaData : nonVegPizzas) {
					ratingProcess.setPizzaRates(pizzaData);
				}
				vegToppings = pizzaProcess.getToppingsByCategory(true);
				nonVegToppings = pizzaProcess.getToppingsByCategory(false);
				return SUCCESS;
			} catch (UnexpectedException e) {
				log.error(getText("exception.error"), e);
				throw new UnexpectedException(getText("exception.error"), e);
			}
		}

		return INPUT;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public PizzaData getPizzaData() {
		return pizzaData;
	}

	public void setPizzaData(PizzaData pizzaData) {
		this.pizzaData = pizzaData;
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

	public List<PizzaData> getVegPizzas() {
		return vegPizzas;
	}

	public void setVegPizzas(List<PizzaData> vegPizzas) {
		this.vegPizzas = vegPizzas;
	}

	public ToppingInfo getToppingInfo() {
		return toppingInfo;
	}

	public void setToppingInfo(ToppingInfo toppingInfo) {
		this.toppingInfo = toppingInfo;
	}

	public List<ToppingInfo> getVegToppings() {
		return vegToppings;
	}

	public void setVegToppings(List<ToppingInfo> vegToppings) {
		this.vegToppings = vegToppings;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

}
