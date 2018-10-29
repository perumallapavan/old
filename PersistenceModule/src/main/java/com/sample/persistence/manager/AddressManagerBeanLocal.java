/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample programe. Please contact Sample org, fakestr. 17, 
 * 40667 Dusseldorf, Germany or visit www.sample.com if you need additional 
 * information or have any questions.
 */

package com.sample.persistence.manager;

import java.util.List;

import javax.ejb.Local;

import com.sample.persistence.entities.Address;

/**
 * This class perform persistence operation for Address class
 * 
 * @author A.Ijaz
 * @version 0.1
 */

@Local
public interface AddressManagerBeanLocal {
	/**
	 * insert Address into database
	 * 
	 * @param address
	 *            The address to insert
	 * @return True if transection successful otherwise false
	 * 
	 */
	public boolean insertAddress(Address address);
	
	
	/**
	 * Fetch active address of company
	 * 
	 * @param companyId
	 *            id of the company
	 * @return active address object
	 * 
	 */
	public Address fetchActiveAddress(long companyId);
	
	
	/**
	 * Update Address with active status
	 * 
	 * @param address
	 *            The address object
	 * @param active
	 *           active status 0 or 1
	 * @return True if transection successful otherwise false
	 * 
	 */
	public boolean updateAddresss(Address address, int active);
	
}
