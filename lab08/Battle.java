/**
 * Battle class file.
 * Written by Hydreesia.
 */

public class Battle {
    /**
     * Handles one turn of battle between two CodeMonsters
     */
    public static void doOneTurn(CodeMonster one, CodeMonster two) {
        if (one.getNextTurnTime() <= two.getNextTurnTime()) {
            Skill move = one.takeTurn();
            System.out.println(one + " uses " + move + " on " + two);
            move.useSkill(one, two);
        } else {
            Skill move = two.takeTurn();
            System.out.println(two + " uses " + move + " on " + one);
            move.useSkill(two, one);
        }

    }

    /**
     * Carries out a battle between two CodeMonsters
     * @return -- the winner of the battle
     */
    public static CodeMonster battle(CodeMonster one, CodeMonster two) {
        one.prepForBattle();
        two.prepForBattle();

        System.out.println(one + " vs. " + two);
        while (one.isAlive() && two.isAlive()) {
            doOneTurn(one, two);
        }

        if (one.isAlive()) {
            System.out.println(one + " wins!");
            return one;
        } else {
            System.out.println(two + " wins!");
            return two;
        }

    }
}