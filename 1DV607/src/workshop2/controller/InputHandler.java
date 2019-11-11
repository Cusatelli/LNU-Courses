package workshop2.controller;

import workshop2.Program;
import workshop2.view.Console;

public class InputHandler {
	Console console = new Console();
	
	public enum INPUT { 
		Register_Member, List, Delete_Member, Edit_Member, View,
		Register_Boat, Delete_Boat, Edit_Boat, Exit_Application
	}
	private INPUT input;
	
	public void start(int input) {
		switch(input) {
		case 0:
			Program.quit();
			break;
		case 1:
			console.m_register();
			break;
		case 2:
			console.list();
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
			break;
		}
	}
}
