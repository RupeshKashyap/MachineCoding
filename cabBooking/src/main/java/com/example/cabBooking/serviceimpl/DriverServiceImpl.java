package com.example.cabBooking.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabBooking.model.DriverModel;
import com.example.cabBooking.repository.DriverRepository;
import com.example.cabBooking.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public void addDriver(DriverModel driverModel) {
		// TODO Auto-generated method stub
		
		driverRepository.addDriver(driverModel);
		
	}

	@Override
	public List<DriverModel> getDrivers() {
		// TODO Auto-generated method stub
		return driverRepository.getDrivers();
	}

	@Override
	public void updateDriverLocation(String driverName, String latitude, String longitude) {
		// TODO Auto-generated method stub
		
		driverRepository.updateDriverLocation(driverName,  latitude, longitude);
	}

	@Override
	public void updateDriverStatus(String driverName, Boolean isAvailable) {
		// TODO Auto-generated method stub
		driverRepository.updateDriverStatus(driverName,isAvailable);
	}

	@Override
	public void DriversEarnings() {
		// TODO Auto-generated method stub
		
	List<DriverModel> driversList = 	driverRepository.getDrivers();
	for(DriverModel driver : driversList) {
		
		if(driver.getTravelUnit()!=null) {
			System.out.println(driver.getDriverName()+" earn $ "+driver.getTravelUnit());
		}else {
			System.out.println(driver.getDriverName()+" earn $0");
		}
		
	}
		
	}

}
