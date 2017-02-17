

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.UserPreferencesAction;

import process.PizzaProcess;
import process.RatingProcess;
import process.UserPreferencesProcess;
import dao.PizzaData;
import dao.ToppingInfo;

public class UserPreferencesActionTest {
	
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
	private UserPreferencesProcess userPreferencesProcess;
	private List<Long> prefPizzaIds;
	private List<String> prefPizzaNames;
	private List<PizzaData> prefPizzaDataList;
	private List<PizzaData> nonVegPizzas;
	private List<ToppingInfo> nonVegToppings;
	private String userFullName;
	private UserPreferencesAction userPreferencesAction;

	@Before
	public void setUp() throws Exception {
		pizzaProcess = new PizzaProcess();
		ratingProcess = new RatingProcess();
		pizzaData = new PizzaData();
		vegPizzas = new ArrayList<PizzaData>();
		toppingInfo = new ToppingInfo();
		vegToppings = new ArrayList<ToppingInfo>();
		prefPizza = new PizzaData();
		prefPizzas = new ArrayList<PizzaData>();
		jsonObject = new JSONObject();
		selectedPizzaId = new Long(10);
		userPreferencesProcess = new  UserPreferencesProcess();
		prefPizzaIds = new ArrayList<Long>();
		prefPizzaNames = new  ArrayList<String>();
		prefPizzaDataList = new  ArrayList<PizzaData>();
		nonVegPizzas = new  ArrayList<PizzaData>();
		nonVegToppings = new  ArrayList<ToppingInfo>();
		userFullName = "deepak jain";
		userPreferencesAction = new UserPreferencesAction();
	}

	@Test
	public void testAllSetterGetter() {
		userPreferencesAction.setPizzaProcess(pizzaProcess);
		userPreferencesAction.setRatingProcess(ratingProcess);
		userPreferencesAction.setPizzaData(pizzaData);
		userPreferencesAction.setVegPizzas(vegPizzas);
		userPreferencesAction.setToppingInfo(toppingInfo);
		userPreferencesAction.setVegToppings(vegToppings);
		userPreferencesAction.setPrefPizza(prefPizza);
		userPreferencesAction.setPrefPizzas(prefPizzas);
		userPreferencesAction.setJsonObject(jsonObject);
		userPreferencesAction.setSelectedPizzaId(selectedPizzaId);
		userPreferencesAction.setUserPreferencesProcess(userPreferencesProcess);
		userPreferencesAction.setPrefPizzaIds(prefPizzaIds);
		userPreferencesAction.setPrefPizzaNames(prefPizzaNames);
		userPreferencesAction.setNonVegPizzas(nonVegPizzas);
		userPreferencesAction.setNonVegToppings(nonVegToppings);
		userPreferencesAction.setUserFullName(userFullName);
		assertNotNull(userPreferencesAction.getPizzaProcess());
		assertNotNull(userPreferencesAction.getRatingProcess());
		assertNotNull(userPreferencesAction.getPizzaData());
		assertNotNull(userPreferencesAction.getVegPizzas());
		assertNotNull(userPreferencesAction.getToppingInfo());
		assertNotNull(userPreferencesAction.getVegToppings());
		assertNotNull(userPreferencesAction.getPrefPizza());
		assertNotNull(userPreferencesAction.getPrefPizzas());
		assertNotNull(userPreferencesAction.getJsonObject());
		assertNotNull(userPreferencesAction.getSelectedPizzaId());
		assertNotNull(userPreferencesAction.getUserPreferencesProcess());
		assertNotNull(userPreferencesAction.getPrefPizzaIds());
		assertNotNull(userPreferencesAction.getPrefPizzaNames());
		assertNotNull(userPreferencesAction.getNonVegPizzas());
		assertNotNull(userPreferencesAction.getNonVegToppings());
		assertNotNull(userPreferencesAction.getUserFullName());
		
	}
	@After
	public void tearDown() throws Exception {
		pizzaProcess = null;
		ratingProcess = null;
		pizzaData = null;
		vegPizzas = null;
		toppingInfo = null;
		vegToppings = null;
		prefPizza = null;
		prefPizzas = null;
		jsonObject = null;
		selectedPizzaId = null;
		userPreferencesProcess = null;
		prefPizzaIds = null;
		prefPizzaNames = null;
		prefPizzaDataList = null;
		nonVegPizzas = null;
		nonVegToppings = null;
		userFullName = null;
	}

}
