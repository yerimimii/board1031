package Main;
import java.util.ArrayList;
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
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어를 입력해주세요: ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("exit")) {
				break;
			}

			if(cmd.equals("add")) {
				int id = 1;
				System.out.print("게시물 제목을 입력해주세요: ");
				String title = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요: ");
				String body = sc.nextLine();
				System.out.println("게시물 등록이 완료되었습니다.");
	            게시물 게시물1 = new 게시물(id,title,body);
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
	   }
   }
}

	
class 게시물 {
		  private String title;
		  private String body;
		  private int id;
		  
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
		public 게시물 (int id, String title, String body) {
			  this.id = id;
			  this.title = title;
			  this.body = body;
		  }
		  void 호명(){
		    System.out.println(" 번호 : " + id);
		    System.out.println(" 제목 : " + title);
		    System.out.println(" 내용 : " + body);
		  }

}