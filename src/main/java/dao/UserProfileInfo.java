package dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfileInfo implements Serializable {
	private Long userProfileId;

	private LoginData loginData;

	private String firstName;

	private String lastName;

	private String email;

	private String contactNo;

	private Long age;

	private String gender;

	@Id
	@Column(name = "USER_PROFILE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	@Column(name = "USER_CONTACT_NO")
	public String getContactNo() {
		return contactNo;
	}

	@Column(name = "USER_EMAIL")
	public String getEmail() {
		return email;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", insertable = true, updatable = true)
	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	@Column(name = "USER_FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "USER_LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "USER_AGE")
	public Long getAge() {
		return age;
	}

	@Column(name = "USER_GENDER")
	public String getGender() {
		return gender;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
