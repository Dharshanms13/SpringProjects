package com.dash.bankingsprintproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dash.bankingsprintproject.entity.SavingsAccount;

@Repository
public interface ISavingsAccountDao extends JpaRepository<SavingsAccount, Integer>{

}
