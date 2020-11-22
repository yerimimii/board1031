package Jv1108;

public class Reply {
	private int parentId;
	private String body;
	private String writer;
	private String writerId;
	private String regDate;

	public Reply(int parentId, String body, String writer, String writerId) {
		super();
		this.parentId = parentId;
		this.body = body;
		this.writer = writer;
		this.writerId = writerId;
	}

	public Reply(int parentId, String body, String writer, String regDate, String writerId) {
		super();
		this.parentId = parentId;
		this.body = body;
		this.writer = writer;
		this.writerId = writerId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
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
