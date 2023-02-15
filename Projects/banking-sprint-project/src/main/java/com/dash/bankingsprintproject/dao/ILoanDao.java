package com.dash.bankingsprintproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dash.bankingsprintproject.entity.Loan;

@Repository
public interface ILoanDao  extends JpaRepository<Loan, Integer>{

}
