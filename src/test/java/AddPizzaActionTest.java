

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.AddPizzaAction;

import process.PizzaProcess;
import process.RatingProcess;
import dao.PizzaData;
import dao.ToppingInfo;

public class AddPizzaActionTest {

	private String imageFileName;

	private PizzaData pizzaData;

	private PizzaProcess pizzaProcess;

	private List<PizzaData> vegPizzas;

	private ToppingInfo toppingInfo;

	private List<ToppingInfo> vegToppings;

	private RatingProcess ratingProcess;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;

	private String userRole;

	private Long deletedPizzaId;

	private Long updatedPizzaId;

	private Long pizzaBasePrice;

	private String userFullName;
	
	private AddPizzaAction addPizzaAction;
	@Before
	public void setUp() {
		pizzaData = new PizzaData();
		pizzaProcess = new PizzaProcess();
		 vegPizzas = new ArrayList<PizzaData>();
		 toppingInfo = new ToppingInfo();
		 vegToppings = new ArrayList<ToppingInfo>();
		 ratingProcess = new RatingProcess();
		 nonVegPizzas = new ArrayList<PizzaData>();
		 nonVegToppings = new ArrayList<ToppingInfo>();
		userRole = "Consumer";
		deletedPizzaId = new Long(10);
		updatedPizzaId = new Long(10);
		pizzaBasePrice = new Long(100);
		userFullName = "deepak jain";
		addPizzaAction = new AddPizzaAction();
	}

	@After
	public void tearDown() {
		pizzaData = null;
		pizzaProcess = null;
		 vegPizzas = null;
		 toppingInfo = null;
		 vegToppings =null;
		 ratingProcess = null;
		 nonVegPizzas = null;
		 nonVegToppings = null;
		userRole = null;
		deletedPizzaId =null;
		updatedPizzaId = null;
		pizzaBasePrice = null;
		userFullName = null;
		addPizzaAction = null;
	}

	@Test
	public void testAllSetterGetter() {
		addPizzaAction.setPizzaData(pizzaData);
		addPizzaAction.setPizzaProcess(pizzaProcess);
		addPizzaAction.setVegPizzas(vegPizzas);
		addPizzaAction.setToppingInfo(toppingInfo);
		addPizzaAction.setVegToppings(vegToppings);
		addPizzaAction.setRatingProcess(ratingProcess);
		addPizzaAction.setNonVegPizzas(nonVegPizzas);
		addPizzaAction.setNonVegToppings(nonVegToppings);
		addPizzaAction.setUserRole(userRole);
		addPizzaAction.setDeletedPizzaId(deletedPizzaId);
		addPizzaAction.setUpdatedPizzaId(updatedPizzaId);
		addPizzaAction.setPizzaBasePrice(pizzaBasePrice);
		addPizzaAction.setUserFullName(userFullName);
		assertNotNull(addPizzaAction.getPizzaData());
		assertNotNull(addPizzaAction.getPizzaProcess());
		assertNotNull(addPizzaAction.getVegPizzas());
		assertNotNull(addPizzaAction.getToppingInfo());
		assertNotNull(addPizzaAction.getVegToppings());
		assertNotNull(addPizzaAction.getRatingProcess());
		assertNotNull(addPizzaAction.getNonVegPizzas());
		assertNotNull(addPizzaAction.getNonVegToppings());
		assertNotNull(addPizzaAction.getUserRole());
		assertNotNull(addPizzaAction.getDeletedPizzaId());
		assertNotNull(addPizzaAction.getUpdatedPizzaId());
		assertNotNull(addPizzaAction.getPizzaBasePrice());
		assertNotNull(addPizzaAction.getUserFullName());
	
	}
	
}
