

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.UserHomeAction;
import action.WelcomeAction;

import process.LoginProcess;
import process.PizzaProcess;
import process.RatingProcess;
import dao.LoginData;
import dao.PizzaData;
import dao.ToppingInfo;

public class WelcomeActionTest {
	
	private String userName;
	private String password;
	private LoginProcess loginProcess;
	private LoginData loginData;
	private PizzaData pizzaData;
	private List<PizzaData> vegPizzas;
	private ToppingInfo toppingInfo;
	private List<ToppingInfo> vegToppings;
	private List<PizzaData> nonVegPizzas;
	private List<ToppingInfo> nonVegToppings;
	private WelcomeAction welcomeAction;

	@Before
	public void setUp() throws Exception {
		userName = "deepakjain";
		password = "dpkjain";
		pizzaData = new PizzaData();
		loginData =new LoginData();
		loginProcess = new LoginProcess();
		vegPizzas = new ArrayList<PizzaData>();
		toppingInfo = new  ToppingInfo();
		vegToppings = new ArrayList<ToppingInfo>();
		nonVegPizzas = new ArrayList<PizzaData>();
		nonVegToppings = new ArrayList<ToppingInfo>();
		welcomeAction = new WelcomeAction();
	}
	
	@Test
	public void testAllSetterGetter() {
		welcomeAction.setUserName(userName);
		welcomeAction.setPassword(password);
		welcomeAction.setPizzaData(pizzaData);
		welcomeAction.setLoginData(loginData);
		welcomeAction.setLoginProcess(loginProcess);
		welcomeAction.setVegPizzas(vegPizzas);
		welcomeAction.setToppingInfo(toppingInfo);
		welcomeAction.setVegToppings(vegToppings);
		welcomeAction.setNonVegPizzas(nonVegPizzas);
		welcomeAction.setNonVegToppings(nonVegToppings);
		assertNotNull(welcomeAction.getUserName());
		assertNotNull(welcomeAction.getPassword());
		assertNotNull(welcomeAction.getPizzaData());
		assertNotNull(welcomeAction.getLoginData());
		assertNotNull(welcomeAction.getLoginProcess());
		assertNotNull(welcomeAction.getVegPizzas());
		assertNotNull(welcomeAction.getToppingInfo());
		assertNotNull(welcomeAction.getVegToppings());
		assertNotNull(welcomeAction.getNonVegPizzas());
		assertNotNull(welcomeAction.getNonVegToppings());
	}
	@After
	public void tearDown() throws Exception {
		userName = null;
		password = null;
		pizzaData = null;
		loginData =null;
		loginProcess = null;
		vegPizzas = null;
		toppingInfo = null;
		vegToppings = null;
		nonVegPizzas = null;
		nonVegToppings = null;
		welcomeAction = null;
	}

}
