
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.PaymentAction;

import process.LoginProcess;
import process.PaymentProcess;
import process.UserProfileProcess;
import dao.AddressInfo;
import dao.PaymentInfo;

public class PaymentActionTest {

	private String userRole;
	private PaymentInfo paymentInfo;
	private PaymentProcess paymentProcess;
	private List<String> cardTypeList;
	private List<Long> expMonthList;
	private List<Long> expYearList;
	private String deliveryChoice;
	private AddressInfo addressInfo;
	private LoginProcess loginProcess;
	private UserProfileProcess userProfileProcess;
	private String userFullName;
	private PaymentAction paymentAction;
	
	@Before
	public void setUp() throws Exception {
		userRole = "Consumer";
		paymentInfo = new PaymentInfo();
		paymentProcess = new PaymentProcess();
		cardTypeList = new ArrayList<String>();
		expMonthList = new ArrayList<Long>();
		expYearList = new ArrayList<Long>();
		deliveryChoice = "Pick Up";
		addressInfo = new AddressInfo();
		loginProcess = new LoginProcess();
		userProfileProcess = new  UserProfileProcess();
		userFullName = "deepak jain";
		paymentAction = new PaymentAction();
	}
	
	@Test
	public void testAllSetterGetter() {
		paymentAction.setUserRole(userRole);
		paymentAction.setPaymentInfo(paymentInfo);
		paymentAction.setPaymentProcess(paymentProcess);
		paymentAction.setCardTypeList(cardTypeList);
		paymentAction.setExpMonthList(expMonthList);
		paymentAction.setExpYearList(expYearList);
		paymentAction.setDeliveryChoice(deliveryChoice);
		paymentAction.setAddressInfo(addressInfo);
		paymentAction.setLoginProcess(loginProcess);
		paymentAction.setUserProfileProcess(userProfileProcess);
		paymentAction.setUserFullName(userFullName);
		assertNotNull(paymentAction.getUserRole());
		assertNotNull(paymentAction.getPaymentInfo());
		assertNotNull(paymentAction.getPaymentProcess());
		assertNotNull(paymentAction.getCardTypeList());
		assertNotNull(paymentAction.getExpMonthList());
		assertNotNull(paymentAction.getExpYearList());
		assertNotNull(paymentAction.getDeliveryChoice());
		assertNotNull(paymentAction.getAddressInfo());
		assertNotNull(paymentAction.getLoginProcess());
		assertNotNull(paymentAction.getUserProfileProcess());
		assertNotNull(paymentAction.getUserFullName());
		
	}

	@After
	public void tearDown() throws Exception {
		userRole = null;
		paymentInfo =  null;
		paymentProcess =  null;
		cardTypeList =  null;
		expMonthList =  null;
		expYearList =  null;
		deliveryChoice =  null;
		addressInfo =  null;
		loginProcess =  null;
		userProfileProcess =  null;
		userFullName =  null;
	}

}
