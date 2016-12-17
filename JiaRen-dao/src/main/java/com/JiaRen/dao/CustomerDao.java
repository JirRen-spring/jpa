package com.JiaRen.dao;

import java.util.List;
import java.util.Map;

import com.JiaRen.model.Customer;

public interface CustomerDao {
	public List<Map<String, Object>> getList(Customer item);
}
