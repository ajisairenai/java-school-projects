/**
 * UnoWarMatch class file.
 * Written by Hydreesia
 */

public class UnoWarMatch {
   private AI ai1;
   private AI ai2;

   public UnoWarMatch(AI ai1, AI ai2) {
      this.ai1 = ai1;
      this.ai2 = ai2;
   }

   public boolean playGame() {
      Deck deck = new Deck();
      CardPile cardPile = new CardPile(deck.draw());
      Hand hand1 = new Hand(deck, 5);
      Hand hand2 = new Hand(deck, 5);
      boolean turn = true;
      int win1 = 0;
      int win2 = 0;

      while (win1 < 10 && win2 < 10) {
         if (turn) {
            Card card = ai1.getPlay(hand1, cardPile);
            turn = false;
            if (card == null) {
               win2++;
               cardPile = new CardPile(deck.draw());
            } else {
               cardPile.play(card);
               hand1.remove(card);
            }
         } else {
            Card card = ai2.getPlay(hand2, cardPile);
            turn = true;
            if (card == null) {
               win1++;
               cardPile = new CardPile(deck.draw());
            } else {
               cardPile.play(card);
               hand2.remove(card);
            }
         }
      }
      return win1 == 10;
   }

   public double winRate(int nTrials) {
      int wins = 0;
      for (int i = 0; i < nTrials; i++) {
         boolean game = playGame();
         if (game) {
            wins++;
         }
      }
      return (double)wins / (double)nTrials;
   }
}
