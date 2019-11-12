package workshop2.controller;

import workshop2.model.Registry;
import workshop2.view.Console;

public class ErrorHandler extends Controller {
	
	public ErrorHandler(Registry registry, Console console) {
		super(registry, console);
	}

	public boolean tryAction() {
		return false;
	}
}
