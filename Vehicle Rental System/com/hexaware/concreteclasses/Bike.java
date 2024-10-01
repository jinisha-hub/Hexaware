package com.hexaware.concreteclasses;
import com.hexaware.abstractclasses.Vehicle;

public class Bike extends Vehicle {
	public Bike(String name,double rentalPrice){
		super(name,rentalPrice);
	}
	public void rentVehicle() {
		if(isRented()) {
			setRented(true);
			System.out.println(getName() + " has been rented at price" + getRentalPrice() + " per day.");
        }
		else {
        	System.out.println(getName() + " is already rented.");
		}
	}
	
	public void returnVehicle() {
		if(isRented()) {
			setRented(false);
			System.out.println(getName() + " has been returned.");
		}
		else {
			System.out.println(getName() + " was not rented.");
		}
	}

}
