
public class Wind extends Instrument
{
	String family;
	boolean w;
	public Wind(String name, String family, boolean w) {
		super(name);
		this.family=family;
		this.w=w;
	}
	
	public String toString() {
		String e = (name + " " + family + " " + w );
		return e;
	}
 
}
