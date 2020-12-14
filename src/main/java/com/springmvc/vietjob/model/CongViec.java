package com.springmvc.vietjob.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "congviec")
public class CongViec {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tieu_de")
	private String tieuDe;
	
	@Column(name = "vi_tri_td")
	private String viTriTuyenDung;
	
	@Column(name = "so_luong")
	private int soLuong;
	
	@Column(name = "mo_ta")
	private String moTa;
	
	@Column(name = "tinh_thanh")
	private String tinhThanh;
	
	@Column(name = "han_nop")
	private Date hanNop;
	
	@Column(name = "muc_luong")
	private String mucLuong;
	
	@Column(name = "ngay_dang")
	private Date ngayDang;
	
	@OneToOne
	@JoinColumn(name = "id_nganh_nghe")
	private NganhNghe nganhNghe;
	
	@ManyToOne
	@JoinColumn(name = "id_cong_ty")
	private NhaTuyenDung nhaTuyenDung;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NhaTuyenDung getNhaTuyenDung() {
		return nhaTuyenDung;
	}

	public void setNhaTuyenDung(NhaTuyenDung nhaTuyenDung) {
		this.nhaTuyenDung = nhaTuyenDung;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getViTriTuyenDung() {
		return viTriTuyenDung;
	}

	public void setViTriTuyenDung(String viTriTuyenDung) {
		this.viTriTuyenDung = viTriTuyenDung;
	}

	public NganhNghe getNganhNghe() {
		return nganhNghe;
	}

	public void setNganhNghe(NganhNghe nganhNghe) {
		this.nganhNghe = nganhNghe;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

	public Date getHanNop() {
		return hanNop;
	}

	public void setHanNop(Date hanNop) {
		this.hanNop = hanNop;
	}

	public String getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(String mucLuong) {
		this.mucLuong = mucLuong;
	}

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	
}
