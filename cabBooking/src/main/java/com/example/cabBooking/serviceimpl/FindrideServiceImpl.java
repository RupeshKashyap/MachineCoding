package com.example.cabBooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabBooking.model.DriverModel;
import com.example.cabBooking.model.UserModel;
import com.example.cabBooking.repository.DriverRepository;
import com.example.cabBooking.repository.UserRepository;
import com.example.cabBooking.service.FindrideService;

@Service
public class FindrideServiceImpl implements FindrideService {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override
	public List<DriverModel> findRides(String userName, String sourceLatitude, String sourceLongitude,
			String destinationLatitude, String destinationLongitude) {
		// TODO Auto-generated method stub
		List<DriverModel> nearestDrivers = new ArrayList<>();
	List<DriverModel> driversList = 	driverRepository.getDrivers();
	if(driversList!=null) {
		for(DriverModel driver :driversList ) {
			//System.out.println("lat Diff : "+Math.abs(Integer.parseInt(driver.getLatitude()) - Integer.parseInt(sourceLatitude)));
			//System.out.println("long diff : "+Math.abs(Integer.parseInt(driver.getLatitude()) - Integer.parseInt(sourceLongitude)));
			if( (Math.abs(Integer.parseInt(driver.getLatitude()) - Integer.parseInt(sourceLatitude)) <=5) || (Math.abs(Integer.parseInt(driver.getLatitude()) - Integer.parseInt(sourceLongitude))<=5) ) {
				if(driver.getIsAvailable())
				nearestDrivers.add(driver);
			}
		}
	}
		
		return nearestDrivers;
	}

	@Override
	public void chooseRide(String userName, String driverName, String destinationLatitude,
			String destinationLongitude) {
		List<DriverModel> driversList = 	driverRepository.getDrivers();
		
		List<UserModel> usersList = 	userRepository.getUser();
		Integer traveledUnits = 0 ;
		if(usersList!=null) {
			for(UserModel user :usersList ) {
				if(user.getUserName().equalsIgnoreCase(userName)) {
					traveledUnits = 	Math.abs(Integer.parseInt(user.getLatitude()) - Integer.parseInt(destinationLatitude));
					userRepository.updateUserLocation(userName, destinationLatitude, destinationLongitude);
					userRepository.updateTravelUnit(userName,traveledUnits);
					
					userServiceImpl.calculateBill(userName);
				}
				
			}
		}
		
		if(driversList!=null) {
			for(DriverModel driver :driversList ) {
				if(driver.getDriverName().equalsIgnoreCase(driverName)) {
					driverRepository.updateDriverLocation(driverName, destinationLatitude, destinationLongitude);
					driverRepository.updateTravelUnit(driverName,traveledUnits);
				}
			}
		}
			
	}

}
