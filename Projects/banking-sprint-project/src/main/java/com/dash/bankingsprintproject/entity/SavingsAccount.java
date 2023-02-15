package com.dash.bankingsprintproject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class SavingsAccount {
	
	@Id
	@GeneratedValue
	private int id;
	private LocalDate lastModified;
	private double balance;
	
	@OneToOne
	private Customer customer;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(double balance, Customer customer) {
		super();
		this.balance = balance;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "SavingsAccount [id=" + id + ", lastModified=" + lastModified + ", balance=" + balance + ", customer="
				+ customer + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDate lastModified) {
		this.lastModified = lastModified;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
