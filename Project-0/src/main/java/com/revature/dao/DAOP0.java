package com.revature.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import com.revature.pojos.BankAccount;

public interface DAOP0<T, I extends Serializable> {
	
	List<T> findAll();
	T findById(I id);
	T save(T object);
	T update(T obj);
	void delete(T obj);


}
