package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(int theId);

	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(int theId);
}
