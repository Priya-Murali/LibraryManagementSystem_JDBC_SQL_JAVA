package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.LibModel;
import utility.ConnectionManager;

public class LibDao extends GetConnection{

	Connection dbConn = null;
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}

	public void storeLibRecordInDb(ArrayList<LibModel> libList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "insert into library(bid,bname,aname,rackno,yearpub) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			for(LibModel lm: libList) {
				ps.setInt(1, lm.getbid());
				ps.setString(2, lm.getbname());
				ps.setString(3, lm.getbname());
				ps.setInt(4, lm.getrackno());
				ps.setDouble(5, lm.getyearpub());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("********************************************************");
					System.out.println("Book record added successfully");
					System.out.println("********************************************************");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewLibraryTableRecord() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "Select * from library";
		try {
			HashMap<Object, Object> hm=new HashMap<>(); 
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				hm.put(rs.getString("bid"),rs.getString("bname"));
			}
			
						System.out.println(hm);
						System.out.println("********************************************************");
						System.out.println("Book record viewed successfully");
						System.out.println("********************************************************");
			
		} catch (SQLException e) {
			System.out.println("error");

			e.printStackTrace();
		}
		
	}

	public void updateLibraryRecord(int option, int bid, String newlibDetail) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = null;
		if(option == 1) {
			sql = "update library set bname = ? where bid = ?";	
		}
		else if(option == 2) {
			sql = "update library set aname = ? where bid = ?";	
		}
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setString(1, newlibDetail);
			ps.setInt(2, bid);
			ps.executeUpdate();
			System.out.println("********************************************************");
			System.out.println("Book record updated successfully");
			System.out.println("********************************************************");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateLibraryRecord(int bid, int newlib) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "update library set rackno = ? where bid = ?";	
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setInt(1, newlib);
			ps.setInt(2, bid);
			ps.executeUpdate();
			System.out.println("********************************************************");
			System.out.println("Book record updated successfully");
			System.out.println("********************************************************");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateLibraryRecord(int bid, double newlibyr) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "update library set yearpub = ? where bid = ?";	
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setDouble(1, newlibyr);
			ps.setInt(2, bid);
			ps.executeUpdate();
			System.out.println("********************************************************");
			System.out.println("Book record updated successfully");
			System.out.println("********************************************************");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteLibraryTableRecord(int bid) throws ClassNotFoundException 
	{
		dbConn = getDbConnection();
		String sql="delete from library where bid=?";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.executeUpdate();
			System.out.println("********************************************************");
			System.out.println("Book record deleted successfully");
			System.out.println("********************************************************");
		} catch (SQLException e) {
			System.out.println("check with query.....");
			e.printStackTrace();
		}
		
	}

}