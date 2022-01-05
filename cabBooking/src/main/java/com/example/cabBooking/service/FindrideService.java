package com.example.cabBooking.service;

import java.util.List;

import com.example.cabBooking.model.DriverModel;

public interface FindrideService {

	List<DriverModel> findRides(String userName, String sourceLatitude, String sourceLongitude,
			String destinationLatitude, String destinationLongitude);

	void chooseRide(String userName, String driverName, String destinationLatitude, String destinationLongitude);

}
