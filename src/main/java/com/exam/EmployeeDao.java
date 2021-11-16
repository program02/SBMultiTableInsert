package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class EmployeeDao {
	Connection con;
	PreparedStatement pstmt;
	public Employee findById(int id) {
		Employee u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiinsert", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from employee where id="+id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Employee(rs.getInt(1));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public Employee findByEmailPassword(String email,String password) {
		//List<Product> pList = new ArrayList<>();
		Employee u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiinsert", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from employee where id="+email+ "and id="+password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Employee(rs.getInt(1));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public void save(Employee u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiinsert", "root", "idb@123456");
			pstmt = con.prepareStatement("insert into employee values(?,?,?,?)");
			//this field is AI
			//pstmt.setInt(1, u.id);
			pstmt.setInt(1, u.id);
			pstmt.setString(2, u.name);
			pstmt.setString(3, u.email);
			pstmt.setString(4, u.phone);

	
			int n = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
