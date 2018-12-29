package com.revature.dao;

import java.io.Serializable;
import java.util.List;

import com.revature.pojos.ErsReimbursement;

public interface DAO<T, I extends Serializable> {
	List<T> findAll();
	T findById(I id);
	T save(T object);
	T update(T obj);
	void delete(T obj);
	List<ErsReimbursement> findAll(Integer id);
}
