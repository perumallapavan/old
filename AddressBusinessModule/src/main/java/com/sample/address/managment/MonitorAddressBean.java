/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample programe. Please contact Sample org, fakestr. 17, 
 * 40667 Dusseldorf, Germany or visit www.sample.com if you need additional 
 * information or have any questions.
 */
package com.sample.address.managment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sample.address.util.EmailUtility;
import com.sample.persistence.entities.Address;
import com.sample.persistence.entities.Company;
import com.sample.persistence.manager.AddressManagerBeanLocal;
import com.sample.persistence.manager.CompanyManagerBeanLocal;

/**
 * Session Bean implementation class MonitorAddressBean
 * 
 * @author A.Ijaz
 * @version 0.1
 */
@Stateless
public class MonitorAddressBean implements MonitorAddressBeanLocal {

	/** CompanyManagerBean object */
	@EJB(mappedName = "CompanyManagerBean/local")
	private CompanyManagerBeanLocal companyManagerBeanLocal;

	/** AddressManagerBean object */
	@EJB(mappedName = "AddressManagerBean/local")
	private AddressManagerBeanLocal addressManagerBeanLocal;

	/**
	 * Default constructor.
	 */
	public MonitorAddressBean() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
     * @see com.sample.address.managment.MonitorAddressBeanLocal#monitorURL(String)
     */
	@Override
	public boolean monitorURL(String url) {
		// TODO Auto-generated method stub
		boolean isAddressChnaged = false;

		Document doc;
		Address extractedAddress = new Address();
		try {
			doc = Jsoup.connect("http://www.regis24.de/impressum.php").get();
			Elements elements = doc.select("h1 ~ *");
			for (Element e : elements) {
				Element node = e.nextElementSibling();
				ArrayList<String> addressStr = extractAddress(e.text());

				extractedAddress.setStreet(addressStr.get(2) + " "
						+ addressStr.get(3));
				extractedAddress.setHouseno(addressStr.get(4));
				extractedAddress.setPostalcode(addressStr.get(5));
				extractedAddress.setCity(addressStr.get(6));
				extractedAddress.setCountry("");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Company company = companyManagerBeanLocal.fetchByName("regis24");

		if (company == null) {
			company = new Company();
			company.setName("regis24");
			extractedAddress.setActive(1);
			extractedAddress.setModifydate(new Date());
			company.getAddresses().add(extractedAddress);
			companyManagerBeanLocal.insertCompany(company);
			
			String subject=company.getName()+" Address Changed";
	        String body= company +" Address has change to "+  extractedAddress.toString();
			EmailUtility.sendEmail(subject, body);
			isAddressChnaged = true;
		} else {
			Address exsistingActiveAddress = addressManagerBeanLocal
					.fetchActiveAddress(company.getCom_id());
			isAddressChnaged = isAddressNew(extractedAddress,
					exsistingActiveAddress);
			if (isAddressChnaged) {
				extractedAddress.setActive(1);
				extractedAddress.setModifydate(new Date());
				addressManagerBeanLocal.insertAddress(extractedAddress);

				addressManagerBeanLocal.updateAddresss(exsistingActiveAddress,
						0);
				EmailUtility.sendEmail(company.getName(),
						extractedAddress.toString());
				isAddressChnaged = true;
			}
		}

		return isAddressChnaged;
	}

	/**
	 * Extract address from jsoup doc object
	 * 
	 * @param doc
	 *            page doc object
	 * @return Address splited in list of Strings
	 * 
	 */
	private ArrayList<String> extractAddress(String doc) {

		ArrayList<String> address = null;
		String[] splits = doc.split(" ");
		String subarray[] = Arrays.copyOfRange(splits, 0, 7);

		address = new ArrayList<String>(Arrays.asList(subarray));
		return address;

	}

	/**
	 * check if address is new or old
	 * 
	 * @param extractedAddress
	 *            new address extracted from the url
	 * @return exsistingActiveAddress Existing address in the system
	 * 
	 */
	private boolean isAddressNew(Address extractedAddress,
			Address exsistingActiveAddress) {

		boolean isNew = false;
		if (exsistingActiveAddress == null) {
			isNew = true;
		} else {
			if (!exsistingActiveAddress.equals(extractedAddress))
				isNew = true;
			else
				isNew = false;
		}

		return isNew;
	}

}
