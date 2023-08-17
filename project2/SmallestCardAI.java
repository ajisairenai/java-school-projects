/**
 * SmallestCardAI class file.
 * Written by Hydreesia
 */

 public class SmallestCardAI extends AI {
    Card smallestCard;

    /**
     * Chooses the smallest playable card in hand
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        smallestCard = null;
        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))) {
                if (smallestCard == null) {
                    smallestCard = hand.get(i);
                } else if (hand.get(i).getRankNum() < smallestCard.getRankNum()) {
                    smallestCard = hand.get(i);
                }
            }
        }
        return smallestCard;
    }

    @Override
    public String toString() {
        return "Smallest Card AI";
    }

 }