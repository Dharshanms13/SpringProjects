package com.dash.bankingsprintproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dash.bankingsprintproject.dao.ILoanDao;
import com.dash.bankingsprintproject.entity.Customer;
import com.dash.bankingsprintproject.entity.Loan;
import com.dash.bankingsprintproject.exception.LoanDoesNotExistException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceLoan implements IServiceLoan {

	@Autowired
	private ILoanDao loanDao;
	
	@Override
	public Loan getLoanById(int id) {
		Optional<Loan> loan = loanDao.findById(id);
		if(!loan.isPresent()) {
			throw new LoanDoesNotExistException("Loan does not exist with id : " + id);
		}
		return loan.get();
	}

	@Override
	public void createLoan(Loan loan) {
		loanDao.save(loan);
	}

	@Override
	public List<Loan> getCustomerLoans(Customer customer) {
		List<Loan> loanList = new ArrayList<>();
		List<Loan> allLoans = loanDao.findAll();
		for(Loan loan:allLoans) {
			if(loan.getCustomer().getId() == customer.getId()) {
				loanList.add(loan);
			}
		}
		return loanList;
	}

}
