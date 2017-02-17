
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import process.PaymentProcess;
import dao.PaymentInfo;

public class PaymentProcessTest {

	private PaymentProcess paymentProcess;

	private PaymentInfo paymentInfo;

	@Before
	public void setUp() {
		paymentProcess = new PaymentProcess();
		paymentInfo = new PaymentInfo();
		paymentInfo.setCardType("Visa");
		paymentInfo.setCardHolderName("Deepak Jain");
		paymentInfo.setBankName("SBI");
		paymentInfo.setVerificationNumber("2345");
		paymentInfo.setCardNumber("111111111111");
		paymentInfo.setExpiredMonth(new Long(6));
		paymentInfo.setExpiredYear(new Long(2013));
		paymentInfo.setAmount(new Long(2000));
	}

	@After
	public void tearDown() {
		paymentProcess = null;
		paymentInfo = null;
	}

	@Test
	public void testSavePaymentInfo() {
		try {
			assertEquals(true, paymentProcess.savePaymentInfo(paymentInfo));
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
