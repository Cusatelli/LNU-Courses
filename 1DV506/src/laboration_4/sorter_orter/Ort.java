package laboration_4.sorter_orter;

public class Ort implements Comparable<Ort> {

	int postcode;
	String city;
	
	public Ort(int postcode, String city) {
		this.postcode = postcode;
		this.city = city;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return " " + postcode + " " + city;
	}

	@Override
	public int compareTo(Ort ort) {
		return postcode - ort.getPostcode();
	}
}