package Jv1108;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test {
	static ArrayList<게시물> ArticleList = new ArrayList<>();
	
	public static int getArticleIndexById(int aid) {
		int existFlag = 1;
		int index = -1; // 없
		for(int i = 0; i < ArticleList.size(); i++) {
  		  게시물 bb = ArticleList.get(i);
  		  if(aid == bb.getId()) {
  			  existFlag = 2;
  			  index = 1;
  		  }
	   }
		return index;
	}
	
	public static void main(String[] args){
//		Date today = new Date ();
//		System.out.println(today);
		
		Calendar cal = Calendar.getInstance();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy / MM / dd / HH:mm:ss");
		
		Scanner sc = new Scanner(System.in);
	    int id = 4;
	    
		게시물 게시물a = new 게시물(1,"제목1","내용1");
		게시물 게시물b = new 게시물(2,"제목2","내용2");
		게시물 게시물c = new 게시물(3,"제목3","내용3");
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
				String regDate;
				regDate = sdf.format(cal.getTime());
				System.out.println(regDate);
				System.out.print("게시물 제목을 입력해주세요: ");
				String title = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요: ");
				String body = sc.nextLine();
				System.out.println("게시물 등록이 완료되었습니다.");
	            
	            게시물 게시물1 = new 게시물(id,regDate,title,body);
				ArticleList.add(게시물1);
				System.out.printf("%d번글이 생성되었습니다.\n", id);
				id++;
			}
			
			if(cmd.equals("list")) {
				for(int i = 0; i < ArticleList.size(); i++) {
			        게시물 aa = ArticleList.get(i);
			        aa.setId(i + 1);
			        aa.호명();
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
	    		   게시물 게시물2 = new 게시물(targetId,title,body);
	    		   
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
	      if(cmd.equals("read")) {
	    	  System.out.print("읽을 게시물 번호: ");
	    	  String aid = sc.nextLine(); 
	    	  int targetId = Integer.parseInt(aid);
	    	  int index = getArticleIndexById(targetId);
	    	  if(index == -1) {
	    		  System.out.println("없는 게시물 입니다.");
	    	  } else {
	    		  게시물 aa = ArticleList.get(targetId-1);
	    		  aa.내용보기();
	    		  aa.increaseHit();
	    		  System.out.println(aa.regDate);
	    		 
	    	     }	    	  
	      }
	      
	   }
   }
}

	
class 게시물 {
		  private String title;
		  private String body;
		  private int id;
		  String writer = "익명";
		  String regDate;
		  int hit;
		  
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
		public 게시물(int id, String title, String body) {
			  this.id = id;
			  this.title = title;
			  this.body = body;
		  }
		public 게시물(int id, String regDate, String title, String body) {
			this.id = id;
			this.regDate = regDate;
			this.title = title;
			this.body = body;
			this.hit = 1;
		}
		public void 호명(){
		    System.out.println(" 번호 : " + id);
		    System.out.println(" 제목 : " + title);
//		    System.out.println(" 내용 : " + body);
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
		
		  public void increaseHit(){
			  hit = 1;
			  hit++;
		  }
		  
}