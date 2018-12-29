package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class LoginDao {
	public boolean login(String user, String pass) {
		boolean b = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select ers_username, ers_password from ers_users where ers_username = ? and ers_password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,  user);
			statement.setString(2, pass);
			ResultSet result = statement.executeQuery();
				if(result.next()) {
					b = true;
				}
				else {
					b = false;
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
}
