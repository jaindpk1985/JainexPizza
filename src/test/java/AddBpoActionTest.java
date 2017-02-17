
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.AddressInfo;
import dao.LoginData;
import dao.UserProfileInfo;
import action.AddBpoAction;
import process.LoginProcess;
import process.UserProfileProcess;

public class AddBpoActionTest {
	AddBpoAction addBpoAction;
	LoginProcess loginProcess;
	LoginData loginData;
	AddressInfo addressInfo;
	UserProfileInfo userProfileInfo;
	UserProfileProcess userProfileProcess;

	@Before
	public void setUp() {
		addBpoAction = new  AddBpoAction();
		loginProcess = new LoginProcess();
		userProfileProcess = new  UserProfileProcess();
		loginData = new  LoginData();
		addressInfo = new AddressInfo();
		userProfileInfo = new  UserProfileInfo();
	}

	@After
	public void tearDown() throws Exception {
		addBpoAction = null;
		loginProcess = null;
		userProfileProcess = null;
		loginData = null;
		addressInfo = null;
		userProfileInfo = null;
	}

	@Test
	public void testAllSetterGetter() {
		addBpoAction.setLoginProcess(loginProcess);
		addBpoAction.setLoginData(loginData);
		addBpoAction.setAddressInfo(addressInfo);
		addBpoAction.setUserFullName("Deepak Jain");
		addBpoAction.setUserProfileInfo(userProfileInfo);
		addBpoAction.setUserProfileProcess(userProfileProcess);
		assertNotNull(addBpoAction.getAddressInfo());
		assertNotNull(addBpoAction.getUserFullName());
		assertNotNull(addBpoAction.getUserProfileProcess());
		assertNotNull(addBpoAction.getLoginProcess());
		assertNotNull(addBpoAction.getLoginData());
		assertNotNull(addBpoAction.getUserProfileInfo());
	}

	public AddBpoAction getAddBpoAction() {
		return addBpoAction;
	}

	public void setAddBpoAction(AddBpoAction addBpoAction) {
		this.addBpoAction = addBpoAction;
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
