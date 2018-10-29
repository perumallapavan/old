package com.sample.persistence.manager;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sample.persistence.entities.Address;
import com.sample.persistence.entities.Company;

/**
 * Session Bean implementation class CompanyManagerBean
 */
@Stateless
public class CompanyManagerBean implements CompanyManagerBeanLocal {

	
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CompanyManagerBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean insertCompany(Company company) {
		// TODO Auto-generated method stub
		//entityManager.getTransaction().begin();
		//EntityTransaction entr = entityManager.getTransaction();
		//entr.begin();
		entityManager.persist(company);
		entityManager.flush();
		//entr.commit();
		//entityManager.getTransaction().commit();

		return true;
	}

	@Override
	public boolean updateCompany(Company company) {
		// TODO Auto-generated method stub
		//EntityTransaction entr = entityManager.getTransaction();
		//entr.begin();
		Company exsistingCompany = entityManager.find(Company.class, company.getCom_id());
		exsistingCompany.setName(company.getName());
		exsistingCompany.setAddresses(company.getAddresses());
		//entr.commit();
		return true;
	}

	@Override
	public Company fetchComopany(long id) {
		// TODO Auto-generated method stub
		Company foundCompany = entityManager.find(Company.class, id);

		return foundCompany;
	}

	@Override
	public List<Company> fetchAll() {
		// TODO Auto-generated method stub
		ArrayList<Company> companyList= new ArrayList<Company>();
		//EntityTransaction entr = entityManager.getTransaction();
		//entr.begin();
		Query query = entityManager.createQuery("SELECT cmp FROM Company cmp");
		List list = query.getResultList();
		return list;
	}

	@Override
	public Company fetchByName(String name) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Company cm where cm.name=:arg1");
		query.setParameter("arg1", name);
		List<Company> list = query.getResultList();
		if(list.size()>0)
			return list.get(0);
		else 
			return null;
	}
	
	
    
    

}
