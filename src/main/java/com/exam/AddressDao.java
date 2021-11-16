package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class AddressDao {
	Connection con;
	PreparedStatement pstmt;
	public Address findById(int id) {
		Address u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiinsert", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from address where id="+id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Address(rs.getInt(1));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public Address findByEmailPassword(String email,String password) {
		//List<Product> pList = new ArrayList<>();
		Address u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiinsert", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from address where id="+email+ "and id="+password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Address(rs.getInt(1));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public void save(Address u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiinsert", "root", "idb@123456");
			pstmt = con.prepareStatement("insert into address(roadno,streetno,pobox) values(?,?,?)");
			//this field is AI
			//pstmt.setInt(1, u.getAid());
			pstmt.setString(1, u.getRoadno());
			pstmt.setString(2, u.getStreetno());
			pstmt.setString(3, u.getPobox());

	
			int n = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
