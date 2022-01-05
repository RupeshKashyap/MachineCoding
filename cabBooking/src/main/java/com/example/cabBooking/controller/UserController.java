package com.example.cabBooking.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabBooking.model.UserModel;
import com.example.cabBooking.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
	@Autowired(required=true)
	private UserService userService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> saveUser(@RequestBody @Validated UserModel userModel) {

		try {
			System.out.println("User Details "+userModel);
			 userService.addUser(userModel);
			return ResponseEntity.ok(userModel);
		}catch(Exception ex){
			System.out.println(ex);
			return ResponseEntity.notFound().build();
		}

	}
	
	
	@GetMapping()
	public ResponseEntity<List<UserModel>> getUser() {
		try {
			System.out.println("Executing get User");
			List<UserModel> userModelList =  userService.getUser();
			return ResponseEntity.ok(userModelList);
		}catch(Exception ex ) {
			System.out.println(ex);
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value ="/{userName}")
	public ResponseEntity updateUserContactNumber(@PathVariable("userName") String userName,@RequestParam("contactNumber")String  contactNumber){
		LOGGER.info("Id = "+userName +" Contact Number  = "+contactNumber);
		try {
			userService.updateUserContactNumber(userName,contactNumber);
			
			return ResponseEntity.ok().build();
		}catch(Exception ex) {
			LOGGER.info("exception "+ ex);
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value ="/updateLocation/{userName}")
	public ResponseEntity updateUserLocation(@PathVariable("userName") String userName,@RequestParam("latitude")String  latitude,@RequestParam("longitude")String  longitude){
		LOGGER.info("Id = "+userName +" latitude  = "+latitude+" longitude  = "+longitude);
		try {
			userService.updateUserLocation(userName,latitude,longitude);
			
			return ResponseEntity.ok().build();
		}catch(Exception ex) {
			LOGGER.info("exception "+ ex);
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value ="/{userName}")
	public ResponseEntity calculateBill(@PathVariable("userName") String userName){
		LOGGER.info("UserName = "+userName);
		try {
			userService.calculateBill(userName);
			
			return ResponseEntity.ok().build();
		}catch(Exception ex) {
			LOGGER.info("exception "+ ex);
			return ResponseEntity.notFound().build();
		}
	}

}
