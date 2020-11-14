package Jv1108;

public class Reply {
	private int parentId;
	private String body;
	private String writer;
	private String regDate;
	// 생성자 Alt + s + a
	public Reply(int parentId, String body, String writer, String regDate) {
		super();
		this.parentId = parentId;
		this.body = body;
		this.writer = writer;
		this.regDate = regDate;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
