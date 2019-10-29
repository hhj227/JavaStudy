import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		
		Scanner scanner = new Scanner(System.in);
		while(run) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택> ");
			
			int choice = scanner.nextInt();
			
			if(choice==1) {
				createAccount();
			}
			else if(choice==2) {
				accountList();
			}
			else if(choice==3) {
				deposit();
			}
			else if(choice==4) {
				withdraw();
			}
			else if(choice==5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void withdraw() {
		System.out.println("------------");
		System.out.println("출금");
		System.out.println("------------");
		System.out.print("계좌번호: ");
		String ano = scanner.next();
		Account account = findAccount(ano);
		if(account==null) {
			System.out.println("해당하는 계좌가 없습니다.");
			return;
		}
		System.out.print("출금액: ");
		account.setBalance(account.getBalance()-scanner.nextInt());
		System.out.println("결과: 출금이 성공되었습니다.");
	}

	private static void deposit() {
		System.out.println("------------");
		System.out.println("예금");
		System.out.println("------------");
		System.out.print("계좌번호: ");
		String ano = scanner.next();
		Account account = findAccount(ano);
		if(account==null) {
			System.out.println("해당하는 계좌가 없습니다.");
			return;
		}
		System.out.print("예금액: ");
		account.setBalance(account.getBalance()+scanner.nextInt());
		System.out.println("결과: 예금이 성공되었습니다.");
	}

	private static void accountList() {
		System.out.println("------------");
		System.out.println("계좌목록");
		System.out.println("------------");
		for(int i=0;i<accountArray.length;i++) {
			Account account = accountArray[i];
			if(account!=null)
				System.out.println(account.getAno()+"	"+account.getOwner()+"	"+account.getBalance());
		}
	}

	private static void createAccount() {
		System.out.println("------------");
		System.out.println("계좌생성");
		System.out.println("------------");
		System.out.print("계좌번호: ");
		String ano = scanner.next();
		System.out.print("계좌주: ");
		String name = scanner.next();
		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();
		
		Account account = new Account(ano, name, balance);
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i]==null) {
				accountArray[i] = account;
				System.out.println("결과: 계좌가 생성되었습니다.");
				return;
			}
		}
	}
	
	private static Account findAccount(String ano) {
		Account account = null;
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i]!=null) {
				String dbAno = accountArray[i].getAno();
				if(dbAno.equals(ano)) {
					account = accountArray[i];
					break;
				}
			}
		}
		return account;
	}
}
