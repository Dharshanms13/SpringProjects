package com.dash.bankingsprintproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dash.bankingsprintproject.dao.ISavingsAccountDao;
import com.dash.bankingsprintproject.entity.Customer;
import com.dash.bankingsprintproject.entity.SavingsAccount;
import com.dash.bankingsprintproject.exception.SavingsAccountDoesNotExistsException;
import com.dash.bankingsprintproject.exception.SavingsAccountExistsException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceSavingsAccount implements IServiceSavingsAccount {

	@Autowired
	private ISavingsAccountDao savingsAccountDao; 
	
	@Override
	public void createSavingsAccountForCustomer(SavingsAccount newSavingsAccount, Customer customer) {
		List<SavingsAccount> savingsAccountList = savingsAccountDao.findAll();
		for(SavingsAccount savingsAccount: savingsAccountList) {
			if(savingsAccount.getCustomer().getId() == customer.getId()) {
				throw new SavingsAccountExistsException("Savings Account already exists for Customer with id : " + customer.getId());
			}
		}
		savingsAccountDao.save(newSavingsAccount);
	}

	@Override
	public SavingsAccount getCustomerAccountByAccountId(int accountId) {
		Optional<SavingsAccount> savingsAccount = savingsAccountDao.findById(accountId);
		if(!savingsAccount.isPresent()) {
			throw new SavingsAccountDoesNotExistsException("Savings Account does not exists with account id : " + accountId);
		}
		return savingsAccount.get();
	}

	@Override
	public void deposit(SavingsAccount savingsAccount, double depositAmount) {
		savingsAccount.setBalance(savingsAccount.getBalance() + depositAmount);
		savingsAccountDao.save(savingsAccount);
	}

	@Override
	public void withdraw(SavingsAccount savingsAccount, double withdrawAmount) {
		savingsAccount.setBalance(savingsAccount.getBalance() - withdrawAmount);
		savingsAccountDao.save(savingsAccount);
	}

}
