package board;

import java.sql.Date;

public class BoardDTO {
	private String title, contents;
	private int code, userCode, viewCnt, likeCnt;
	private Date createdAt, modefiedAt;
	
	public BoardDTO(String title, String contents, int userCode){
		this.title = title;
		this.contents = contents;
		this.userCode = userCode;
	}
	
	public BoardDTO(String title, String contents) {
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModefiedAt() {
		return modefiedAt;
	}

	public void setModefiedAt(Date modefiedAt) {
		this.modefiedAt = modefiedAt;
	}
	
}
