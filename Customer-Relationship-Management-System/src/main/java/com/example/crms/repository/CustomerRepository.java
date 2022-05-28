package com.example.crms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
