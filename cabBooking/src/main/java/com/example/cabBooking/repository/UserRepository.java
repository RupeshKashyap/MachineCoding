package com.example.cabBooking.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.cabBooking.model.UserModel;

@Repository
public class UserRepository {
	 List<UserModel> userModelList;
	 
	 public UserRepository() {
		 this.userModelList = new ArrayList<>();
	        
	    }
	 
	 public void addUser(UserModel userModel) {
		 try {
			if(userModel!=null) {
				userModelList.add(userModel);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	 }

	public List<UserModel> getUser() {
		// TODO Auto-generated method stub
		return userModelList;
	}
	
	public void updateUserContactNumber(String userName, String contactNumber) {
		for(UserModel um : userModelList) {
			if(um.getUserName().equalsIgnoreCase(userName)) {
				um.setContactNumber(contactNumber);
			}
		}
	}

	public void updateUserLocation(String userName, String latitude, String longitude) {
		// TODO Auto-generated method stub
		
		for(UserModel user : userModelList) {
			if(user.getUserName().equalsIgnoreCase(userName)) {
				user.setLatitude(latitude);
				user.setLongitude(longitude);
			}
		}
		
	}

	public void updateTravelUnit(String userName, Integer traveledUnits) {
		// TODO Auto-generated method stub
		for(UserModel user : userModelList) {
			if(user.getUserName().equalsIgnoreCase(userName)) {
				user.setTravelUnit(traveledUnits);
			}
		}
		
		
	}
	

}
