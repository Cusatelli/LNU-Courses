package workshop3.view;

import java.util.concurrent.TimeUnit;

public class SwedishView implements IView 
{
	public void DisplayWelcomeMessage()
	{

		for(int i = 0; i < 50; i++) {System.out.print("\n");};

		System.out.println("Hej Black Jack Världen");
		System.out.println("----------------------");
		System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
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

	public void DisplayCard(workshop3.model.Card a_card)
	{
		if(!a_card.IsOnTable()) {
			DisplayAddDelay(1250);
			a_card.CardOnTable();
		}
		if (a_card.GetColor() == workshop3.model.Card.Color.Hidden)
		{
			System.out.println("Dolt Kort");
		}
		else
		{
			String colors[] = 
				{ "Hjärter", "Spader", "Ruter", "Klöver" };
			String values[] =  
				{ "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
			System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
		}
	}
	public void DisplayPlayerHand(Iterable<workshop3.model.Card> a_hand, int a_score)
	{
		DisplayHand("Spelare", a_hand, a_score);
	}
	public void DisplayDealerHand(Iterable<workshop3.model.Card> a_hand, int a_score)
	{
		DisplayHand("Croupier", a_hand, a_score);
	}
	public void DisplayGameOver(boolean a_dealerIsWinner)
	{
		System.out.println("Slut: ");
		if (a_dealerIsWinner)
		{
			System.out.println("Croupiern Vann!");
		}
		else
		{
			System.out.println("Du vann!");
		}
	}

	private void DisplayHand(String a_name, Iterable<workshop3.model.Card> a_hand, int a_score)
	{
		System.out.println(a_name + " Har: " + a_score);
		for(workshop3.model.Card c : a_hand)
		{
			DisplayCard(c);
		}
		System.out.println("Poäng: " + a_score);
		System.out.println("");
	}

	@Override
	public void DisplayAddDelay(int milliseconds) {
		try { TimeUnit.MILLISECONDS.sleep(milliseconds); } 
		catch (InterruptedException e) { e.printStackTrace(); }		
	}
}
