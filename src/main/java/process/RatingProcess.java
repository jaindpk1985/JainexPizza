package process;

import org.apache.log4j.Logger;

import common.UnexpectedException;

import dao.PizzaData;

public class RatingProcess {

	static final Logger log = Logger.getLogger(RatingProcess.class);
	/**
	 * Set the all size pizza prices on the basis of base rate
	 * 
	 * @param pizzaData
	 * @return Pizza Data
	 * @throws UnexpectedException
	 */
	public PizzaData setPizzaRates(PizzaData pizzaData){

			int baseRate = pizzaData.getBasePrice();
			pizzaData.setSmallPrice(baseRate);
			pizzaData.setMediumPrice(baseRate * 2
					- (int) Math.round(baseRate * 2 * 0.1));
			pizzaData.setLargePrice(baseRate * 4
					- (int) Math.round(baseRate * 2 * 0.2));
			return pizzaData;

	}

}
