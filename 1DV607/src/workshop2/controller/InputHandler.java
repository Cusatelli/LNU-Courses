package workshop2.controller;

import java.util.Scanner;

import workshop2.Program;
import workshop2.model.Id;
import workshop2.model.Member;
import workshop2.model.Registry;
import workshop2.view.Console;

public class InputHandler {
	Console console = new Console();
	Id id;
	InputHandler inputHandler;
	Scanner scan = new Scanner(System.in);

	// Pattern to check input:
	String idPattern = "^([a-zA-Z]{1}\\d{3})$"; // One Character & 3 digits.
	String namePattern = "^\\D[ _a-zA-Z]{2,40}$"; // 2-40 characters.
	String ssnPattern = "^(\\d{12})$"; // 12 digits. (YYYYMMDDXXXX).
	String integerPattern = "^(\\d?[0-9]|[1-9]0|[1-9]00|[1-9]000)$"; // 1-4 digit input
	
	public void start(int user_action) {
		switch(user_action) {
		case 0:
			Program.quit();
			break;
		case 1:
			// Register member to database:
			m_sendToRegistry();
			break;
			
		case 2:
			break;
		case 3:
			console.m_delete();
			break;
		case 4:
			console.m_edit();
			break;
		case 5:
			console.view();
			break;
		case 6:
			console.b_register();
			break;
		case 7:
			console.b_delete();
			break;
		case 8:
			console.b_edit();
			break;
		default:
			console.invalid();
			break;
		}
	}
	
	private void m_sendToRegistry() {
		console.m_setFullName();
		String name = console.getUserInput(namePattern);
		
		console.m_setSocialSecurityNumber();
		String ssn = console.getUserInput(ssnPattern);
		
		console.m_setId();
		int id = new Id().getUniqueID();
		
		Registry registry = new Registry();
		registry.m_register(id, name, ssn);
		
		console.m_displayNew();
	}
	
	private void getList() {
		console.listType();
	}
	
	private void delete(SYSTEM_ACTIONS system_action) {
		if(system_action == SYSTEM_ACTIONS.Member) {
			console.m_delete();
			
		} else if(system_action == SYSTEM_ACTIONS.Boat) {
			console.b_delete();
			
		} else { console.invalid(); }		
	}
	
	private void edit(SYSTEM_ACTIONS system_action) {
		if(system_action == SYSTEM_ACTIONS.Member) {
			console.m_edit();
			
		} else if(system_action == SYSTEM_ACTIONS.Boat) {
			console.b_edit();
			
		} else { console.invalid(); }
	}
}
