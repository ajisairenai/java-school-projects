
/**
 * Deck class file.
 * Written by Hydreesia
 */

import java.util.Random;

public class Deck {
    private Card[] cards;
    private int cardsRemaining;
    private Random rand;

    /**
     * Creates a new Deck object of 52 unique cards, which are already shuffled
     */
    public Deck() {
        cards = new Card[52];
        cardsRemaining = 52;
        int index = 0;
        for (int i = 1; i <= 4; i++) { // suit
            for (int j = 1; j <= 13; j++) { // rank
                cards[index] = new Card(j, i);
                index++;
            }
        }
        shuffle();
    }

    /**
     * Shuffles the cards in the deck
     */
    public void shuffle() {
        rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    /**
     * Draws a card from the deck starting from the first index, and not repeating any previous draws
     * @return -- the card being drawn
     */
    public Card draw() {
        if (isEmpty()) {
            shuffle();
            cardsRemaining = 52;
        }
        cardsRemaining--;
        return cards[51 - cardsRemaining];
    }

    public int cardsRemaining() {
        return cardsRemaining;
    }

    public boolean isEmpty() {
        return cardsRemaining == 0;
    }
}
