package com.example.cabBooking.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.cabBooking.model.DriverModel;
import com.example.cabBooking.model.UserModel;


@Repository
public class DriverRepository {
	
	 List<DriverModel> driverModelList;
	 
	 public DriverRepository() {
		 driverModelList = new ArrayList<>();
	 }
	 

	public void addDriver(DriverModel driverModel) {
		// TODO Auto-generated method stub
		driverModelList.add(driverModel);
		
	}


	public List<DriverModel> getDrivers() {
		// TODO Auto-generated method stub
		return driverModelList;
	}


	public void updateDriverLocation(String driverName, String latitude, String longitude) {
		// TODO Auto-generated method stub
		
		for(DriverModel driver : driverModelList) {
			if(driver.getDriverName().equalsIgnoreCase(driverName)) {
				driver.setLatitude(latitude);
				driver.setLongitude(longitude);
			}
		}
		
	}


	public void updateDriverStatus(String driverName, Boolean isAvailable) {
		// TODO Auto-generated method stub
		
		for(DriverModel driver : driverModelList) {
			if(driver.getDriverName().equalsIgnoreCase(driverName)) {
				driver.setIsAvailable(isAvailable);
				
			}
		}
		
	}


	public void updateTravelUnit(String driverName, Integer traveledUnits) {
		// TODO Auto-generated method stub
		for(DriverModel driver : driverModelList) {
			if(driver.getDriverName().equalsIgnoreCase(driverName)) {
				driver.setTravelUnit(traveledUnits);
				
			}
		}
		
	}

}
