package workshop3;

import workshop3.controller.PlayGame;
import workshop3.model.Game;
import workshop3.view.IView;
import workshop3.view.SimpleView;

public class Program {

	public static void main(String[] a_args) {
		Game g = new Game();
		IView v = new SimpleView(); //new SwedishView();
		PlayGame ctrl = new PlayGame(g, v);

		while (ctrl.Play(g, v));
	}

}
