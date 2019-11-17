package workshop2.controller;

import workshop2.Program;
import workshop2.model.ModelHandler;
import workshop2.view.View;

public class Controller {
	private View view;
	private ModelHandler model_Handler;
	private InputHandler input_Handler;
	
	protected boolean APPLICATION_IS_RUNNING;
	private INPUT_ENUMERATION[] input_Enumeration;
	
	public Controller(View view, ModelHandler model_Handler) {
		this.view = view;
		this.model_Handler = model_Handler;
		input_Handler = new InputHandler(view, model_Handler);
	}
	
	public void start() throws Exception {
		APPLICATION_IS_RUNNING = true;
		input_Enumeration = INPUT_ENUMERATION.values();
		
		while(APPLICATION_IS_RUNNING) { update(); }
		
		exit();
	}
	
	public void update() throws Exception {
		view.printMenu(input_Enumeration);
		INPUT_ENUMERATION input = view.getInput(input_Enumeration);
		
		if(input_Handler.check(input)) { model_Handler.m_save(); }
		else { APPLICATION_IS_RUNNING = false; }
	}
	
	public void exit() {
		view.displayExitMessage();
		Program.terminate();
	}
}
