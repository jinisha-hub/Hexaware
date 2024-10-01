package com.hexaware.mainvehicleprogram;

import com.hexaware.concreteclasses.Car;
import com.hexaware.abstractclasses.Vehicle;
import com.hexaware.concreteclasses.Bike;
import com.hexaware.concreteclasses.Truck;
import com.hexaware.userclass.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("John Doe");
        
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Rent a Car");
            System.out.println("2. Rent a Bike");
            System.out.println("3. Rent a Truck");
            System.out.println("4. Return a Vehicle");
            System.out.println("5. List Rented Vehicles");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                
                if (choice == 0) {
                    System.out.println("Exiting the program.");
                    break; // Exit the loop if the user enters 0
                }
                
                Vehicle vehicle = null;
                switch (choice) {
                    case 1:
                        vehicle = new Car("Toyota", 70);
                        break;
                    case 2:
                        vehicle = new Bike("Yamaha", 30);
                        break;
                    case 3:
                        vehicle = new Truck("Ford", 100);
                        break;
                    case 4:
                        System.out.print("Enter the name of the vehicle to return: ");
                        String vehicleName= scanner.next();
                        // Assuming vehicle name is unique; you may implement a more robust solution later
                        vehicle = findVehicleByName(user, vehicleName);
                        if (vehicle != null) {
                            user.returnVehicle(vehicle); // Return the selected vehicle
                        } else {
                            System.out.println("Vehicle not found in rented vehicles.");
                        }
                        continue; // Go back to the menu after returning
                    case 5:
                        user.listRentedVehicles(); // List rented vehicles
                        continue; // Go back to the menu
                    default:
                        System.out.println("Invalid choice. Please enter 1-5.");
                        continue; // Skip to the next iteration of the loop
                }
                
                if (vehicle != null) {
                    user.rentVehicle(vehicle); 
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close(); // Close the scanner when done
    }

    // Helper method to find a vehicle by name in the user's rented vehicles

//    private static Vehicle findVehicleByName(User user, String name) {
//        Vehicle[] rentedVehicles = user.getRentedVehicles();
//        
//        for (int i = 0; i < user.getRentedCount(); i++) {
//            // Compare the names of the vehicles using equalsIgnoreCase
//        	if (rentedVehicles[i].getName().trim().equalsIgnoreCase(name.trim())) 
//                return rentedVehicles[i];
//            }
//        
//        return null; // Return null if no vehicle is found
//    }
    private static Vehicle findVehicleByName(User user, String name) {
        Vehicle[] rentedVehicles = user.getRentedVehicles();
     
        
        for (int i = 0; i < user.getRentedCount(); i++) {
            // Compare the names of the vehicles using equalsIgnoreCase
            System.out.println("Checking vehicle: " + rentedVehicles[i].getName()); // Print each vehicle being checked
            if (rentedVehicles[i].getName().trim().equalsIgnoreCase(name.trim())) {
                return rentedVehicles[i]; // Return the found vehicle
            }
        }
        return null; // Return null if no vehicle is found
    }

}
