package com.slend.entity.core.borrower;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "sl_applicantdetails")
public class ApplicantDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String applicantFirstName;
	private String applicantLastName;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private City city;

	private String applicantEmail;

	private String applicantMobile;

	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private Gender applicantGender;

	private String fathersFirstName;
	
	private String fathersLastName; 
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address applicantPermAdd;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address applicantCurrAdd;

	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private DependentsCount dependentsCount;
	
	public String getFathersLastName() {
		return fathersLastName;
	}

	public void setFathersLastName(String fathersLastName) {
		this.fathersLastName = fathersLastName;
	}

	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;

	private String homePhone;

	private Date dob;

	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private LoanStatus defaultedLoanCC;

	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private LoanStatus declinedLoanAppSixMonths;

	@Column(columnDefinition = "VARCHAR(12)")
	@Enumerated(EnumType.STRING)
	private LoanIntentTimeFrame loanIntentTimeFrame;

	private String loanAmountReq;

	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private TenureLoanYears tenureLoanYears;

	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private TenureLoanMonths tenureLoanMonths;

	@Column(columnDefinition = "VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private EmploymentType employmentType;

	@Column(columnDefinition = "VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private ResidenceType residenceType;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicantFirstName() {
		return applicantFirstName;
	}

	public void setApplicantFirstName(String applicantFirstName) {
		this.applicantFirstName = applicantFirstName;
	}

	public String getApplicantLastName() {
		return applicantLastName;
	}

	public void setApplicantLastName(String applicantLastName) {
		this.applicantLastName = applicantLastName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	public String getApplicantMobile() {
		return applicantMobile;
	}

	public void setApplicantMobile(String applicantMobile) {
		this.applicantMobile = applicantMobile;
	}

	public Gender getApplicantGender() {
		return applicantGender;
	}

	public void setApplicantGender(Gender applicantGender) {
		this.applicantGender = applicantGender;
	}

	public String getFathersFirstName() {
		return fathersFirstName;
	}

	public void setFathersFirstName(String fathersFirstName) {
		this.fathersFirstName = fathersFirstName;
	}

	public Address getApplicantPermAdd() {
		return applicantPermAdd;
	}

	public void setApplicantPermAdd(Address applicantPermAdd) {
		this.applicantPermAdd = applicantPermAdd;
	}

	public Address getApplicantCurrAdd() {
		return applicantCurrAdd;
	}

	public void setApplicantCurrAdd(Address applicantCurrAdd) {
		this.applicantCurrAdd = applicantCurrAdd;
	}

	public DependentsCount getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(DependentsCount dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public LoanStatus getDefaultedLoanCC() {
		return defaultedLoanCC;
	}

	public void setDefaultedLoanCC(LoanStatus defaultLoanCC) {
		this.defaultedLoanCC = defaultLoanCC;
	}

	public LoanStatus getDeclinedLoanAppSixMonths() {
		return declinedLoanAppSixMonths;
	}

	public void setDeclinedLoanAppSixMonths(LoanStatus declinedLoanAppSixMonths) {
		this.declinedLoanAppSixMonths = declinedLoanAppSixMonths;
	}

	public LoanIntentTimeFrame getLoanIntentTimeFrame() {
		return loanIntentTimeFrame;
	}

	public void setLoanIntentTimeFrame(LoanIntentTimeFrame loanIntentTimeFrame) {
		this.loanIntentTimeFrame = loanIntentTimeFrame;
	}

	public String getLoanAmountReq() {
		return loanAmountReq;
	}

	public void setLoanAmountReq(String loanAmountReq) {
		this.loanAmountReq = loanAmountReq;
	}

	public TenureLoanYears getTenureLoanYears() {
		return tenureLoanYears;
	}

	public void setTenureLoanYears(TenureLoanYears tenureLoanYears) {
		this.tenureLoanYears = tenureLoanYears;
	}

	public TenureLoanMonths getTenureLoanMonths() {
		return tenureLoanMonths;
	}

	public void setTenureLoanMonths(TenureLoanMonths tenureLoanMonths) {
		this.tenureLoanMonths = tenureLoanMonths;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public ResidenceType getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(ResidenceType residenceType) {
		this.residenceType = residenceType;
	}

}
