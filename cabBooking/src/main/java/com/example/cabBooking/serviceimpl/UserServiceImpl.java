package com.example.cabBooking.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabBooking.controller.UserController;
import com.example.cabBooking.model.UserModel;
import com.example.cabBooking.repository.UserRepository;
import com.example.cabBooking.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(UserModel userModel) {
		userRepository.addUser(userModel);
	}

	@Override
	public List<UserModel> getUser() {
		// TODO Auto-generated method stub
		
		
		return userRepository.getUser();
	}

	@Override
	public void updateUserContactNumber(String userName, String contactNumber) {
		// TODO Auto-generated method stub
		
		userRepository.updateUserContactNumber(userName,contactNumber);
		
		
		
	}

	@Override
	public void updateUserLocation(String userName, String latitude, String longitude) {
		// TODO Auto-generated method stub
		
		userRepository.updateUserLocation(userName,latitude,longitude);
		
	}

	@Override
	public void calculateBill(String userName) {
		// TODO Auto-generated method stub
		List<UserModel> userList = userRepository.getUser();
		if(userList!=null) {
			for(UserModel user :userList ) {
				if(user.getUserName().equalsIgnoreCase(userName)) {
					System.out.println(" ride Ended bill amount :  $ "+user.getTravelUnit());
				}
				}
			}
	}

}
