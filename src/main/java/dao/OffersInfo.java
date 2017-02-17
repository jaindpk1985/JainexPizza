/**
 * 
 */
package dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OFFERS")
public class OffersInfo implements Serializable {
	private Long offerId;

	private String offerName;

	private Date startDate;

	private Date endDate;

	private String offerDesc;

	private Long offerDiscount;

	/**
	 * @return the end_Date
	 */
	@Column(name = "OFFER_END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @return the offerDesc
	 */
	@Column(name = "OFFER_DESC")
	public String getOfferDesc() {
		return offerDesc;
	}

	/**
	 * @return the offerId
	 */
	@Id
	@Column(name = "OFFER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getOfferId() {
		return offerId;
	}

	/**
	 * @return the offerName
	 */
	@Column(name = "OFFER_NAME")
	public String getOfferName() {
		return offerName;
	}

	/**
	 * @return the start_Date
	 */
	@Column(name = "OFFER_START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param end_Date
	 *            the end_Date to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param offerDesc
	 *            the offerDesc to set
	 */
	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	/**
	 * @param offerId
	 *            the offerId to set
	 */
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	/**
	 * @param offerName
	 *            the offerName to set
	 */
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	/**
	 * @param start_Date
	 *            the start_Date to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "OFFER_DISCOUNT")
	public Long getOfferDiscount() {
		return offerDiscount;
	}

	public void setOfferDiscount(Long offerDiscount) {
		this.offerDiscount = offerDiscount;
	}

}
