package userInfo;
import java.util.Date;

public class CollectedData {
	private String TType;
	private String TDate;
	private double TAmount;

	public CollectedData(String TransType, String TransDate, double TransAmount) {
		TransType =this.TType;
		TransDate =this.TDate;
		TransAmount=this.TAmount;
	}
	
	//Creates a string of today
	public String CurrentDate() {
		Date a = new Date();
		String Today = a.toString();
		return Today;
	}
	//Creates an object with today's Date as a timestamp
	public CollectedData CreateCollectedData(String TransType, String TransDate, double TransAmount) {
		String NewDate = CurrentDate();
		return new CollectedData(TransType,NewDate,TransAmount);
	}
	//Get/set TType
	public String getTType() {
		return TType;
	}
	public void setTType(String TransType) {
		this.TType = TransType;
	}
	//Get/set TDate
	public String getTDate() {
		return TDate;
	}
	//Get/set TAmount
	public double getTAmount() {
		return TAmount;
	}
	public void setTAmount(double TransAmount) {
		this.TAmount =TransAmount;
	}
}
