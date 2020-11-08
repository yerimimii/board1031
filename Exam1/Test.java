//package Exam1;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Test {
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		
//		int n = 1;
//		int id = 1;
//		ArrayList<게시물> list = new ArrayList();
//
//		while(true) {
//			System.out.print("명령어를 입력해주세요: ");
//			String cmd = sc.nextLine();
//			
//			if(cmd.equals("exit")) {
//				break;
//			}
//			if(cmd.equals("add")) {
//				//ArrayList<게시물> list = new ArrayList(); 
//				게시물 게시물n = new 게시물();
//				System.out.print("게시물 제목을 입력해주세요: ");
//				게시물n.title = sc.nextLine();
//				System.out.print("게시물 내용을 입력해주세요: ");
//				게시물n.body = sc.nextLine();
//				System.out.println("게시물 등록이 완료되었습니다.");
//	            list.add(게시물n);
//				n++;
//				id++;
//			}
//			
//			if(cmd.equals("list")) {
//				for(int i = 0; i < list.size(); i++) {
//			        게시물 aa = list.get(i);
//			        aa.id = i;
//			        aa.호명();
//			      }
//							System.out.println("================");
//						}
//		
//	      if(cmd.equals("update")) {
//	    	  System.out.print("수정할 게시물 번호: ");
//	    	  String num = sc.nextLine();
//	    	  int a = Integer.parseInt(num);
//	    	  for(int i = 0; i < list.size(); i++) {
//	    		  게시물 aa = list.get(i);
//	    		  if(a == aa.id) {
//	    			  System.out.print("새로운 제목을 입력해주세요: ");
//	    			  
//	    			    // for(int i = 0; i < list.size(); i++){
//	    			    //    사람 aa = list.get(i);
//	    			    //    if(aa.get이름().equals("황진이")){
//	    			    //     aa.set이름("황진희");
//	    			    //     aa.호명();
//	    			    //    }
//	    		  }
//	    	  }
//	    	  
//			
//		}
//	   }
//
//   }
//}
//
//	
//class 게시물 {
//		  String title;
//		  String body;
//		  int id;
//		  void 호명(){
//		    System.out.println(" 번호 : " + id);
//		    System.out.println(" 제목 : " + title);
//		  }
//		  
//		  public void set_title(String title) {
//		 		this.title = title;
//		 	}
//
//}