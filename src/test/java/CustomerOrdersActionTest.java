

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.CustomerOrdersAction;

import process.OrderProcess;
import dao.AddressInfo;
import dao.OrderPizzasInfo;
import dao.PizzaOrderInfo;

public class CustomerOrdersActionTest {

	private OrderProcess orderProcess;

	private List<PizzaOrderInfo> pizzaOrderDatas;

	private PizzaOrderInfo orderInfo;

	private List<OrderPizzasInfo> orderPizzasInfoList;

	private Long orderId;

	private String userRole;

	private Long userId;

	private Long totalOrderPrice;

	private AddressInfo deliveryAddressInfo;
	
	private String userFullName;
	
	private CustomerOrdersAction customerOrdersAction;
	@Before
	public void setUp() throws Exception {
		orderProcess = new  OrderProcess();
		pizzaOrderDatas = new ArrayList<PizzaOrderInfo>();
		orderInfo = new  PizzaOrderInfo();
		orderPizzasInfoList = new ArrayList<OrderPizzasInfo>();
		orderId = new  Long(5);
		userRole = "Consumer";
		userId = new Long(3);
		totalOrderPrice = new Long(200);
		deliveryAddressInfo = new AddressInfo();
		userFullName = "deepak jain";
		customerOrdersAction = new CustomerOrdersAction();
	}

	@Test
	public void testAllSetterGetter() {
		customerOrdersAction.setOrderProcess(orderProcess);
		customerOrdersAction.setPizzaOrderDatas(pizzaOrderDatas);
		customerOrdersAction.setOrderInfo(orderInfo);
		customerOrdersAction.setOrderPizzasInfoList(orderPizzasInfoList);
		customerOrdersAction.setOrderId(orderId);
		customerOrdersAction.setUserRole(userRole);
		customerOrdersAction.setUserId(userId);
		customerOrdersAction.setTotalOrderPrice(totalOrderPrice);
		customerOrdersAction.setDeliveryAddressInfo(deliveryAddressInfo);
		customerOrdersAction.setUserFullName(userFullName);
		assertNotNull(customerOrdersAction.getOrderProcess());
		assertNotNull(customerOrdersAction.getPizzaOrderDatas());
		assertNotNull(customerOrdersAction.getOrderInfo());
		assertNotNull(customerOrdersAction.getOrderPizzasInfoList());
		assertNotNull(customerOrdersAction.getOrderId());
		assertNotNull(customerOrdersAction.getUserRole());
		assertNotNull(customerOrdersAction.getUserId());
		assertNotNull(customerOrdersAction.getTotalOrderPrice());
		assertNotNull(customerOrdersAction.getDeliveryAddressInfo());
		assertNotNull(customerOrdersAction.getUserFullName());
	}
	@After
	public void tearDown() throws Exception {
		orderProcess = null;
		pizzaOrderDatas = null;
		orderInfo= null;
		orderPizzasInfoList= null;
		orderId= null;
		userRole= null;
		userId= null;
		totalOrderPrice= null;
		deliveryAddressInfo= null;
		userFullName= null;
		customerOrdersAction= null;
	}

}
