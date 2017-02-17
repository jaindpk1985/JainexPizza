
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import process.UserProfileProcess;

import common.UnexpectedException;

import dao.AddressInfo;
import dao.LoginData;
import dao.UserProfileInfo;

public class UserProfileProcessTest {
	private UserProfileProcess userProfileProcess;

	private LoginData loginData;

	private UserProfileInfo userProfileInfo;

	private AddressInfo addressInfo;

	@Before
	public void setUp() throws Exception {
		userProfileProcess = new UserProfileProcess();
		loginData = new LoginData();
		userProfileInfo = new UserProfileInfo();
		addressInfo = new AddressInfo();
		loginData.setUserId(new Long(30));
		loginData.setUserName("deepakjain");
		loginData.setPwd_text("dpkjain");
		loginData.setRole("Bpo");
		userProfileInfo.setFirstName("deepak jain");
		userProfileInfo.setContactNo("9911497944");
		addressInfo.setLoginData(loginData);
		addressInfo.setAddLine("Balbir Nagar");
		addressInfo.setState("Delhi");
		addressInfo.setZipCode("110032");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUserProfile() {
		loginData.setUserName((new Date()).toString());
		userProfileInfo.setLoginData(loginData);
		try {
			assertEquals(true, userProfileProcess
					.createUserProfile(userProfileInfo));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testFindUserInfoByLoginData() {
		loginData.setUserId(new Long(44));
		try {
			assertNotNull(userProfileProcess.findUserInfoByLoginData(loginData));
		} catch (UnexpectedException e) {
			Assert.fail();
		}

	}

	@Test
	public void testCreateAddressInfo() {
		addressInfo.getLoginData().setUserName((new Date()).toString());
		try {
			assertEquals(true, userProfileProcess
					.createAddressInfo(addressInfo));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testFindAddressInfoByLoginData() {
		loginData.setUserId(new Long(7));
		try {
			assertNotNull(userProfileProcess
					.findAddressInfoByLoginData(loginData));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testFindAddressInfoByAddressId() {
		try {
			assertNotNull(userProfileProcess
					.findAddressInfoByAddressId(new Long(60)));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
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
