
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import process.PizzaProcess;
import dao.PizzaData;

public class PizzaProcessTest {

	private PizzaProcess pizzaProcess;

	private Boolean isVeg;

	private Long pizzaId;

	private PizzaData pizzaData;

	@Before
	public void setUp() {
		pizzaProcess = new PizzaProcess();
		isVeg = true;
		pizzaId = new Long(10);
		pizzaData = new PizzaData();
		pizzaData.setPizzaName("Veg Extra");
		pizzaData.setDescription("Onion,Tomatto");
		pizzaData.setIsVeg(isVeg);
		pizzaData.setBasePrice(100);
		pizzaData.setStatus("Active");
	}

	@After
	public void tearDown() {
		pizzaProcess = null;
		pizzaData = null;

	}

	@Test
	public void testGetPizzaByCategory() {
		try {
			assertNotNull(pizzaProcess.getPizzaByCategory(isVeg));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testSaveUpdatePizzaData() {

		try {
			assertEquals(true, pizzaProcess.saveUpdatePizzaData(pizzaData));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetToppingsByCategory() {
		try {
			assertNotNull(pizzaProcess.getToppingsByCategory(isVeg));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetPizzaById() {
		try {
			assertNotNull(pizzaProcess.getPizzaById(pizzaId));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetToppingById() {
		try {
			assertNotNull(pizzaProcess.getToppingById(pizzaId));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testRemovePizzaData() {
		try {
			pizzaData.setStatus("Deactive");
			assertEquals(true, pizzaProcess.saveUpdatePizzaData(pizzaData));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetPizzaByCategoryAndName() {
		try {
			assertNotNull(pizzaProcess.getPizzaByCategoryAndName(true, "Shahi"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetPizzaByCategoryAndContent() {
		try {
			assertNotNull(pizzaProcess.getPizzaByCategoryAndName(true, "paneer"));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public Boolean getIsVeg() {
		return isVeg;
	}

	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}

	public PizzaData getPizzaData() {
		return pizzaData;
	}

	public void setPizzaData(PizzaData pizzaData) {
		this.pizzaData = pizzaData;
	}

	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public PizzaProcess getPizzaProcess() {
		return pizzaProcess;
	}

	public void setPizzaProcess(PizzaProcess pizzaProcess) {
		this.pizzaProcess = pizzaProcess;
	}
}
