package workshop2;

import workshop2.controller.Controller;
import workshop2.model.Registry;
import workshop2.view.Console;

public class Program {

    public static void main(String[] args) {
        try {
            Console console = new Console();
            Registry registry = new Registry();
            Controller controller = new Controller(registry, console);

            controller.start();

        } catch (Exception error) {
        	System.out.println("| [Error] Application Terminated!" 
        			+ error.getMessage());
        }
    }
}
