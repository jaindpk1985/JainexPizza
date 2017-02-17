package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import process.LoginProcess;
import process.UserProfileProcess;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import common.UnexpectedException;

import dao.AddressInfo;
import dao.LoginData;
import dao.UserProfileInfo;

public class UserProfileAction extends ActionSupport implements Preparable,
		SessionAware {

	static final Logger log = Logger.getLogger(UserProfileAction.class);

	private Long userId;

	private UserProfileProcess userProfileProcess;

	private UserProfileInfo userProfileInfo;

	private AddressInfo addressInfo;

	private Map session;

	private Map<String, String> genders;

	private LoginProcess loginProcess;

	private LoginData loginData;

	private String userFullName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() {
		genders = new HashMap<String, String>();
		genders.put("M", "Male");
		genders.put("F", "Fenale");
		loginProcess = new LoginProcess();
		userProfileProcess = new UserProfileProcess();
		userFullName = (String) session.get("userFullName");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		userId = (Long) session.get("userId");
		try {
			if (userId != null) {
				loginData = loginProcess.getLoginInfoByUserId(userId);
				userProfileInfo = userProfileProcess
						.findUserInfoByLoginData(loginData);
				addressInfo = userProfileProcess
						.findAddressInfoByLoginData(loginData);
			}
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
		}

		return SUCCESS;
	}

	/**
	 * Save the profile information entered by the user
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String save() throws UnexpectedException {
		userId = (Long) session.get("userId");
		try {
			if (userId != null) {
				loginData = loginProcess.getLoginInfoByUserId(userId);
				userProfileInfo.setLoginData(loginData);
				userProfileProcess.createUserProfile(userProfileInfo);
				addressInfo.setLoginData(loginData);
				userProfileProcess.createAddressInfo(addressInfo);
			}
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"), e);
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the userProfileInfo
	 */
	public UserProfileInfo getUserProfileInfo() {
		return userProfileInfo;
	}

	/**
	 * @return the userProfileProcess
	 */
	public UserProfileProcess getUserProfileProcess() {
		return userProfileProcess;
	}

	/**
	 * @param addressInfo
	 *            the addressInfo to set
	 */
	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @param userProfileInfo
	 *            the userProfileInfo to set
	 */
	public void setUserProfileInfo(UserProfileInfo userProfileInfo) {
		this.userProfileInfo = userProfileInfo;
	}

	/**
	 * @param userProfileProcess
	 *            the userProfileProcess to set
	 */
	public void setUserProfileProcess(UserProfileProcess userProfileProcess) {
		this.userProfileProcess = userProfileProcess;
	}

	/**
	 * @return the session
	 */
	public Map getSession() {
		return session;
	}

	/**
	 * @param genders
	 *            the genders to set
	 */
	public void setGenders(Map<String, String> genders) {
		this.genders = genders;
	}

	/**
	 * @return
	 */
	public LoginData getLoginData() {
		return loginData;
	}

	public LoginProcess getLoginProcess() {
		return loginProcess;
	}

	/**
	 * @param loginData
	 */
	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	public void setLoginProcess(LoginProcess loginProcess) {
		this.loginProcess = loginProcess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	public Map<String, String> getGenders() {
		return genders;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
}
