package Jv1108;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	ArrayList<Member> MemberList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	Member loginedMember = null;
	public Member getLoginedMember() {
		return this.loginedMember;
	}
	
	public void doCommand(String cmd) {
		if (cmd.equals("signup")) {
			memberSignUp();
		}

		if (cmd.equals("signin")) {
			memberSignIn();
		}
	}
	
	public void memberSignIn() {
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
	public void memberSignUp() {
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
	//??
	public Member getloginedMember() {
		return loginedMember;
	}
	
	

}
