/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample programe. Please contact Sample org, fakestr. 17, 
 * 40667 Dusseldorf, Germany or visit www.sample.com if you need additional 
 * information or have any questions.
 */

package com.sample.persistence.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import com.sample.persistence.entities.Company;

/**
 * This class perform persistence operation for Company class
 * 
 * @author A.Ijaz
 * @version 0.1
 */
@Local
public interface CompanyManagerBeanLocal {
	
	
	/**
	 * insert Company into database
	 * 
	 * @param company
	 *            The company to insert
	 * @return True if transection successful otherwise false
	 * 
	 */
	public boolean insertCompany(Company company);
	
	
	/**
	 * update Company into database
	 * 
	 * @param company
	 *            The company to update
	 * @return True if transection successful otherwise false
	 * 
	 */
	public boolean updateCompany(Company company);
	
	/**
	 * Fetch Company by Id from database
	 * 
	 * @param id
	 *            The id of company
	 * @return company object
	 * 
	 */
	public Company fetchComopany(long id);
	
	/**
	 * Fetch all companies from database
	 * 
	 * 
	 * @return company list
	 * 
	 */
	public List<Company> fetchAll();
	
	
	
	/**
	 * fetch company by name
	 * 
	 * @param name
	 *            name of the company
	 * @return company object 
	 * 
	 */
	public Company fetchByName(String name);

	
}
