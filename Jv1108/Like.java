package Jv1108;

public class Like {
	private int parentId; // 원게시물 번호
	private String checkMemberId;
	private String regDate;
	// 생성자 Alt + s + a
	
	public Like(int parentId, String checkMemberId, String regDate) {
		super();
		this.parentId = parentId;
		this.checkMemberId = checkMemberId;
		this.regDate = regDate;
	}
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getCheckMemberId() {
		return checkMemberId;
	}

	public void setCheckMemberId(String checkMemberId) {
		this.checkMemberId = checkMemberId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	 
	
	
	
}
