package com.dash.bankingsprintproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dash.bankingsprintproject.dao.ICustomerDao;
import com.dash.bankingsprintproject.entity.Customer;
import com.dash.bankingsprintproject.exception.CustomerDoesNotExistException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceCustomer implements IServiceCustomer {
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public List<Customer> getAllUsers() {
		return customerDao.findAll();
	}

	@Override
	public void saveCustomer(Customer newCustomer) {
		customerDao.save(newCustomer);
	}

	@Override
	public Customer getCustomerById(int id) {
		Optional<Customer> customer = customerDao.findById(id);
		if(!customer.isPresent()) {
			throw new CustomerDoesNotExistException("Customer does not exist with customer id : " + id);
		}
		return customer.get();
	}

	@Override
	public void update(Customer existingCustomer) {
		customerDao.save(existingCustomer);
	}

	@Override
	public void deleteUser(int id) {
		customerDao.deleteById(id);
	}

}
