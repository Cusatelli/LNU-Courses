package workshop3.model.rules;

import workshop3.model.Player;

public interface IWinStrategy {
	boolean IsDealerWinner(Player a_dealerScore, Player a_playerScore, int a_score);
}
