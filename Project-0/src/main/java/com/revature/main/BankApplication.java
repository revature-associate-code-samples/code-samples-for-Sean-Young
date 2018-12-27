package com.revature.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountTypeDao;
import com.revature.dao.BankUserDao;
import com.revature.dao.DAOP0;
import com.revature.dao.LoginDao;
import com.revature.pojos.BankAccount;
import com.revature.pojos.BankType;
import com.revature.pojos.BankUser;

import com.revature.service.BankService;

public class BankApplication {

	public static void main(String[] args) {
		
		BankService.showMenu();

	}

	
}
