package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.pojos.BankAccount;
import com.revature.pojos.BankUser;
import com.revature.util.ConnectionFactory;

public class LoginDao {
	public boolean login(String s, String x) {
		boolean b = false;
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			String sql = "select username, password from bank_user where username = ? and password = ?";
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1, s);
			statement.setString(2, x);
			ResultSet result = statement.executeQuery();
				if(result.next()) {
					b = true;}
				else {
					b = false;
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	
		
	}
	
	public BankUser findByUserName(String s) {
		BankUser b = null;
		try(Connection c =ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from bank_user where username = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = new BankUser();
				b.setUserId(rs.getInt(1));
				b.setFirstName(rs.getString(2));
				b.setLastName(rs.getString(3));
				b.setUserName(rs.getString(4));
				b.setPassWord(rs.getString(5));
			}
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public BankAccount findByOwner(int i) {
		BankAccount b = null;
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from bank_account where owner = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				b = new BankAccount();
				b.setAccountId(rs.getInt(1));
				b.setType(rs.getInt(2));
				b.setOwner(rs.getInt(3));
				b.setBalance(rs.getInt(4));
			}
			return b;

					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
