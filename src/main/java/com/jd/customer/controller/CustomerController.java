package com.jd.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jd.customer.model.Customer;
import com.jd.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		System.out.println("CustomerController : addCustomer Customer ");
		
		//substring
		//n-number 
		return customerService.addCustomer(customer);
	}

	@RequestMapping("/deleteCustomer")
	public void deleteCustomer(@RequestBody Customer customer) {

		customerService.deleteCustomer(customer);
	}

	@RequestMapping("/viewCustomer")
	public Iterable<Customer> viewCustomer(@RequestBody String customerName) {

		return customerService.searchCustomer(customerName);
	}
}
