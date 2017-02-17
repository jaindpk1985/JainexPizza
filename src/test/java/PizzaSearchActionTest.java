

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.PizzaSearchAction;

import process.PizzaProcess;
import process.RatingProcess;
import dao.PizzaData;
import dao.ToppingInfo;

public class PizzaSearchActionTest {

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
	private String userFullName;
	private PizzaSearchAction pizzaSearchAction;
	
	@Before
	public void setUp() throws Exception {
		key = "tomatto";
		pizzaData = new PizzaData();
		vegPizzas = new ArrayList<PizzaData>();
		toppingInfo = new ToppingInfo();
		vegToppings = new  ArrayList<ToppingInfo>();
		pizzaProcess = new PizzaProcess();
		ratingProcess = new RatingProcess();
		userRole = "Consumer";
		nonVegPizzas = new ArrayList<PizzaData>();
		nonVegToppings = new ArrayList<ToppingInfo>();
		searchBy = "Content";
		userFullName = "deepak jain";
		pizzaSearchAction = new PizzaSearchAction();
	}

	@Test
	public void testAllSetterGetter() {
		pizzaSearchAction.setKey(key);
		pizzaSearchAction.setPizzaData(pizzaData);
		pizzaSearchAction.setVegPizzas(vegPizzas);
		pizzaSearchAction.setToppingInfo(toppingInfo);
		pizzaSearchAction.setVegToppings(vegToppings);
		pizzaSearchAction.setPizzaProcess(pizzaProcess);
		pizzaSearchAction.setRatingProcess(ratingProcess);
		pizzaSearchAction.setUserRole(userRole);
		pizzaSearchAction.setNonVegPizzas(nonVegPizzas);
		pizzaSearchAction.setNonVegToppings(nonVegToppings);
		pizzaSearchAction.setSearchBy(searchBy);
		pizzaSearchAction.setUserFullName(userFullName);
		assertNotNull(pizzaSearchAction.getKey());
		assertNotNull(pizzaSearchAction.getPizzaData());
		assertNotNull(pizzaSearchAction.getVegPizzas());
		assertNotNull(pizzaSearchAction.getToppingInfo());
		assertNotNull(pizzaSearchAction.getVegToppings());
		assertNotNull(pizzaSearchAction.getPizzaProcess());
		assertNotNull(pizzaSearchAction.getRatingProcess());
		assertNotNull(pizzaSearchAction.getUserRole());
		assertNotNull(pizzaSearchAction.getNonVegToppings());
		assertNotNull(pizzaSearchAction.getNonVegPizzas());
		assertNotNull(pizzaSearchAction.getSearchBy());
		assertNotNull(pizzaSearchAction.getUserFullName());
	}
	
	@After
	public void tearDown() throws Exception {
		key = null;
		pizzaData = null;
		vegPizzas = null;
		toppingInfo = null;
		vegToppings = null;
		pizzaProcess = null;
		ratingProcess = null;
		userRole = null;
		nonVegPizzas = null;
		nonVegToppings = null;
		searchBy = null;
		userFullName = null;
	}

}
