
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.UserHomeAction;

import process.PizzaProcess;
import process.RatingProcess;
import dao.PizzaData;
import dao.ToppingInfo;

public class UserHomeActionTest {
	private PizzaData pizzaData;
	private List<PizzaData> vegPizzas;
	private ToppingInfo toppingInfo;
	private List<ToppingInfo> vegToppings;
	private PizzaProcess pizzaProcess;
	private RatingProcess ratingProcess;
	private String userRole;
	private List<PizzaData> nonVegPizzas;
	private List<ToppingInfo> nonVegToppings;
	private String userFullName;
	private UserHomeAction userHomeAction;

	@Before
	public void setUp() throws Exception {
		pizzaData = new PizzaData();
		vegPizzas = new ArrayList<PizzaData>();
		toppingInfo = new  ToppingInfo();
		vegToppings = new ArrayList<ToppingInfo>();
		pizzaProcess = new PizzaProcess();
		ratingProcess = new RatingProcess();
		userRole = "Consumer";
		nonVegPizzas = new ArrayList<PizzaData>();
		nonVegToppings = new ArrayList<ToppingInfo>();
		userFullName = "deepak jain";
		userHomeAction = new UserHomeAction();
	}

	@Test
	public void testAllSetterGetter() {
		userHomeAction.setPizzaData(pizzaData);
		userHomeAction.setVegPizzas(vegPizzas);
		userHomeAction.setToppingInfo(toppingInfo);
		userHomeAction.setVegToppings(vegToppings);
		userHomeAction.setPizzaProcess(pizzaProcess);
		userHomeAction.setRatingProcess(ratingProcess);
		userHomeAction.setUserRole(userRole);
		userHomeAction.setNonVegPizzas(nonVegPizzas);
		userHomeAction.setNonVegToppings(nonVegToppings);
		userHomeAction.setUserFullName(userFullName);
		assertNotNull(userHomeAction.getPizzaData());
		assertNotNull(userHomeAction.getVegPizzas());
		assertNotNull(userHomeAction.getToppingInfo());
		assertNotNull(userHomeAction.getVegToppings());
		assertNotNull(userHomeAction.getPizzaProcess());
		assertNotNull(userHomeAction.getRatingProcess());
		assertNotNull(userHomeAction.getUserRole());
		assertNotNull(userHomeAction.getNonVegPizzas());
		assertNotNull(userHomeAction.getNonVegToppings());
		assertNotNull(userHomeAction.getUserFullName());
	}
	@After
	public void tearDown() throws Exception {
		pizzaData = null;
		vegPizzas =null;
		toppingInfo = null;
		vegToppings =null;
		pizzaProcess = null;
		ratingProcess = null;
		userRole = null;
		nonVegPizzas = null;
		nonVegToppings = null;
		userFullName = null;
		userHomeAction =null;
	}


}
