package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.BankAccount;
import com.revature.pojos.BankUser;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class BankUserDao implements DAOP0<BankUser, Integer>{

	@Override
	public List<BankUser> findAll() {
		List<BankUser> bankUser = new ArrayList<BankUser>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "{call FIND_ALL_OF_USERS(?)}";
			CallableStatement callable = conn.prepareCall(sql);
			callable.registerOutParameter(1, OracleTypes.CURSOR);
			callable.execute();
			
			ResultSet rs = (ResultSet) callable.getObject(1);
			while(rs.next()) {
				BankUser temp = new BankUser();
				temp.setUserId(rs.getInt("USERID"));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setUserName(rs.getString(4));
				temp.setPassWord(rs.getString(5));
				bankUser.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankUser;
	}

	@Override
	public BankUser findById(Integer id) {
		BankUser b = null;
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from bank_user where userid = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
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

	@Override
	public BankUser save(BankUser object) {
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			c.setAutoCommit(false);
			
			String sql = "insert into bank_user(firstname, lastname, username, password) values(?, ?, ?, ?)";
			String[] keyName = {"userid"};
			
			PreparedStatement ps = c.prepareStatement(sql, keyName);
			ps.setString(1, object.getFirstName());
			ps.setString(2, object.getLastName());
			ps.setString(3, object.getUserName());
			ps.setString(4, object.getPassWord());
			
			int numRow = ps.executeUpdate();
			if(numRow > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					object.setUserId(pk.getInt(1));
				}
				c.commit();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BankUser update(BankUser obj) {
		BankUser b = null;
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			String sql = "select username, password from bank_user where username = ? and password = ?";
			PreparedStatement ps = c.prepareStatement(sql);
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

	@Override
	public void delete(BankUser obj) {
		// TODO Auto-generated method stub
		
	}





}
