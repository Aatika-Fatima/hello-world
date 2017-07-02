package com.slend.rest.api.borrower;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slend.entity.core.borrower.ApplicantDetails;
import com.slend.entity.core.borrower.ConsumerLoan;
import com.slend.entity.dao.core.borrower.ConsumerLoanDao;

@RestController
@Path("/consumerloan/applicantdetails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApplicantDetailsService {
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(ApplicantDetailsService.class);
	@Autowired
	ConsumerLoanDao consumerLoanDao;
	ConsumerLoan consumerLoan;

	@GET
	@Path("/getformques/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarLoanRequestDetails(@PathParam("id") int id) {
		// consumerLoan= consumerLoanDao.findOne(id);
		JSONObject msg = new JSONObject();
		try {
			consumerLoan = consumerLoanDao.findOne(id);
			ApplicantDetails applicantDetails = consumerLoan.getApplicantDetails();
			consumerLoan.setStatus("1");
			consumerLoan.setError("NA");

			msg.put("applicantGender", applicantDetails.getApplicantGender());
			msg.put("dependentsCount", applicantDetails.getDependentsCount());
			msg.put("maritalStatus", applicantDetails.getMaritalStatus());
			msg.put("defaultLoanCC", applicantDetails.getDefaultedLoanCC());
			msg.put("declinedLoanAppSixMonths", applicantDetails.getDeclinedLoanAppSixMonths());
			msg.put("loanIntentTimeFrame", applicantDetails.getLoanIntentTimeFrame());
			msg.put("tenureLoanYears", applicantDetails.getTenureLoanYears());
			msg.put("tenureLoanMonths", applicantDetails.getTenureLoanMonths());
			msg.put("employmentType", applicantDetails.getEmploymentType());
			msg.put("residenceType", applicantDetails.getResidenceType());
			msg.put("status", "1");
			msg.put("error", "NA");
		} catch (Exception e) {
			try {
				e.printStackTrace();
				msg.put("message", "Could not get the ApplicantDetails");
				msg.put("status", "error");
			} catch (JSONException ex) {
				ex.printStackTrace();
				logger.debug("could not create the error json object for [ApplicantDetails  Object cannot be fetched]");
			}
			logger.debug(msg.toString());
			return Response.status(250).entity(msg.toString()).build();
		}
		// return Response.ok().entity(msg.toString()).build();
		return Response.ok(msg.toString()).build();
	}

	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCarLoanApplication(ApplicantDetails applicantDetails) {
		JSONObject msg = new JSONObject();
 		//ObjectMapper mapper = new ObjectMapper();

		try {
			//mapper.writeValue(new File("src/main/resources/json_test_data/applicantDetails.json"), applicantDetails);
			consumerLoan = new ConsumerLoan();
			consumerLoan.setApplicantDetails(applicantDetails);// (applicantDetails);
			consumerLoan = consumerLoanDao.save(consumerLoan);
			consumerLoan.setStatus("1");
			consumerLoan.setError("NA");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				msg.put("message", "Could not save the ApplicantDetails");
				msg.put("status", "error");
			} catch (JSONException ex) {
				logger.debug(
						"could not create the error json object for [ConsumerLoan->ApplicantDetails Object cannot be created]");
			}
			logger.debug(msg.toString());
			return Response.status(250).entity(msg.toString()).build();
		}
		return Response.ok(consumerLoan).build();
	}
}
