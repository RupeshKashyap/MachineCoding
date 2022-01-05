package com.example.cabBooking.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabBooking.model.DriverModel;
import com.example.cabBooking.service.DriverService;
import com.example.cabBooking.service.FindrideService;
import com.example.cabBooking.service.UserService;

@RestController
@RequestMapping("/findride")
public class FindRideController {
	
	private static final Logger LOGGER = Logger.getLogger(FindRideController.class.getName());
	
	@Autowired()
	private DriverService driverService;
	
	@Autowired()
	private UserService userService;
	
	@Autowired
	private FindrideService findrideService;
	
	@PostMapping(value ="/{userName}")
	public ResponseEntity findRides(@PathVariable("userName") String userName,@RequestParam("sourceLatitude")String  sourceLatitude,@RequestParam("sourceLongitude")String  sourceLongitude,@RequestParam("destinationLatitude")String  destinationLatitude,@RequestParam("destinationLongitude")String  destinationLongitude){
		LOGGER.info("Username = "+userName +" sourceLatitude  = "+sourceLatitude+" sourceLongitude  = "+sourceLongitude);
		LOGGER.info("Username = "+userName +" destinationLatitude  = "+destinationLatitude+" destinationLongitude  = "+destinationLongitude);
		try {
		List<DriverModel> cabs = 	findrideService.findRides(userName,sourceLatitude,sourceLongitude,destinationLatitude,destinationLongitude);
			
			return ResponseEntity.ok(cabs);
		}catch(Exception ex) {
			LOGGER.info("exception "+ ex);
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value ="/chooseRide/{userName}")
	public ResponseEntity chooseRide(@PathVariable("userName")String userName,@RequestParam("driverName") String driverName,@RequestParam("destinationLatitude")String  destinationLatitude,@RequestParam("destinationLongitude")String  destinationLongitude){
		LOGGER.info("Username = "+userName +" destinationLatitude  = "+destinationLatitude+" destinationLongitude  = "+destinationLongitude);
		try {
		findrideService.chooseRide(userName,driverName,destinationLatitude,destinationLongitude);
			LOGGER.info("Ride Started");
			return ResponseEntity.ok().build();
		}catch(Exception ex) {
			LOGGER.info("exception "+ ex);
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
