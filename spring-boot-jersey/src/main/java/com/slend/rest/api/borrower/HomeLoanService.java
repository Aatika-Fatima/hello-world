package com.slend.rest.api.borrower;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slend.entity.core.borrower.ConsumerLoan;
import com.slend.entity.core.borrower.HomeLoan;
import com.slend.entity.dao.core.borrower.ConsumerLoanDao;

@Component
@Path("/consumerloan/homeloan")
public class HomeLoanService {
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(HomeLoanService.class);

	ConsumerLoan consumerLoan;
	@Autowired
	ConsumerLoanDao consumerLoanDao;

	@GET
	@Path("/gethomeques/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHomeLoanRequestDetails(@PathParam("id") int id) {
		// consumerLoan= consumerLoanDao.findOne(id);
		JSONObject msg = new JSONObject();
		try {
			consumerLoan = consumerLoanDao.findOne(id);
			consumerLoan.setStatus("1");
			consumerLoan.setError("NA");

		} catch (Exception e) {
			try {
				e.printStackTrace();
				msg.put("message", "Could not get the Home Loan");
				msg.put("status", "error");
			} catch (JSONException ex) {
				ex.printStackTrace();
				logger.debug("could not create the error json object for [Home Loan Object cannot be fetched]");
			}
			logger.debug(msg.toString());
			return Response.status(250).entity(msg.toString()).build();
		}
		// return Response.ok().entity(msg.toString()).build();
		return Response.ok(consumerLoan).build();
	}

	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createHomeLoan(HomeLoan homeLoan) {
		JSONObject msg = new JSONObject();
		ConsumerLoan consumerLoan;

		try {

			consumerLoan = new ConsumerLoan();
			consumerLoan.setHomeLoan(homeLoan);

			consumerLoan = consumerLoanDao.save(consumerLoan);
			consumerLoan.setStatus("1");
			consumerLoan.setError("NA");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				msg.put("message", "Could not save the Home Loan");
				msg.put("status", "error");
			} catch (JSONException ex) {
				logger.debug(
						"could not create the error json object for [ConsumerLoan->Home Loan Object cannot be created]");
			}
			logger.debug(msg.toString());
			return Response.status(250).entity(msg.toString()).build();
		}
		return Response.ok().entity(msg).entity(consumerLoan).build();
	}
}
