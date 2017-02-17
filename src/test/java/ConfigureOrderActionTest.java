

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.ConfigureOrderAction;

import process.PizzaProcess;
import process.RatingProcess;
import process.UserPreferencesProcess;
import dao.OrderPizzasInfo;
import dao.PizzaData;
import dao.PizzaOrderInfo;
import dao.ToppingInfo;

public class ConfigureOrderActionTest {

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

	private String userRole;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;

	private UserPreferencesProcess userPreferencesProcess;

	private List<PizzaData> prefPizzaDataList;

	private String deliveryChoice;
	
	private String userFullName;
	
	private ConfigureOrderAction configureOrderAction;
	@Before
	public void setUp() throws Exception {
		vegPizzas = new ArrayList<PizzaData>();
		vegToppings = new ArrayList<ToppingInfo>();
		pizzaProcess = new PizzaProcess();
		ratingProcess = new RatingProcess();
		pizzaOrderInfo = new PizzaOrderInfo();
		orderedPizzaData = new OrderPizzasInfo();
		sizeList = new ArrayList<String>();
		quantityList = new ArrayList<Integer>();
		jsonObject = new JSONObject();
		deliverChoices = new ArrayList();
		orderedPizzaDataList = new ArrayList<OrderPizzasInfo>();
		toppings = "tomatto, paneer";
		orderedPizzaNames = new ArrayList<String>();
		orderedPizzaQuantities = new ArrayList<Long>();
		orderedPizzaPrices = new ArrayList<Long>();
		index = 3;
		totalOrderPrice = new Long(200);
		userRole = "Consuemr";
		nonVegPizzas = new ArrayList<PizzaData>();
		nonVegToppings = new ArrayList<ToppingInfo>();
		userPreferencesProcess = new UserPreferencesProcess();
		prefPizzaDataList = new ArrayList<PizzaData>();
		deliveryChoice = "Pick Up";
		userFullName = "deepak jain";
		configureOrderAction = new ConfigureOrderAction();
	}
	@Test
	public void testAllSetterGetter() {
		configureOrderAction.setVegPizzas(vegPizzas);
		configureOrderAction.setVegToppings(vegToppings);
		configureOrderAction.setPizzaProcess(pizzaProcess);
		configureOrderAction.setRatingProcess(ratingProcess);
		configureOrderAction.setPizzaOrderInfo(pizzaOrderInfo);
		configureOrderAction.setOrderedPizzaData(orderedPizzaData);
		configureOrderAction.setSizeList(sizeList);
		configureOrderAction.setQuantityList(quantityList);
		configureOrderAction.setJsonObject(jsonObject);
		configureOrderAction.setDeliverChoices(deliverChoices);
		configureOrderAction.setOrderedPizzaDataList(orderedPizzaDataList);
		configureOrderAction.setToppings(toppings);
		configureOrderAction.setOrderedPizzaNames(orderedPizzaNames);
		configureOrderAction.setOrderedPizzaQuantities(orderedPizzaQuantities);
		configureOrderAction.setOrderedPizzaPrices(orderedPizzaPrices);
		configureOrderAction.setIndex(index);
		configureOrderAction.setTotalOrderPrice(totalOrderPrice);
		configureOrderAction.setUserRole(userRole);
		configureOrderAction.setNonVegPizzas(nonVegPizzas);
		configureOrderAction.setNonVegToppings(nonVegToppings);
		configureOrderAction.setPrefPizzaDataList(prefPizzaDataList);
		configureOrderAction.setUserPreferencesProcess(userPreferencesProcess);
		configureOrderAction.setDeliveryChoice(deliveryChoice);
		configureOrderAction.setUserFullName(userFullName);
		assertNotNull(configureOrderAction.getVegPizzas());
		assertNotNull(configureOrderAction.getVegToppings());
		assertNotNull(configureOrderAction.getPizzaProcess());
		assertNotNull(configureOrderAction.getRatingProcess());
		assertNotNull(configureOrderAction.getPizzaOrderInfo());
		assertNotNull(configureOrderAction.getOrderedPizzaData());
		assertNotNull(configureOrderAction.getSizeList());
		assertNotNull(configureOrderAction.getQuantityList());
		assertNotNull(configureOrderAction.getJsonObject());
		assertNotNull(configureOrderAction.getDeliverChoices());
		assertNotNull(configureOrderAction.getOrderedPizzaDataList());
		assertNotNull(configureOrderAction.getToppings());
		assertNotNull(configureOrderAction.getOrderedPizzaNames());
		assertNotNull(configureOrderAction.getOrderedPizzaQuantities());
		assertNotNull(configureOrderAction.getOrderedPizzaPrices());
		assertNotNull(configureOrderAction.getIndex());
		assertNotNull(configureOrderAction.getTotalOrderPrice());
		assertNotNull(configureOrderAction.getUserRole());
		assertNotNull(configureOrderAction.getNonVegPizzas());
		assertNotNull(configureOrderAction.getNonVegToppings());
		assertNotNull(configureOrderAction.getPrefPizzaDataList());
		assertNotNull(configureOrderAction.getUserPreferencesProcess());
		assertNotNull(configureOrderAction.getDeliveryChoice());
		assertNotNull(configureOrderAction.getUserFullName());
	}

	@After
	public void tearDown() throws Exception {
		vegPizzas = null;

		vegToppings = null;

		pizzaProcess = null;

		ratingProcess =null;

		pizzaOrderInfo =null;

		orderedPizzaData = null;

		sizeList = null;

		quantityList = null;

		jsonObject = null;

		deliverChoices = null;

		orderedPizzaDataList = null;

		toppings = null;

		orderedPizzaNames = null;

		orderedPizzaQuantities = null;

		orderedPizzaPrices = null;

		index = 0;

		totalOrderPrice = null;

		userRole = null;

		nonVegPizzas = null;

		nonVegToppings = null;

		userPreferencesProcess = null;

		prefPizzaDataList = null;

		deliveryChoice = null;
		
		userFullName = null;
	}

}
