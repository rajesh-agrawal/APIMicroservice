package com.jd.customer.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Customer")
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int customerid;
	@Column(name = "customername", updatable = false, nullable = false)
	String customerName = "";

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int cid, String cname) {
		// TODO Auto-generated constructor stub
		this.customerid = cid;
		this.customerName = cname;

	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
