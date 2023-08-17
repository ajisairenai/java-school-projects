/**
 * Hand class file.
 * Written by Hydreesia
 */

public class Hand {
    private Card[] hand;
    private Deck deck;
    private int size;

    /**
     * Creates a Hand object representing a set of cards in a hand
     * @param deck -- the deck that cards will be drawn from
     * @param size -- the number of cards in Hand
     */
    public Hand(Deck deck, int size) {
        hand = new Card[size];
        this.deck = deck;
        this.size = size;

        for (int i = 0; i < size; i++) {
            hand[i] = deck.draw();
        }
    }

    public int getSize() {
        return size;
    }

    public Card get(int i) {
        if (i < 0 || i > size - 1) {
            System.out.println("Invalid hand index!");
            return hand[0];
        } else {
            return hand[i];
        }
    }

    /**
     * removes the chosen Card from Hand and replaces it with a new Card drawn from deck
     * @param card -- the card to be removed
     * @return -- a boolean value representing fi the card has been removed from Hand or not
     */
    public boolean remove(Card card) {
        if (card == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (card.equals(hand[i])) {
                hand[i] = deck.draw();
                return true;
            }
        }
        return false;
    }
}
