package com.app.service;

import java.util.List;

import com.app.model.Hotel;

public interface IHotel {
	
	public Integer saveHotel(Hotel h);
	public void updateHotel(Hotel h);
	public void deleteHotel(Integer id);
	public List<Hotel> getAllHotels();
	public Hotel getoneHotel(Integer id);
	public boolean isHotelexist(Integer id);
	

}
