package workshop3.model;

import java.util.List;
import java.util.LinkedList;

public class Player {

	private List<Card> m_hand;
	protected final int g_maxScore = 21;
	final int g_hitLimit = 17;
	private List<AUpdateObserver> m_observer;

	public Player() {
		m_hand = new LinkedList<Card>();
		m_observer = new LinkedList<AUpdateObserver>();
		System.out.println("Hello List World");
	}

	public void DealCard(Card a_addToHand) {
		m_hand.add(a_addToHand);
	}

	public Iterable<Card> GetHand() {
		return m_hand;
	}

	public void ClearHand() {
		m_hand.clear();
	}

	public void ShowHand() {
		for(Card c : GetHand()) { c.Show(true); }
	}

	public int CalcScore() {
		int score = TotalCardValues();

		if (score > g_maxScore) {
			for(Card c : GetHand()) {
				if (c.GetValue() == Card.Value.Ace && score > g_maxScore) {
					score -= 10;
				}
			}
		}

		return score;
	}

	public boolean HasSoft17() {
		if(TotalCardValues() == g_hitLimit) {
			for(Card c : GetHand()) {
				if (c.GetValue() == Card.Value.Ace) { return true; }
			}
		}
		return false;
	}

	private int TotalCardValues() {
		// the number of scores is dependant on the number of scorable values
		// as it seems there is no way to do this check at compile time in java ?!
		// cardScores[13] = {...};
		int cardScores[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11 };
		assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";

		int score = 0;
		for(Card c : GetHand()) {
			if (c.GetValue() != Card.Value.Hidden) { 
				score += cardScores[c.GetValue().ordinal()]; 
			}
		}
		return score;
	}

	public void addObserver(AUpdateObserver a_observer) {
		m_observer.add(a_observer);
	};

	public void removeObserver(AUpdateObserver a_observer) {
		m_observer.remove(a_observer);
	};

	public void updateObserver() {
		for (AUpdateObserver a_observer : m_observer) { a_observer.update(); }
	};

}
