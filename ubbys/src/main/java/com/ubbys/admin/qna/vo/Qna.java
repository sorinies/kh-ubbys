package com.ubbys.admin.qna.vo;

public class Qna {
	
	private int qnaPostId;
	private String qnaCategoryName; // 카테고리 이름
	private String qnaDate;			// 작성일
	private String qnaTitle;		// 제목
	private String userNickname;	// 작성자
	private int qnaLike;			// 좋아요슈
	private int qnaReplyCount;		// 댓글수
	
	// 상세조회
	private String qnaContent;		// 내용
	private int userId;				// 회원번호
	
	// 조회조건
	private String searchQnaCond;
	private String searchQnaCondText;
	private String searchOrder;
	
	private int qnaCategoryId;
	
	public Qna() {}

	public int getQnaPostId() {
		return qnaPostId;
	}

	public void setQnaPostId(int qnaPostId) {
		this.qnaPostId = qnaPostId;
	}

	public String getQnaCategoryName() {
		return qnaCategoryName;
	}

	public void setQnaCategoryName(String qnaCategoryName) {
		this.qnaCategoryName = qnaCategoryName;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getQnaLike() {
		return qnaLike;
	}

	public void setQnaLike(int qnaLike) {
		this.qnaLike = qnaLike;
	}

	public int getQnaReplyCount() {
		return qnaReplyCount;
	}

	public void setQnaReplyCount(int qnaReplyCount) {
		this.qnaReplyCount = qnaReplyCount;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSearchQnaCond() {
		return searchQnaCond;
	}

	public void setSearchQnaCond(String searchQnaCond) {
		this.searchQnaCond = searchQnaCond;
	}

	public String getSearchQnaCondText() {
		return searchQnaCondText;
	}

	public void setSearchQnaCondText(String searchQnaCondText) {
		this.searchQnaCondText = searchQnaCondText;
	}

	public String getSearchOrder() {
		return searchOrder;
	}

	public void setSearchOrder(String searchOrder) {
		this.searchOrder = searchOrder;
	}

	public int getQnaCategoryId() {
		return qnaCategoryId;
	}

	public void setQnaCategoryId(int qnaCategoryId) {
		this.qnaCategoryId = qnaCategoryId;
	}

	@Override
	public String toString() {
		return "Qna [qnaPostId=" + qnaPostId + ", qnaCategoryName=" + qnaCategoryName + ", qnaDate=" + qnaDate
				+ ", qnaTitle=" + qnaTitle + ", userNickname=" + userNickname + ", qnaLike=" + qnaLike
				+ ", qnaReplyCount=" + qnaReplyCount + ", qnaContent=" + qnaContent + ", userId=" + userId + "]";
	}

}
