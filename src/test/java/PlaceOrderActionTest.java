

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.PlaceOrderAction;

import process.OrderProcess;
import dao.PizzaOrderInfo;

public class PlaceOrderActionTest {
	private PizzaOrderInfo pizzaOrderInfo;
	private OrderProcess orderProcess;
	private String userRole;
	private String userFullName;
	private PlaceOrderAction placeOrderAction;

	@Before
	public void setUp() throws Exception {
		pizzaOrderInfo = new PizzaOrderInfo();
		orderProcess = new OrderProcess();
		userRole = "Consumer";
		userFullName = "deepak jain";
		placeOrderAction = new PlaceOrderAction();
	}

	@Test
	public void testAllSetterGetter() {
		placeOrderAction.setPizzaOrderInfo(pizzaOrderInfo);
		placeOrderAction.setOrderProcess(orderProcess);
		placeOrderAction.setUserRole(userRole);
		placeOrderAction.setUserFullName(userFullName);
		assertNotNull(placeOrderAction.getPizzaOrderInfo());
		assertNotNull(placeOrderAction.getOrderProcess());
		assertNotNull(placeOrderAction.getUserRole());
		assertNotNull(placeOrderAction.getUserFullName());
	}
	
	@After
	public void tearDown() throws Exception {
		pizzaOrderInfo = null;
		orderProcess = null;
		userRole = null;
		userFullName = null;
		placeOrderAction = null;
	}

}
