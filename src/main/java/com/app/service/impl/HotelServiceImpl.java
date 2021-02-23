package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Hotel;
import com.app.repo.HotelRepository;
import com.app.service.IHotel;

@Service
public class HotelServiceImpl implements IHotel {

	@Autowired
	private HotelRepository repo;

	@Override
	@Transactional
	public Integer saveHotel(Hotel h) {
		return repo.save(h).getId();
	}

	@Override
	@Transactional
	public void updateHotel(Hotel h) {
		repo.save(h);
	}

	@Override
	@Transactional
	public void deleteHotel(Integer id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hotel> getAllHotels() {
		return repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Hotel getoneHotel(Integer id) {
		return repo.getOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isHotelexist(Integer id) {
		return repo.existsById(id);
	}

}
