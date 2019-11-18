package workshop2.model;

import java.util.ArrayList;

import workshop2.debug.MemberNotFound;
import workshop2.registry.FileHandler;

public class Registry {
	private Id id;
	private ArrayList<Member> members;
	private FileHandler file_Handler = new FileHandler("Database");

	public Registry() throws Exception {
		initialize();
	}
	
	/**
	 * If the File Handler has a readable & writable file attached to it:<br>
	 * Initialize the ArrayList with all Member Data currently present in database!<br>
	 * If no file present create a new writable file.
	 * 
	 * @throws Exception
     * @version 2.0
	 * @author cusatelli
	 * @category Registry & Member
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws Exception {
		if (file_Handler.containsReadableFile()) {
			members = (ArrayList<Member>) file_Handler.readFromFile();
		} else {
			members = new ArrayList<>();
			file_Handler.writeToFile(members);
		}
	}
	
	/**
	 * Send all Members in ArrayList to FileHandler to be written to File.
	 * 
	 * @throws Exception
     * @version 2.0
	 * @author cusatelli
	 * @category Registry & Member
	 */
	public void saveDataToRegistry() throws Exception {
		file_Handler.writeToFile(members);
	}
	
	/**
	 * Add Member to ArrayList.
	 * 
	 * @param
     * @version 2.0
	 * @author cusatelli
	 * @category Member
	 */
	public void m_register(String name, String socialSecurityNumber) {
		id = new Id(members);
		Member member = new Member(name, socialSecurityNumber, id.getId());
		members.add(member);
	}

	/**
	 * Get Member from ArrayList.
	 * 
	 * @param
	 * @throws MemberNotFound
     * @version 2.0
	 * @author cusatelli
	 * @category Member
	 */
	public Member m_get(int id) throws MemberNotFound {
		for (Member member : members) {
			if (member.getId() == id) { return member; }
		}
		throw new MemberNotFound("Member Not Found!");
	}

	/**
	 * Get All Members from ArrayList.
	 * 
     * @version 2.0
	 * @author cusatelli
	 * @category Member
	 */
	public Member[] m_getAll() {
		Member[] allMembers = new Member[members.size()];
		return members.toArray(allMembers);
	}

	/**
	 * Remove Member from ArrayList.
	 * 
	 * @param
	 * @throws MemberNotFound
     * @version 2.0
	 * @author cusatelli
	 * @category Member
	 */
	public void m_remove(int id) throws MemberNotFound {
		Member member = m_get(id);
		members.remove(member);
	}

}
