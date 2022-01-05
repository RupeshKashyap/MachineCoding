package com.example.cabBooking.model;

public class DriverModel {
	
	private String driverName;
	
	private Character gender;
	
	private Integer age;
	
	private String vehicleName ;
	
	private String vehicleNumber;
	
	private String latitude;
	
	private String longitude;
	
	private Boolean isAvailable;
	
	private Integer travelUnit;
	
	 public DriverModel() {}
	 
	public DriverModel(String driverName, Character gender, Integer age, String vehicleName, String vehicleNumber,
			String latitude, String longitude, Boolean isAvailable, Integer travelUnit) {
		super();
		this.driverName = driverName;
		this.gender = gender;
		this.age = age;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.latitude = latitude;
		this.longitude = longitude;
		this.isAvailable = isAvailable;
		this.travelUnit = travelUnit;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
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

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Integer getTravelUnit() {
		return travelUnit;
	}

	public void setTravelUnit(Integer travelUnit) {
		this.travelUnit = travelUnit;
	}

	@Override
	public String toString() {
		return "DriverModel [driverName=" + driverName + ", gender=" + gender + ", age=" + age + ", vehicleName="
				+ vehicleName + ", vehicleNumber=" + vehicleNumber + ", latitude=" + latitude + ", longitude="
				+ longitude + ", isAvailable=" + isAvailable + ", travelUnit=" + travelUnit + "]";
	}



}
