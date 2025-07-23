package com.oracle.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.oracle.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext   //READ by appilication properties to handle entity manager
	private EntityManager entityManager;
	
	@Override
	@Transactional   //treats as transaction commit or rollback
	public void createCustomer(Customer customer) {
		entityManager.persist(customer);
	}
	
	@Override
	public Customer readCustomerById(String id) {
		return entityManager.find(Customer.class, id);
	}
	
	@Override
	public List<Customer> readAllCustomers() {
		return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
	}
	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		entityManager.merge(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(String id) {
		Customer customer = entityManager.find(Customer.class, id);
	    if (customer != null) {
	        entityManager.remove(customer);
	    }
	}   
}
