package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.revature.pojos.ErsReimbursement;
import com.revature.pojos.ErsUsers;
import com.revature.util.ConnectionFactory;

public class UserDao implements DAO<ErsUsers, Integer> {

	@Override
	public List<ErsUsers> findAll() {
		List<ErsUsers> user = new ArrayList<ErsUsers>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ers_users";
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				ErsUsers temp = new ErsUsers();
				temp.setErsUserId(result.getInt(1));
				temp.setErsUserName(result.getString(2));
				temp.setErsPassword(result.getString(3));
				temp.setFirstName(result.getString(4));
				temp.setLastName(result.getString(5));
				temp.setUserEmail(result.getString(6));
				temp.setUserRoleId(result.getInt(7));
				user.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public ErsUsers findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErsUsers save(ErsUsers object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErsUsers update(ErsUsers obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ErsUsers obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ErsReimbursement> findAll(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



}
