package com.slend.rest.api.borrower;

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
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.slend.entity.core.borrower.CarCondition;
import com.slend.entity.core.borrower.CarLoan;
import com.slend.entity.core.borrower.City;
import com.slend.entity.core.borrower.ConsumerLoan;
import com.slend.entity.core.borrower.Country;
import com.slend.entity.core.borrower.State;
import com.slend.entity.dao.core.borrower.CarLoanDao;
import com.slend.entity.dao.core.borrower.ConsumerLoanDao;

@Component
@Path("/consumerloan/autoloan/carloan")
public class CarLoanService {
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(CarLoanService.class);
	@Autowired
	ConsumerLoanDao consumerLoanDao;

	@Autowired
	CarLoanDao carLoanDao;

	@GET
	@Path("/getcardetails/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarLoanRequestDetails(@PathParam("id") int id) {
		JSONObject msg = new JSONObject();
		CarLoan carLoan;
		try {
			carLoan = carLoanDao.findOne(id);
			msg.put("status", "1");
			msg.put("error", "NA");
		} catch (Exception e) {
			try {
				msg.put("message", "Could not get the CarLoan");
				msg.put("status", "error");
			} catch (JSONException ex) {
				logger.debug("could not create the error json object for [CarLoan Object cannot be fetched]");
			}
			logger.debug(msg.toString());
			return Response.status(250).entity(msg.toString()).build();
		}
		return Response.ok(carLoan).build();
	}

	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCarLoanApplication(CarLoan carLoan) {
		JSONObject msg = new JSONObject();
		ConsumerLoan consumerLoan;

		try {

			consumerLoan = new ConsumerLoan();
			consumerLoan.setCarLoan(carLoan);
			consumerLoan = consumerLoanDao.save(consumerLoan);
			msg.put("status", "1");
			msg.put("error", "NA");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				msg.put("message", "Could not save the CarLoan");
				msg.put("status", "error");
			} catch (JSONException ex) {
				logger.debug(
						"could not create the error json object for [ConsumerLoan->CarLoan Object cannot be created]");
			}
			logger.debug(msg.toString());
			return Response.status(250).entity(msg.toString()).build();
		}
		return Response.ok(consumerLoan).build();
	}
}
