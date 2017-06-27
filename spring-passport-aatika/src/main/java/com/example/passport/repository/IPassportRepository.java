package com.example.passport.repository;

import org.springframework.data.repository.query.Param;

import com.example.passport.model.Passport;

public interface IPassportRepository extends IDao<Passport>{
	public Passport findDocumentByApplicationId( Integer applicationId);

	public void updatePassport(String photoURL, String addressProofDocNumber, String AddressProofDocFileUrl,
			int photoIdProofDocNumber, String PhotoIdProofDocUrl, int applicationId);

}
