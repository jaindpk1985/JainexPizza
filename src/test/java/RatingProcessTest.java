
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.PizzaData;

import process.RatingProcess;

public class RatingProcessTest {

	private RatingProcess ratingProcess;

	private PizzaData pizzaData;

	private PizzaData pizzaDataTemp;

	@Before
	public void setUp() {
		ratingProcess = new RatingProcess();
		pizzaData = new PizzaData();
		pizzaDataTemp = new PizzaData();
		pizzaData.setPizzaName("Vagenza");
		pizzaData.setBasePrice(100);

		pizzaDataTemp.setPizzaName("Vagenza");
		pizzaDataTemp.setBasePrice(100);
		pizzaDataTemp.setSmallPrice(100);
		pizzaDataTemp.setMediumPrice(180);
		pizzaDataTemp.setLargePrice(360);
	}

	@After
	public void tearDown() {
		ratingProcess = null;
		pizzaData = null;
		pizzaData = null;
	}

	@Test
	public void testSetPizzaRates() {
		assertNotNull(ratingProcess.setPizzaRates(pizzaData));
	}

}
