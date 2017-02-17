

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import action.AddCustomerAction;
import process.LoginProcess;
import process.UserProfileProcess;
import dao.AddressInfo;
import dao.LoginData;
import dao.UserProfileInfo;

public class AddCustomerActionTest {
	
	AddCustomerAction addCustomerAction;
	LoginProcess loginProcess;
	LoginData loginData;
	AddressInfo addressInfo;
	UserProfileInfo userProfileInfo;
	UserProfileProcess userProfileProcess;

	@Before
	public void setUp() throws Exception {
		addCustomerAction = new AddCustomerAction();
		loginProcess = new LoginProcess();
		userProfileProcess = new  UserProfileProcess();
		loginData = new  LoginData();
		addressInfo = new AddressInfo();
		userProfileInfo = new  UserProfileInfo();
	}

	@After
	public void tearDown() throws Exception {
		addCustomerAction = null;
		loginProcess = null;
		userProfileProcess = null;
		loginData = null;
		addressInfo = null;
		userProfileInfo = null;
	}

	@Test
	public void testAllSetterGetter() {
		addCustomerAction.setLoginProcess(loginProcess);
		addCustomerAction.setLoginData(loginData);
		addCustomerAction.setAddressInfo(addressInfo);
		addCustomerAction.setUserFullName("Deepak Jain");
		addCustomerAction.setUserProfileInfo(userProfileInfo);
		addCustomerAction.setUserProfileProcess(userProfileProcess);
		assertNotNull(addCustomerAction.getAddressInfo());
		assertNotNull(addCustomerAction.getUserProfileInfo());
		assertNotNull(addCustomerAction.getUserProfileProcess());
		assertNotNull(addCustomerAction.getLoginProcess());
		assertNotNull(addCustomerAction.getLoginData());
		assertNotNull(addCustomerAction.getUserFullName());
	}

	public AddCustomerAction getAddCustomerAction() {
		return addCustomerAction;
	}

	public void setAddCustomerAction(AddCustomerAction addCustomerAction) {
		this.addCustomerAction = addCustomerAction;
	}

	public AddressInfo getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	public LoginProcess getLoginProcess() {
		return loginProcess;
	}

	public void setLoginProcess(LoginProcess loginProcess) {
		this.loginProcess = loginProcess;
	}

	public UserProfileInfo getUserProfileInfo() {
		return userProfileInfo;
	}

	public void setUserProfileInfo(UserProfileInfo userProfileInfo) {
		this.userProfileInfo = userProfileInfo;
	}

	public UserProfileProcess getUserProfileProcess() {
		return userProfileProcess;
	}

	public void setUserProfileProcess(UserProfileProcess userProfileProcess) {
		this.userProfileProcess = userProfileProcess;
	}
}
