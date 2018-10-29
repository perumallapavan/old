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

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sample.persistence.entities.Address;
import com.sample.persistence.entities.Company;

/**
 * Session Bean implementation class AddressManagerBean
 */
@Stateless
public class AddressManagerBean implements AddressManagerBeanLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
     * Default constructor. 
     */
    public AddressManagerBean() {
        // TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
     * @see com.sample.persistence.manager.AddressManagerBeanLocal#insertAddress(Address)
     */
	@Override
	public boolean insertAddress(Address address) {
		// TODO Auto-generated method stub
		entityManager.persist(address);
		entityManager.flush();
		return true;
	}
	
	 /* (non-Javadoc)
     * @see com.sample.persistence.manager.AddressManagerBeanLocal#fetchActiveAddress(Long)
     */
	@Override
	public Address fetchActiveAddress(long companyId) {
		Company c= new Company();
		c.setCom_id(companyId);
		Query query = entityManager.createQuery("from Address ad where ad.company=:arg1 and ad.active=:arg2");
		query.setParameter("arg1", c);
		query.setParameter("arg2", 1);
		List<Address> list = query.getResultList();
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	
	 /* (non-Javadoc)
     * @see com.sample.persistence.manager.AddressManagerBeanLocal#updateAddresss(Address, int)
     */
	@Override
	public boolean updateAddresss(Address address,int active) {
		// TODO Auto-generated method stub
		Address exsistingAddress = entityManager.find(Address.class, address.getAdd_id());
		exsistingAddress.setActive(active);
		return true;

	}

}
