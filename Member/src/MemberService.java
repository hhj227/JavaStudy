
public class MemberService {

	public boolean login(String id, String pw) {
		if(id=="hong" && pw=="12345") {
			return true;
		}else {
			return false;
		}
	}

	public void logout(String string) {
		System.out.println("로그아웃 되었습니다.");
	}

}
