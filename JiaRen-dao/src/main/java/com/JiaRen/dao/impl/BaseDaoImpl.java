package com.JiaRen.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.JiaRen.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void persist(T o) {
		this.em.persist(o);
	}

	@Override
	public abstract Serializable save(T o);

	@Override
	public void delete(T o) {
		this.em.remove(o);
	}

	@Override
	public T update(T o) {
		return this.em.merge(o);
	}

	@Override
	public T get(Class<T> c, Serializable id) {
		return this.em.find(c, id);
	}

	@Override
	public List<Map<String, Object>> getInfoListBySql(String sql, Map<String, Object> params) {
		Query query = this.em.createNativeQuery(sql);
		query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.getResultList();
	}

}
