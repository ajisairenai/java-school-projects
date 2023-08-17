/**
 * AI class file.
 * Written by Hydreesia
 */

public class AI {
    Hand hand;
    CardPile cardPile;
    
    /**
     * Chooses a random playable card from hand
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    public String toString() {
        return "Random Card AI";
    }
}
