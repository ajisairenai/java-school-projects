/**
 * CodeMonster class file.
 * Written by Hydreesia.
 */

public class Skill {
    private String name;
    private int strength;
    private int usageLeft;
    private int usageLimit;

    /**
     * creates a skill
     * 
     * @param name       - name of the skill
     * @param strength   - power of the skill
     * @param usageLimit - the total amount of uses of a skill
     **/
    public Skill(String name, int strength, int usageLimit) {
        this.name = name;
        this.strength = strength;
        this.usageLimit = usageLimit;
        usageLeft = usageLimit;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getUsageLimit() {
        return usageLimit;
    }

    public int getUsageLeft() {
        return usageLeft;
    }

    /**
     * Resets usageLeft back to usageLimit
     */
    public void refresh() {
        usageLeft = usageLimit;
    }

    /**
     * checks whether character can use skill
     * 
     * @param me  the character you're playing as
     * @param foe the monster you're facing
     **/
    public void useSkill(CodeMonster me, CodeMonster foe) {
        if (usageLeft != 0) {
            usageLeft -= 1;
            applyChanges(me, foe);
        }
    }

    /**
     * Updates the state of the CodeMonster to reflect damage taken
     * 
     * @param me  the character you're playing as
     * @param foe the monster you're facing
     */
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        foe.adjustHealth(-strength);
    }

    public String toString() {
        return (name + " " + usageLeft + "/" + usageLimit);
    }
}