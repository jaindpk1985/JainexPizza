package action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import common.UnexpectedException;

import dao.LoginData;
import dao.PizzaData;
import dao.ToppingInfo;
import dao.UserProfileInfo;
import process.LoginProcess;
import process.PizzaProcess;
import process.RatingProcess;
import process.UserProfileProcess;

public class LoginAction extends ActionSupport implements SessionAware,
		Preparable {

	static final Logger log = Logger.getLogger(LoginAction.class);

	private LoginProcess loginProcess;

	private LoginData loginData;

	private RatingProcess ratingProcess;

	private PizzaProcess pizzaProcess;

	private List<PizzaData> vegPizzas;

	private ToppingInfo toppingInfo;

	private List<ToppingInfo> vegToppings;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;

	private long userId;

	private Map session;
	
	private UserProfileProcess userProfileProcess;

	/*
	 * (non-Javadoc) show existing pizza and topping information from the DB
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() throws UnexpectedException {
		ratingProcess = new RatingProcess();
		pizzaProcess = new PizzaProcess();
		loginProcess = new LoginProcess();
		userProfileProcess = new UserProfileProcess();

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
			throw new UnexpectedException(getText("exception.error"),e);
		}
	}

	/**
	 * Aunthenitcate the user and put the information in the session
	 * 
	 * @return
	 * @throws UnexpectedException
	 * @throws UnexpectedException
	 * @throws Exception
	 */
	public String save() throws UnexpectedException {
		try {
			loginData = loginProcess.authenticateUser(loginData);
			if (loginData == null) {
				this.addActionError(getText("invalidPassword"));
				return INPUT;
			}
			UserProfileInfo userProfileInfo = userProfileProcess.findUserInfoByLoginData(loginData);
			String userFullName = userProfileInfo.getFirstName() + " " + userProfileInfo.getLastName();
			session.put("userFullName",userFullName);
			session.put("userId", loginData.getUserId());
			session.put("userRole", loginData.getRole());

		} catch (UnexpectedException e) {
			log.error(getText("exception.error"),e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
		return SUCCESS;
	}

	/**
	 * @return the loginProcess
	 */
	public LoginProcess getLoginProcess() {
		return loginProcess;
	}

	/**
	 * @param loginProcess
	 *            the loginProcess to set
	 */
	public void setLoginProcess(LoginProcess loginProcess) {
		this.loginProcess = loginProcess;
	}

	/**
	 * @return the loginData
	 */
	public LoginData getLoginData() {
		return loginData;
	}

	/**
	 * @param loginData
	 *            the loginData to set
	 */
	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
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

	public UserProfileProcess getUserProfileProcess() {
		return userProfileProcess;
	}

	public void setUserProfileProcess(UserProfileProcess userProfileProcess) {
		this.userProfileProcess = userProfileProcess;
	}

}
