package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class PaymentInfo implements Serializable {

	private Long paymentId;

	private String cardHolderName;

	private String cardType;
	
	private String bankName;

	private String cardNumber;

	private String verificationNumber;

	private Long expiredMonth;

	private Long expiredYear;

	private Long amount;

	/**
	 * @return the amount
	 */
	@Column(name = "AMOUNT", nullable = false)
	public Long getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * @return the cardHolderName
	 */
	@Column(name = "CARD_HOLDER_NAME", nullable = false)
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * @param cardHolderName
	 *            the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * @return the cardNumber
	 */
	@Column(name = "CARD_NUMBER", nullable = false)
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cardType
	 */
	@Column(name = "CARD_TYPE", nullable = false)
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the expiredMonth
	 */
	@Column(name = "EXPIRED_MONTH", nullable = false)
	public Long getExpiredMonth() {
		return expiredMonth;
	}

	/**
	 * @param expiredMonth
	 *            the expiredMonth to set
	 */
	public void setExpiredMonth(Long expiredMonth) {
		this.expiredMonth = expiredMonth;
	}

	/**
	 * @return the expiredYear
	 */
	@Column(name = "EXPIRED_YEAR", nullable = false)
	public Long getExpiredYear() {
		return expiredYear;
	}

	/**
	 * @param expiredYear
	 *            the expiredYear to set
	 */
	public void setExpiredYear(Long expiredYear) {
		this.expiredYear = expiredYear;
	}

	/**
	 * @return the paymentId
	 */
	@Id
	@Column(name = "PAYMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId
	 *            the paymentId to set
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the verificationNumber
	 */
	@Column(name = "VERIFICATION_NUMBER", nullable = false)
	public String getVerificationNumber() {
		return verificationNumber;
	}

	/**
	 * @param verificationNumber
	 *            the verificationNumber to set
	 */
	public void setVerificationNumber(String verificationNumber) {
		this.verificationNumber = verificationNumber;
	}

	/**
	 * @return the bankName
	 */
	@Column(name = "BANK_NAME", nullable = false)
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


}
