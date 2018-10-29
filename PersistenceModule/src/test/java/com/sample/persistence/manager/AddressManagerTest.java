package com.sample.persistence.manager;



import com.sample.persistence.entities.Address;

import junit.framework.TestCase;

public class AddressManagerTest extends TestCase {

	private AddressManagerBean addressManagerBean;
	
	protected void setUp() throws Exception {
		super.setUp();
		addressManagerBean= new AddressManagerBean();
		}
	
	public void testUpdateAddress() {
		
		Address address= new Address();
		address.setAdd_id(new Long(101));
		address.setStreet("streatName");

		assertEquals(true, addressManagerBean.updateAddresss(address, 0));
		}
	
	
	
	

}
