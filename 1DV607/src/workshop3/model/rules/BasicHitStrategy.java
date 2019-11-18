package workshop3.model.rules;

import workshop3.model.Player;

class BasicHitStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;

	public boolean DoHit(Player a_dealer) {
		return a_dealer.CalcScore() < g_hitLimit;  
	}
}