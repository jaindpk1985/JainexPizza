
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.UserProfileAction;

import process.LoginProcess;
import process.UserProfileProcess;
import dao.AddressInfo;
import dao.LoginData;
import dao.UserProfileInfo;

public class UserProfileActionTest {
	
	private Long userId;
	private UserProfileProcess userProfileProcess;
	private UserProfileInfo userProfileInfo;
	private AddressInfo addressInfo;
	private Map<String, String> genders;
	private LoginProcess loginProcess;
	private LoginData loginData;
	private String userFullName;
	private UserProfileAction userProfileAction;

	@Before
	public void setUp() throws Exception {
		userId = new Long(10);
		userProfileProcess = new UserProfileProcess();
		userProfileInfo = new UserProfileInfo();
		addressInfo = new AddressInfo();
		genders = new HashMap<String, String>();
		loginProcess = new LoginProcess();
		loginData = new LoginData();
		userFullName = "deepak jain";
		userProfileAction = new UserProfileAction();
	}

	@Test
	public void testAllSetterGetter() {
		userProfileAction.setUserId(userId);
		userProfileAction.setUserProfileProcess(userProfileProcess);
		userProfileAction.setUserProfileInfo(userProfileInfo);
		userProfileAction.setAddressInfo(addressInfo);
		userProfileAction.setGenders(genders);
		userProfileAction.setLoginProcess(loginProcess);
		userProfileAction.setLoginData(loginData);
		userProfileAction.setUserFullName(userFullName);
		assertNotNull(userProfileAction.getUserId());
		assertNotNull(userProfileAction.getUserProfileProcess());
		assertNotNull(userProfileAction.getUserProfileInfo());
		assertNotNull(userProfileAction.getAddressInfo());
		assertNotNull(userProfileAction.getGenders());
		assertNotNull(userProfileAction.getLoginProcess());
		assertNotNull(userProfileAction.getLoginData());
		assertNotNull(userProfileAction.getUserFullName());		
		
	}
	@After
	public void tearDown() throws Exception {
		userId = null;
		userProfileProcess = null;
		userProfileInfo = null;
		addressInfo = null;
		genders = null;
		loginProcess = null;
		loginData = null;
		userFullName = null;
		userProfileAction = null;
	}

}
