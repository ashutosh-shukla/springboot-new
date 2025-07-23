package com.oracle.service;

import java.util.List;

import com.oracle.model.Customer;

public interface CustomerService {
	void saveCustomer(Customer customer);

	Customer findCustomerById(String id);

	List<Customer> findAllCustomers();

	void modifyCustomer(Customer customer);

	void removeCustomer(String id);
}
