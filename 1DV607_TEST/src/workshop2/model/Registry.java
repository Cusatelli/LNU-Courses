package workshop2.model;

import java.util.ArrayList;

import workshop2.debug.MemberNotFound;
import workshop2.registry.FileHandler;

public class Registry {
    private ArrayList<Member> members;
    private FileHandler file_Handler = new FileHandler("Database");

    public Registry() throws Exception {
        initializeList();
    }
    
    private void initializeList() throws Exception {
        if (file_Handler.containsReadableFile()) {
            members = (ArrayList<Member>) file_Handler.readFromFile();
        } else {
            members = new ArrayList<>();
            file_Handler.writeToFile(members);
        }
    }

    public void saveDataToRegistry() throws Exception {
        file_Handler.writeToFile(members);
    }

    public void registerMember(String name, String socialSecurityNumber) {
        Member member = new Member(name, socialSecurityNumber, getNext());
        members.add(member);
    }

    public Member getMember(int id) throws MemberNotFound {
    	for (Member member : members) {
    		if (member.getId() == id) { return member; }
    	}
        throw new MemberNotFound();
    }

    public Member[] getAllMembers() {
        Member[] allMembers = new Member[members.size()];

        return members.toArray(allMembers);
    }

    public void removeMember(int id) throws MemberNotFound {
        Member member = getMember(id);
        members.remove(member);
    }

    private int getNext() {
        int maxValue = members.stream().mapToInt(Member::getId).max().orElse(0);
        return maxValue + 1;
    }
}
