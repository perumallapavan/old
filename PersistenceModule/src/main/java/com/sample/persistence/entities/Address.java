package com.sample.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@SequenceGenerator(name = "appAddSeq", sequenceName = "ADDRESS_SQUENCE", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appAddSeq")
	@Column(name = "ADD_ID")
	private Long add_id;
	private String street;
	private String houseno;
	private String postalcode;
	private String city;
	private String country;
	private int active;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifydate;
	// private int com_id;

	@ManyToOne
	@JoinColumn(name = "COM_ID")
	private Company company;

	public Address() {
		super();
	}

	public Long getAdd_id() {
		return add_id;
	}

	public void setAdd_id(Long add_id) {
		this.add_id = add_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseno() {
		return houseno;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String toString() {

		return street + " " + houseno + " " + postalcode + " " + city + " "
				+ country;
	}

	@Override
	public boolean equals(Object object) {
		boolean isEqual = true;
		if (object instanceof Address) {
			Address address = (Address) object;
			if (address.getStreet() == null || this.street == null) {
				System.out.println("Street is NULL");
				return false;
			} else if (!this.street.equalsIgnoreCase(address.getStreet())) {
				System.out.println("Street is not Equeal");
				return false;
			} else if (address.getHouseno() == null || this.houseno == null) {
				System.out.println("HouseNo is NULL");
				return false;
			} else if (!this.houseno.equalsIgnoreCase(address.getHouseno())) {
				System.out.println("HouseNO is not Equal");
				return false;
			} else if (address.getPostalcode() == null
					|| this.postalcode == null) {
				System.out.println("PostalCode is NULL");
				return false;
			} else if (!this.postalcode.equalsIgnoreCase(address
					.getPostalcode())) {
				System.out.println("PostalCode is not Equal");
				return false;
			} else if (address.getCity() == null || this.city == null) {
				System.out.println("City is NULL");
				return false;
			} else if (!this.city.equalsIgnoreCase(address.getCity())) {
				System.out.println("City is not Equal");
				return false;
			} else if (address.getCountry() == null || this.country == null) {
				System.out.println("Country is NULL");
				return false;
			} else if (!this.country.equalsIgnoreCase(address.getCountry())) {
				System.out.println("Country is not Equal");
				return false;
			}

		}
		return false;
	}

}
