package action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import process.LoginProcess;
import process.UserProfileProcess;

import common.PizzaConstants;
import common.UnexpectedException;

import dao.AddressInfo;
import dao.LoginData;
import dao.UserProfileInfo;

public class AddCustomerAction extends ActionSupport implements SessionAware,
		Preparable {

	static final Logger log = Logger.getLogger(AddCustomerAction.class);

	private UserProfileInfo userProfileInfo;

	private AddressInfo addressInfo;

	private LoginData loginData;

	private UserProfileProcess userProfileProcess;

	private LoginProcess loginProcess;

	private Map session;

	private String userFullName;
	
	private String contactNo;
	

	/*
	 * Initialize the process classes (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() {
		loginProcess = new LoginProcess();
		userProfileProcess = new UserProfileProcess();
		userFullName = (String) session.get("userFullName");
	}
	
	public String execute(){
		if(contactNo!=null){
			try {
				LoginData loginData = loginProcess.getLoginInfoByUserName(contactNo);
				if(loginData!=null){
					userProfileInfo = userProfileProcess.findUserInfoByLoginData(loginData);
					addressInfo = userProfileProcess.findAddressInfoByLoginData(loginData);
				}
			} catch (UnexpectedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return SUCCESS;
	}

	/*
	 * Validate the login date entered by user (non-Javadoc)
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
							getText("alreadyRegistered"));
				}
			}
		} catch (Exception e) {
			log.error(getText("exception.error"), e);
		}

	}

	/**
	 * save all Bpo information entered by admiin
	 * 
	 * @return success
	 * @throws UnexpectedException
	 */
	public String save() throws UnexpectedException {
		try {
			loginData.setRole(PizzaConstants.UserRole.ROLE_CONSUMER);
			loginProcess.createUser(loginData);
			userProfileInfo.setLoginData(loginData);
			userProfileProcess.createUserProfile(userProfileInfo);
			addressInfo.setLoginData(loginData);
			userProfileProcess.createAddressInfo(addressInfo);
			session.put("customerUserId", loginData.getUserId());
		} catch (Exception e) {
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

	/**
	 * @return the session
	 */
	public Map getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
