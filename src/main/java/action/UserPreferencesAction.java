package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
//import org.json.JSONException;
import org.json.JSONObject;

import process.PizzaProcess;
import process.RatingProcess;
import process.UserPreferencesProcess;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import common.UnexpectedException;

import dao.PizzaData;
import dao.ToppingInfo;
import dao.UserPreferencesInfo;

public class UserPreferencesAction extends ActionSupport implements
		SessionAware, Preparable {
	static final Logger log = Logger.getLogger(UserPreferencesAction.class);

	private PizzaProcess pizzaProcess;

	private RatingProcess ratingProcess;

	private PizzaData pizzaData;

	private List<PizzaData> vegPizzas;

	private ToppingInfo toppingInfo;

	private List<ToppingInfo> vegToppings;

	private PizzaData prefPizza;

	private List<PizzaData> prefPizzas;

	private JSONObject jsonObject;

	private Long selectedPizzaId;

	private Map session;

	private UserPreferencesProcess userPreferencesProcess;

	private List<Long> prefPizzaIds;

	private List<String> prefPizzaNames;

	private List<PizzaData> prefPizzaDataList;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;
	
	private String userFullName;

	/*
	 * Intialized the process classes (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare(){
		ratingProcess = new RatingProcess();
		pizzaProcess = new PizzaProcess();
		userPreferencesProcess = new UserPreferencesProcess();
		userFullName = (String) session.get("userFullName");

	}

	/*
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {

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

			Long userId = (Long) session.get("userId");

			prefPizzaDataList = new ArrayList<PizzaData>();
			List<UserPreferencesInfo> userPreferencesInfos = userPreferencesProcess
					.getUserPreferencesByUserId(userId);
			if (userPreferencesInfos != null) {
				for (UserPreferencesInfo preferencesInfo : userPreferencesInfos) {
					PizzaData prefPizzaData = pizzaProcess
							.getPizzaById(preferencesInfo.getPizzaId());
					prefPizzaDataList.add(prefPizzaData);
				}
			}
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
		} catch (Exception e) {
			log.error(getText("exception.error"), e);
		}
		return SUCCESS;
	}

	/**
	 * Add the selected pizza in the user preferences list
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String addPreference() throws UnexpectedException {
		try {
			Long userId = (Long) session.get("userId");
			if (userId != 0) {

				UserPreferencesInfo preferenceInfo = userPreferencesProcess
						.getUserPreferencesByUserIdandPizzaId(userId,
								selectedPizzaId);
				if (preferenceInfo == null) {
					preferenceInfo = new UserPreferencesInfo();
					preferenceInfo.setUserId(userId);
					preferenceInfo.setPizzaId(selectedPizzaId);
					userPreferencesProcess
							.saveUpdateUserPreferences(preferenceInfo);
				}

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
			}
			createPreferencesPizza();
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
		return SUCCESS;
	}

	/**
	 * Delete the preference from the user preference list
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String deletePreference() throws UnexpectedException {
		try {
			Long userId = (Long) session.get("userId");
			if (userId != 0) {

				UserPreferencesInfo userPreferencesInfo = userPreferencesProcess
						.getUserPreferencesByUserIdandPizzaId(userId,
								selectedPizzaId);
				if (userPreferencesInfo != null) {
					userPreferencesProcess
							.deleteUserPreference(userPreferencesInfo);
				}
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
			}
			createPreferencesPizza();
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
		return SUCCESS;
	}

	/**
	 * Recreate the selected preference pizza list
	 * 
	 * @throws UnexpectedException
	 */
	private void createPreferencesPizza() throws UnexpectedException {
		try {
			jsonObject = new JSONObject();
			prefPizzaIds = new ArrayList<Long>();
			prefPizzaNames = new ArrayList<String>();
			for (PizzaData prefPizza : prefPizzaDataList) {
				prefPizzaIds.add(prefPizza.getPizzaId());
				prefPizzaNames.add(prefPizza.getPizzaName());
			}
			jsonObject.put("prefPizzaIds", prefPizzaIds);
			jsonObject.put("prefPizzaNames", prefPizzaNames);
			jsonObject.put("prefPizzaDataList", prefPizzaDataList);
		} /*catch (JSONException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"));
		}*/catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}
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

	public PizzaData getPrefPizza() {
		return prefPizza;
	}

	public void setPrefPizza(PizzaData prefPizza) {
		this.prefPizza = prefPizza;
	}

	public List<PizzaData> getPrefPizzas() {
		return prefPizzas;
	}

	public void setPrefPizzas(List<PizzaData> prefPizzas) {
		this.prefPizzas = prefPizzas;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public long getSelectedPizzaId() {
		return selectedPizzaId;
	}

	public void setSelectedPizzaId(long selectedPizzaId) {
		this.selectedPizzaId = selectedPizzaId;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public Map getSession() {
		return session;
	}

	public List<PizzaData> getPrefPizzaDataList() {
		return prefPizzaDataList;
	}

	public void setPrefPizzaDataList(List<PizzaData> prefPizzaDataList) {
		this.prefPizzaDataList = prefPizzaDataList;
	}

	public List<Long> getPrefPizzaIds() {
		return prefPizzaIds;
	}

	public void setPrefPizzaIds(List<Long> prefPizzaIds) {
		this.prefPizzaIds = prefPizzaIds;
	}

	public List<String> getPrefPizzaNames() {
		return prefPizzaNames;
	}

	public void setPrefPizzaNames(List<String> prefPizzaNames) {
		this.prefPizzaNames = prefPizzaNames;
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

	public UserPreferencesProcess getUserPreferencesProcess() {
		return userPreferencesProcess;
	}

	public void setUserPreferencesProcess(
			UserPreferencesProcess userPreferencesProcess) {
		this.userPreferencesProcess = userPreferencesProcess;
	}

	public void setSelectedPizzaId(Long selectedPizzaId) {
		this.selectedPizzaId = selectedPizzaId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

}
