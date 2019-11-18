package workshop3.model.rules;

import workshop3.model.Player;

public class DealerWinStrategy implements IWinStrategy {

	@Override
	public boolean IsDealerWinner(Player a_dealer, Player a_player, int a_score) {
		int a_dealerScore = a_dealer.CalcScore();
		int a_playerScore = a_player.CalcScore();

		if(a_dealerScore > a_score) { return false; } 
		else if(a_playerScore > a_score) { return true; }

		return a_dealerScore >= a_playerScore;
	}

}
