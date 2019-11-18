package workshop3.model.rules;

import workshop3.model.Player;

public interface IHitStrategy {
	boolean DoHit(Player a_dealer);
}