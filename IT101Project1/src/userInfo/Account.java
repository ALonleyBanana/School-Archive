package userInfo;

import java.util.ArrayList;
import java.util.Date;

public class Account {

	private String FName;
	private String LName;
	private int AccNum;
	private double[] Tran;
	private String[] Summ;
	private int numTrans;
	private String AccType;
	private double bal;
	public String getAccInfo() {
		return ("Account Number: " + AccNum + "\n");
	}
	public String getTranInfo(int n) {
		String tran = Summ[n];
		return tran;
	}
	public Account(String AFName, String ALName, double Abal, int aAccNum, String AccType) {
		FName = AFName;
		LName = ALName;
		AccNum = aAccNum;
		bal = Abal;
		Tran = new double[100];
		Summ = new String[100];
		Tran[0]=bal;
		Date date = new Date();
		Summ[0]=("$" + Double.toString(bal) + " was Deposited on " + date.toString());
		numTrans = 1;
	}
	public int getAccNum() {
		return AccNum;
	}
	public int getnumTrans() {
		return numTrans;
	}
	public void deposit(double amnt) {
		if(amnt<=0) {
			System.out.println("Input a positive non 0 balance.");
		}
		else {
			bal = bal+amnt;
			Tran[numTrans] = amnt;
			Date date = new Date();
			Summ[numTrans] = ("$" + Double.toString(amnt) + " deposited on " + date.toString());
			numTrans++;
			System.out.println("Successful Deposit");
		}
		
	}
	public void widthdraw(double amnt) {
		if(amnt<=0) {
			System.out.println("Input a positive non 0 balance.");
		}
		else {
			if(bal<amnt) {
				System.out.println("Insufficent Balance");
				
			}
			else {
				bal = bal - amnt;
				Tran[numTrans] = amnt;
				Date date = new Date();
				Summ[numTrans] = ("$" + Double.toString(amnt) + " Widthdrew on " + date.toString());
				numTrans++;
				System.out.println("Successful Widthdraw");
			}
		}
	}
	public double getBal() {
		return bal;
	}
	public String getName() {
		String name = (FName + " " + LName);
		return name;
	}
	
}