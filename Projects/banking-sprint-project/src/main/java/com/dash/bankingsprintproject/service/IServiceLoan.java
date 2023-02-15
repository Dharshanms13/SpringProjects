package com.dash.bankingsprintproject.service;

import java.util.List;

import com.dash.bankingsprintproject.entity.Customer;
import com.dash.bankingsprintproject.entity.Loan;

public interface IServiceLoan {

	Loan getLoanById(int id);

	void createLoan(Loan loan);

	List<Loan> getCustomerLoans(Customer customer);

}
