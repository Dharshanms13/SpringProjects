package com.dash.bankingsprintproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dash.bankingsprintproject.entity.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer>{

}
