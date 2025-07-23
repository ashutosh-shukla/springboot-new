package com.oracle.dao;

import com.oracle.model.Customer;
import java.util.List;

public interface CustomerDao {
    void createCustomer(Customer customer);

    Customer readCustomerById(String id);

    List<Customer> readAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(String id);
}
