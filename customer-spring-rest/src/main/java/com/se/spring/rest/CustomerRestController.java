package com.se.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.Customer;
import com.se.spring.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	
	//get all customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	//get customer by id
	@GetMapping("/customers/{customerId}")
	private Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomerById(customerId);
//		if(theCustomer == null) {
//			
//		}
		return theCustomer;

	}
	
	//insert
	@PostMapping("/customers")
	private Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//delete
	@DeleteMapping("/customers/{customerId}")
	private String deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.getCustomerById(customerId);
		if (tempCustomer == null) {

		}
		customerService.deleteCustomer(customerId);
		return "Delete customer id -" + customerId;

	}
	
	//update
	@PutMapping("/customers")
	private Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@GetMapping("/customers/{customerId}/money/{money}")
	private String getCustomermoney(@PathVariable int customerId, @PathVariable String money) {
		return "Customer id:" +customerId+" money: " +money;
	}
}
