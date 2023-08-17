/**
 * CodeMonster class file.
 * Written by Hydreesia.
 */

public class CodeMonster {
    private String name;
    private int currentHp;
    private int maxHp;
    private Skill[] moves;
    private int moveIndex;
    private double speedScore;
    private double nextTurnTime;

    /**
     * Create a new CodeMonster
     * 
     * @param maxHp      -- the max hp of the CodeMonster
     * @param speedScore -- the speed of the CodeMonster
     * @param name       -- the name of the CodeMonster
     * @param moves      -- the skill/move set of the CodeMonster
     */
    public CodeMonster(int maxHp, double speedScore, String name, Skill[] moves) {
        this.maxHp = maxHp;
        this.speedScore = speedScore;
        this.name = name;
        this.moves = moves;
        currentHp = maxHp;
        nextTurnTime = speedScore;
    }

    public void setNextTurnTime(double nextTurnTime) {
        this.nextTurnTime = nextTurnTime;
    }

    public double getNextTurnTime() {
        return nextTurnTime;
    }

    public int getHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Skill[] getMoves() {
        return moves;
    }

    public String getName() {
        return name;
    }

    public double getSpeedScore() {
        return speedScore;
    }

    /**
     * Refreshes stats (HP, turn time, move usage) for a new battle
     */
    public void prepForBattle() {
        currentHp = maxHp;
        nextTurnTime = speedScore;
        moveIndex = 0;
        for (int i = 0; i < moves.length; i++) {
            moves[i].refresh();
        }
    }

    /**
     * Picks the next move to use and updates the time for the next turn
     * 
     * @return -- the skill used for the turn
     */
    public Skill takeTurn() {
        Skill move = moves[moveIndex];
        nextTurnTime += speedScore;
        moveIndex += 1;
        if (moveIndex > moves.length - 1) {
            moveIndex = 0;
        }
        return move;
    }

    /**
     * Checks to see if the CodeMonster is alive or dead
     */
    public boolean isAlive() {
        if (currentHp > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adjusts currentHp to reflect healing or damage taken
     * 
     * @param amount -- the amount of health to be added or subtracted
     */
    public void adjustHealth(int amount) {
        currentHp += amount;
        if (currentHp < 0) {
            currentHp = 0;
        }
        if (currentHp > maxHp) {
            currentHp = maxHp;
        }
    }

    public String toString() {
        return (name + " " + currentHp + "/" + maxHp);
    }
}
