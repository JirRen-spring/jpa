package com.JiaRen.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.JiaRen.dao.CustomerDao;
import com.JiaRen.model.Customer;

@Repository
public class CustomerDaoImpl  implements CustomerDao {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Map<String, Object>> getList(Customer item) {
		String sql = "SELECT a.first_name, a.last_name FROM customer a";
	    Query query = this.em.createNativeQuery(sql);
        query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return  query.getResultList();

	}


}
