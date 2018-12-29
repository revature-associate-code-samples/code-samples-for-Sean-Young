package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.ErsReimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDao implements DAO<ErsReimbursement, Integer>{
	@Override
	public List<ErsReimbursement> findAll(Integer id) {
		List<ErsReimbursement> er = new ArrayList<ErsReimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ERS_REIMBURSEMENT where reimb_author = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				ErsReimbursement temp = new ErsReimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbResolved(rs.getTimestamp(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(6));
				temp.setReimbResolver(rs.getInt(7));
				temp.setReimbStatusId(rs.getInt(8));
				temp.setReimbTypeId(rs.getInt(9));
				er.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return er;
		
	}
	
	public List<ErsReimbursement> findByStatusId(int id) {
		List<ErsReimbursement> er = new ArrayList<ErsReimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ERS_REIMBURSEMENT where reimb_status_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				ErsReimbursement temp = new ErsReimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbResolved(rs.getTimestamp(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(6));
				temp.setReimbResolver(rs.getInt(7));
				temp.setReimbStatusId(rs.getInt(8));
				temp.setReimbTypeId(rs.getInt(9));
				er.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return er;
		
	}

	@Override
	public ErsReimbursement findById(Integer id) {
		ErsReimbursement e = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String s = "select * from ers_reimbursement where reimb_amount = ?";
			PreparedStatement ps = conn.prepareStatement(s);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				e = new ErsReimbursement();
				e.setReimbId(rs.getInt(1));
				e.setReimbAmount(rs.getDouble(2));
				e.setReimbSubmitted(rs.getTimestamp(3));
				e.setReimbResolved(rs.getTimestamp(4));
				e.setReimbDescription(rs.getString(5));
				e.setReimbAuthor(rs.getInt(6));
				e.setReimbResolver(rs.getInt(7));
				e.setReimbStatusId(rs.getInt(8));
				e.setReimbTypeId(rs.getInt(9));
				
			}
			return e;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public ErsReimbursement save(ErsReimbursement object) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values(?, ?, ?, ?, ?, ?, ?, ?)";
			String[] keyName = {"reimb_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keyName);
			ps.setDouble(1, object.getReimbAmount());
			ps.setTimestamp(2, object.getReimbSubmitted());
			ps.setTimestamp(3, object.getReimbResolved());
			ps.setString(4, object.getReimbDescription());
			ps.setInt(5, object.getReimbAuthor());
			ps.setInt(6,  object.getReimbResolver());
			ps.setInt(7, object.getReimbStatusId());
			ps.setInt(8, object.getReimbTypeId());
			
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					object.setReimbId(pk.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public ErsReimbursement update(ErsReimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update ers_reimbursement set reimb_resolved = ?, reimb_status_id = ? where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, obj.getReimbResolved());
			ps.setInt(2, obj.getReimbStatusId());
			ps.setInt(3, obj.getReimbId());
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void delete(ErsReimbursement obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ErsReimbursement> findAll() {
		List<ErsReimbursement> er = new ArrayList<ErsReimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from ERS_REIMBURSEMENT";

			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				ErsReimbursement temp = new ErsReimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getTimestamp(3));
				temp.setReimbResolved(rs.getTimestamp(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(6));
				temp.setReimbResolver(rs.getInt(7));
				temp.setReimbStatusId(rs.getInt(8));
				temp.setReimbTypeId(rs.getInt(9));
				er.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return er;
	}

}
