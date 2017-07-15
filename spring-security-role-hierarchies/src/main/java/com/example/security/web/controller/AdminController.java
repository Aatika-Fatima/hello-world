package com.example.security.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

 
@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(method=RequestMethod.POST, value="/movies")
	@ResponseBody
	public ResponseEntity<?> createMovie(){
  		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/movies")
	@ResponseBody
	public ResponseEntity<?> accessMovie(){
		UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 		return new ResponseEntity<>(userDetails.getUsername() + " is accessing movies" ,HttpStatus.FOUND);
	}
}
