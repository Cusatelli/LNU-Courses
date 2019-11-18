package workshop3.model;

public class Game {

	private Dealer m_dealer;
	private Player m_player;

	public Game() {
		m_dealer = new Dealer(new workshop3.model.rules.RulesFactory());
		m_player = new Player();
	}


	public boolean IsGameOver() {
		return m_dealer.IsGameOver();
	}

	public boolean IsDealerWinner() {
		return m_dealer.IsDealerWinner(m_player);
	}

	public boolean NewGame() {
		return m_dealer.NewGame(m_player);
	}

	public boolean Hit() {
		return m_dealer.Hit(m_player);
	}

	public boolean Stand() {
		// TODO: Implement this according to Game_Stand.sequencediagram
		return m_dealer.Stand(m_player);
	}

	public Iterable<Card> GetDealerHand() {
		return m_dealer.GetHand();
	}

	public Iterable<Card> GetPlayerHand() {
		return m_player.GetHand();
	}

	public int GetDealerScore() {
		return m_dealer.CalcScore();
	}

	public int GetPlayerScore() {
		return m_player.CalcScore();
	}
	
	public void addObserver(AUpdateObserver a_observer) {
		m_dealer.addObserver(a_observer);
		m_player.addObserver(a_observer);
	};

}