package com.ubbys.board.vo;


public class Reply {
	
	private int replyId;			// 댓글 번호
	private String replyContent;	// 댓글 내용
	private int replyLike;			// 댓글 좋아요 수
	private String replyDate;			// 댓글 작성일
	private String userNickname;	// 댓글 작성자 닉네임
	private int qnaPostId;			// 해당 댓글의 본문 번호
	private int userId;				// 작성자 번호
	private String userPic;			// 작성자 프로필 사진
	
	public Reply() {}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getReplyLike() {
		return replyLike;
	}

	public void setReplyLike(int replyLike) {
		this.replyLike = replyLike;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getQnaPostId() {
		return qnaPostId;
	}

	public void setQnaPostId(int qnaPostId) {
		this.qnaPostId = qnaPostId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyLike=" + replyLike
				+ ", replyDate=" + replyDate + ", userNickname=" + userNickname + ", qnaPostId=" + qnaPostId
				+ ", userId=" + userId + ", userPic=" + userPic + "]";
	}

	
	
}
