package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void addBoard(BoardDTO board) {
		conn = DBManager.getConnection("firstJsp");
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		System.out.println(now);
		
		try {
			String sql = String.format("insert into board values(%d, %d, '%s', '%s', %d, %d, '%s')",
					0, board.getUserCode(), board.getTitle(), board.getContents(), 0, 0, now.toString());
			
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 작성 실패");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
		
		
	}
	
	
	
}
