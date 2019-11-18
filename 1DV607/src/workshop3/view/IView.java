package workshop3.view;

public interface IView
{
	void DisplayWelcomeMessage();
	InputMenu GetInput();
	void DisplayCard(workshop3.model.Card a_card);
	void DisplayPlayerHand(Iterable<workshop3.model.Card> a_hand, int a_score);
	void DisplayDealerHand(Iterable<workshop3.model.Card> a_hand, int a_score);
	void DisplayGameOver(boolean a_dealerIsWinner);
	void DisplayAddDelay(int milliseconds);
	enum InputMenu { Play, Hit, Stand, Quit, InvalidInput; }
}
