package workshop3.model.rules;

import workshop3.model.Deck;
import workshop3.model.Dealer;
import workshop3.model.Player;

public interface INewGameStrategy {
	boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
}