package workshop2.model;

import java.util.ArrayList;

public class Id {
	private int id;

	/**
	 * Get next id in ArrayList.<br>
	 * Example: if last id = 274 set new id to 275.
	 * 
	 * @author cusatelli
	 * @category Member
	 */
	public Id(ArrayList<Member> members) {
		this.id = members.stream().mapToInt(Member::getId).max().orElse(0) + 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
