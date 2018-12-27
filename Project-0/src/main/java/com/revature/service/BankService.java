package com.revature.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountTypeDao;
import com.revature.dao.BankUserDao;
import com.revature.dao.DAOP0;
import com.revature.dao.LoginDao;
import com.revature.main.CustomException;
import com.revature.pojos.BankAccount;
import com.revature.pojos.BankType;
import com.revature.pojos.BankUser;

public class BankService {
	public static void showMenu() {
		BankUserDao b = new BankUserDao();
		b.findAll();
		System.out.println("==================================================");
		System.out.println(
				"Hello and welcome to your banking system" + "\n 1.) Create a User and Account" + "\n 2.) Login"
						+ "\n 3.) Exit");
		System.out.println("==================================================");
		Scanner scan = new Scanner(System.in);
		int option = 0;
		boolean bool = true;
		while (bool) {
			try {
				option = scan.nextInt();
				switch (option) {
				case 1:
					newUser();

					break;
				case 2:
					login();
					showMenu2();
					break;
				case 3:
					System.out.println("Logging Out");
					System.exit(0);
					break;
				default:
					System.out.println("Good Bye");

				}
			} catch (InputMismatchException | CustomException e) {
				System.out.println("Must enter a valid option to continue with your banking. \n"
						+ "Due to security risk. You are being logged out.");
				//showMenu();
			}
		}
	}

	static void showMenu2() {
		System.out.println("=============================" + "\n Select 1 to withdraw. " + "\n Select 2 to deposit. "
				+ "\n Select 3 to to return to the main menu. " + "\n Select 4 to create another Account"
				);
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		boolean bool =  true;
		while (bool) {
			try {
				switch (i) {
				case 1:
					withdraw();
					break;
				case 2:
					deposit();
					break;
				case 3:
					showMenu();
					break;
				case 4:
					createAccount();
					break;
				default:
					System.out.println("You have not chosen a valid option");
				}
			} catch (InputMismatchException e) {
				System.out.println("You must enter a valid option to continue with your banking.");
				showMenu2();
			}
		}
	}

	static void newUser() throws CustomException {
		DAOP0<BankUser, Integer> uDao = new BankUserDao();
		BankUser bUser = new BankUser();

		System.out.println("Enter your first name: ");
		Scanner s1 = new Scanner(System.in);
		String fn = s1.nextLine();
		bUser.setFirstName(fn);

		System.out.println("Enter your last name: ");
		Scanner s2 = new Scanner(System.in);
		String ln = s2.nextLine();
		bUser.setLastName(ln);

		System.out.println("Enter a username: ");
		Scanner s3 = new Scanner(System.in);
		String un = s3.nextLine();
		bUser.setUserName(un);
		try {
			LoginDao l = new LoginDao();
			BankUser use2 = l.findByUserName(un);
			List<BankUser> bank = uDao.findAll();
			for (BankUser ba : bank) {
				if (use2.getUserName().equals(ba.getUserName())) {
					System.out.println("This username is already in use. Please try again.");
					newUser();
				}
			}
		} catch (NullPointerException e) {

		}
		try {
			System.out.println("Enter a password: ");
			Scanner s4 = new Scanner(System.in);
			String pw = s4.nextLine();
			bUser.setPassWord(pw);
			throw new CustomException(pw);
		} catch (CustomException e) {

		}
		uDao.save(bUser);

		System.out.println(bUser);
		createAccount();
	}

	static void login() {
		LoginDao c = new LoginDao();
		DAOP0<BankAccount, Integer> typeDao = new BankAccountDao();
		DAOP0<BankUser, Integer> uDao = new BankUserDao();
		List<BankUser> b = uDao.findAll();
		BankUser b1 = new BankUser();
		List<BankAccount> b2 = typeDao.findAll();
		System.out.println("Please enter your username: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		b1 = c.findByUserName(s);
		System.out.println("Please enter your password: ");
		Scanner scan1 = new Scanner(System.in);
		String s1 = scan.nextLine();

		if (c.login(s, s1) == true) {
			System.out.println("Login succesful");

			b1 = c.findByUserName(s);
			for (BankAccount bank : b2) {
				if (bank.getOwner() == b1.getUserId()) {
					System.out.println(bank);
				}
			}
		}
		if (c.login(s, s1) == false) {
			System.out.println("Your credentials do not match... Log in failed.");
			showMenu();
		}

	}

	static void deposit() {
		DAOP0<BankAccount, Integer> typeB = new BankAccountDao();
		System.out.println("===============================");
		System.out.println("Enter the Account Identification Number that you would like to deposit into. \n");
		Scanner scan1 = new Scanner(System.in);
		int n = scan1.nextInt();
		BankAccount b = typeB.findById(n);
		System.out.println(b);
		System.out.println("How much would you like to deposit into your account?");
		Scanner s1 = new Scanner(System.in);
		double i1 = 0, i2 = 0;
		try {
			i1 = s1.nextDouble();
			i2 = b.getBalance();
		} catch (InputMismatchException e) {
			System.out.println("Deposit must be a dollar amount.");
			s1.nextLine();
			System.out.println("How much would you like to deposit?");
			i1 = s1.nextDouble();
			i2 = b.getBalance();
		}
		double i3 = i1 + i2;
		b.setBalance(i3);
		typeB.update(b);
		System.out.println(b);
		System.out.println("Deposit Successful.");
		System.out.println("Your new account balance is " + i3 + " dollars");
		showMenu2();
	}

	static void withdraw() {
		DAOP0<BankAccount, Integer> typeB = new BankAccountDao();
		System.out.println("What is your account id? ");
		Scanner scan2 = new Scanner(System.in);
		int n = scan2.nextInt();
		BankAccount b = typeB.findById(n);
		System.out.println("How much would you like to withdraw? ");
		Scanner scan1 = new Scanner(System.in);
		double d, d1;
		try {
			d = scan1.nextDouble();
			d1 = b.getBalance();
		} catch (InputMismatchException e) {
			System.out.println("Must enter a dollar amount");
			scan1.nextLine();
			System.out.println("How much would you like to withdraw? ");
			d = scan1.nextDouble();
			d1 = b.getBalance();
		}
		if (d > d1) {
			System.out.println("You do not have enough funds to withdraw that amount");
			withdraw();
		} else {
			double d2 = d1 - d;
			b.setBalance(d2);
			typeB.update(b);
			System.out.println("Withdraw successful. You withdrew " + d + " dollars and have " + d2 + " remaining");
			// showMenu2();
		}
		showMenu2();

	}

	static void createAccount() {
		DAOP0<BankAccount, Integer> typeDao = new BankAccountDao();

		System.out.println("Create a new Account");
		System.out.println("=========================================");

		BankUser user1 = new BankUser();
		BankAccount user = new BankAccount();

		System.out.println("\nWhat account type are you opening today? (Enter 1 for checking and 2 for savings): ");
		Scanner scan1 = new Scanner(System.in);
		int i1 = scan1.nextInt();
		user.setType(i1);

		System.out.println("Enter an owner (This is the same as your User Id): ");
		Scanner scan2 = new Scanner(System.in);
		int i2 = scan2.nextInt();
		user.setOwner(i2);

		System.out.println("Enter a balance: ");
		Scanner scan3 = new Scanner(System.in);
		double i3 = scan3.nextInt();
		user.setBalance(i3);

		typeDao.save(user);

		System.out.println(user);
		showMenu();
	}

}
