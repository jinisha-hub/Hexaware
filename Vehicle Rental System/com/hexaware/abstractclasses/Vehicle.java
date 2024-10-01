package com.hexaware.abstractclasses;

public abstract class Vehicle {
	private String name;
    private double rentalPrice;
    private boolean isRented;
    public abstract void rentVehicle();
    public abstract void returnVehicle();
	public Vehicle(String name, double rentalPrice) {
		super();
		this.name = name;
		this.rentalPrice = rentalPrice;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public boolean isRented() {
		return isRented;
	}
	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}
	 public String getDetails() {
	        return "Name: " + name + ", Rental Price: " + rentalPrice  ;
	    }
}
