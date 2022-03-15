package com.jd.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.jd.customer.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	
	public Iterable<Customer> findByCustomerName(String customerName);
}
