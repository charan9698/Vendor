package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Bank;

public interface IBank {
	
	public Integer saveBank(Bank b);
	public void updateBank(Bank b);
	public void deleteBank(Integer id);
	public Optional<Bank> getOneBank(Integer id);
	public List<Bank> getAllBanks();
	public boolean IsBankExist(Integer id);

}
