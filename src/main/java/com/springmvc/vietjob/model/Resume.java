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
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "vi_tri_mm")
	private String desiredVacancy;
	
	@Column(name = "trinh_do")
	private String education;
	
	@Column(name = "kinh_nghiem")
	private	String experience;
	
	@Column(name = "hinh_thuc")
	private String jobType;
	
	@Column(name = "ngoai_ngu")
	private String foreignLanguage;
	
	@Column(name = "muc_luong")
	private String wage;
	
	@OneToOne
	@JoinColumn(name = "id_nganh_nghe")
	private	Career career;
	
	@OneToOne
	@JoinColumn(name = "id_nguoi_tim_viec")
	private Applicant applicant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesiredVacancy() {
		return desiredVacancy;
	}

	public void setDesiredVacancy(String desiredVacancy) {
		this.desiredVacancy = desiredVacancy;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getForeignLanguage() {
		return foreignLanguage;
	}

	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
}
