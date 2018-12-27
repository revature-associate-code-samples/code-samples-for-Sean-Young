package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.LoginDao;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.pojos.ErsReimbursement;
import com.revature.pojos.ErsUsers;

public class UserService {
	
	
	static LoginDao login = new LoginDao();
	static UserDao uDao = new UserDao();
	static ReimbursementDao rDao = new ReimbursementDao();
	public ErsUsers getByUsername(String name) {
		ErsUsers u = uDao.findAll().stream().filter(x -> x.getErsUserName().equalsIgnoreCase(name)).findAny().orElse(null);
		
		
		return u;
	}
	
	public ErsUsers validateUser(String username, String password) {
		ErsUsers u = getByUsername(username);
		if(login.login(username, password) == true) {
			return u;
		}
		else return null;
		
	}
	
	public List<ErsReimbursement> getSubmitted(int i) {
		return rDao.findAll(i);
		
	}
	
	public static ErsReimbursement findById(int i) {
		return rDao.findById(i);
		
	}

	public List<ErsReimbursement> getPending(int i){
		return rDao.findByStatusId(i);
	}
	
	public ErsReimbursement submitReimbursement(ErsReimbursement e) {
		return rDao.save(e);
		
	}
	
	public ErsReimbursement updateReimbursement(ErsReimbursement e) {
		return rDao.update(e);
	}
	
	public List<ErsReimbursement> getHandled(){
		
		return rDao.findByStatusId(1);
	}
	
	public List<ErsReimbursement> getHandled2(){
		return rDao.findByStatusId(2);
	}

}
