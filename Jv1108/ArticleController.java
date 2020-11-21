package Jv1108;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
	
	public ArticleController() {
		articleDao.init();
	}
	
	ArticleDao articleDao = new ArticleDao();
	Scanner sc = new Scanner(System.in);
	
	public void doCommand(String cmd) {
		if (cmd.equals("add")) {
			addArticle();
		}

		if (cmd.equals("list")) {
			printArticleList();
		}

		if (cmd.equals("update")) {
			updateArticle();
		}

		if (cmd.equals("delete")) {
			deleteArticle();
		}

		if (cmd.equals("read")) {
			readArticle();
		}

		if (cmd.equals("search")) {
			searchArticle();
		}
	}
	
	public void searchArticle() {
		System.out.print("검색 항목을 입력해주세요 (1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자) ");
		int searchTarget = Integer.parseInt(sc.nextLine());

		System.out.print("검색 키워드를 입력해주세요 :");
		String keyword = sc.nextLine();
		ArrayList<Article> ArticleList = articleDao.getArticleList();

		for (int i = 0; i < ArticleList.size(); i++) {
			Article aa = ArticleList.get(i);
			String targetStr;

			if (searchTarget == 1) {
				targetStr = aa.getTitle();
			} else if (searchTarget == 2) {
				targetStr = aa.getBody();
			} else if (searchTarget == 3) {
				targetStr = aa.getTitle() + aa.getBody();
			} else {
				targetStr = aa.getWriter();
			}

			if (targetStr.contains(keyword)) {
				System.out.println(" 번호 : " + aa.getId());
				System.out.println(" 제목 : " + aa.getTitle());
				System.out.println(" 등록날짜 : " + aa.getRegDate());
				System.out.println(" 조회수 : " + aa.getHit());
				System.out.println(" 작성자 : " + aa.getWriter());
			}
		}
	}
	
	public void readProcess(Article article) {
		while (true) {
			System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3.수정, 4. 삭제, 5. 목록으로) :");
			int rCmdNo = Integer.parseInt(sc.nextLine());
			if (rCmdNo == 1) {
				System.out.print("댓글 내용을 입력해주세요 : ");
				String replyBody = sc.nextLine();
				Reply re = new Reply(article.getId(), replyBody, "익명");

				articleDao.addReply(re);
				System.out.println("댓글이 등록되었습니다.");

				printArticle(article);
			}

			if (rCmdNo == 2) {
				System.out.println("[좋아요 기능]");
			}

			if (rCmdNo == 3) {
				System.out.println("[수정 기능]");
			}

			if (rCmdNo == 4) {
				System.out.println("[삭제 기능]");
			}

			if (rCmdNo == 5) {
				break;
			}
		}
	}
	public void readArticle() {
		System.out.print("읽을 게시물 번호: ");
		String aid = sc.nextLine();
		int targetId = Integer.parseInt(aid);
		Article article = articleDao.getArticleById(targetId);

		if (article == null) {
			System.out.println("없는 게시물입니다.");
		} else {
			int targetHit = article.getHit();
			article.setHit(targetHit + 1);

			printArticle(article);
			readProcess(article);
		}
	}
	
	public void deleteArticle() {
		System.out.print("삭제할 게시물 번호: ");
		String aid = sc.nextLine();
		int targetId = Integer.parseInt(aid);
		boolean rst = articleDao.deleteArticle(targetId);

		if (!rst) {
			System.out.println("없는 게시물 번호입니다.");
		}
	}
	
	public void updateArticle() {
		System.out.print("수정할 게시물 번호: ");
		String aid = sc.nextLine();
		int targetId = Integer.parseInt(aid);

		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String body = sc.nextLine();

		boolean rst = articleDao.updateArticle(targetId, title, body);

		if (!rst) {
			System.out.println("없는 게시물 번호입니다.");
		}
	}
	
	public void printArticle(Article aa) {
		System.out.println("번호 : " + aa.getId());
		System.out.println("제목 : " + aa.getTitle());
		System.out.println("내용 : " + aa.getBody());
		System.out.println("등록날짜 : " + aa.getRegDate());
		System.out.println("조회수 : " + aa.getHit());
		System.out.println("작성자 : " + aa.getWriter());
		System.out.println("======================");
		System.out.println("---------댓글---------");
		
		ArrayList<Reply> ReplyList = articleDao.getReplyList();
		for (int i = 0; i < ReplyList.size(); i++) {
			Reply re = ReplyList.get(i);
			if (re.getParentId() == aa.getId()) {
				System.out.println("내용 : " + re.getBody());
			}
		}
	}

	public void addArticle() {
		System.out.print("게시물 제목을 입력해주세요: ");
		String title = sc.nextLine();
		System.out.print("게시물 내용을 입력해주세요: ");
		String body = sc.nextLine();
		System.out.println("게시물 등록이 완료되었습니다.");
		Article 게시물1 = new Article(title, body, 0, "익명");

		articleDao.addArticle(게시물1);
	}

	public void printArticleList() {

		ArrayList<Article> ArticleList = articleDao.getArticleList();
		for (int i = 0; i < ArticleList.size(); i++) {
			Article aa = ArticleList.get(i);
			System.out.println(" 번호 : " + aa.getId());
			System.out.println(" 제목 : " + aa.getTitle());
			System.out.println(" 등록날짜 : " + aa.getRegDate());
			System.out.println(" 조회수 : " + aa.getHit());
			System.out.println(" 작성자 : " + aa.getWriter());
			// aa.setId(i + 1);
		}
		System.out.println("================");
	}
}
