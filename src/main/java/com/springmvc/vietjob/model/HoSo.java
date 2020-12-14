package com.springmvc.vietjob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hoso")
public class HoSo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "vi_tri_mm")
	private String viTriMM;
	
	@Column(name = "trinh_do")
	private String trinhDo;
	
	@Column(name = "kinh_nghiem")
	private	String kinhNghiem;
	
	@Column(name = "hinh_thuc")
	private String hinhThuc;
	
	@Column(name = "ngoai_ngu")
	private String ngoaiNgu;
	
	@Column(name = "muc_luong")
	private String mucLuong;
	
	@OneToOne
	@JoinColumn(name = "id_nganh_nghe")
	private	NganhNghe nganhNghe;
	
	@OneToOne
	@JoinColumn(name = "id_nguoi_tim_viec")
	private NguoiTimViec nguoiTimViec;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NguoiTimViec getNguoiTimViec() {
		return nguoiTimViec;
	}

	public void setNguoiTimViec(NguoiTimViec nguoiTimViec) {
		this.nguoiTimViec = nguoiTimViec;
	}

	public String getViTriMM() {
		return viTriMM;
	}

	public void setViTriMM(String viTriMM) {
		this.viTriMM = viTriMM;
	}

	public NganhNghe getNganhNghe() {
		return nganhNghe;
	}

	public void setNganhNghe(NganhNghe nganhNghe) {
		this.nganhNghe = nganhNghe;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getKinhNghiem() {
		return kinhNghiem;
	}

	public void setKinhNghiem(String kinhNghiem) {
		this.kinhNghiem = kinhNghiem;
	}

	public String getHinhThuc() {
		return hinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public String getNgoaiNgu() {
		return ngoaiNgu;
	}

	public void setNgoaiNgu(String ngoaiNgu) {
		this.ngoaiNgu = ngoaiNgu;
	}

	public String getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(String mucLuong) {
		this.mucLuong = mucLuong;
	}
}
