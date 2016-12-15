package com.JiaRen.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.JiaRen.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
