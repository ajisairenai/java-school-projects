/**
 * CardPile class file.
 * Written by Hydreesia
 */

public class CardPile {
    private Card topCard;
    private int numCards;

    public CardPile(Card topCard) {
        this.topCard = topCard;
        numCards = 1;
    }
    
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        } else if (topCard.getSuitName() == card.getSuitName() || topCard.getRankNum() <= card.getRankNum()) {
            return true;
        }    
        return false;
    }

    /**
     * Adds a card to the top of the CardPile 
     */
    public void play(Card card) {
        if (canPlay(card)) {
            topCard = card;
            numCards++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    public int getNumCards() {
        return numCards;
    }

    public Card getTopCard() {
        return topCard;
    }
}
