package com.example.cabBooking.service;

import com.example.cabBooking.model.UserModel;
import java.util.List;

public interface UserService {

	public void addUser(UserModel userModel);
	
	public List<UserModel> getUser();
	
	public void updateUserContactNumber(String userName,String contactNumber);

	public void updateUserLocation(String userName, String latitude, String longitude);

	public void calculateBill(String userName);
}
