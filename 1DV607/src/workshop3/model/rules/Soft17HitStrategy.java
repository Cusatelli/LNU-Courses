package workshop3.model.rules;

import workshop3.model.Player;

public class Soft17HitStrategy extends BasicHitStrategy {
	private final int g_hitLimit = 17;
	public boolean DoHit(Player a_dealer) { return a_dealer.HasSoft17() || a_dealer.CalcScore() < g_hitLimit; }
}
