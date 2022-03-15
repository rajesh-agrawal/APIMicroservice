package com.jd.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.customer.dao.CustomerDAO;
import com.jd.customer.model.Customer;
@Service
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public Customer addCustomer(Customer customer) {
		System.out.println("CustomerService : Saving Customer ");
		return customerDAO.addCustomer(customer);
	}

	public Iterable<Customer> searchCustomer(String customerName) {

		return customerDAO.findByCustomerName(customerName);
	}

	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}
}
