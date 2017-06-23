package com.example.passport.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.passport.model.Passport;
import com.example.passport.service.PassportService;
import com.example.passport.util.SuccessMessage;

@RestController
public class PassportController {

	@Autowired
	PassportService passportService;

	@RequestMapping("/passport/getDocInfo/{applicationId}")
	public ResponseEntity<Map<String, Object>> getPassportInfo(@PathVariable("applicationId") Integer applicationId) {
		return new ResponseEntity<>(passportService.getDocumentInfo(applicationId), HttpStatus.OK);
	}

	@RequestMapping(value = "/passport/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuccessMessage createPassport(@RequestBody Passport passport) {
		SuccessMessage successMessage = passportService.createPassport(passport);
		return successMessage;

	}

	@RequestMapping(value = "/passport/getapplication/{applicationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Passport getApplicationDocument(@PathVariable("applicationId") Integer applicationId) {
		return passportService.getApplicationByApplicationId(applicationId);
	}

	@RequestMapping(value = "/passport/savedocs", method = RequestMethod.POST, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuccessMessage test(@RequestParam(name = "photoFile", required = true) MultipartFile photoFile,
			@RequestParam("applicationId") int applicationId,
			@RequestParam(name = "addressProofDocFile", required = true) MultipartFile addressProofDocFile,
			@RequestParam(name = "photoIdProofDocFile", required = true) MultipartFile photoIdProofDocFile,
			@RequestParam(name = "photoIdProofDocNumber", required = true) int photoIdProofDocNumber,
			@RequestPart(name = "addressProofDocNumber", required = true) String addressProofDocNumber) {
		
		passportService.uploadFiles(photoFile, addressProofDocFile, photoIdProofDocFile, applicationId);
		
		Passport p = new Passport();
		p.setApplicationId(applicationId);
		p.setPhotoURL(photoFile.getOriginalFilename());
		p.setAddressProofDocNumber(addressProofDocNumber);
		p.setAddressProofDocFileUrl(addressProofDocFile.getOriginalFilename());
		p.setPhotoIdProofDocNumber(photoIdProofDocNumber);
		p.setPhotoIdProofDocUrl(photoIdProofDocFile.getOriginalFilename());

		return passportService.saveDocuments(p);

	}

/*	@RequestMapping(value = "/passport/uploadFile", method = RequestMethod.POST, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.ALL_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuccessMessage saveDocs(@RequestPart(name = "applicationId", required = true) int applicationId,
			@RequestPart(name = "photoFile", required = true) MultipartFile photoFile,
			@RequestPart(name = "addressProofDocNumber", required = true) String addressProofDocNumber,
			@RequestPart(name = "addressProofDocFile", required = true) MultipartFile addressProofDocFile,
			@RequestPart(name = "photoIdProofDocNumber", required = true) int photoIdProofDocNumber,
			@RequestPart(name = "photoIdProofDocFile", required = true) MultipartFile photoIdProofDocFile) {
		passportService.uploadFiles(photoFile, addressProofDocFile, photoIdProofDocFile, applicationId);
		Passport p = new Passport();
		p.setApplicationId(applicationId);

		p.setPhotoURL(photoFile.getOriginalFilename());
		p.setAddressProofDocNumber("1");
		p.setAddressProofDocFileUrl(addressProofDocFile.getOriginalFilename());
		p.setPhotoIdProofDocNumber(1);
		p.setPhotoIdProofDocUrl(photoIdProofDocFile.getOriginalFilename());

		return passportService.saveDocuments(p);
	}*/

}
