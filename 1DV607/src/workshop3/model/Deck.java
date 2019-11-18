package workshop3.model;

import java.util.List;
import java.util.LinkedList;

public class Deck {

	private List<Card> m_cards;

	public Deck() {
		m_cards = new LinkedList<Card>();

		for(int cIx = 0; cIx < Card.Color.Count.ordinal(); cIx++) {
			for (int vIx = 0; vIx < Card.Value.Count.ordinal(); vIx++) {
				Card c = new Card(Card.Color.values()[cIx], Card.Value.values()[vIx]);
				AddCard(c);
			}
		}

		Shuffle();
	}


	public void AddCard(Card a_cardToAdd) {
		m_cards.add(a_cardToAdd);
	}

	public Card GetCard() {
		Card c = m_cards.get(0);
		m_cards.remove(0);

		return c;
	}

	public Iterable<Card> GetCards() {
		return m_cards;
	}

	private void Shuffle() {
		for (int i = 0; i < 1017; i++) {
			int index = (int)(Math.random() * 171717.0) % m_cards.size();
			Card c = m_cards.get(index);
			m_cards.remove(index);
			AddCard(c);
		}
	}

}
