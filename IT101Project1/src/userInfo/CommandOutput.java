package userInfo;
//Imports
import java.util.Scanner;
import java.util.ArrayList;
//Main Class
public class CommandOutput {
	public static void main(String args[] ) {
		AdminMode a = new AdminMode();
		int kill = 0;
		Scanner num = new Scanner(System.in);
		while(kill == 0) {
		System.out.println("Enter Account Number: ");
		String anum = num.nextLine();
		int bnum = Integer.parseInt(anum);
		if(bnum == 0) {
			Scanner admin = new Scanner(System.in);
			System.out.println("Search for an account by number (1) or show all accounts (2): ");
			String cmd = admin.nextLine();
			int cmdn = Integer.parseInt(cmd);
			if(cmdn== 1) {
				Scanner check = new Scanner(System.in);
				System.out.println("Enter Account Number: ");
				String next = check.nextLine();
				int cn = Integer.parseInt(next);
				a.Search(cn);
				if(a.Search(cn)==false) {
					Scanner YN = new Scanner(System.in);
					System.out.println("Account Does not exist would you like to make one? (Y/N)");
					String YesNo = YN.nextLine();
					if(YesNo != "N") {
						Scanner FN = new Scanner(System.in);
						System.out.println("Enter First Name: ");
						String First = FN.nextLine();
						Scanner LN = new Scanner(System.in);
						System.out.println("Enter Last Name: ");
						String Last = LN.nextLine();
						Scanner AT = new Scanner(System.in);
						System.out.println("Enter Type of account (Checking or Savings): ");
						String Type = AT.nextLine();
						Scanner SB = new Scanner(System.in);
						System.out.println("Enter Initial Balance: ");
						double Start = SB.nextDouble();
						a.newAcc(First, Last, Start, cn, Type);
						System.out.println("Account Created");
						
					}
					else {
						System.out.println("GoodBye");
						kill = 1;
					}
					
				}
				
			}
			else {
				if(cmdn == 2) {
					a.getAll();
					kill =1;
				}
				else {
					System.out.println("Bye");
					kill = 1;
				}
			}
			
			
			}
		else {
			
			if(a.Search(bnum)) {
				Scanner choice = new Scanner(System.in);
				System.out.println("Enter 1-4 (1) Deposit (2) Widthdraw (3) Balance Inquirey (4) Exit");
				int c = choice.nextInt();
				//while(c != 4) {
				switch(c) {
				case 1:
					Account p = a.getAcc(bnum);
					if (p.getName() == "No Account") {
						System.out.println("No account found.");
					}
					else {
						Scanner AmntD = new Scanner(System.in);
						System.out.println("Amount to deposit in USD ");
						Double amnt = AmntD.nextDouble();
						p.deposit(amnt);
					}
				case 2:
					Account p2 = a.getAcc(bnum);
					if (p2.getName() == "No Account") {
						System.out.println("No account found.");
					}
					else {
						Scanner AmntD = new Scanner(System.in);
						System.out.println("Amount to Widthdraw in USD ");
						Double amnt = AmntD.nextDouble();
						p2.widthdraw(amnt);
					}
				case 3:
					Account p3 = a.getAcc(bnum);
					if (p3.getName() == "No Account") {
						System.out.println("No account found.");
					}
					else {
						p3.getBal();
					}
				case 4:
					kill = 1;
				}
			}
			}
		System.out.println("Try entering setup (0) mode");
		}
		//}
	}
}

