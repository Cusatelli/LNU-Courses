package workshop3.model;

import workshop3.model.rules.*;

public class Dealer extends Player {

	private Deck m_deck;
	private INewGameStrategy m_newGameRule;
	private IHitStrategy m_hitRule;
	private IWinStrategy m_winRule;

	public Dealer(RulesFactory a_rulesFactory) {
		m_newGameRule = a_rulesFactory.GetNewGameRule();
		m_hitRule = a_rulesFactory.GetHitRule();
		m_winRule = a_rulesFactory.GetWinnerRule();
	}

	public boolean NewGame(Player a_player) {
		if (m_deck == null || IsGameOver()) {
			m_deck = new Deck();
			ClearHand();
			a_player.ClearHand();
			return m_newGameRule.NewGame(m_deck, this, a_player);   
		}
		return false;
	}

	public boolean Hit(Player a_player) {
		if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
			DealCard(a_player, m_deck.GetCard(), true);
			return true;
		}
		return false;
	}

	public boolean Stand(Player a_player) {
		if(m_deck != null) {
			ShowHand();
			while(m_hitRule.DoHit(this)) { Hit(this); }
		}
		return false;
	}

	public boolean IsDealerWinner(Player a_player) {
		return m_winRule.IsDealerWinner(this, a_player, g_maxScore);
	}

	public boolean IsGameOver() {
		if (m_deck != null && m_hitRule.DoHit(this) != true) {
			return true;
		}
		return false;
	}

	public void DealCard(Player a_player, Card a_card, boolean a_show) {
		a_card.Show(a_show);
		a_player.DealCard(a_card);
	}

}
