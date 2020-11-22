package Jv1108;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Jv1108.Article;

public class ArticleDao {
	private ArrayList<Article> ArticleList = new ArrayList<>();
	private ArrayList<Reply> ReplyList = new ArrayList<>();
	private ArrayList<Like> LikeList = new ArrayList<>();
	int id = 4;

	public String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
		Date time = new Date();
		String time1 = format1.format(time);
		return time1;
	}

	public void init() {
		getCurrentDate();
		
		Article 게시물a = new Article(1, "안녕하세요", "반갑습니다.", getCurrentDate(), 0, "홍길동", "h123");
		Article 게시물b = new Article(2, "제목2", "내용2", getCurrentDate(), 0, "홍길순", "h23");
		Article 게시물c = new Article(3, "제목3", "내용3", getCurrentDate(), 0, "홍홍홍", "h33");

		ArticleList.add(게시물a);
		ArticleList.add(게시물b);
		ArticleList.add(게시물c);
	}
//	public boolean isExistLikeByParentIdAndMemberId(int parentId, String memberLoginId) {
//		for(int i = 0; i < LikeList.size(); i++) {
//			if(LikeList.get(i).getParentId() == (parentId) && LikeList.get(i).getCheckMemberId().equals(memberLoginId)) {
//				return true;
//			} 
//		} return false;
//	}
	
	public void addLike(Like like) {
		like.setRegDate(getCurrentDate());
		LikeList.add(like);
	}	
	

	public void addReply(Reply reply) {
		reply.setRegDate(getCurrentDate());
		ReplyList.add(reply);
	}

	public void addArticle(Article article1) {
		article1.setId(id);
		article1.setRegDate(getCurrentDate());
		ArticleList.add(article1);
		id++;
	}

	public Article getArticleById(int id) {
		int index = getArticleIndexById(id);
		if (index == -1) {
			return null;
		} else {
			return ArticleList.get(index);
		}
	}

	public int getArticleIndexById(int aid) {

		int existFlag = 1; // 1 없다, 2 있다.
		int index = -1; // -1 없다.

		for (int i = 0; i < ArticleList.size(); i++) {
			Article article = ArticleList.get(i);
			if (aid == article.getId()) {
				existFlag = 2;
				index = i;
			}
		}

		return index;
	}

	public boolean updateArticle(int id, String title, String body) {
		int index = getArticleIndexById(id);
		if (index != -1) {
			Article article = ArticleList.get(index);
			article.setTitle(title);
			article.setBody(body);
			ArticleList.set(index, article);

			return true;
		}
		return false;
	}

	public boolean deleteArticle(int id) {
		int index = getArticleIndexById(id);
		if (index != -1) {
			ArticleList.remove(index);
			return true;
		}

		return false;
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
