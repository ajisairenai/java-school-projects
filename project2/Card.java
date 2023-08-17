/**
 * Card class file.
 * Written by Hydreesia
 */

public class Card {
    private int rank;
    private int suit;

    /**
     * Construct a new Card object
     * @param rank -- the rank of the card as an int between 1-13
     * @param suit -- the suit of the card as an int between 1-4
     */
    public Card(int rank, int suit) {
        if ((rank < 1 || rank > 13) || (suit < 1 || suit > 4)) {
            System.out.println("Invalid Card");
            this.rank = 1;
            this.suit = 1;
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    public int getRankNum() {
        return rank;
    }

    /**
     * returns the rank as a string
     */
    public String getRankName() {
        if (rank == 1) {
            return "Ace";
        } else if (rank == 2) {
            return "Two";
        } else if (rank == 3) {
            return "Three";
        } else if (rank == 4) {
            return "Four";
        } else if (rank == 5) {
            return "Five";
        } else if (rank == 6) {
            return "Six";
        } else if (rank == 7) {
            return "Seven";
        } else if (rank == 8) {
            return "Eight";
        } else if (rank == 9) {
            return "Nine";
        } else if (rank == 10) {
            return "Ten";
        } else if (rank == 11) {
            return "Jack";
        } else if (rank == 12) {
            return "Queen";
        } else if (rank == 13) {
            return "King";
        } else {
            return null;
        }
    }

    /**
     * returns the suit value as a string
     */
    public String getSuitName() {
        if (suit == 1) {
            return "Spades";
        } else if (suit == 2) {
            return "Hearts";
        } else if (suit == 3) {
            return "Clubs";
        } else if (suit == 4) {
            return "Diamonds";
        } else {
            return null;
        }
    }

    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Card) {
            Card card = (Card) obj;
            return this.rank == card.rank && this.suit == card.suit;
        } else {
            return false;
        }
    }
}
