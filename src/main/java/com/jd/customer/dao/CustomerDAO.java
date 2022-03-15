package com.jd.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jd.customer.model.Customer;
import com.jd.customer.repository.CustomerRepository;

@Repository
public class CustomerDAO {
	@Autowired
	CustomerRepository customerRepository;

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer addCustomer(Customer customer) {
		System.out.println("CustomerDAO : Saving Customer ");
		return customerRepository.save(customer);
	}

	public Iterable<Customer> findByCustomerName(String customerName) {
		return customerRepository.findByCustomerName(customerName);
	}

	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
}
