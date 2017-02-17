package dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ADDRESS")
public class AddressInfo implements Serializable {
	private LoginData loginData;

	private Long addressId;

	private String addLine;

	private String city;

	private String state;

	private String zipCode;

	@Column(name = "ADDRESS_LINE")
	public String getAddLine() {
		return addLine;
	}

	@Id
	@Column(name = "ADDRESS_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getAddressId() {
		return addressId;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setAddLine(String addLine) {
		this.addLine = addLine;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	@Column(name = "ZIPCODE")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
