

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import process.LoginProcess;
import process.UserProfileProcess;
import dao.AddressInfo;
import dao.LoginData;
import dao.UserProfileInfo;
import action.NewRegisterationAction;

public class NewRegisterationActionTest {

	NewRegisterationAction newRegisterationAction;
	LoginProcess loginProcess;
	LoginData loginData;
	AddressInfo addressInfo;
	UserProfileInfo userProfileInfo;
	UserProfileProcess userProfileProcess;
	
	
	@Before
	public void setUp() throws Exception {
		newRegisterationAction = new  NewRegisterationAction();
		loginProcess = new LoginProcess();
		userProfileProcess = new  UserProfileProcess();
		loginData = new  LoginData();
		addressInfo = new AddressInfo();
		userProfileInfo = new  UserProfileInfo();
	}

	@After
	public void tearDown() throws Exception {
		newRegisterationAction = null;
		loginProcess = null;
		userProfileProcess = null;
		loginData = null;
		addressInfo = null;
		userProfileInfo = null;
	}

	@Test
	public void testAllSetterGetter() {
		newRegisterationAction.setLoginProcess(loginProcess);
		newRegisterationAction.setLoginData(loginData);
		newRegisterationAction.setAddressInfo(addressInfo);
		newRegisterationAction.setUserProfileInfo(userProfileInfo);
		newRegisterationAction.setUserProfileProcess(userProfileProcess);
		assertNotNull(newRegisterationAction.getAddressInfo());
		assertNotNull(newRegisterationAction.getUserProfileInfo());
		assertNotNull(newRegisterationAction.getUserProfileProcess());
		assertNotNull(newRegisterationAction.getLoginProcess());
		assertNotNull(newRegisterationAction.getLoginData());
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

	public NewRegisterationAction getNewRegisterationAction() {
		return newRegisterationAction;
	}

	public void setNewRegisterationAction(
			NewRegisterationAction newRegisterationAction) {
		this.newRegisterationAction = newRegisterationAction;
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
