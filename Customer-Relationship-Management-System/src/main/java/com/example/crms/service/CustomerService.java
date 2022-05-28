package com.example.crms.service;

import java.util.List;

import com.example.crms.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomer();
	
	Customer saveCustomer(Customer customer);
	
	Customer getCustomerById(Long id);
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomerById(Long id);
}

