package workshop2.controller;

import workshop2.debug.BoatNotFound;
import workshop2.debug.InvalidInputParameter;
import workshop2.debug.MemberNotFound;
import workshop2.model.Boat;
import workshop2.model.Registry;
import workshop2.model.Member;
import workshop2.view.Console;

public class Controller {
	
    Console console;
    Registry registry;
    
    private boolean APPLICATION_IS_RUNNING;
    private ACTIONS[] actions;

    public Controller(Registry registry, Console console) {
        this.registry = registry;
        this.console = console;
    }

    public void start() {
    	APPLICATION_IS_RUNNING = true;
        actions = ACTIONS.values();
        
        // Run Application:
        console.printApplicationLaunched();
        update();
        // Called once update is finished:
        console.printApplicationTerminated();
    }
    
    public void update() {
    	// Print Menu in Console:
    	console.getMenu(actions);
    	
    	// Get User input & Check it against Actions
    	// Stored in ACTIONS Enumeration:
    	ACTIONS action = console.getUserRequest(actions);
    	
    	try { 
        	// Check if Action is possible:
    		checkInput(action);
        	// Save Data To Registry after every loop:
    		registry.saveDataToRegistry();
    	} catch (Exception error) { 
    		console.printExceptionStackTrace("Something went wrong!", error);
    	}

    	// If Application is still running do Recursive Looping:
    	if(APPLICATION_IS_RUNNING) { update(); }
    }

    private void checkInput(ACTIONS action) throws InvalidInputParameter {
        try { inputHandler(action); }
        catch (MemberNotFound e) { console.m_printNotFound(); }
        catch (BoatNotFound e) { console.b_printNotFound(); }
    }

	public void inputHandler(ACTIONS input) throws MemberNotFound, BoatNotFound, InvalidInputParameter {
        switch (input) {
            case LIST_COMPACT:
            	compactList();
                break;
            case LIST_VERBOSE:
            	verboseList();
                break;
            case MEMBER_REGISTER:
            	m_register();
                break;
            case MEMBER_VIEW:
            	m_view();
                break;
            case MEMBER_EDIT:
            	m_edit();
                break;
            case MEMBER_DELETE:
            	m_remove();
                break;
            case BOAT_REGISTER:
            	b_register();
                break;
            case BOAT_EDIT:
            	b_edit();
                break;
            case BOAT_REMOVE:
            	b_remove();
                break;
            case EXIT_APPLICATION:
            	console.printHeader();
            	if(isConfirmed()) { APPLICATION_IS_RUNNING = false; }
            	console.printFooter();
                break;
            default:
            	throw new InvalidInputParameter();
        }
	}

    void compactList() {
        console.getListHeader();
        for (Member member : registry.m_getAll()) {
            console.getList(member.getId(), member.getName(), member.getSocialSecurityNumber(), member.b_getListSize());
        }
        console.getListFooter();
    }

    void verboseList() throws InvalidInputParameter {
        for (Member member : registry.m_getAll()) {
            console.m_printData(member.getName(), member.getSocialSecurityNumber(), member.getId());
            b_list(member.b_getAll());
        }
    }

    private void b_list(Boat[] boats) throws InvalidInputParameter {
        for (Boat boat : boats) {
            console.b_print(boat.getType(), boat.getLength());
        }
        if(boats.length > 0) { console.b_printFooter(1); }
        else { console.b_printFooter(2); }
    }

    private void m_register() {
    	console.printHeader();
        String name = console.m_getInputFirstName();
    	console.printFooter();
    	console.printHeader();
        String pno = console.m_getInputSocialSecurityNumber();
    	console.printFooter();
        registry.m_register(name, pno);
        
        console.m_printRegistered();
    }

    private void m_view() throws MemberNotFound {
        Member member = m_get();
        console.m_printData(member.getName(), member.getSocialSecurityNumber(), member.getId());
        console.m_printFooter();
    }

    private void m_edit() throws MemberNotFound {
        Member member = m_get();
        
        console.printHeader();
        String name = console.m_editName(member.getName());
        console.printFooter();
        member.setName(name);

        console.printHeader();
        String socialSecurityNumber = console.m_printEditSSN(member.getSocialSecurityNumber());
        console.printFooter();
        
        member.setSocialSecurityNumber(socialSecurityNumber);
    }

    private void m_remove() throws MemberNotFound {
    	console.printHeader();
        int id = console.m_getInputID();
        console.printFooter();
        
        registry.m_remove(id);
        console.m_printRemove();
    }

    private void b_register() throws MemberNotFound {
        Member member = m_get();
        Boat.TYPE type = console.b_getInputType();
        
        console.printHeader();
        double length = console.b_getInputLength();
        console.printFooter();
        
        member.b_register(type, length);

        console.b_printRegister();
    }

    private void b_edit() throws MemberNotFound, BoatNotFound {
        Member member = m_get();
        Boat boat = b_get(member);

        Boat.TYPE boatType = console.b_printEditType(boat.getType());
        double length = console.b_printEditLength(boat.getLength());

        boat.setType(boatType);
        boat.setLength(length);
    }

    private void b_remove() throws MemberNotFound, BoatNotFound {
        Member member = m_get();
    	console.printHeader();
        int index = console.b_getInputIndex();
    	console.printFooter();
        member.b_remove(index);
        
        console.b_printRemoved();
    }

    private Member m_get() throws MemberNotFound {
    	console.printHeader();
        int id = console.m_getInputID();
        console.printFooter();
        
        return registry.m_get(id);
    }

    private Boat b_get(Member member) throws BoatNotFound {
    	console.printHeader();
        int index = console.b_getInputIndex();
        console.printFooter();
        
        return member.b_get(index);
    }
    
    private boolean isConfirmed() {
    	return console.getConfirmation();
    }

}
