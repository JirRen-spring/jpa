package com.JiaRen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.JiaRen.dao.CustomCustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomCustomerRepository {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void customMethod() {
		Query q = em.createNativeQuery("SELECT a.first_name, a.last_name FROM customer a WHERE a.id = :id");
		q.setParameter("id", 1);
		Object[] author = (Object[]) q.getSingleResult();

		System.out.println("Author "
		        + author[0]
		        + " "
		        + author[1]);

	}

}
