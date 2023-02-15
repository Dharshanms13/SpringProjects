package com.dash.bankingsprintproject.entity;

import java.time.LocalDate;
import java.util.List;

import com.dash.bankingsprintproject.dto.CustomerDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	private String customerName;
	private String mobileNumber;
	private String email;
	private LocalDate dateOfBirth;
	private String gender;
	private String nationality;
	private String aadharNumber;
	private String panNumber;
	private String password;
	private String role;

	@OneToOne
	private SavingsAccount savingsAccount;
	
	@OneToMany
	private List<Loan> loans;

	public Customer() {
		super();
	}

	public Customer(int id, String customerName, String mobileNumber, String email, LocalDate dateOfBirth,
			String gender, String nationality, String aadharNumber, String panNumber, String password, String role,
			SavingsAccount savingsAccount, List<Loan> loans) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.password = password;
		this.role = role;
		this.savingsAccount = savingsAccount;
		this.loans = loans;
	}



	public Customer(CustomerDto customer) {
		this.customerName = customer.getCustomerName();
		this.mobileNumber = customer.getMobileNumber();
		this.email = customer.getEmail();
		this.dateOfBirth = customer.getDateOfBirth();
		this.gender = customer.getGender();
		this.nationality = customer.getNationality();
		this.aadharNumber = customer.getAadharNumber();
		this.panNumber = customer.getPanNumber();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber + ", email="
				+ email + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", nationality=" + nationality
				+ ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", password=" + password + ", role="
				+ role + ", savingsAccount=" + savingsAccount + ", loans=" + loans + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

}
