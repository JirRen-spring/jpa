package com.JiaRen.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	public void persist(T o);
	public Serializable save(T o);
	public void delete(T o);
	public T update(T o);
	public T get(Class<T> c, Serializable id);
	public List<Map<String, Object>> getInfoListBySql(String sql,Map<String, Object> params);
}
