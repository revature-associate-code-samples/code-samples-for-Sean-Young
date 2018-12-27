package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.BankType;
import com.revature.util.ConnectionFactory;

public class BankAccountTypeDao implements DAOP0<BankType, Integer> {

	public List<BankType> findAll() {
		List<BankType> b = new ArrayList<BankType>();
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			
		
				String s = "select * from Bank_AccountType";
				
				Statement statement = c.createStatement();
				
				ResultSet rs = statement.executeQuery(s);
				
				while(rs.next()) {
					BankType temp = new BankType();
					temp.setId(rs.getInt(1));
					temp.setType(rs.getString(2));
					b.add(temp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public BankType findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public BankType save(BankType object) {
		// TODO Auto-generated method stub
		return null;
	}

	public BankType update(BankType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(BankType obj) {
		// TODO Auto-generated method stub
		
	}

}
