package workshop2.model;

import java.io.Serializable;
import java.util.ArrayList;

import workshop2.debug.BoatNotFound;

public class Member implements Serializable {
	// Generated serialVersionUID:
	private static final long serialVersionUID = 765191115952174300L;
	
	private String name;
	private String socialSecurityNumber;
	private int id;
	private ArrayList<Boat> b_arrayList = new ArrayList<>();

	Member(String name, String socialSecurityNumber, int id) {
		this.name = name;
		this.socialSecurityNumber = socialSecurityNumber;
		this.id = id;
	}

    public String getName() { return name; }
    public void setName(String newName) { name = newName; }

    public String getSocialSecurityNumber () { return socialSecurityNumber; }
    public void setSocialSecurityNumber(String socialSecurityNumber) { this.socialSecurityNumber = socialSecurityNumber; }

    public int getId () { return id; }

    public int b_getListSize() { return b_arrayList.size(); }

    public Boat b_get(int position) throws BoatNotFound {
        b_hasBoat(position);
        return b_arrayList.get(position);
    }

    public Boat[] b_getAll() {
        Boat[] b_array = new Boat[b_arrayList.size()];
        return b_arrayList.toArray(b_array);
    }

    public void b_register(Boat.TYPE type, double length) {
        Boat boat = new Boat(type, length);
        b_arrayList.add(boat);
    }

    public void b_remove(int position) throws BoatNotFound {
        b_hasBoat(position);
        b_arrayList.remove(position);
    }

    private void b_hasBoat(int position) throws BoatNotFound {
        if (b_arrayList.size() <= position) {
            throw new BoatNotFound("Boat Not Found!");
        }
    }
}
