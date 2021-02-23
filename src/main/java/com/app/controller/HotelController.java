package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Hotel;
import com.app.service.IHotel;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private IHotel service;

	@GetMapping("/register")
	public String sav(Model model) {
		model.addAttribute("hotel", new Hotel());
		return "HotelRegister";
	}
	
	@PostMapping("/save")
	public String savhotel(@ModelAttribute Hotel hotel,Model model) {
		Integer id=service.saveHotel(hotel);
		String message="Hotel '"+ id +"' created successfully";
		model.addAttribute("message", message);
		model.addAttribute("hotel", new Hotel());
		return "HotelRegister";	
	}
	
	@GetMapping("/all")
	public String getall(Model model) {
		List<Hotel> list=service.getAllHotels();
		model.addAttribute("list", list);
		return "HotelData";
	}
	
	@GetMapping("/delete/{id}")
	public String del(@PathVariable Integer id,Model model) {
		String msg="null";
		if (service.isHotelexist(id)) {
			service.deleteHotel(id);
			msg="deleted";
		}else {
			msg="not found";
		}
	model.addAttribute("message", msg);
	 List<Hotel> list=service.getAllHotels();
	 model.addAttribute("list", list);
	 return "HotelData";
	}
}
