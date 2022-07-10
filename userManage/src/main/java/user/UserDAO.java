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
	// 1. lib > mysqlconnectordriver.jar �� �־��ֱ� 
	// (maven repository > mysql java)
	// 2. ������ ���̽� ���� (Connection Ŭ���� import (java.sql))
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
			System.out.println("�����߰� ����");
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
		System.out.println("�α��� ���� �޼ҵ� ����");
		try {
			String sql = "select * from users where id = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tempUser.getId());
			pstmt.setString(2, tempUser.getPw());
			rs = pstmt.executeQuery();
			System.out.println(tempUser.getId());
			System.out.println("���� ������");
			
			while(rs.next()){
				int targetCode = Integer.parseInt(rs.getString(1));
				tempUser.setUserCode(targetCode);
				return tempUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������");
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
