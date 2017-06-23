package com.example.passport.repository;

import java.net.URL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.passport.model.Passport;

@Repository
public interface PassportJpaRepository extends JpaRepository<Passport, Integer>{
	/*
	 * "id":"",
"applicationId":"",
"name":"",
"applicationStatus":"",
"addressProofDoc":"",
" photoIdProofDoc ":""
	 */
	@Query("SELECT p FROM Passport p where p.applicationId = :applicationId")
	public Passport findDocumentByApplicationId(@Param("applicationId") Integer applicationId);
	
	/*
	 * p.setPhotoURL(new URL(photoFile.getOriginalFilename()));
			p.setAddressProofDocNumber(addressProofDocNumber);
			p.setAddressProofDocFileUrl(new URL(addressProofDocFile.getOriginalFilename()));
			p.setPhotoIdProofDocNumber(photoIdProofDocNumber);
			p.setPhotoIdProofDocUrl(new URL(photoIdProofDocFile.getOriginalFilename()));
	 */
	
	@Modifying
	@Query("UPDATE Passport p set p.photoURL=:photoURL,p.addressProofDocNumber =:addressProofDocNumber, p.addressProofDocFileUrl =:addressProofDocFileUrl,p.photoIdProofDocNumber=:photoIdProofDocNumber,p.photoIdProofDocUrl=:photoIdProofDocUrl where p.applicationId=:applicationId")
	public void updatePassport(@Param("photoURL")URL photoURL, 
			@Param("addressProofDocNumber") String addressProofDocNumber, 
			@Param("addressProofDocFileUrl") URL AddressProofDocFileUrl, 
			@Param("photoIdProofDocNumber")int photoIdProofDocNumber,
			@Param("photoIdProofDocUrl")URL PhotoIdProofDocUrl, 
			@Param("applicationId") int applicationId);
	
	@Modifying
	@Query("UPDATE Passport p set p.photoURL=:photoURL,p.addressProofDocNumber =:addressProofDocNumber, p.addressProofDocFileUrl =:addressProofDocFileUrl,p.photoIdProofDocNumber=:photoIdProofDocNumber,p.photoIdProofDocUrl=:photoIdProofDocUrl where p.applicationId=:applicationId")
	public void updatePassport(@Param("photoURL")String photoURL, 
			@Param("addressProofDocNumber") String addressProofDocNumber, 
			@Param("addressProofDocFileUrl") String AddressProofDocFileUrl, 
			@Param("photoIdProofDocNumber")int photoIdProofDocNumber,
			@Param("photoIdProofDocUrl")String PhotoIdProofDocUrl, 
			@Param("applicationId") int applicationId);


 
	
 }
	