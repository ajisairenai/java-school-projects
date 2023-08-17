/**
 * Gamescore class file.
 * Written by Hydreesia.
 */

public class GameScore implements Comparable<GameScore> {
    private double score;
    private String name;
    private boolean hardMode;

    public GameScore(String name, double score, boolean hardMode) {
        this.name = name;
        this.score = score;
        this.hardMode = hardMode;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public boolean isHardMode() {
        return hardMode;
    }

    @Override
    public String toString() {
        if (hardMode) {
            return this.name + " " + this.score + "*";
        }
        return this.name + " " + this.score;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o instanceof GameScore) {
            GameScore gs = (GameScore) o;
            return (this.name.equals(gs.getName())) && (this.score == gs.getScore()) && (this.hardMode == gs.isHardMode());
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(GameScore other) {
        if (this.hardMode && !other.hardMode) {
            // If this is in hard mode and other is not, this > other
            return 1;
        } else if (!this.hardMode && other.hardMode) {
            // if this is not in hard mode and other is, this < other
            return -1;
        } else if (this.score > other.score) {
            return 1;
        } else if (this.score < other.score) {
            return -1;
        } else {
            return 0;
        }
    }
}