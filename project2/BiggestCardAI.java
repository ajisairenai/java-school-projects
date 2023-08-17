/**
 * BiggestCardAI class file.
 * Written by Hydreesia
 */

public class BiggestCardAI extends AI {
    Card biggestCard;

    /**
     * Chooses the biggest playable card in hand
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        biggestCard = null;
        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))) {
                if (biggestCard == null) {
                    biggestCard = hand.get(i);
                } else if (hand.get(i).getRankNum() > biggestCard.getRankNum()) {
                    biggestCard = hand.get(i);
                }
            }
        }
        return biggestCard;
    }

    @Override
    public String toString() {
        return "Biggest Card AI";
    }

}
