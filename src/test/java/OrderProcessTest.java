
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import common.UnexpectedException;

import dao.OrderPizzasInfo;
import dao.PizzaOrderInfo;

import process.OrderProcess;

public class OrderProcessTest {

	private OrderProcess orderProcess;
	private PizzaOrderInfo pizzaOrderInfo;
	private OrderPizzasInfo orderPizzasInfo;
	@Before
	public void setUp() throws Exception {
		orderProcess = new OrderProcess();
		pizzaOrderInfo = new PizzaOrderInfo();
		orderPizzasInfo = new  OrderPizzasInfo();
		pizzaOrderInfo.setUserId(new Long(15));
		pizzaOrderInfo.setOrderCreationDate(new Date());
		pizzaOrderInfo.setStatus("Placed");
		pizzaOrderInfo.setDeliveryAddressId(new Long(50));
		pizzaOrderInfo.setPaymentId(new Long(15));
		pizzaOrderInfo.setHomeDelivery(true);
		orderPizzasInfo.setOrderId(new Long(5));
		orderPizzasInfo.setPizzaId(new Long(5));
		orderPizzasInfo.setQuantity(new Long(4));
	}

	@After
	public void tearDown() throws Exception {
		orderProcess = null;
		pizzaOrderInfo = null;
		orderPizzasInfo = null;
	}

	@Test
	public void testSaveUpdatePizzaOrder() {
		try {
			assertEquals(true, orderProcess.saveUpdatePizzaOrder(pizzaOrderInfo));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testSaveUpdateOrderPizza() {
		try {
			assertEquals(true, orderProcess.saveUpdateOrderPizza(orderPizzasInfo));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetCustomerOrders() {
		try {
			assertNotNull(orderProcess.getCustomerOrders());
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetCustomerOrdersByUserId() {
		try {
			assertNotNull(orderProcess.getCustomerOrdersByUserId(new Long(1)));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetOrderInfoByOrderId() {
		try {
			assertNotNull(orderProcess.getOrderInfoByOrderId(new Long(15)));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetOrderPizzasInfoByOrderId() {
		try {
			assertNotNull(orderProcess.getOrderPizzasInfoByOrderId(new Long(30)));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	public OrderPizzasInfo getOrderPizzasInfo() {
		return orderPizzasInfo;
	}

	public void setOrderPizzasInfo(OrderPizzasInfo orderPizzasInfo) {
		this.orderPizzasInfo = orderPizzasInfo;
	}

	public OrderProcess getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(OrderProcess orderProcess) {
		this.orderProcess = orderProcess;
	}

	public PizzaOrderInfo getPizzaOrderInfo() {
		return pizzaOrderInfo;
	}

	public void setPizzaOrderInfo(PizzaOrderInfo pizzaOrderInfo) {
		this.pizzaOrderInfo = pizzaOrderInfo;
	}

}
