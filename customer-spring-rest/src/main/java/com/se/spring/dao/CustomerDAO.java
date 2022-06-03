package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public Customer getCustomerById(int theId);

	public void saveCustomer(Customer theCustomer); 

	public void deleteCustomer(int theId);
}
