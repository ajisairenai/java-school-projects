/**
 * VampiricSkill class file.
 * Written by Hydreesia.
 */
public class VampiricSkill extends Skill {
    public VampiricSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    /**
     * Heals the CodeMonster to it's strength and damages the foe by the same
     * strength.
     */
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        me.adjustHealth(getStrength());
        foe.adjustHealth((getStrength() * -1));
    }
}