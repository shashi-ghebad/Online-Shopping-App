package com.cg.onlineshoppingapps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id")
	@SequenceGenerator(sequenceName = "ADDRESS_SEQ", allocationSize = 1, name = "address_id")
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "street_no")
	private String streetNo;

	@Column(name = "building_name")
	private String buildingName;

	@NotNull(message = "It Is Mandatory!!")
	@Column(name = "city")
	private String city;

	@NotNull(message = "State Cannot Be Null")
	@Column(name = "state")
	private String state;

	@NotNull(message = "Country Field Should Be Filled")
	@Column(name = "country")
	private String country;

	@NotNull(message = "Pincode Is Mandatory")
	@Column(name = "pincode")
	private int pincode;

	public AddressEntity() {
		super();
	}

	public AddressEntity(int addressId, String streetNo, String buildingName, String city, String state, String country,
			int pincode) {
		super();
		this.addressId = addressId;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public AddressEntity(String string) {
	}

	public AddressEntity(int i) {
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetNo=" + streetNo + ", buildingName=" + buildingName
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}

}
