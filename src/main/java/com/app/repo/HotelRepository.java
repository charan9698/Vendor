package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
