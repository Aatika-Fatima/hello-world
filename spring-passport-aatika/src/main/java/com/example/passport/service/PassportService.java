package com.example.passport.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.passport.exceptions.ApplicationNotFoundException;
import com.example.passport.exceptions.DocumentUploadingException;
import com.example.passport.exceptions.PassportApplicationSaveException;
import com.example.passport.model.AddressProofDoc;
import com.example.passport.model.ApplicationStatus;
import com.example.passport.model.Gender;
import com.example.passport.model.Passport;
import com.example.passport.model.PhotoProofDoc;
import com.example.passport.repository.IPassportRepository;
import com.example.passport.repository.PassportJpaRepository;
import com.example.passport.util.SuccessMessage;

@Service
public class PassportService {
	@Autowired
	IPassportRepository passportRepository;

	@Transactional
	public SuccessMessage saveDocuments(Passport p) {
		passportRepository.updatePassport(p.getPhotoURL(), p.getAddressProofDocNumber(), p.getAddressProofDocFileUrl(),
				p.getPhotoIdProofDocNumber(), p.getPhotoIdProofDocUrl(), p.getApplicationId());
		p = passportRepository.findDocumentByApplicationId(p.getApplicationId());
		SuccessMessage successMessage = new SuccessMessage(1, "Documents Uploaded Successfuly", p.getApplicationId(),
				p.getApplicationStatus());
		return successMessage;
	}

	@Transactional
	public SuccessMessage createPassport(Passport p) {
		Passport passport = null;

		try {
			passportRepository.create(p);
			passport = passportRepository.findDocumentByApplicationId(p.getApplicationId());
		} catch (RuntimeException ex) {
			throw new PassportApplicationSaveException();
		}

		SuccessMessage successMessage = new SuccessMessage(1, "Application Created", passport.getApplicationId(),
				passport.getApplicationStatus());
		return successMessage;
	}

	public Map<String, Object> getDocumentInfo(int applicationId) {
		Passport p = passportRepository.findDocumentByApplicationId(applicationId);
		if (p == null)
			throw new ApplicationNotFoundException(applicationId);

		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("id", p.getId());
		responseMap.put("applicationId", p.getApplicationId());
		responseMap.put("applicationStatus", p.getApplicationStatus());
		responseMap.put("addressProofDoc", p.getAddressProofDoc());
		responseMap.put("photoIdProofDoc", p.getPhotoIdProofDoc());
		return responseMap;
	}

	public Passport getApplicationByApplicationId(Integer applicationId) {
		Passport p = passportRepository.findDocumentByApplicationId(applicationId);
		if (p == null)
			throw new ApplicationNotFoundException(applicationId);
		return p;
	}

	public void uploadFiles(MultipartFile photoFile, MultipartFile addressProofDocFile,
			MultipartFile photoIdProofDocFile, int applicationId) {
		final String appId = String.valueOf(applicationId);
		final String ADDRESS_PROOF_PATH = "src/main/resources/files/ADDRESS_PROOF";
		final String PHOTO_FILE_PATH = "src/main/resources/files/PHOTO_FILE";
		final String PHOTO_ID_PROOF_PATH = "src/main/resources/files/PHOTO_ID_PROOF";
		try {
			Files.write(Paths.get(ADDRESS_PROOF_PATH, applicationId + "_" + addressProofDocFile.getOriginalFilename()),
					addressProofDocFile.getBytes());
			Files.write(Paths.get(PHOTO_FILE_PATH, applicationId + "_" + photoFile.getOriginalFilename()),
					photoFile.getBytes());
			Files.write(Paths.get(PHOTO_ID_PROOF_PATH, applicationId + "_" + photoIdProofDocFile.getOriginalFilename()),
					photoIdProofDocFile.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
			throw new DocumentUploadingException();
		}
	}

}
