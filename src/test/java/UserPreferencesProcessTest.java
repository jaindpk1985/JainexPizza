
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import common.UnexpectedException;

import process.UserPreferencesProcess;
import dao.UserPreferencesInfo;

public class UserPreferencesProcessTest {

	private UserPreferencesProcess userPreferencesProcess;

	private UserPreferencesInfo userPreferencesInfo;

	private Long userId;

	private Long pizzaId;

	@Before
	public void setUp() {
		userPreferencesProcess = new UserPreferencesProcess();
		userPreferencesInfo = new UserPreferencesInfo();
		userPreferencesInfo.setPizzaId(new Long(10));
		userPreferencesInfo.setUserId(new Long(8));
		userId = new Long(15);
		pizzaId = new Long(6);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testSaveUpdateUserPreferences() {
		try {
			assertEquals(true, userPreferencesProcess
					.saveUpdateUserPreferences(userPreferencesInfo));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetUserPreferencesByUserId() {
		try {
			assertNotNull(userPreferencesProcess
					.getUserPreferencesByUserId(userId));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetUserPreferencesByUserIdandPizzaId() {
		try {
			assertNotNull(userPreferencesProcess
					.getUserPreferencesByUserIdandPizzaId(userId, pizzaId));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testDeleteUserPreference() {
		try {
			assertEquals(true, userPreferencesProcess
					.deleteUserPreference(userPreferencesInfo));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserPreferencesInfo getUserPreferencesInfo() {
		return userPreferencesInfo;
	}

	public void setUserPreferencesInfo(UserPreferencesInfo userPreferencesInfo) {
		this.userPreferencesInfo = userPreferencesInfo;
	}

	public UserPreferencesProcess getUserPreferencesProcess() {
		return userPreferencesProcess;
	}

	public void setUserPreferencesProcess(
			UserPreferencesProcess userPreferencesProcess) {
		this.userPreferencesProcess = userPreferencesProcess;
	}

}
