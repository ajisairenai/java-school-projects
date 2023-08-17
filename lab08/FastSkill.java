/**
 * FastSkill class file.
 * Written by Hydreesia.
 */
public class FastSkill extends Skill {
    public FastSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    /**
     * damages CodeMonster by strength and passes the next turn to itself again
     */
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        foe.adjustHealth((getStrength() * -1));
        me.setNextTurnTime(me.getNextTurnTime() - me.getSpeedScore());
    }
}