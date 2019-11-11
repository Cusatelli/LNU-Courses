package workshop2.controller;

import workshop2.Program;
import workshop2.view.Console;

public class InputHandler {
	Console console = new Console();
	
	public enum INPUT { 
		Member, Register_Member, List, Delete_Member, Edit_Member, View,
		Boat, Register_Boat, Delete_Boat, Edit_Boat, Exit_Application
	}
	
	public void start(int input) {
		switch(input) {
		case 0:
			Program.quit();
			break;
		case 1:
			register(INPUT.Member);
			break;
		case 2:
			console.list();
			break;
		case 3:
			delete(INPUT.Member);
			break;
		case 4:
			edit(INPUT.Member);
			break;
		case 5:
			console.view();
			break;
		case 6:
			register(INPUT.Boat);
			break;
		case 7:
			delete(INPUT.Boat);
			break;
		case 8:
			edit(INPUT.Boat);
			break;
		default:
			console.invalid();
			break;
		}
	}
	
	private void register(INPUT input) {
		if(input == INPUT.Member) {
			console.m_register();
			
		} else if(input == INPUT.Boat) {
			console.b_register();
			
		} else { console.invalid(); }
	}
	
	private void delete(INPUT input) {
		if(input == INPUT.Member) {
			console.m_delete();
			
		} else if(input == INPUT.Boat) {
			console.b_delete();
			
		} else { console.invalid(); }		
	}
	
	private void edit(INPUT input) {
		if(input == INPUT.Member) {
			console.m_edit();
			
		} else if(input == INPUT.Boat) {
			console.b_edit();
			
		} else { console.invalid(); }
	}
}
