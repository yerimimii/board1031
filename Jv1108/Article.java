package Jv1108;

public class Article {
	private String title;
	  private String body;
	  private int id;
	  private String writer = "익명";
	  private int hit; 
	  private String regDate;
	  
	  public Article(int id, String title, String body, String regDate) {
		  this.id = id;
		  this.title = title;
		  this.body = body;
		  this.regDate = regDate;
	  }
	  public Article(int id, String title, String body, String regDate, int hit, String writer) {
		  this.id = id;
		  this.title = title;
		  this.body = body;
		  this.regDate = regDate;
		  this.hit = hit;
		  this.writer = writer;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	  
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
