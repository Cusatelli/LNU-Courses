package workshop2.controller;

import workshop2.debug.BoatNotFound;
import workshop2.debug.InvalidInputParameter;
import workshop2.debug.MemberNotFound;
import workshop2.model.Boat;
import workshop2.model.Registry;
import workshop2.model.Member;
import workshop2.view.Console;

/*
 * InputHandler.java & DataHandler.java have been moved from 
 * being separate classes to being part of Controller.java 
 * for better clarity.
 */
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
    		tryInput(action);
        	// Save Data To Registry after every loop:
    		registry.saveDataToRegistry();
    	} catch (Exception error) { 
    		console.printExceptionStackTrace("Something went wrong!", error);
    	}

    	// If Application is still running do Recursive Looping:
    	if(APPLICATION_IS_RUNNING) { update(); }
    }
    
    /**
	 * This is the <b>TRY INPUT</b> for the <b>INPUT HANDLER</b>.<br>
	 * The <b>Try Input</b> tries desired user input action to see if.<br>
	 * the user has made a valid input action.
	 * 
	 * @param
	 * @throws InvalidInputParameter
	 * @version 2.0
	 * @author cusatelli
	 * @category Input Handler
	 */
    private void tryInput(ACTIONS action) throws InvalidInputParameter {
        try { inputHandler(action); }
        catch (MemberNotFound error) { error.getMessage(); }//console.m_printNotFound(); }
        catch (BoatNotFound error) { error.getMessage(); }//console.b_printNotFound(); }
    }
    
    /**
	 * This is the <b>INPUT HANDLER</b> for the <b>CONTROLLER</b>.<br>
	 * The <b>Input Handler</b> checks the available actions a user can make<br>
	 * against their desired action from a list of <i>Enumerations</i>: <b>ACTIONS</b>.<br>
	 * 
	 * @param
	 * @throws InvalidInputParameter
	 * @version 2.0
	 * @author cusatelli
	 * @category Input Handler
	 */
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
            	throw new InvalidInputParameter("Invalid Input Parameter!");
        }
	}
	
	/**
	 * Print a <b>Compact List</b> of all Members & Number of Boats.
	 * 
	 * @version 2.0
	 * @author cusatelli
	 * @category Compact List
	 */
    void compactList() {
        console.getListHeader();
        for (Member member : registry.m_getAll()) {
            console.getList(member.getId(), member.getName(), member.getSocialSecurityNumber(), member.b_getListSize());
        }
        console.getListFooter();
    }
    
	/**
	 * Print a <b>Verbose List</b> of all Members & Boats.
	 * 
	 * @throws InvalidInputParameter
	 * @version 2.0
	 * @author cusatelli
	 * @category Verbose List
	 */
    void verboseList() throws InvalidInputParameter {
        for (Member member : registry.m_getAll()) {
            console.m_printData(member.getName(), member.getSocialSecurityNumber(), member.getId());
            b_list(member.b_getAll());
        }
    }
    
	/**
	 * Print <b>Boats</b> in <b>Verbose List</b> underneath corresponding Members.
	 * 
	 * @throws InvalidInputParameter
	 * @version 2.0
	 * @author cusatelli
	 * @category Verbose List
	 */
    private void b_list(Boat[] boats) throws InvalidInputParameter {
        for (Boat boat : boats) {
            console.b_print(boat.getType(), boat.getLength());
        }
        if(boats.length > 0) { console.b_printFooter(1); }
        else { console.b_printFooter(2); }
    }
    
    /**
     * Get users input for <b>Member Id</b> so it can fetch 
     * <b>Member</b> Data from <b>Registry</b>.
     * 
     * @return Member
     * @throws MemberNotFound
     * @version 2.0
     * @author cusatelli
     * @category Member
     */
    private Member m_get() throws MemberNotFound {
    	console.printHeader();
        int id = console.m_getInputID();
        console.printFooter();
        
        return registry.m_get(id);
    }
    
    /**
     * Get input from user containing <b>Member Name</b> & <b>Social Security Number</b>.<br>
     * Then send this Member Data to the <b>Registry</b> to register new Member.
     * 
	 * @author cusatelli
	 * @category Member
     */
    private void m_register() {
    	console.printHeader();
        String name = console.m_getInputFirstName();
    	console.printFooter();
    	console.printHeader();
        String socialSecurityNumber = console.m_getInputSocialSecurityNumber();
    	console.printFooter();
        registry.m_register(name, socialSecurityNumber);
        
        console.m_printRegistered();
    }
    
    /**
     * Get <b>Member</b> data and print it to the console in the format 
     * | Name | Social Security Number | ID |.
     * 
     * @throws MemberNotFound
	 * @version 2.0
     * @author cusatelli
     * @category Member
     */
    private void m_view() throws MemberNotFound {
        Member member = m_get();
        console.m_printData(member.getName(), member.getSocialSecurityNumber(), member.getId());
        console.m_printFooter();
    }
    
    /**
     * Get <b>Member</b> data and ask user for <b>new Member</b> data.<br>
     * If user inputs new <b>Member</b> data set the corresponding data and wait for: <br>
     * <code>update()</code> method.
     * 
     * @throws MemberNotFound
	 * @version 2.0
     * @author cusatelli
     * @category Member
     */
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
    
    /**
     * Get <b>Member</b> data and ask user which <b>Member</b> data they wish to remove.<br>
     * If user inputs a valid <b>Member</b> ID remove the corresponding data and wait for: <br>
     * <code>update()</code> method.
     * 
     * @throws MemberNotFound
	 * @version 2.0
     * @author cusatelli
     * @category Member
     */
    private void m_remove() throws MemberNotFound {
    	console.printHeader();
        int id = console.m_getInputID();
        console.printFooter();
        
        registry.m_remove(id);
        console.m_printRemove();
    }
    
    /**
     * Get input from user containing <b>new Boat</b> data such as 
     * <b>Member ID, Type & Length</b>.<br>
     * If user inputs valid <b>Boat</b> data 
     * <b>Member ID, Type & Length</b> add the corresponding data to<br>
     * <b>Member</b> and wait for: <br>
     * <code>update()</code> method.
     * 
     * @throws MemberNotFound
	 * @version 2.0
     * @author cusatelli
     * @category Boat
     */
    private void b_register() throws MemberNotFound {
        Member member = m_get();
        Boat.TYPE type = console.b_getInputType();
        
        console.printHeader();
        double length = console.b_getInputLength();
        console.printFooter();
        
        member.b_register(type, length);

        console.b_printRegister();
    }
    
    /**
     * Get <b>Member</b> and <b>Boat</b> data.<br>
     * If user inputs new <b>Boat</b> data set the corresponding data and wait for: <br>
     * <code>update()</code> method.
     * 
     * @throws MemberNotFound
	 * @version 2.0
     * @author cusatelli
     * @category Boat
     */
    private void b_edit() throws MemberNotFound, BoatNotFound {
        Member member = m_get();
        Boat boat = b_get(member);

        Boat.TYPE boatType = console.b_printEditType(boat.getType());
        double length = console.b_printEditLength(boat.getLength());

        boat.setType(boatType);
        boat.setLength(length);
    }
    
    /**
     * Get <b>Member</b> data and ask user which <b>Boat</b> data they wish to remove.<br>
     * If user inputs a valid <b>Boat</b> index (Position in List) remove the corresponding data and wait for: <br>
     * <code>update()</code> method.
     * 
     * @throws MemberNotFound
	 * @version 2.0
     * @author cusatelli
     * @category Boat
     */
    private void b_remove() throws MemberNotFound, BoatNotFound {
        Member member = m_get();
    	console.printHeader();
        int index = console.b_getInputIndex();
    	console.printFooter();
        member.b_remove(index);
        
        console.b_printRemoved();
    }
    
    /**
     * Get users input for <b>Boat Index</b> in List so it can fetch 
     * <b>Boat</b> data from <b>Member</b> data in the <b>Registry</b>.
     * 
     * @return Boat
     * @throws BoatNotFound
	 * @version 2.0
     * @author cusatelli
     * @category Boat
     */
    private Boat b_get(Member member) throws BoatNotFound {
    	console.printHeader();
        int index = console.b_getInputIndex();
        console.printFooter();
        
        return member.b_get(index);
    }
    
    /**
     * Get user input confirmation that they are sure 
     * about Terminating the Application.
     * 
     * @return boolean
	 * @version 2.0
     * @author cusatelli
     * @category Terminate Application
     */
    private boolean isConfirmed() {
    	return console.getConfirmation();
    }

}
