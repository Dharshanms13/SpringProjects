package com.dash.bankingsprintproject.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dash.bankingsprintproject.dto.CustomerDto;
import com.dash.bankingsprintproject.entity.Customer;
import com.dash.bankingsprintproject.entity.Loan;
import com.dash.bankingsprintproject.entity.SavingsAccount;
import com.dash.bankingsprintproject.service.IServiceCustomer;
import com.dash.bankingsprintproject.service.IServiceLoan;
import com.dash.bankingsprintproject.service.IServiceSavingsAccount;

@RestController
public class BankController {

	@Autowired
	private IServiceCustomer iCustomer;

	@Autowired
	private IServiceLoan iLoan;

	@Autowired
	private IServiceSavingsAccount iSavingsAccount;

	// Customer APIs

	// Get All users
	@GetMapping("/users")
	public List<Customer> getUsers() {
		List<Customer> customerList = iCustomer.getAllUsers();
		return customerList;
	}

	// Get Users By Id
	@GetMapping("/users/{id}")
	public Customer getSingleCustomer(@PathVariable int id) {
		Customer customer = iCustomer.getCustomerById(id);
		return customer;
	}

	// Create Customer
	@PostMapping("/users/createCustomer")
	public void createCustomer(@RequestBody CustomerDto customer) {
		Customer newCustomer = new Customer(customer);
		newCustomer.setPassword("password");
		newCustomer.setRole("Customer");
		iCustomer.saveCustomer(newCustomer);
	}

	// Update Customer Phone number
	@PutMapping("/users/{id}/{number}")
	public void updateCustomer(@PathVariable int id, @PathVariable String number) {
		Customer existingCustomer = iCustomer.getCustomerById(id);
		existingCustomer.setMobileNumber(number);
		iCustomer.update(existingCustomer);
	}

	// Delete Customer
	@DeleteMapping("/users/{id}")
	public void deleteCustomer(@PathVariable int id) {
		Customer existingCustomer = iCustomer.getCustomerById(id);
		iCustomer.deleteUser(existingCustomer.getId());
	}

	// Loan APIs

	// Create Loan for Customer
	@PostMapping("/users/loans/{id}/{amount}")
	public void createLoan(@PathVariable int id, @PathVariable long amount) {
		Customer customer = iCustomer.getCustomerById(id);
		Loan loan = new Loan(amount, customer);
		iLoan.createLoan(loan);
	}

	// Get Loan By Id
	@GetMapping("/users/loans/{id}")
	public Loan getLoanById(@PathVariable int id) {
		Loan loan = iLoan.getLoanById(id);
		return loan;
	}

	// Get all Loans of a Customer by using Customer Id
	@GetMapping("/users/loans/customer/{id}")
	public List<Loan> getAllLoansOfCustomer(@PathVariable int id) {
		Customer customer = iCustomer.getCustomerById(id);
		return iLoan.getCustomerLoans(customer);
	}

	// Savings account

	// Create Savings account for Customer
	@PostMapping("/users/account/{userId}/{initialDeposit}")
	public void createSavingsAccount(@PathVariable int userId, @PathVariable double initialDeposit) {
		Customer customer = iCustomer.getCustomerById(userId);
		LocalDate date = LocalDate.now();
		SavingsAccount newSavingsAccount = new SavingsAccount(initialDeposit, customer);
		newSavingsAccount.setLastModified(date);
		iSavingsAccount.createSavingsAccountForCustomer(newSavingsAccount, customer);
	}

	@GetMapping("/users/account/getAccount/{accountId}")
	public SavingsAccount getSavingsAccountById(@PathVariable int accountId) {
		SavingsAccount savingsAccount = iSavingsAccount.getCustomerAccountByAccountId(accountId);
		return savingsAccount;
	}

	// Deposit to Savings Account
	@PutMapping("/users/account/deposit/{accountId}/{depositAmount}")
	public void depositAmount(@PathVariable int accountId, @PathVariable double depositAmount) {
		SavingsAccount savingsAccount = iSavingsAccount.getCustomerAccountByAccountId(accountId);
		iSavingsAccount.deposit(savingsAccount, depositAmount);
	}

	// Withdraw from Savings Account
	@PutMapping("/users/account/withdraw/{accountId}/{withdrawAmount}")
	public void withdrawAmount(@PathVariable int accountId, @PathVariable double withdrawAmount) {
		SavingsAccount savingsAccount = iSavingsAccount.getCustomerAccountByAccountId(accountId);
		iSavingsAccount.withdraw(savingsAccount, withdrawAmount);
	}
	
	
	
	// Example method used for Docker
	@GetMapping("/users/getString")
	public String getString() {
		return "String for testing docker";
	}
	

}
