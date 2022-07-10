package user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Random;

import util.DBManager;

public class UserDAO {	// Data Access Object
	
	private Random ran = new Random();
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
		
		int uc = createNum();
		userDto.setUserCode(uc);
		System.out.println(uc);
		System.out.println(userDto.getUserCode());
		
		Date date = new Date(userDto.getYear()-1900, userDto.getMonth(), userDto.getDay());
		Timestamp birthDate = new Timestamp(date.getTime());
		
		try {
			String sql = String.format("insert into users values(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", userDto.getUserCode(), userDto.getId(), userDto.getPw()
			, userDto.getName(), birthDate.toString(), userDto.getGender(), userDto.getEmail(), userDto.getCountry(), userDto.getMobile());
			
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("유저추가 실패");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	public int createNum() {
		while(true) {
			int ranNum = ran.nextInt(8999)+1000;
			if(numDup(ranNum) == 0) {
				return ranNum;
			}
		}
	}
	
	public int numDup(int ranNum) {
		int num = 0;
		conn = DBManager.getConnection("firstJsp");
		
		try {
			String sql = "select * from users where code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ranNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				num = Integer.parseInt(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
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
				String targetId = rs.getString(2);
				String targetPw= rs.getString(3);
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
	
	public UserDTO loginUser(UserDTO tempUser) {
		conn = DBManager.getConnection("firstJSP");
		System.out.println("로그인 유저 메소드 탔음");
		try {
			String sql = "select * from users where id = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tempUser.getId());
			pstmt.setString(2, tempUser.getPw());
			rs = pstmt.executeQuery();
			System.out.println(tempUser.getId());
			System.out.println("쿼리 가져옴");
			
			while(rs.next()){
				int targetCode = Integer.parseInt(rs.getString(1));
				tempUser.setUserCode(targetCode);
				return tempUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연동실패");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return null;
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
	
	public UserDTO getUser(int userCode) {
		UserDTO user = null;
		conn = DBManager.getConnection("firstJsp");
		
		try {
			String sql = "select * from users where `code` = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userCode);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int targetCode = Integer.parseInt(rs.getString(1));
				String targetId = rs.getString(2);
				String targetPw= rs.getString(3);
				user = new UserDTO(targetCode, targetId, targetPw);
				return user;
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
