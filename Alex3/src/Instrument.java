
public class Instrument {
	public String name;
	private String family;
	public Instrument(String name) {
		this.name=name;
		this.family = family;
	}
	public String getName() {
		return name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
}
