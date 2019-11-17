package workshop2.controller;

import workshop2.model.Boat;
import workshop2.model.Boat.ENUMERATION_BOAT_TYPES;
import workshop2.model.Member;
import workshop2.model.ModelHandler;
import workshop2.view.View;

public class InputHandler extends Controller {
	private View view;
	private ModelHandler model_Handler;
	
	public InputHandler(View view, ModelHandler model_Handler) {
		super(view, model_Handler);
		this.view = view;
		this.model_Handler = model_Handler;
	}

	public boolean check(INPUT_ENUMERATION input_Enumeration) {
		APPLICATION_IS_RUNNING = true;
		
        switch (input_Enumeration) {
            case LIST_COMPACT:
                compactList();
                break;
            case LIST_VERBOSE:
                verboseList();
                break;
            case MEMBER_REGISTER:
                m_registered();
                break;
            case MEMBER_VIEW:
                m_view();
                break;
            case MEMBER_EDIT:
                m_edit();
                break;
            case MEMBER_REMOVE:
                m_remove();
                break;
            case BOAT_REGISTER:
                b_registered();
                break;
            case BOAT_EDIT:
                b_edit();
                break;
            case BOAT_REMOVE:
                b_remove();
                break;
            case EXIT_APPLICATION:
                APPLICATION_IS_RUNNING = false;
                break;
        }
        return APPLICATION_IS_RUNNING;
    }
	
	public void compactList() {
        view.displayMemberListHeader();

        for (Member member : model_Handler.m_getAll()) {
            view.displayMemberListRow(member.getId(), member.getName(), member.getSocialSecurityNumber(), member.getNumberOfBoats());
        }
    }

	public void verboseList() {
        for (Member member : model_Handler.m_getAll()) {

            view.displayMember(member.getId(), member.getName(), member.getSocialSecurityNumber());

            b_list(member.b_get());
        }
    }

    public void b_list(Boat[] boats) {
        for (Boat boat : boats) {
            view.displayBoat(boat.getType(), boat.getLength());
        }
    }

    public void m_registered() {
        String name = view.getInputMemberName();
        String ssn = view.m_getInputSSN();

        model_Handler.m_add(name, ssn);
        view.displayAddedMember();
    }

    public void m_view() {
        Member member = m_get();
        view.displayMember(member.getId(), member.getName(), member.getSocialSecurityNumber());
    }

    public void m_edit() {
        Member member = m_get();

        String name = view.displayUpdateName(member.getName());
        String ssn = view.displayUpdatePno(member.getSocialSecurityNumber());

        member.setName(name);
        member.setSocialSecurityNumber(ssn);
    }

    public void m_remove() {
        int id = view.getInputMemberId();
        model_Handler.m_remove(id);

        view.displayMemberDeleted();
    }

    public void b_registered() {
        Member member = m_get();
        ENUMERATION_BOAT_TYPES type = view.getInputBoatType();
        float length = view.getInputBoatLength();
        member.b_register(type, length);

        view.displayAddedBoat();
    }

    public void b_edit() {
        Member member = m_get();
        Boat boat = b_get(member);

        ENUMERATION_BOAT_TYPES type = view.displayUpdateType(boat.getType());
        double length = view.displayUpdateLength(boat.getLength());

        boat.setType(type);
        boat.setLength(length);
    }

    public void b_remove() {
        Member member = m_get();
        int index = view.getInputBoatIndex();
        member.b_remove(index);

        view.displayBoatDeleted();
    }

    public Member m_get() {
        int id = view.getInputMemberId();
        return model_Handler.m_get(id);
    }

    public Boat b_get(Member member) {
        int index = view.getInputBoatIndex();
        return member.b_get(index);
    }
	
}
