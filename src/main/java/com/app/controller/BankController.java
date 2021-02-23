package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Bank;
import com.app.service.IBank;


@Controller
@RequestMapping("/bankk")
public class BankController {

	@Autowired
	private IBank service;

	@GetMapping("/shit")
	public String getbank(Model model) {
		model.addAttribute("bank", new Bank());
		return "BankRegister";
	}

	@PostMapping("/save")
	public String savew(@ModelAttribute Bank bank,Model model) {
		Integer id=service.saveBank(bank);
		String inform="Shipment '"+id+"' Succes fully save";
		model.addAttribute("inform",inform);
		model.addAttribute("bank", new Bank());
		return "BankRegister";
	}

	@GetMapping("/all")
	public String getal(Model model) {
		List<Bank> list=service.getAllBanks();
		model.addAttribute("list", list);
		return "BankData";
	}

	@GetMapping("/delete/{id}")
	public String del(@PathVariable Integer id,Model model) {
		String msg="null";
		if (service.IsBankExist(id)) {
			service.deleteBank(id);
			msg="bank '"+ id +"' deleted";

		}else {
			msg="not found";
		}
		model.addAttribute("message", msg);
		List<Bank> list=service.getAllBanks();
		model.addAttribute("list", list);

		return "BankData";
	}
	
	@GetMapping("/edit/{id}")
	public String showedit(@PathVariable Integer id,Model model) {
		
		Optional<Bank> opt=service.getOneBank(id);
		if (opt.isPresent()) {
			Bank b=opt.get();
			model.addAttribute("bank", b);
			return "BankEdit";
		}else {
			return "BankData";
		}
	}
	@PostMapping("/update")
	public String showupdat(@ModelAttribute Bank bank,Model model) {
		service.updateBank(bank);
		String msg="Bank '"+bank.getId()+"'updated";
		model.addAttribute("message", msg);
		List<Bank> list=service.getAllBanks();
		model.addAttribute("list", list);
		return "BankData";
	}

}
