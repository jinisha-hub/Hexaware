package com.hexaware.BankAccountManagementSystem;
import java.util.Scanner;
import com.hexaware.exceptions.*;

	// Bank Account class
	class BankAccount {
	    private String accountHolderName;
	    private double balance;

	    // Constructor to create a new bank account
	    public BankAccount(String accountHolderName) {
	        this.accountHolderName = accountHolderName;
	        this.balance = 0.0;
	    }

	    // Method to deposit money
	    public void deposit(double amount) throws InvalidAmountException {
	        if (amount <= 0) {
	            throw new InvalidAmountException("Amount to deposit must be greater than zero.");
	        }
	        balance += amount;
	        System.out.println("Successfully deposited $" + amount);
	    }

	    // Method to withdraw money
	    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
	        if (amount <= 0) {
	            throw new InvalidAmountException("Amount to withdraw must be greater than zero.");
	        }
	        if (amount > balance) {
	            throw new InsufficientFundsException("Insufficient funds. You only have $" + balance);
	        }
	        balance -= amount;
	        System.out.println("Successfully withdrew $" + amount);
	    }

	    // Method to check balance
	    public double getBalance() {
	        return balance;
	    }

	    // Get account holder name
	    public String getAccountHolderName() {
	        return accountHolderName;
	    }
	}

	// Main class
	public class Handling {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        BankAccount account = null;
	        
	        while (true) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Create New Account");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Check Balance");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");
	            
	            try {
	                int choice = scanner.nextInt();
	                
	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter account holder name: ");
	                        scanner.nextLine();  // Consume newline
	                        String name = scanner.nextLine();
	                        account = new BankAccount(name);
	                        System.out.println("Account created successfully for " + account.getAccountHolderName());
	                        break;

	                    case 2:
	                        if (account == null) throw new NullPointerException("No account found. Create an account first.");
	                        System.out.print("Enter amount to deposit: ");
	                        double depositAmount = scanner.nextDouble();
	                        account.deposit(depositAmount);
	                        break;

	                    case 3:
	                        if (account == null) throw new NullPointerException("No account found. Create an account first.");
	                        System.out.print("Enter amount to withdraw: ");
	                        double withdrawAmount = scanner.nextDouble();
	                        account.withdraw(withdrawAmount);
	                        break;

	                    case 4:
	                        if (account == null) throw new NullPointerException("No account found. Create an account first.");
	                        System.out.println("Current balance: $" + account.getBalance());
	                        break;

	                    case 5:
	                        System.out.println("Exiting the system.");
	                        System.exit(0);

	                    default:
	                        throw new InvalidChoiceException("Invalid choice! Please select a valid option.");
	                }
	            } catch (InvalidAmountException | InsufficientFundsException | InvalidChoiceException e) {
	                System.out.println(e.getMessage());
	            } catch (NullPointerException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (Exception e) {
	                System.out.println("Please enter a valid option.");
	                scanner.next(); // Clear the invalid input
	            }
	        }
	    }
	}



