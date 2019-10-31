package com.company;

import java.util.ArrayList;

/**
 * The super class of all the monsters
 */
public abstract class Monsters extends Creature {
    /**
     * <h1>Monsters</h1>
     * Handles the wizard
     *
     * @param health     The health of the monsters
     * @param damage     The damage the monsters deal
     * @param damageInfo Shows how much the monsters can hit for
     * @param name       The name of the monsters
     */
    public Monsters(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    @Override
    public String toString() {
        return name + ": Health: " + health + " Damage: " + damageInfo;
    }
}
