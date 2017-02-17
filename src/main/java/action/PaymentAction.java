package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import common.PizzaConstants;
import process.LoginProcess;
import process.PaymentProcess;
import process.UserProfileProcess;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import common.UnexpectedException;

import dao.AddressInfo;
import dao.LoginData;
import dao.OrderPizzasInfo;
import dao.PaymentInfo;

public class PaymentAction extends ActionSupport implements SessionAware,
		Preparable {

	static final Logger log = Logger.getLogger(PaymentAction.class);

	private String userRole;

	private PaymentInfo paymentInfo;

	private PaymentProcess paymentProcess;

	private List<String> cardTypeList;

	private List<Long> expMonthList;

	private List<Long> expYearList;

	private String deliveryChoice;

	private AddressInfo addressInfo;

	private LoginProcess loginProcess;

	private UserProfileProcess userProfileProcess;

	private Map session;

	private String userFullName;

	/*
	 * Initialize the data (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() {
		userRole = (String) session.get("userRole");
		cardTypeList = new ArrayList<String>();
		expMonthList = new ArrayList<Long>();
		expYearList = new ArrayList<Long>();

		cardTypeList.add("");
		cardTypeList.add("Visa Card");
		cardTypeList.add("Master Card");
		cardTypeList.add("Discover");
		cardTypeList.add("American Exp.");

		for (int i = 1; i <= 12; i++) {
			expMonthList.add(new Long(i));
		}
		for (int i = 2012; i <= 2030; i++) {
			expYearList.add(new Long(i));
		}
		paymentProcess = new PaymentProcess();
		loginProcess = new LoginProcess();
		userProfileProcess = new UserProfileProcess();
		userFullName = (String) session.get("userFullName");
	}

	/*
	 * Get the ordered data (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		paymentInfo = new PaymentInfo();
		Long totalBillPrice = new Long(0);
		Long userId = (Long) session.get("userId");
		Long customerUserId = (Long) session.get("customerUserId");
		LoginData loginData = null;
		try {
			if (PizzaConstants.UserRole.ROLE_CONSUMER.equals(userRole)) {
				loginData = loginProcess.getLoginInfoByUserId(userId);
			} else if (PizzaConstants.UserRole.ROLE_BPO.equals(userRole)) {
				loginData = loginProcess.getLoginInfoByUserId(customerUserId);
			}
			if (loginData != null) {
				addressInfo = userProfileProcess
						.findAddressInfoByLoginData(loginData);
			}
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
		}

		List<OrderPizzasInfo> orderedPizzaDataList = (List<OrderPizzasInfo>) session
				.get("orderedPizzaDataList");
		if (orderedPizzaDataList != null) {
			for (OrderPizzasInfo orderPizzasInfo : orderedPizzaDataList) {
				totalBillPrice += orderPizzasInfo.getTotalPizzaPrice();
			}
		}
		session.put("deliveryChoice",
				PizzaConstants.DeliveryChoice.HOME_DELIVERY);
		paymentInfo.setAmount(totalBillPrice);
		return SUCCESS;
	}

	/**
	 * Save the payment information into the DB
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String savePayment() throws UnexpectedException {
		try {
			userProfileProcess.createAddressInfo(addressInfo);
			session.put("deliveryAddrId", addressInfo.getAddressId());
			paymentProcess.savePaymentInfo(paymentInfo);
		} catch (UnexpectedException e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"), e);
		}
		return SUCCESS;
	}

	public Map getSession() {
		return session;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the paymentInfo
	 */
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	/**
	 * @param paymentInfo
	 *            the paymentInfo to set
	 */
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	/**
	 * @return the paymentProcess
	 */
	public PaymentProcess getPaymentProcess() {
		return paymentProcess;
	}

	/**
	 * @param paymentProcess
	 *            the paymentProcess to set
	 */
	public void setPaymentProcess(PaymentProcess paymentProcess) {
		this.paymentProcess = paymentProcess;
	}

	/**
	 * @return the cardTypeList
	 */
	public List<String> getCardTypeList() {
		return cardTypeList;
	}

	/**
	 * @param cardTypeList
	 *            the cardTypeList to set
	 */
	public void setCardTypeList(List<String> cardTypeList) {
		this.cardTypeList = cardTypeList;
	}

	/**
	 * @return the expMonthList
	 */
	public List<Long> getExpMonthList() {
		return expMonthList;
	}

	/**
	 * @param expMonthList
	 *            the expMonthList to set
	 */
	public void setExpMonthList(List<Long> expMonthList) {
		this.expMonthList = expMonthList;
	}

	/**
	 * @return the expYearList
	 */
	public List<Long> getExpYearList() {
		return expYearList;
	}

	/**
	 * @param expYearList
	 *            the expYearList to set
	 */
	public void setExpYearList(List<Long> expYearList) {
		this.expYearList = expYearList;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getDeliveryChoice() {
		return deliveryChoice;
	}

	public void setDeliveryChoice(String deliveryChoice) {
		this.deliveryChoice = deliveryChoice;
	}

	public AddressInfo getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

	public LoginProcess getLoginProcess() {
		return loginProcess;
	}

	public void setLoginProcess(LoginProcess loginProcess) {
		this.loginProcess = loginProcess;
	}

	public UserProfileProcess getUserProfileProcess() {
		return userProfileProcess;
	}

	public void setUserProfileProcess(UserProfileProcess userProfileProcess) {
		this.userProfileProcess = userProfileProcess;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

}
