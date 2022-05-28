package com.example.crms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.crms.entity.Customer;
import com.example.crms.service.CustomerService;

@Controller
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	// handler method to handle list Customer and return mode and view
	@GetMapping("/Customer")
	public String listCustomer(Model model) {
		model.addAttribute("Customer", customerService.getAllCustomer());
		return "Customer";
	}
	
	@GetMapping("/Customer/new")
	public String createCustomerForm(Model model) {
		
		// create Customer object to hold Customer form data
		Customer customer = new Customer();
		model.addAttribute("Customer", customer);
		return "create_Customer";
		
	}
	
	@PostMapping("/Customer")
	public String saveCustomer(@ModelAttribute("Customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/Customer";
	}
	
	@GetMapping("/Customer/edit/{id}")
	public String editCustomerForm(@PathVariable Long id, Model model) {
		model.addAttribute("Customer", customerService.getCustomerById(id));
		return "edit_Customer";
	}

	@PostMapping("/Customer/{id}")
	public String updateCustomer(@PathVariable Long id,
			@ModelAttribute("Customer") Customer customer,
			Model model) {
		
		// get Customer from database by id
		Customer existingCustomer = customerService.getCustomerById(id);
		existingCustomer.setId(id);
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmail(customer.getEmail());
		
		// save updated Customer object
		customerService.updateCustomer(existingCustomer);
		return "redirect:/Customer";		
	}
	
	// handler method to handle delete Customer request
	
	@GetMapping("/Customer/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomerById(id);
		return "redirect:/Customer";
	}
	
}

