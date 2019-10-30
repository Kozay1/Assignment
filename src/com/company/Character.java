package com.company;

import java.io.Serializable;

/**
 * Character is the super class of wizard
 */
public abstract class Character extends Creature implements Serializable {
    double level;
    int mana;
    String role;

    /**
     * <h1>Character</h1>
     * Handles the wizard
     *
     * @param health     The health of the character
     * @param damage     The damage the character deals
     * @param level      Indicates what level the character is
     * @param mana       Shows how much mana the character has
     * @param damageInfo Shows how much the character can hit for
     * @param role       The role of the character
     * @param name       The name of the character
     */
    public Character(int health, int damage, double level, int mana, String damageInfo, String role, String name) {
        super(health, damage, damageInfo, name);
        this.role = role;
        this.level = level;
        this.mana = mana;
    }

    @Override
    public String toString() {
        return name + " the " + role + " has " + health + "hp and is level ";
    }
}
