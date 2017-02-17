package action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import process.LoginProcess;
import process.UserProfileProcess;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.Validateable;
import common.UnexpectedException;
import common.PizzaConstants;
import dao.AddressInfo;
import dao.LoginData;
import dao.UserProfileInfo;

public class NewRegisterationAction extends ActionSupport implements
		SessionAware, Validateable, Preparable {
	static final Logger log = Logger.getLogger(NewRegisterationAction.class);

	private UserProfileInfo userProfileInfo;

	private AddressInfo addressInfo;

	private LoginData loginData;

	private UserProfileProcess userProfileProcess;

	private LoginProcess loginProcess;

	private Map session;

	/*
	 * Initialize the process classes (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() {
		loginProcess = new LoginProcess();
		userProfileProcess = new UserProfileProcess();
	}

	/*
	 * Validate the login data (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {

		try {
			if (!StringUtils.isEmpty(loginData.getUserName())) {
				if (loginProcess
						.getLoginInfoByUserName(loginData.getUserName()) != null) {
					this.addFieldError("loginData.userName",
							getText("alreadyInUse"));
				}
			}
			if (loginData.getPwd_text() != null
					&& !"".equals(loginData.getPwd_text())
					&& loginData.getPwd_text().length() >= 6) {
				Pattern pattern1 = Pattern.compile(".*[0-9].*");
				Pattern pattern2 = Pattern.compile(".*[A-Za-z].*");
				Matcher m1 = pattern1.matcher(loginData.getPwd_text());
				Matcher m2 = pattern2.matcher(loginData.getPwd_text());
				// Check whether a match is found
				if (!m1.matches() || !m2.matches()) {
					addFieldError("loginData.pwd_text",
							getText("atLeastAlphaNumeric.error"));
				}
			}
			if (!StringUtils.isEmpty(loginData.getPwd_text())
					&& !StringUtils.isEmpty(loginData.getConfirmPassword())) {
				if (!loginData.getPwd_text().equals(
						loginData.getConfirmPassword())) {
					this.addFieldError("loginData.pwd_text",
							getText("passwordMatch.error"));
					this.addFieldError("loginData.confirmPassword",
							getText("passwordMatch.error"));
				}
			}
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
		}
	}

	/**
	 * Save the information entered by the new user
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String save() throws UnexpectedException {
		try {
			loginData.setRole(PizzaConstants.UserRole.ROLE_CONSUMER);
			userProfileInfo.setLoginData(loginData);
			userProfileProcess.createUserProfile(userProfileInfo);
			addressInfo.setLoginData(loginData);
			userProfileProcess.createAddressInfo(addressInfo);
			
			String userFullName = userProfileInfo.getFirstName() + " " + userProfileInfo.getLastName();
			session.put("userFullName",userFullName);
			session.put("userId", loginData.getUserId());
			session.put("userRole", loginData.getRole());
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"),e);
		}

		return SUCCESS;
	}

	/**
	 * @return the addressInfo
	 */
	public AddressInfo getAddressInfo() {
		return addressInfo;
	}

	/**
	 * @return the userProfileInfo
	 */
	public UserProfileInfo getUserProfileInfo() {
		return userProfileInfo;
	}

	/**
	 * @param addressInfo
	 *            the addressInfo to set
	 */
	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

	/**
	 * @param userProfileInfo
	 *            the userProfileInfo to set
	 */
	public void setUserProfileInfo(UserProfileInfo userProfileInfo) {
		this.userProfileInfo = userProfileInfo;
	}

	/**
	 * @return the userProfileProcess
	 */
	public UserProfileProcess getUserProfileProcess() {
		return userProfileProcess;
	}

	/**
	 * @param userProfileProcess
	 *            the userProfileProcess to set
	 */
	public void setUserProfileProcess(UserProfileProcess userProfileProcess) {
		this.userProfileProcess = userProfileProcess;
	}

	/**
	 * @return the loginProcess
	 */
	public LoginProcess getLoginProcess() {
		return loginProcess;
	}

	/**
	 * @param loginProcess
	 *            the loginProcess to set
	 */
	public void setLoginProcess(LoginProcess loginProcess) {
		this.loginProcess = loginProcess;
	}

	/**
	 * @return the loginData
	 */
	public LoginData getLoginData() {
		return loginData;
	}

	/**
	 * @param loginData
	 *            the loginData to set
	 */
	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
}
