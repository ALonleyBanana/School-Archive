
public class Strings extends Instrument
{
	public boolean s;
	public Strings(String name, boolean s) {
		super(name);
		this.s=s;
	}
	public String toString() {
		String e = (name + " " + s);
		return e;
	}
    
       
}