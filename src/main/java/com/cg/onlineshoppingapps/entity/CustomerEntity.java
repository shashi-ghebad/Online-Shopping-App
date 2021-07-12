package com.cg.onlineshoppingapps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id")
	@SequenceGenerator(sequenceName = "CUSTOMER_SEQ", allocationSize = 1, name = "customer_id")
	@Column(name = "customer_id")
	private int customerId;

	@NotNull(message = "First Name Should Not Be Null!!")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "Last Name Should Not Be Null!!")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "Mobile Number Should Be Filled")
	@Column(name = "mobile_no")
	private String mobileNumber;

	@NotNull(message = "Email Id Should Be Filled")
	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private AddressEntity address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private UserEntity username;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(int customerId, String firstName, String lastName, String mobileNumber, String email,
			AddressEntity address, UserEntity username) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.username = username;
	}

	public CustomerEntity(String string) {
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public UserEntity getUsername() {
		return username;
	}

	public void setUsername(UserEntity username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + ", username="
				+ username + "]";
	}

}