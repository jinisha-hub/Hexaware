package com.hexaware.userclass;
import com.hexaware.abstractclasses.Vehicle;

public class User {
	private String name;
    private Vehicle[] rentedVehicles;
    private int rentedCount;
    private static final int MAX_VEHICLES = 5;
	//public User(String name, Vehicle[] rentedVehicles, int rentedCount) {
		//super();
		//this.name = name;
		//this.rentedVehicles = rentedVehicles;
		//this.rentedCount = rentedCount;
	//}
	public User(String name) {
		this.name = name;
		this.rentedVehicles = new Vehicle[MAX_VEHICLES];;
		this.rentedCount = 0;
		// TODO Auto-generated constructor stub
	}
//	public void rentVehicle(Vehicle vehicle) {
//		if(rentedCount < MAX_VEHICLES) {
//            rentedVehicles[rentedCount] = vehicle;
//            rentedCount++;
//            vehicle.rentVehicle();  // Mark the vehicle as rented
//            System.out.println(name + " has rented " + vehicle.getName());
//        } else {
//            System.out.println(name + " cannot rent more than " + MAX_VEHICLES + " vehicles.");
//        }
//			
//		}
	public void rentVehicle(Vehicle vehicle) {
	    // Check if the vehicle is already rented
		 if (vehicle.isRented()) {
		        System.out.println(vehicle.getName() + " is already rented.");
		        return;
		 }
	    if (rentedCount < MAX_VEHICLES) {
	        rentedVehicles[rentedCount] = vehicle;
	        rentedCount++;
	       // vehicle.rentVehicle();  // Mark the vehicle as rented
	        System.out.println(name + " has rented " + vehicle.getName());
	    } 
	    
	     else {
	        System.out.println(name + " cannot rent more than " + MAX_VEHICLES + " vehicles.");
	     }
	
	}

//   public void returnVehicle(Vehicle vehicle) {
//    boolean found = false;
//    for (int i = 0; i < rentedCount; i++) {
//        if (rentedVehicles[i].getName().trim().equalsIgnoreCase(vehicle.getName().trim()))  {
//            rentedVehicles[i].returnVehicle();  // Return the vehicle
//            rentedVehicles[i] = rentedVehicles[rentedCount - 1];  // Replace with the last rented vehicle
//            rentedVehicles[rentedCount - 1] = null;  // Remove reference
//            rentedCount--;
//            System.out.println(name + " has returned " + vehicle.getName());
//            found = true;
//            break;
//        }
//    }
//    if (!found) {
//        System.out.println(name + " has not rented this vehicle.");
//    }
//}
//	public void returnVehicle(Vehicle vehicle) {
//	    boolean found = false;
//	    System.out.println("Currently rented vehicles for " + name + ":");
//	    
//	    for (int i = 0; i < rentedCount; i++) {
//	        System.out.println("- " + rentedVehicles[i].getName()); // Print names of all rented vehicles
//	    }
//	    
//	    for (int i = 0; i < rentedCount; i++) {
//	        if (rentedVehicles[i].getName().trim().equalsIgnoreCase(vehicle.getName().trim()))  {
//	            rentedVehicles[i].returnVehicle();  // Return the vehicle
//	            rentedVehicles[i] = rentedVehicles[rentedCount - 1];  // Replace with the last rented vehicle
//	            rentedVehicles[rentedCount - 1] = null;  // Remove reference
//	            rentedCount--;
//	            System.out.println(name + " has returned " + vehicle.getName());
//	            found = true;
//	            break;
//	        }
//	    }
//	    if (!found) {
//	        System.out.println(name + " has not rented this vehicle.");
//	    }
//	}
	public void returnVehicle(Vehicle vehicle) {
	    boolean found = false;
	    String vehicleNameToReturn = vehicle.getName().trim(); // Get the name to return
	  
	    for (int i = 0; i < rentedCount; i++) {
	        String rentedVehicleName = rentedVehicles[i].getName().trim(); // Trim the rented vehicle name
	        if (rentedVehicleName.equalsIgnoreCase(vehicleNameToReturn)) {
	            rentedVehicles[i].returnVehicle();  // Return the vehicle
	            rentedVehicles[i] = rentedVehicles[rentedCount - 1];  // Replace with the last rented vehicle
	            rentedVehicles[rentedCount - 1] = null;  // Remove reference
	            rentedCount--;
	            System.out.println(name + " has returned " + vehicle.getName());
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println(name + " has not rented this vehicle.");
	    }
	}


// Method to list all rented vehicles
    public void listRentedVehicles() {
    if (rentedCount == 0) {
        System.out.println(name + " has not rented any vehicles.");
    } else {
        System.out.println(name + " has rented the following vehicles:");
        for (int i = 0; i < rentedCount; i++) {
            System.out.println("- " + rentedVehicles[i].getName());
        }}
    }
    public int getRentedCount() {
        return rentedCount;
    }

   
    public Vehicle[] getRentedVehicles() {
        return rentedVehicles; // Return the array of rented vehicles
    }
    

	
	}
    
