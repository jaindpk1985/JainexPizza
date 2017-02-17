

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.LoginAction;

import process.LoginProcess;
import process.PizzaProcess;
import process.RatingProcess;
import process.UserProfileProcess;
import dao.LoginData;
import dao.PizzaData;
import dao.ToppingInfo;

public class LoginActionTest {

	private LoginProcess loginProcess;
	private LoginData loginData;
	private RatingProcess ratingProcess;
	private PizzaProcess pizzaProcess;
	private List<PizzaData> vegPizzas;
	private ToppingInfo toppingInfo;
	private List<ToppingInfo> vegToppings;
	private List<PizzaData> nonVegPizzas;
	private List<ToppingInfo> nonVegToppings;
	private Long userId;
	private UserProfileProcess userProfileProcess;
	private LoginAction loginAction;
	
	@Before
	public void setUp() throws Exception {
		loginProcess = new  LoginProcess();
		loginData = new LoginData();
		ratingProcess = new RatingProcess();
		pizzaProcess = new PizzaProcess();
		vegPizzas = new ArrayList<PizzaData>();
		toppingInfo = new ToppingInfo();
		vegToppings = new ArrayList<ToppingInfo>();
		nonVegPizzas = new ArrayList<PizzaData>();
		nonVegToppings = new ArrayList<ToppingInfo>();
		userId = new Long(5);
		userProfileProcess = new UserProfileProcess();
		loginAction = new LoginAction();
	}

	@Test
	public void testAllSetterGetter() {
		loginAction.setLoginProcess(loginProcess);
		loginAction.setLoginData(loginData);
		loginAction.setPizzaProcess(pizzaProcess);
		loginAction.setRatingProcess(ratingProcess);
		loginAction.setVegPizzas(vegPizzas);
		loginAction.setToppingInfo(toppingInfo);
		loginAction.setVegToppings(vegToppings);
		loginAction.setNonVegPizzas(nonVegPizzas);
		loginAction.setUserId(userId);
		loginAction.setUserProfileProcess(userProfileProcess);
		assertNotNull(loginAction.getLoginProcess());
		assertNotNull(loginAction.getLoginData());
		assertNotNull(loginAction.getPizzaProcess());
		assertNotNull(loginAction.getRatingProcess());
		assertNotNull(loginAction.getVegPizzas());
		assertNotNull(loginAction.getToppingInfo());
		assertNotNull(loginAction.getVegToppings());
		assertNotNull(loginAction.getNonVegPizzas());
		assertNotNull(loginAction.getUserId());
		assertNotNull(loginAction.getUserProfileProcess());
		
	}
	@After
	public void tearDown() throws Exception {
		loginProcess = null;
		loginData = null;
		ratingProcess = null;
		pizzaProcess = null;
		vegPizzas = null;
		toppingInfo = null;
		vegToppings = null;
		nonVegPizzas = null;
		nonVegToppings = null;
		userId = null;
		userProfileProcess = null;
		loginAction = null;
	}

}
