package workshop2.model;

import java.util.ArrayList;

import workshop2.controller.FileHandler;
import workshop2.debug.ErrorHandler;

public class ModelHandler {
	private ArrayList<Member> members;
	
	private ErrorHandler error_Handler;
	private FileHandler file_Handler;

	public ModelHandler() throws Exception {
		error_Handler = new ErrorHandler();
		file_Handler = new FileHandler("./Registry/database.dat");
		initialize();
	}
	
	private void initialize() throws Exception {
		if (file_Handler.exists()) {
			members = (ArrayList<Member>) file_Handler.read();
		} else {
			members = new ArrayList<Member>(); // TODO: Remove <Member>
			m_save();
		}
	}

	public void m_save() throws Exception {
		file_Handler.save(members);
	}
	
	public void m_add(String name, String socialSecurityNumber) {
        Member newMember = new Member(getNextID(), name, socialSecurityNumber);
        members.add(newMember);
	}
	
	public Member m_get(int id) {
		for (Member member : members) {
			if (member.getId() == id) {
				return member;
			}
		}
		error_Handler.MemberNotFound();
		return null; // Will never return null!
	}

	public Member[] m_getAll() {
		Member[] allMembers = new Member[members.size()];

		return members.toArray(allMembers);
	}

	public void m_remove(int id) {
		Member member = m_get(id);
		members.remove(member);
	}

	private int getNextID() {
		int maxId = members.stream().mapToInt(Member::getId).max().orElse(0);
		return maxId + 1;
	}
}
