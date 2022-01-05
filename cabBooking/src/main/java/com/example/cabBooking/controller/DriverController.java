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

import com.example.cabBooking.model.DriverModel;
import com.example.cabBooking.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	private static final Logger LOGGER = Logger.getLogger(DriverController.class.getName());
	@Autowired()
	private DriverService driverService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DriverModel> saveDriver(@RequestBody @Validated DriverModel driverModel) {

		try {
			LOGGER.info("User Details "+driverModel);
			// default current location
			driverModel.setLatitude("10");
			driverModel.setLongitude("11");
			driverModel.setIsAvailable(true);
			LOGGER.info("User Details "+driverModel);
			driverService.addDriver(driverModel);
			return ResponseEntity.ok(driverModel);
		}catch(Exception ex){
			LOGGER.info("Execption in saveDriver "+ex);
			return ResponseEntity.notFound().build();
		}

	}
	
	@GetMapping()
	public ResponseEntity<List<DriverModel>> getDrivers() {
		try {
			System.out.println("Executing get Drivers");
			List<DriverModel> driverModelList =  driverService.getDrivers();
			return ResponseEntity.ok(driverModelList);
		}catch(Exception ex ) {
			System.out.println(ex);
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value ="/updateLocation/{driverName}")
	public ResponseEntity updateDriverLocation(@PathVariable("driverName") String driverName,@RequestParam("latitude")String  latitude,@RequestParam("longitude")String  longitude){
		LOGGER.info("Username = "+driverName +" latitude  = "+latitude+" longitude  = "+longitude);
		try {
			driverService.updateDriverLocation(driverName,latitude,longitude);
			
			return ResponseEntity.ok().build();
		}catch(Exception ex) {
			LOGGER.info("exception "+ ex);
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value ="/{driverName}")
	public ResponseEntity updateDriverStatus(@PathVariable("driverName") String driverName,@RequestParam("isAvailable")Boolean  isAvailable){
		LOGGER.info("Id = "+driverName +" Contact Number  = "+isAvailable);
		try {
			driverService.updateDriverStatus(driverName,isAvailable);
			
			return ResponseEntity.ok().build();
		}catch(Exception ex) {
			LOGGER.info("exception "+ ex);
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping(value = "/driversearnings")
	public ResponseEntity DriversEarnings() {
		try {
			System.out.println("Executing  Driverearnings");
			  driverService.DriversEarnings();
			return ResponseEntity.ok().build();
		}catch(Exception ex ) {
			System.out.println(ex);
			return ResponseEntity.notFound().build();
		}
	}
	
}
