package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bank_tab")
public class Bank {
	
	@Id
	@GeneratedValue
	@Column(name = "bank_id_col",length = 10,nullable = false)
	private Integer id;
	
	@Column(name = "bank_name_col",length = 10,nullable =false)
	private String bankName;
	
	@Column(name = "bank_passbook_col",length = 10,nullable = false)
	private String bankPassbook;
}