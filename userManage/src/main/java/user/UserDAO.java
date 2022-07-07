package user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

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
		
		Date date = new Date(userDto.getYear()-1900, userDto.getMonth(), userDto.getDay());
		Timestamp birthDate = new Timestamp(date.getTime());
		
		try {
			String sql = "insert into users values(?, ? ,?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPw());
			pstmt.setString(3, userDto.getName());
			pstmt.setTimestamp(4, birthDate);
			pstmt.setString(5, userDto.getGender());
			pstmt.setString(6, userDto.getEmail());
			pstmt.setString(7, userDto.getCountry());
			pstmt.setString(8, userDto.getMobile());
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터 연동 실패");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	public UserDTO getUser(UserDTO tempUser) {
		UserDTO user = null;
		conn = DBManager.getConnection("firstJsp");
		
		try {
			String sql = "select * from users where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tempUser.getId());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String targetId = rs.getString(1);
				String targetPw= rs.getString(2);
				user = new UserDTO(targetId, targetPw);
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
	
	public boolean userDupl(UserDTO user) {
		// 아래 메소드를 통해서 받아온 Id를 가진 유저가 있는지 조회
		// null일 시 없다는 뜻
		UserDTO targetUser = getUser(user);
		
		// targetUser가 null이 아닐 시 받아온 user를 추가
		if(targetUser == null) {
			addUser(user);
			return true;
		}
		else {
			return false;
		}
	}
}
