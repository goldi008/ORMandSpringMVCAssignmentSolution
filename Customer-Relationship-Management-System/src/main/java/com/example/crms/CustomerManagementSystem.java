package com.example.crms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.crms.entity.Customer;
import com.example.crms.repository.CustomerRepository;

@SpringBootApplication
public class CustomerManagementSystem implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementSystem.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
