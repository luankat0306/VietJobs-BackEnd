package com.springmvc.vietjob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name = "nganhnghe")
public class NganhNghe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nganh_nghe")
	private String nganhNghe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNganhNghe() {
		return nganhNghe;
	}

	public void setNganhNghe(String nganhNghe) {
		this.nganhNghe = nganhNghe;
	}
}
