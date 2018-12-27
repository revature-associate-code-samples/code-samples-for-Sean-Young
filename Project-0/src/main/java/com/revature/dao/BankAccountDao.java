package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.BankAccount;
import com.revature.util.ConnectionFactory;

public class BankAccountDao implements DAOP0<BankAccount, Integer> {

	@Override
	public List<BankAccount> findAll() {
		List<BankAccount> ba = new ArrayList<BankAccount>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String s = "select * from Bank_Account";
			
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(s);
			
			while(rs.next()){
				BankAccount temp = new BankAccount();
				temp.setAccountId(rs.getInt(1));
				temp.setType(rs.getInt(2));
				temp.setOwner(rs.getInt(3));
				temp.setBalance(rs.getInt(4));
				ba.add(temp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ba;
	}

	



	@Override
	public BankAccount update(BankAccount obj) {
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			c.setAutoCommit(false);
			String sql = "update bank_account set balance = ? where accountid = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getAccountId());
			ps.executeUpdate();
			c.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}





	@Override
	public BankAccount findById(Integer id) {
		BankAccount b = null;
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from bank_account where accountid = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				b = new BankAccount();
				b.setAccountId(rs.getInt(1 ));
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





	@Override
	public BankAccount save(BankAccount object) {
		try(Connection c = ConnectionFactory.getInstance().getConnection()){
			c.setAutoCommit(false);
			
			String sql = "insert into bank_account(type, owner, balance) values(?, ?, ?)";
			String[] bankAccount = {"accountid"};
			
			PreparedStatement ps = c.prepareStatement(sql, bankAccount);
			ps.setInt(1, object.getType());
			ps.setInt(2, object.getOwner());
			ps.setDouble(3, object.getBalance());
			
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					object.setAccountId(pk.getInt(1));
				}
				c.commit();}
			}
	
		
	
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}




	@Override
	public void delete(BankAccount obj) {
		// TODO Auto-generated method stub
		
	}







}
