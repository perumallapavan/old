package com.sample.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {

	@Id
	@SequenceGenerator(name = "appComSeq", sequenceName = "COMPANY_SQUENCE", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appComSeq")
	@Column(name = "COM_ID")
	private Long com_id;
	private String name;
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<Address>();

	public Company() {
		super();
	}

	public Long getCom_id() {
		return com_id;
	}

	public void setCom_id(Long com_id) {
		this.com_id = com_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
