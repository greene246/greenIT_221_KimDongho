package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	// DBManager.getConnection();
	// ���ܺ� Ŭ�������� ��� ������ �ʿ��� ��, Connection�� �� �� �ִ�.
	public static Connection getConnection(String database) {
//	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
//		String url = "jdbc:mysql://localhost:3306/firstJsp";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url + database, user, password);
//			conn = DriverManager.getConnection(url, user, password);
			System.out.println("���� ����");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� ����");
		}
		return null;
	}

}
