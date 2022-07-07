package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import user.UserDTO;
import util.DBManager;

public class BoardDAO {
	private Random ran = new Random();
	
	private BoardDAO() {}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean addBoard(BoardDTO board) {
		conn = DBManager.getConnection("firstJsp");
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		int boardCode = createBoardCode();
		
		try {
			String sql = String.format("insert into board values(%d, %d, '%s', '%s', %d, %d, '%s', null)",
					boardCode, board.getUserCode(), board.getTitle(), board.getContents(), 0, 0, now.toString());
			
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			return true;
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
		return false;
	}
	
	private int createBoardCode() {
		conn = DBManager.getConnection("firstJsp");
		
		int num = -1;
		
		while(true){
			int boardCode = ran.nextInt(8999)+1000;
			
			try {
				String sql = String.format("select count(*) from board where code = %d", boardCode);
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					num = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			if(num == 0) {
				return boardCode;
			}
		}
	}
	
	public ArrayList<BoardDTO> getBoard() {
		ArrayList<BoardDTO> boardList = new ArrayList<>();
		conn = DBManager.getConnection("firstJsp");
		
			try {
				String sql = String.format("select * from board");
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int code = rs.getInt(1);
					int userCode = rs.getInt(2);
					String title = rs.getString(3);
					String contents = rs.getString(4);
					int viewCnt = rs.getInt(5);
					int likeCnt = rs.getInt(6);
					Timestamp createdAt = rs.getTimestamp(7);
					Timestamp modifiedAt = rs.getTimestamp(8);
					
					BoardDTO board = new BoardDTO(code, userCode, title, contents,
							viewCnt, likeCnt, createdAt, modifiedAt);
					
					boardList.add(board);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("게시글 추출 실패");
			} 
			return boardList;
	}
	
	public BoardDTO getBoard(int code) {
		ArrayList<BoardDTO> tempBoard = getBoard();
		
		for(int i=0; i<tempBoard.size(); i++) {
			if(tempBoard.get(i).getCode() == code) {
				return tempBoard.get(i);
			}
		}
		return null;
	}
	
	public void update(BoardDTO temp) {
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		try {
			String sql = String.format("UPDATE board SET title = '%s', contents = '%s', modifiedAt = '%s'"
					+ " WHERE code = %d;", temp.getTitle(), temp.getContents(), now.toString(), temp.getCode());
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 수정 실패");
		} 
	}
	
	
}
