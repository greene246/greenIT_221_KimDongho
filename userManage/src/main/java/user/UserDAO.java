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
	// 1. lib > mysqlconnectordriver.jar �� �־��ֱ� 
	// (maven repository > mysql java)
	// 2. ������ ���̽� ���� (Connection Ŭ���� import (java.sql))
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
			System.out.println("������ ���� ����");
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
		// �Ʒ� �޼ҵ带 ���ؼ� �޾ƿ� Id�� ���� ������ �ִ��� ��ȸ
		// null�� �� ���ٴ� ��
		UserDTO targetUser = getUser(user);
		
		// targetUser�� null�� �ƴ� �� �޾ƿ� user�� �߰�
		if(targetUser == null) {
			addUser(user);
			return true;
		}
		else {
			return false;
		}
	}
}
