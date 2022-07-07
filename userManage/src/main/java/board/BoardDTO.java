package board;

import java.sql.Date;
import java.sql.Timestamp;

public class BoardDTO {
	private String title, contents;
	private int code, userCode, viewCnt, likeCnt;
	private Timestamp createdAt, modifiedAt;
	
	public BoardDTO(int code, int userCode, String title, String contents, int viewCnt, int likeCnt, Timestamp createdAt, Timestamp modifiedAt) {
		this.code = code;
		this.userCode = userCode;
		this.title = title;
		this.contents = contents;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
	
	public BoardDTO(String title, String contents, int userCode){
		this.title = title;
		this.contents = contents;
		this.userCode = userCode;
	}
	
	public BoardDTO(int code, String title, String contents) {
		this.code = code;
		this.title = title;
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
