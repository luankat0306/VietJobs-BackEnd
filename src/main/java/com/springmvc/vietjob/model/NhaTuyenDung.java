package com.springmvc.vietjob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "congty")
public class NhaTuyenDung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ten_cong_ty")
	private String tenCongTy;
	
	@Column(name = "ten_nguoi_lien_he")
	private String nguoiLienHe;
	
	@Column(name = "sdt")
	private String sdt;

	@Column(name = "email")
	private String email;
	
	@Column(name = "dia_chi")
	private String diaChi;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "mo_ta")
	private String moTa;
	
	@Column(name = "ten_nguoi_dung")
	private String tenNguoiDung;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "image")
	private String image;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenCongty() {
		return tenCongTy;
	}

	public void setTenCongty(String tenCongty) {
		this.tenCongTy = tenCongty;
	}

	public String getNguoiLienHe() {
		return nguoiLienHe;
	}

	public void setNguoiLienHe(String nguoiLienHe) {
		this.nguoiLienHe = nguoiLienHe;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
