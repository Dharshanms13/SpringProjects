package com.dash.bankingsprintproject.service;

import com.dash.bankingsprintproject.entity.Customer;
import com.dash.bankingsprintproject.entity.SavingsAccount;

public interface IServiceSavingsAccount {

	void createSavingsAccountForCustomer(SavingsAccount newSavingsAccount, Customer customer);

	SavingsAccount getCustomerAccountByAccountId(int accountId);

	void deposit(SavingsAccount savingsAccount, double depositAmount);

	void withdraw(SavingsAccount savingsAccount, double withdrawAmount);

}
