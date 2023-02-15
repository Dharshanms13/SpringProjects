package com.dash.bankingsprintproject.service;

import java.util.List;

import com.dash.bankingsprintproject.entity.Customer;

public interface IServiceCustomer {

	List<Customer> getAllUsers();

	void saveCustomer(Customer newCustomer);

	Customer getCustomerById(int id);

	void update(Customer existingCustomer);

	void deleteUser(int id);

}
