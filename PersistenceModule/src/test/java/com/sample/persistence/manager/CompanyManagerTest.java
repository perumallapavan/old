package com.sample.persistence.manager;



import junit.framework.TestCase;

import com.sample.persistence.entities.Company;

public class CompanyManagerTest extends TestCase {

	private CompanyManagerBean companyManagerBean;
	
	protected void setUp() throws Exception {
		super.setUp();
		companyManagerBean= new CompanyManagerBean();
		}
	
	public void testInsertCompany() {
		
		Company company= new Company();
		company.setName("blahh");

		assertEquals(true, companyManagerBean.insertCompany(company));
		}
	
	
	
	

}
