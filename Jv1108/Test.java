package Jv1108;

import java.util.ArrayList;
import java.util.Scanner;
import Jv1108.Article;

//ctrl + shift + f = 줄정리

public class Test {
//	ArticleController ac = new ArticleController();
//	MemberController mc = new MemberController();
	static ArrayList<Member> MemberList = new ArrayList<>();
	static ArticleDao articleDao = new ArticleDao();
	
	public void start() {
		
	}
	public static void printArticle(Article aa) {
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member loginedMember = null;

		while (true) {
			if (loginedMember == null) {
				System.out.print("명령어를 입력해주세요:");
			} else {
				System.out.print(
						"명령어를 입력해주세요[" + loginedMember.getMemberId() + "(" + loginedMember.getMemberName() + ")] :");
			}
			
			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}

			if (cmd.equals("add")) {
				System.out.print("게시물 제목을 입력해주세요: ");
				String title = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요: ");
				String body = sc.nextLine();
				System.out.println("게시물 등록이 완료되었습니다.");
				Article 게시물1 = new Article(title, body, 0, "익명");

				articleDao.addArticle(게시물1);
			}

			if (cmd.equals("list")) {
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

			if (cmd.equals("update")) {
				System.out.print("수정할 게시물 번호: ");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
//	    	  int index = getArticleIndexById(targetId);
//	    	  if(index == -1) {
//	    		  System.out.println("없는 게시물 입니다.");
//	    	  } else {
//	    		   System.out.print("새로운 제목을 입력해주세요: ");
//	    		   String title = sc.nextLine();
//	    		   System.out.print("새로운 내용을 입력해주세요: ");
//	    		   String body = sc.nextLine();
//	    		   System.out.printf("%d번째 게시물 수정이 완료되었습니다.", targetId);
//	    		   System.out.println();
//	    		   Article 게시물2 = new Article(targetId,title,body,time1);
//	    		   
//	    		   ArticleList.set(index,게시물2);

				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();

				boolean rst = articleDao.updateArticle(targetId, title, body);

				if (!rst) {
					System.out.println("없는 게시물 번호입니다.");
				}

			}

			if (cmd.equals("delete")) {
				System.out.print("삭제할 게시물 번호: ");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
//	    	  int index = getArticleIndexById(targetId);
//	    	  
//	    	  if(index == -1) {
//	    		  System.out.println("없는 게시물 입니다.");
//	    	  } else {
//	    		  ArticleList.remove(index);
//    			  System.out.println("게시물 삭제가 완료되었습니다.");
//	    	     }
				boolean rst = articleDao.deleteArticle(targetId);

				if (!rst) {
					System.out.println("없는 게시물 번호입니다.");
				}
			}

			if (cmd.equals("read")) {
				System.out.print("읽을 게시물 번호: ");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
//	    	  int index = getArticleIndexById(targetId);
//	    	  if(index == -1) {
//	    		  System.out.println("없는 게시물 입니다.");
//	    	  } else {
//	    		  Article aa = ArticleList.get(index);
//	    		  int targetHit = aa.getHit();
//	    		  aa.setHit(targetHit + 1);
//	    		  printArticle(aa);
				Article article = articleDao.getArticleById(targetId);

				if (article == null) {
					System.out.println("없는 게시물입니다.");
				} else {
					int targetHit = article.getHit();
					article.setHit(targetHit + 1);

					printArticle(article);

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
			}

			if (cmd.equals("search")) {
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
			if (cmd.equals("signup")) {
				System.out.println("==== 회원 가입을 진행합니다 ====");
				System.out.print("이름을 입력해 주세요: ");
				String memberName = sc.nextLine();
				System.out.print("아이디를 입력해 주세요: ");
				String memberId = sc.nextLine();
				System.out.print("비밀번호를 입력해 주세요: ");
				String memberPw = sc.nextLine();

				Member member = new Member(memberId, memberPw, memberName);
				MemberList.add(member);
				System.out.println("회원가입이 완료되었습니다.");
			}

			if (cmd.equals("signin")) {
				System.out.println("==== 로그인을 진행합니다 ====");
				System.out.print("아이디: ");
				String memberId = sc.nextLine();
				System.out.print("비밀번호: ");
				String memberPw = sc.nextLine();

				boolean loginFlag = false; // 로그인 성공 여부
				Member aa = null;
				for (int i = 0; i < MemberList.size(); i++) {
					aa = MemberList.get(i);
					if (memberId.equals(aa.getMemberId()) && memberPw.equals(aa.getMemberPw())) {
						loginFlag = true;
						break;
					}
				}
				if (loginFlag) {
					System.out.println(aa.getMemberName() + "님 환영합니다.");
					loginedMember = aa;

				} else {
					System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
				}
			}
//	      if(cmd.equals("help")) {
//	    	  System.out.println("article [add: 게시물 추가 / list : 게시물 목록 조회 / read : 게시물 조회 / search : 검색]");
//	    	  System.out.println("member [signup : 회원가입 / signin : 로그인 / findpass : 비밀번호 찾기 / findid : 아이디 찾기 / logout : 로그아웃 / myinfo : 나의 정보 확인및 수정]");
//	    	  
//	    	  boolean loginFlag = false; //로그인 여부
//	    	  Member aa = null;
//	    	  for(int i = 0; i < MemberList.size(); i++) {
//	    		  aa = MemberList.get(i); 
//	    		  if(memberId.equals(aa.getMemberId()) && memberPw.equals(aa.getMemberPw())) {
//	    			loginFlag = true;
//	    			break;
//	    		    } 
//	    	  
//	    	  while(true) {
//    			  System.out.print("명령어를 입력해주세요: ");
//    			  String hCmd = sc.nextLine();
//    			  
//    			  if (hCmd.equals("article add")) {
//    				  System.out.print("[게시물 추가]");
//    			  }
//    			  if (hCmd.equals("article list")) {
//    				  System.out.println("[게시물 목록 조회]");
//    			  }
//
//    			  if (hCmd.equals("article read")) {
//    				  System.out.println("[게시물 조회]");
//    			  }
//
//    			  if (hCmd.equals("article search")) {
//    				  System.out.println("[검색]");
//    			  }
//
//    			  if (hCmd.equals("member signup")) {
//    				  System.out.println("[회원가입]");
//    			  }
//    			  if (hCmd.equals("member signin")) {
//    				  System.out.println("[로그인]");
//    			  }
//    			  if (hCmd.equals("member findpass")) {
//    				  System.out.println("[비밀번호찾기]");
//    			  }
//    			  if (hCmd.equals("member findid")) {
//    				  System.out.println("[아이디 찾기]");
//    			  }
//    			  if (hCmd.equals("member logout")) {
//    				  System.out.println("[로그아웃]");
//    			  }
//    			  if (hCmd.equals("member myinfo")) {
//    				  System.out.println("[나의 정보 확인및 수정]");
//    			  }
//    			  
//    		  }
//    		  
//    	   }	
//	      }

		}
	}

}
