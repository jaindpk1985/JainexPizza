package action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import common.PizzaConstants;
import process.PizzaProcess;
import process.RatingProcess;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.Validateable;
import common.UnexpectedException;

import dao.PizzaData;
import dao.ToppingInfo;

public class AddPizzaAction extends ActionSupport implements Validateable,
		SessionAware, Preparable {

	static final Logger log = Logger.getLogger(AddPizzaAction.class);

	private File image;

	private String imageFileName;

	private PizzaData pizzaData;

	private PizzaProcess pizzaProcess;

	private List<PizzaData> vegPizzas;

	private ToppingInfo toppingInfo;

	private List<ToppingInfo> vegToppings;

	private RatingProcess ratingProcess;

	private List<PizzaData> nonVegPizzas;

	private List<ToppingInfo> nonVegToppings;

	private Map session;

	private String userRole;

	private Long deletedPizzaId;

	private Long updatedPizzaId;

	private Long pizzaBasePrice;

	private String userFullName;

	/*
	 * Initialize the process classes; (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() {
		ratingProcess = new RatingProcess();
		pizzaProcess = new PizzaProcess();
		userFullName = (String) session.get("userFullName");
	}

	/*
	 * Validate the Pizza Data (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {
		if (pizzaData != null && pizzaBasePrice != null) {
			if (pizzaBasePrice <= 0) {
				this.addFieldError("pizzaBasePrice",
						getText("nonNegative.error"));
			}
		}
	}

	/*
	 * Get the pizza and toppings date from the DB (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws UnexpectedException {

		try {
			vegPizzas = pizzaProcess.getPizzaByCategory(true);
			for (PizzaData pizzaData : vegPizzas) {
				ratingProcess.setPizzaRates(pizzaData);
			}
			nonVegPizzas = pizzaProcess.getPizzaByCategory(false);
			for (PizzaData pizzaData : nonVegPizzas) {
				ratingProcess.setPizzaRates(pizzaData);
			}
			vegToppings = pizzaProcess.getToppingsByCategory(true);
			nonVegToppings = pizzaProcess.getToppingsByCategory(false);
			userRole = (String) session.get("userRole");
			if (updatedPizzaId != null) {
				pizzaData = pizzaProcess.getPizzaById(updatedPizzaId);
				pizzaBasePrice = new Long(pizzaData.getBasePrice());
			}
		} catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"), e);
		}

		return SUCCESS;
	}

	/**
	 * Save added pizza on the screen into the DB
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String save() throws UnexpectedException {

		try {
			String fullFileName = "D:/Pizzas/" + imageFileName;
			File theFile = new File(fullFileName);
			if (image != null) {
				String ext = "";
				int mid = fullFileName.lastIndexOf('.');
				ext = fullFileName.substring(mid + 1, fullFileName.length());
				if (!("png".equalsIgnoreCase(ext)
						|| "gif".equalsIgnoreCase(ext)
						|| "jpg".equalsIgnoreCase(ext) || "jpeg"
						.equalsIgnoreCase(ext))) {
					this
							.addFieldError("image",
									"Only png, gif, jpg, jpeg type of files are allowed");
					return INPUT;
				}
				FileUtils.copyFile(image, theFile);
				pizzaData.setPizzaImageName(imageFileName);
			}
			pizzaData.setStatus(PizzaConstants.Pizza.PIZZA_STATUS_ACTIVE);
			pizzaData.setBasePrice(getPizzaBasePrice().intValue());
			if (updatedPizzaId != null) {
				pizzaData.setPizzaId(updatedPizzaId);
			}
			pizzaProcess.saveUpdatePizzaData(pizzaData);

		} catch (IOException e) {
			log.error("An IO exception has occured :", e);
			throw new UnexpectedException("An internal error has occured", e);
		} catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"), e);
		}
		return SUCCESS;
	}

	/**
	 * Delete the Pizza by changing the status of pizza
	 * 
	 * @return
	 * @throws UnexpectedException
	 */
	public String deletePizza() throws UnexpectedException {
		try {
			if (deletedPizzaId != null) {
				PizzaData pizzaData = pizzaProcess.getPizzaById(deletedPizzaId);
				pizzaData.setStatus(PizzaConstants.Pizza.PIZZA_STATUS_INACTIVE);
				pizzaProcess.saveUpdatePizzaData(pizzaData);
			}

		} catch (Exception e) {
			log.error(getText("exception.error"), e);
			throw new UnexpectedException(getText("exception.error"), e);
		}
		return SUCCESS;
	}

	/**
	 * @return session
	 */
	public Map getSession() {
		return session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public PizzaData getPizzaData() {
		return pizzaData;
	}

	public void setPizzaData(PizzaData pizzaData) {
		this.pizzaData = pizzaData;
	}

	public PizzaProcess getPizzaProcess() {
		return pizzaProcess;
	}

	public void setPizzaProcess(PizzaProcess pizzaProcess) {
		this.pizzaProcess = pizzaProcess;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public List<PizzaData> getNonVegPizzas() {
		return nonVegPizzas;
	}

	public void setNonVegPizzas(List<PizzaData> nonVegPizzas) {
		this.nonVegPizzas = nonVegPizzas;
	}

	public List<ToppingInfo> getNonVegToppings() {
		return nonVegToppings;
	}

	public void setNonVegToppings(List<ToppingInfo> nonVegToppings) {
		this.nonVegToppings = nonVegToppings;
	}

	public RatingProcess getRatingProcess() {
		return ratingProcess;
	}

	public void setRatingProcess(RatingProcess ratingProcess) {
		this.ratingProcess = ratingProcess;
	}

	public ToppingInfo getToppingInfo() {
		return toppingInfo;
	}

	public void setToppingInfo(ToppingInfo toppingInfo) {
		this.toppingInfo = toppingInfo;
	}

	public List<PizzaData> getVegPizzas() {
		return vegPizzas;
	}

	public void setVegPizzas(List<PizzaData> vegPizzas) {
		this.vegPizzas = vegPizzas;
	}

	public List<ToppingInfo> getVegToppings() {
		return vegToppings;
	}

	public void setVegToppings(List<ToppingInfo> vegToppings) {
		this.vegToppings = vegToppings;
	}

	public Long getDeletedPizzaId() {
		return deletedPizzaId;
	}

	public void setDeletedPizzaId(Long deletedPizzaId) {
		this.deletedPizzaId = deletedPizzaId;
	}

	/**
	 * @return the updatedPizzaId
	 */
	public Long getUpdatedPizzaId() {
		return updatedPizzaId;
	}

	/**
	 * @param updatedPizzaId
	 *            the updatedPizzaId to set
	 */
	public void setUpdatedPizzaId(Long updatedPizzaId) {
		this.updatedPizzaId = updatedPizzaId;
	}

	public Long getPizzaBasePrice() {
		return pizzaBasePrice;
	}

	public void setPizzaBasePrice(Long pizzaBasePrice) {
		this.pizzaBasePrice = pizzaBasePrice;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

}