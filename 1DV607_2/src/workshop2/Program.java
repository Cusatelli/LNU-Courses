package workshop2;

import workshop2.controller.Controller;
import workshop2.controller.InputHandler;
import workshop2.model.ModelHandler;
import workshop2.view.View;

public class Program {
	protected static View view_Handler;
	protected static ModelHandler model_Handler;
	protected static Controller controller_Handler;
	
	public static void main(String[] args) {
		try {
			view_Handler = new View();
			model_Handler = new ModelHandler();
			controller_Handler = new Controller(view_Handler, model_Handler);
			controller_Handler.start();
		
		} catch (Exception e) { 
			System.out.print("\nApplication Could not Launch!"
				+ "\n\n[Error] ");
			e.printStackTrace();
		}
	}
	
	public static void terminate() {
		System.exit(0);
	}
}
