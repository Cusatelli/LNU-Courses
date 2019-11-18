package workshop3.view;

import java.util.concurrent.TimeUnit;

public class SimpleView implements IView 
{

	public void DisplayWelcomeMessage() {
		for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
		System.out.println("Hello Black Jack World");
		System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
	}

	public InputMenu GetInput() {
		InputMenu inputMenu;
		switch(GetInputCharacter()) {
		case 'p':
			inputMenu = InputMenu.Play;
			break;
		case 'h':
			inputMenu = InputMenu.Hit;
			break;
		case 's':
			inputMenu = InputMenu.Stand;
			break;
		case 'q':
			inputMenu = InputMenu.Quit;
			break;
		default:
			inputMenu = InputMenu.InvalidInput;
			break;
		}

		return inputMenu;
	}

	private int GetInputCharacter() {
		try {
			int c = System.in.read();
			while (c == '\r' || c =='\n') {
				c = System.in.read();
			}
			return c;
		} catch (java.io.IOException e) {
			System.out.println("" + e);
			return 0;
		}
	}

	public void DisplayCard(workshop3.model.Card a_card) {
		if(!a_card.IsOnTable()) {
			DisplayAddDelay(1250);
			a_card.CardOnTable();
		}
		System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
	}

	public void DisplayPlayerHand(Iterable<workshop3.model.Card> a_hand, int a_score) {
		DisplayHand("Player", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<workshop3.model.Card> a_hand, int a_score) {
		DisplayHand("Dealer", a_hand, a_score);
	}

	private void DisplayHand(String a_name, Iterable<workshop3.model.Card> a_hand, int a_score) {
		System.out.println(a_name + " Has: ");
		for(workshop3.model.Card c : a_hand)
		{
			DisplayCard(c);
		}
		System.out.println("Score: " + a_score);
		System.out.println("");
	}

	public void DisplayGameOver(boolean a_dealerIsWinner) {
		System.out.println("GameOver: ");
		if (a_dealerIsWinner)
		{
			System.out.println("Dealer Won!");
		}
		else
		{
			System.out.println("You Won!");
		}

	}

	@Override
	public void DisplayAddDelay(int milliseconds) {
		try { TimeUnit.MILLISECONDS.sleep(milliseconds); } 
		catch (InterruptedException e) { e.printStackTrace(); }		
	}
}
