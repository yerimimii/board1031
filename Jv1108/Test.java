package Jv1108;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {
	static ArrayList<게시물> ArticleList = new ArrayList<>();
	static ArrayList<Reply> ReplyList = new ArrayList<>();
	
	public static void printArticle (게시물 aa){
		System.out.println("번호 : " + aa.getId());
		System.out.println("제목 : " + aa.getTitle());
	    System.out.println("내용 : " + aa.getBody());
	    System.out.println("등록날짜 : " + aa.getRegDate());
	    System.out.println("조회수 : " + aa.getHit());
	    System.out.println("작성자 : " + aa.getWriter());
	    System.out.println("======================");
	}
	public static int getArticleIndexById(int aid) {
		int existFlag = 1;
		int index = -1; // 없
		for(int i = 0; i < ArticleList.size(); i++) {
  		  게시물 bb = ArticleList.get(i);
  		  if(aid == bb.getId()) {
  			  existFlag = 2;
  			  index = i;
  		  }
	   }
		return index;
	}
	
	public static void main(String[] args){
//		Date today = new Date ();
//		System.out.println(today);
		
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy.MM.dd");
		Date time = new Date();		
		String time1 = format1.format(time);
		
		Scanner sc = new Scanner(System.in);
	    int id = 4;
	    
		게시물 게시물a = new 게시물(1,"안녕하세요","반갑습니다.",time1);
		게시물 게시물b = new 게시물(2,"제목2","내용2",time1);
		게시물 게시물c = new 게시물(3,"제목3","내용3",time1);
		ArticleList.add(게시물a);
		ArticleList.add(게시물b);
		ArticleList.add(게시물c);
		
		
		while(true) {
			System.out.print("명령어를 입력해주세요: ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("exit")) {
				break;
			}

			if(cmd.equals("add")) {
				System.out.print("게시물 제목을 입력해주세요: ");
				String title = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요: ");
				String body = sc.nextLine();
				System.out.println("게시물 등록이 완료되었습니다.");
	            
	            //게시물 게시물1 = new 게시물(id,title,body,time1);
	            게시물 게시물1 = new 게시물(id,title,body,time1,0,"익명");
				ArticleList.add(게시물1);
				System.out.printf("%d번글이 생성되었습니다.\n", id);
				id++;
			}
			
			if(cmd.equals("list")) {
				for(int i = 0; i < ArticleList.size(); i++) {
			        게시물 aa = ArticleList.get(i);
				    System.out.println(" 번호 : " + aa.getId());
				    System.out.println(" 제목 : " + aa.getTitle());
				    System.out.println(" 등록날짜 : " + aa.getRegDate());
				    System.out.println(" 조회수 : " + aa.getHit());
				    System.out.println(" 작성자 : " + aa.getWriter());
			        //aa.setId(i + 1);
			      }
				System.out.println("================");
			}
		
	      if(cmd.equals("update")) {
	    	  System.out.print("수정할 게시물 번호: ");
	    	  String aid = sc.nextLine();
	    	  int targetId = Integer.parseInt(aid);
	    	  int index = getArticleIndexById(targetId);
	    	 
	    	  if(index == -1) {
	    		  System.out.println("없는 게시물 입니다.");
	    	  } else {
	    		   System.out.print("새로운 제목을 입력해주세요: ");
	    		   String title = sc.nextLine();
	    		   System.out.print("새로운 내용을 입력해주세요: ");
	    		   String body = sc.nextLine();
	    		   System.out.printf("%d번째 게시물 수정이 완료되었습니다.", targetId);
	    		   System.out.println();
	    		   
	    		   게시물 게시물2 = new 게시물(targetId,title,body,time1);
	    		   
	    		   ArticleList.set(index,게시물2);
	    	     }
	         }
	      
	      if(cmd.equals("delete")) {
	    	  System.out.print("삭제할 게시물 번호: ");
	    	  String aid = sc.nextLine(); 
	    	  int targetId = Integer.parseInt(aid);
	    	  int index = getArticleIndexById(targetId);
	    	  
	    	  if(index == -1) {
	    		  System.out.println("없는 게시물 입니다.");
	    	  } else {
	    		  ArticleList.remove(index);
    			  System.out.println("게시물 삭제가 완료되었습니다.");
	    	     }
	      }

	      //수정필요//
	      if(cmd.equals("read")) {
	    	  System.out.print("읽을 게시물 번호: ");
	    	  String aid = sc.nextLine(); 
	    	  int targetId = Integer.parseInt(aid);
	    	  int index = getArticleIndexById(targetId);
	    	  if(index == -1) {
	    		  System.out.println("없는 게시물 입니다.");
	    	  } else {
	    		  게시물 aa = ArticleList.get(index);
	    		  int targetHit = aa.getHit();
	    		  aa.setHit(targetHit + 1);
	    		  printArticle(aa);
	    		  while(true) {
	    			  System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3.수정, 4. 삭제, 5. 목록으로) ");
	    			  int rCmdNo = Integer.parseInt(sc.nextLine());
	    			  
	    			  if (rCmdNo == 1) {
	    				  System.out.print("댓글 내용을 입력해주세요 : ");
	    				  //sc.nextLine()
	    			  }
	    				

	    			  if (rCmdNo == 2) {
	    				  
	    			  }

	    			  if (rCmdNo == 3) {
	    				  
	    			  }

	    			  if (rCmdNo == 4) {
	    				  
	    			  }

	    			  if (rCmdNo == 5) {
	    				  break;
	    			  }
	    		  }
	    		  
	    	   }	    	  
	      }
	      if(cmd.equals("search")) {
	    	  System.out.print("검색 항목을 입력해주세요 (1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자) ");
	    	  int searchTarget = Integer.parseInt(sc.nextLine());
	    	  
	    	  System.out.print("검색 키워드를 입력해주세요 :" );
	    	  String keyword = sc.nextLine();
	    	  
	    	  for(int i = 0; i < ArticleList.size(); i++) {
			        게시물 aa = ArticleList.get(i);
			        String targetStr = aa.getTitle();
			        targetStr = " ";
			        if(searchTarget == 1) {
			        	
			        } else if (searchTarget == 2) {
			        	
			        } else if (searchTarget == 3) {
			        	
			        } else {
			        	
			        }
			        
			        
			        if(targetStr.contains(keyword)) {
			        	System.out.println(" 번호 : " + aa.getId());
					    System.out.println(" 제목 : " + aa.getTitle());
					    System.out.println(" 등록날짜 : " + aa.getRegDate());
					    System.out.println(" 조회수 : " + aa.getHit());
					    System.out.println(" 작성자 : " + aa.getWriter());
			        }
	        }
	      
	   }
   }
}

	
static class 게시물 {
		  private String title;
		  private String body;
		  private int id;
		  private String writer = "익명";
		  private int hit; 
		  private String regDate;
		  
		  public 게시물(int id, String title, String body, String regDate) {
			  this.id = id;
			  this.title = title;
			  this.body = body;
			  this.regDate = regDate;
		  }
		  public 게시물(int id, String title, String body, String regDate, int hit, String writer) {
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

		public void 호명(){
		    System.out.println(" 번호 : " + id);
		    System.out.println(" 제목 : " + title);
		    System.out.println(" 등록날짜 : " + regDate);
		    System.out.println(" 조회수 : " + hit);
		    System.out.println(" 작성자 : " + writer);
		    
		  }
		
		  public void 내용보기() {
			  System.out.println("=======" + id + "번째 게시물 =======");
			  System.out.println(" 번호 : " + id);
			  System.out.println(" 날짜 : " + regDate);
			  System.out.println(" 제목 : " + title);
			  System.out.println(" 내용 : " + body);
			  System.out.println(" 조회수 : " + hit);
			  System.out.println("===========================");
		  }
		
		  }


}
		  
