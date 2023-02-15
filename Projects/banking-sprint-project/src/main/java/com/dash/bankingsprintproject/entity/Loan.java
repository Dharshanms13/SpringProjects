package com.dash.bankingsprintproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue
	private int id;
	private long loanAmount;
	
	@ManyToOne
	private Customer customer;

	public Loan() {
		super();
	}

	public Loan(long loanAmount, Customer customer) {
		super();
		this.loanAmount = loanAmount;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", loanAmount=" + loanAmount + ", customer=" + customer.getId() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
