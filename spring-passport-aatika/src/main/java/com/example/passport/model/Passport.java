package com.example.passport.model;

import java.net.URL;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@NamedQueries({ @NamedQuery(name = "findDocumentByApplicationId", query = "SELECT p FROM Passport p where p.applicationId = :applicationId"),
	@NamedQuery(name = "updatePassport", query = "UPDATE Passport p set p.photoURL=:photoURL,p.addressProofDocNumber =:addressProofDocNumber, p.addressProofDocFileUrl =:addressProofDocFileUrl,p.photoIdProofDocNumber=:photoIdProofDocNumber,p.photoIdProofDocUrl=:photoIdProofDocUrl where p.applicationId=:applicationId") })
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true, length = 16, nullable = false)
	private int applicationId;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 50, nullable = false)
	private String fatherName;

	@Column(nullable = false)
	private Date dateOfBirth;

	@Enumerated(EnumType.STRING)
	@Column(length = 6, nullable = false)
	private Gender gender;

	@Column(nullable = false)
	private String address;

	@Column(length = 10, nullable = false)
	private String phone;

	@Column(length = 50, nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private ApplicationStatus applicationStatus;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable=false)
	private AddressProofDoc addressProofDoc;
	
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable=false)
	private PhotoProofDoc photoIdProofDoc;

	@Column(length = 60)
	private String photoURL;
	
	@Column(length = 20)
	private String addressProofDocNumber;
	
	@Column(length = 60)
	private String addressProofDocFileUrl;

	@Column(length = 20)
	private int photoIdProofDocNumber;
	
	@Column(length = 60)
	private String photoIdProofDocUrl;
	
 	private Date lastModified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public AddressProofDoc getAddressProofDoc() {
		return addressProofDoc;
	}

	public void setAddressProofDoc(AddressProofDoc addressProofDoc) {
		this.addressProofDoc = addressProofDoc;
	}

	public PhotoProofDoc getPhotoIdProofDoc() {
		return photoIdProofDoc;
	}

	public void setPhotoIdProofDoc(PhotoProofDoc photoIdProofDoc) {
		this.photoIdProofDoc = photoIdProofDoc;
	}
 

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public String getAddressProofDocNumber() {
		return addressProofDocNumber;
	}

	public void setAddressProofDocNumber(String addressProofDocNumber) {
		this.addressProofDocNumber = addressProofDocNumber;
	}

	public String getAddressProofDocFileUrl() {
		return addressProofDocFileUrl;
	}

	public void setAddressProofDocFileUrl(String addressProofDocFileUrl) {
		this.addressProofDocFileUrl = addressProofDocFileUrl;
	}

	public int getPhotoIdProofDocNumber() {
		return photoIdProofDocNumber;
	}

	public void setPhotoIdProofDocNumber(int photoIdProofDocNumber) {
		this.photoIdProofDocNumber = photoIdProofDocNumber;
	}

	public String getPhotoIdProofDocUrl() {
		return photoIdProofDocUrl;
	}

	public void setPhotoIdProofDocUrl(String photoIdProofDocUrl) {
		this.photoIdProofDocUrl = photoIdProofDocUrl;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", applicationId=" + applicationId + ", name=" + name + ", fatherName="
				+ fatherName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", applicationStatus=" + applicationStatus
				+ ", addressProofDoc=" + addressProofDoc + ", photoIdProofDoc=" + photoIdProofDoc + ", photoURL="
				+ photoURL + ", addressProofDocNumber=" + addressProofDocNumber + ", addressProofDocFileUrl="
				+ addressProofDocFileUrl + ", photoIdProofDocNumber=" + photoIdProofDocNumber + ", photoIdProofDocUrl="
				+ photoIdProofDocUrl + ", lastModified=" + lastModified + "]";
	}

 
}
