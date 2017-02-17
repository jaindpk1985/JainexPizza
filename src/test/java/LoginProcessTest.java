
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import common.UnexpectedException;

import dao.LoginData;

import process.LoginProcess;

public class LoginProcessTest {

	private LoginProcess loginProcess;
	private LoginData loginData;
	
	@Before
	public void setUp() throws Exception {
		loginProcess = new LoginProcess();
		loginData = new LoginData();
		loginData.setUserName("deepakjain");
		loginData.setPwd_text("dpkjain");
		loginData.setRole("Bpo");
	}

	@After
	public void tearDown() throws Exception {
		loginProcess = null;
		loginData = null;
	}

	@Test
	public void testAunthenticateUser() {
		try {
			assertNotNull(loginProcess.authenticateUser(loginData));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testCreateUser() {
		loginData.setUserName((new Date()).toString());
		try {
			assertEquals(true, loginProcess.createUser(loginData));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
		
	}

	@Test
	public void testGetLoginInfoByUserId() {
		try {
			assertNotNull(loginProcess.getLoginInfoByUserId(new Long(49)));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetLoginInfoByUserName() {
		try {
			assertNotNull(loginProcess.getLoginInfoByUserName("deepakjain"));
		} catch (UnexpectedException e) {
			Assert.fail();
		}
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

}
