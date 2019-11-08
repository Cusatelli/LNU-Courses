package assignment_3.norseGods;

/*
 * Program start: ArrayList of gods name. (Minimum 8 gods).
 * 
 * Information stored: Race, (Aesir, Vanir, Giant or Other).
 * Description of the god or being (copy from wikipedia).
 * 
 */

public interface GodsInterface {	
	public void NorseGod();
	public void NorseGod(String name, String race, String desc);
	
	public String getName();
	public void setName(String name);
	
	public String getRace();
	public void setRace(String race);
	
	public String getDesc();
	public void setDesc(String desc);
}