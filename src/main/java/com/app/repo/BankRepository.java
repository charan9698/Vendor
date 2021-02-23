package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
