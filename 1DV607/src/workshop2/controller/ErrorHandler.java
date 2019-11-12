package workshop2.controller;

import workshop2.model.Registry;
import workshop2.view.Console;

public class ErrorHandler extends Controller {
	
	public ErrorHandler(Registry registry, Console console) {
		super(registry, console);
	}

	public boolean tryAction(UserAction action) {
		try {
			return Action(action);
		} catch (MemberNotFoundException e) {
			console.memberNotFoundException();
		} catch (BoatNotFoundException e) {
			console.boatNotFoundException();
		}
		
		return false;
	}
}
