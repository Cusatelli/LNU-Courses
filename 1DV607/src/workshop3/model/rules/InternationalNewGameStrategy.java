package workshop3.model.rules;

import workshop3.model.Deck;
import workshop3.model.Dealer;
import workshop3.model.Player;
import workshop3.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

	public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
		Card c;

		c = a_deck.GetCard();
		c.Show(true);
		a_player.DealCard(c);

		c = a_deck.GetCard();
		c.Show(true);
		a_dealer.DealCard(c);

		c = a_deck.GetCard();
		c.Show(true);
		a_player.DealCard(c);

		return true;
	}
	
}
