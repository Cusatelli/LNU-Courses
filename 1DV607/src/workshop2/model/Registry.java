package workshop2.model;

import java.util.ArrayList;

import workshop2.controller.FileHandler;

public class Registry {
	private ArrayList<Member> members;
	private FileHandler fileHandler;
	
	public Registry() {
		fileHandler = new FileHandler("./registry/database.dat");
		initialize();
	}
	
	@SuppressWarnings("unchecked")
	private void initialize() {
		if(fileHandler.containsFile()) {
			members = (ArrayList<Member>) fileHandler.readFromFile();
			
		} else {
			members = new ArrayList<>();
			fileHandler.writeToFile(members);
		}
	}
	
	public void sendToFileHandler() {
		fileHandler.writeToFile(members);
	}
	
	public void m_register(int id, String name, String socialSecurityNumber) {
		Member member = new Member(id, name, socialSecurityNumber);
		members.add(member);
	}
	
	public Member m_get(int ID) {
		for(Member member : members) {
			if(member.getID() == ID) { return member; }
		}
		return null;
	}
	
	public Member[] m_getAll() {
		Member[] members = new Member[this.members.size()];
		return this.members.toArray(members);
	}
	
	public void m_delete(int ID) {
		Member member = m_get(ID);
		members.remove(member);
	}
	
	private int m_getNext() {
		int max_Value = members.stream().mapToInt(Member::getID).max().orElse(0);
		return max_Value + 1;
	}
}
