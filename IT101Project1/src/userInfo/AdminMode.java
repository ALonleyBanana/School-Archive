package userInfo;

import java.util.Scanner;

public class AdminMode {
	private Account[] accounts;
	private int amntAcc;
	public AdminMode() {
		accounts = new Account[20];
		amntAcc = 0;
	}
	public Account newAcc(String FName, String LName, Double bal, int accNum, String AccType) {
		Account acc = new Account(FName,LName,bal,accNum,AccType);
		accounts[amntAcc]=acc;
		amntAcc++;
		return acc;
	}
	public boolean Search(int AccNum) {
		for(int i = 0; i<amntAcc; i++) {
			int a = accounts[i].getAccNum();
			if (AccNum == a) {
				System.out.println(accounts[i].getAccInfo());
				System.out.println("Transactions: ");
				for(int j = 0; j<accounts[i].getnumTrans();j++) {
					System.out.println(accounts[i].getName() + ": " + accounts[i].getTranInfo(j));
				}
				return true;
			}
			
			
		}
		return false;
	}
	public Account getAcc(int AccNum) {
		for(int i = 0; i<amntAcc; i++) {
			int a = accounts[i].getAccNum();
			if (AccNum == a) {
				System.out.println(accounts[i].getAccInfo());
				return accounts[i];
			}
			else {
				System.out.println("No account");
			}
		}
		return new Account("No","Account",0,0,"NULL");
	}
	public void getAll() {
		for (int i=0; i<amntAcc; i++) {
			System.out.println(accounts[i].getAccInfo());
			System.out.println("Transactions: ");
			for(int j = 0; j<accounts[i].getnumTrans();j++) {
				System.out.println(accounts[i].getName() + ": " + accounts[i].getTranInfo(j));
			}
		}
	}
}
