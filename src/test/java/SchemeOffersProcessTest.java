
import static org.junit.Assert.assertEquals;

import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import process.SchemeOffersProcess;
import dao.OffersInfo;

public class SchemeOffersProcessTest {

	private SchemeOffersProcess schemeOffersProcess;
	private OffersInfo offersInfo;
	@Before
	public void setUp() {
		schemeOffersProcess = new SchemeOffersProcess();
		offersInfo = new OffersInfo();
		offersInfo.setOfferName("Festive Discount");
		offersInfo.setOfferDesc("Allow 30% discount");
		offersInfo.setStartDate(new Date(02/03/2012));
		offersInfo.setEndDate(new Date(07/06/2012));
		offersInfo.setOfferDiscount(new Long(20));
	}

	@After
	public void tearDown() {
		schemeOffersProcess = null;
		offersInfo = null;
	}

	@Test
	public void testSaveUpdateSchemeOffers() {
		try {
			assertEquals(true,schemeOffersProcess.saveUpdateSchemeOffers(offersInfo));
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
