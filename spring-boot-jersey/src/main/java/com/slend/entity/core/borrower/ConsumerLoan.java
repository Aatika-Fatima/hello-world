package com.slend.entity.core.borrower;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sl_consumerloan")
public class ConsumerLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CarLoan carLoan;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private HomeLoan homeLoan;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PersonalLoan personalLoan;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private EducationLoan educationLoan;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ApplicantDetails applicantDetails;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional=true)
	private CoApplicantDetails coApplicantsDetails;

	@Transient
	private String status; 
	@Transient
	private String error;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarLoan getCarLoan() {
		return carLoan;
	}

	public void setCarLoan(CarLoan carLoan) {
		this.carLoan = carLoan;
	}

	public HomeLoan getHomeLoan() {
		return homeLoan;
	}

	public void setHomeLoan(HomeLoan homeLoan) {
		this.homeLoan = homeLoan;
	}

	public PersonalLoan getPersonalLoan() {
		return personalLoan;
	}

	public void setPersonalLoan(PersonalLoan personalLoan) {
		this.personalLoan = personalLoan;
	}

	public EducationLoan getEducationLoan() {
		return educationLoan;
	}

	public void setEducationLoan(EducationLoan educationLoan) {
		this.educationLoan = educationLoan;
	}

	public ApplicantDetails getApplicantDetails() {
		return applicantDetails;
	}

	public void setApplicantDetails(ApplicantDetails applicantDetails) {
		this.applicantDetails = applicantDetails;
	}

	public CoApplicantDetails getCoApplicantsDetails() {
		return coApplicantsDetails;
	}

	public void setCoApplicantsDetails(CoApplicantDetails coApplicantsDetails) {
		this.coApplicantsDetails = coApplicantsDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
