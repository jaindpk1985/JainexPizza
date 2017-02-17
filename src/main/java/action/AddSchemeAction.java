package action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import process.SchemeOffersProcess;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import common.UnexpectedException;

import dao.OffersInfo;

public class AddSchemeAction extends ActionSupport implements Preparable,
		SessionAware {

	static final Logger log = Logger.getLogger(AddSchemeAction.class);

	private SchemeOffersProcess schemeOffersProcess;

	private OffersInfo offersInfo;

	private Map session;

	private String userFullName;

	/*
	 * Initialize the process classes; (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() {
		schemeOffersProcess = new SchemeOffersProcess();
		userFullName = (String) session.get("userFullName");
	}

	/**
	 * Save the scheme/offers information into the DB
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String save() throws UnexpectedException {

		try {

			schemeOffersProcess.saveUpdateSchemeOffers(offersInfo);

		} catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"), e);
		}

		return SUCCESS;
	}

	/**
	 * @return the offersInfo
	 */
	public OffersInfo getOffersInfo() {
		return offersInfo;
	}

	/**
	 * @param offersInfo
	 *            the offersInfo to set
	 */
	public void setOffersInfo(OffersInfo offersInfo) {
		this.offersInfo = offersInfo;
	}

	/**
	 * @return the schemeOffersProcess
	 */
	public SchemeOffersProcess getSchemeOffersProcess() {
		return schemeOffersProcess;
	}

	/**
	 * @param schemeOffersProcess
	 *            the schemeOffersProcess to set
	 */
	public void setSchemeOffersProcess(SchemeOffersProcess schemeOffersProcess) {
		this.schemeOffersProcess = schemeOffersProcess;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
}
