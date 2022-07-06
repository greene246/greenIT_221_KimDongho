package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class UserDAO {	// Data Access Object
	
	// Singletone Pattern
	
	private UserDAO() {
		
	}
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	// mysql local DB
	// 1. lib > mysqlconnectordriver.jar 를 넣어주기 
	// (maven repository > mysql java)
	// 2. 데이터 베이스 연동 (Connection 클래스 import (java.sql))
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void addUser(UserDTO userDto) {
		conn = DBManager.getConnection("firstJsp");
		
		try {
			String sql = "insert into tetsUser values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getName());
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	public UserDTO getUser(String name) {
		UserDTO user = null;
		conn = DBManager.getConnection("firstJsp");
		try {
			String sql = "select * from testUser where name = ?";
			pstmt.setString(1, name);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String result = rs.getString(1);
				user = new UserDTO(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return user;
	}
}
