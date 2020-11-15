package Jv1108;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Jv1108.Article;

public class ArticleDao {
	private ArrayList<Article> ArticleList = new ArrayList<>();
	private ArrayList<Reply> ReplyList = new ArrayList<>();
	int id = 4;
	
	public String getCurrentDate(){
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy.MM.dd");
		Date time = new Date();		
		String time1 = format1.format(time);
		return time1;
	}
	
	
	public void addArticle(Article article1) {
		ArticleList.add(article1);
		id++;
	}
	public void init() {
		getCurrentDate();
		Article 게시물a = new Article(1,"안녕하세요","반갑습니다.",time1);
		Article 게시물b = new Article(2,"제목2","내용2",time1);
		Article 게시물c = new Article(3,"제목3","내용3",time1);
		
		ArticleList.add(게시물a);
		ArticleList.add(게시물b);
		ArticleList.add(게시물c);
		
	}
	
	public ArrayList<Article> getArticleList() {
		return ArticleList;
	}
	public void setArticleList(ArrayList<Article> articleList) {
		ArticleList = articleList;
	}
	public ArrayList<Reply> getReplyList() {
		return ReplyList;
	}
	public void setReplyList(ArrayList<Reply> replyList) {
		ReplyList = replyList;
	}
}
