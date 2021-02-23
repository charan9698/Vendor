package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Bank;
import com.app.repo.BankRepository;
import com.app.service.IBank;

@Service
public class BankServiceImpl implements IBank {

	@Autowired
	private BankRepository repo;

	@Override
	@Transactional
	public Integer saveBank(Bank b) {
		return repo.save(b).getId();
	}

	@Override
	@Transactional
	public void updateBank(Bank b) {
		repo.save(b);
	}

	@Override
	@Transactional
	public void deleteBank(Integer id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Bank> getOneBank(Integer id) {
		return repo.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bank> getAllBanks() {
		return repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean IsBankExist(Integer id) {
		return repo.existsById(id);
	}

}
