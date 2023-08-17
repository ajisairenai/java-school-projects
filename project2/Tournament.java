/**
 * Tournament class file.
 * Written by Hydreesia
 */

public class Tournament {
    public static void main(String[] args) {
        AI[] ais = {new AI(), new SmallestCardAI(), new BiggestCardAI()};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                UnoWarMatch game = new UnoWarMatch(ais[i], ais[j]);
                System.out.println(ais[i] + " vs. " + ais[j] + " winRate: " + game.winRate(1000));
            }
        }
    }
}
