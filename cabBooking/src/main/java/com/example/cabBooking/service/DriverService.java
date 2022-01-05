package com.example.cabBooking.service;

import java.util.List;

import com.example.cabBooking.model.DriverModel;

public interface DriverService {

	void addDriver(DriverModel driverModel);

	List<DriverModel> getDrivers();

	void updateDriverLocation(String driverName, String latitude, String longitude);

	void updateDriverStatus(String driverName, Boolean isAvailable);

	void DriversEarnings();

}
