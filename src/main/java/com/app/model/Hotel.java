package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "hotel_tab")
public class Hotel {
	@Id
	@GeneratedValue
	@Column(name = "hotel_id_col",length = 10,nullable = false)
	private Integer id;
	@Column(name = "hotel_name_col",length = 15,nullable = false)
	private String hotelName;
	@Column(name = "hotel_area_col",length = 12,nullable = false)
	private String hotelArea;
	@Column(name ="hotel_comment_col",length = 20,nullable = false )
	private String comment;

}
