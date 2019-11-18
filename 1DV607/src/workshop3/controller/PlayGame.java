package workshop3.controller;

import workshop3.model.AUpdateObserver;
import workshop3.model.Game;
import workshop3.view.IView;

public class PlayGame extends AUpdateObserver {

	private Game m_game;
	private IView m_view;

	public PlayGame(Game a_game, IView a_view) {
		m_game = a_game;
		m_view = a_view;

		m_game.addObserver(this);
	}

	public boolean Play(Game a_game, IView a_view) {
		a_view.DisplayWelcomeMessage();

		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

		if (a_game.IsGameOver())
		{
			a_view.DisplayGameOver(a_game.IsDealerWinner());
		}

		IView.InputMenu input = a_view.GetInput();

		if (input == IView.InputMenu.Play)
		{
			a_game.NewGame();
		}
		else if (input == IView.InputMenu.Hit)
		{
			a_game.Hit();
		}
		else if (input == IView.InputMenu.Stand)
		{
			a_game.Stand();
		}

		return input != IView.InputMenu.Quit;
	}

	@Override
	public void update() {
		m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
		m_view.DisplayDealerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
	}
	
}
