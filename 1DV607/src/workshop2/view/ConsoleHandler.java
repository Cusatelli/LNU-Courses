package workshop2.view;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleHandler {
	
	private Scanner scan = new Scanner(System.in);
	
	<T> void startHandler(T[] user_Actions, HashMap<T, String> user_Options) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < user_Actions.length; i++) {
			T user_Action = user_Actions[i];
			if(user_Options.containsKey(user_Action)) {
				stringBuilder.append((i + 1) + "->" + user_Options.get(user_Action));
				stringBuilder.append("\n");
			}
		}
		
		System.out.println(stringBuilder.toString());
	}
}
