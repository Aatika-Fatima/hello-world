package com.slend.entity.core.borrower;

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

import com.slend.entity.validator.core.borrower.ValidEmploymentType;

@Entity
@Table(name = "s1_educationloan")
public class EducationLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String applicantFirstName;
	private String applicantLastName;

	private String applicantEmail;
	private String applicantMobile;
	
	@Column(columnDefinition="VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private Gender applicantGender;

	private String fathersFirstName;
	private String fathersLastName;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Address applicantPermAdd;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Address applicantCurrAdd;

	private String loanAmountReq;

	@Column(columnDefinition="VARCHAR(5)")
	@Enumerated(EnumType.STRING)
	private TenureLoanYears tenureLoanYears;

	@Column(columnDefinition="VARCHAR(5)")
	@Enumerated(EnumType.STRING)
	private TenureLoanMonths tenureLoanMonths;
	
	@Column(columnDefinition="VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private CourseLevel courseLevel;

	@Column(columnDefinition="VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private StudyCountry studyCountry;

	@Column(columnDefinition="VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private StudyCourse studyCourse;

	@Column(columnDefinition="VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private CourseDuration courseDuration;

	private String coBorrowerFirstName;
	private String coBorrowerLastName;
	private String coBorrowerMobile;
	
	@Column(columnDefinition="VARCHAR(6)")
	@Enumerated(EnumType.STRING)
	private Gender coBorrowerGender;

	private String coBorrowerFathersFirstName;
	private String coBorrowerFathersLastName;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Address coBorrowerPermAdd;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Address coBorrowerCurrAdd;

	@Column(columnDefinition="VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	StudentRelationship studentRelationship;

 	@Column(columnDefinition="VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private EmploymentType employmentType; 
	
	@Column(columnDefinition="VARCHAR(30)")
	@Enumerated(EnumType.STRING)
	private ProvideCollateral provideCollateral;
	
	public EducationLoan() {
		super();
	}

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

	public String getFathersLastName() {
		return fathersLastName;
	}

	public void setFathersLastName(String fathersLastName) {
		this.fathersLastName = fathersLastName;
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

	public CourseLevel getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(CourseLevel courseLevel) {
		this.courseLevel = courseLevel;
	}

	public StudyCountry getStudyCountry() {
		return studyCountry;
	}

	public void setStudyCountry(StudyCountry studyCountry) {
		this.studyCountry = studyCountry;
	}

	public StudyCourse getStudyCourse() {
		return studyCourse;
	}

	public void setStudyCourse(StudyCourse studyCourse) {
		this.studyCourse = studyCourse;
	}

	public CourseDuration getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(CourseDuration courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCoBorrowerFirstName() {
		return coBorrowerFirstName;
	}

	public void setCoBorrowerFirstName(String coBorrowerFirstName) {
		this.coBorrowerFirstName = coBorrowerFirstName;
	}

	public String getCoBorrowerLastName() {
		return coBorrowerLastName;
	}

	public void setCoBorrowerLastName(String coBorrowerLastName) {
		this.coBorrowerLastName = coBorrowerLastName;
	}

	public String getCoBorrowerMobile() {
		return coBorrowerMobile;
	}

	public void setCoBorrowerMobile(String coBorrowerMobile) {
		this.coBorrowerMobile = coBorrowerMobile;
	}

	public Gender getCoBorrowerGender() {
		return coBorrowerGender;
	}

	public void setCoBorrowerGender(Gender coBorrowerGender) {
		this.coBorrowerGender = coBorrowerGender;
	}

	public String getCoBorrowerFathersFirstName() {
		return coBorrowerFathersFirstName;
	}

	public void setCoBorrowerFathersFirstName(String coBorrowerFathersFirstName) {
		this.coBorrowerFathersFirstName = coBorrowerFathersFirstName;
	}

	public String getCoBorrowerFathersLastName() {
		return coBorrowerFathersLastName;
	}

	public void setCoBorrowerFathersLastName(String coBorrowerFathersLastName) {
		this.coBorrowerFathersLastName = coBorrowerFathersLastName;
	}

	public Address getCoBorrowerPermAdd() {
		return coBorrowerPermAdd;
	}

	public void setCoBorrowerPermAdd(Address coBorrowerPermAdd) {
		this.coBorrowerPermAdd = coBorrowerPermAdd;
	}

	public Address getCoBorrowerCurrAdd() {
		return coBorrowerCurrAdd;
	}

	public void setCoBorrowerCurrAdd(Address coBorrowerCurrAdd) {
		this.coBorrowerCurrAdd = coBorrowerCurrAdd;
	}

	public StudentRelationship getStudentRelationship() {
		return studentRelationship;
	}

	public void setStudentRelationship(StudentRelationship studenteRelationship) {
		this.studentRelationship = studenteRelationship;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public ProvideCollateral getProvideCollateral() {
		return provideCollateral;
	}

	public void setProvideCollateral(ProvideCollateral provideCollateral) {
		this.provideCollateral = provideCollateral;
	}
	
	
}
