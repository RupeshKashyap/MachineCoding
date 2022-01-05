package com.example.cabBooking.model;


public class UserModel {
	
	private String userName;
	
	private Character gender;
	
	private String  contactNumber;
	
	private String latitude;
	
	private String longitude;
	
	private Integer travelUnit;
	
	
	public UserModel() {}

	public UserModel(String userName, Character gender, String contactNumber, String latitude, String longitude,Integer travelUnit) {
		this.userName = userName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.latitude = latitude;
		this.longitude = longitude;
		this.travelUnit = travelUnit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	

	public Integer getTravelUnit() {
		return travelUnit;
	}

	public void setTravelUnit(Integer travelUnit) {
		this.travelUnit = travelUnit;
	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", gender=" + gender + ", contactNumber=" + contactNumber
				+ ", latitude=" + latitude + ", longitude=" + longitude  + ", travelUnit=" + travelUnit +"]";
	} 
	
	

}
