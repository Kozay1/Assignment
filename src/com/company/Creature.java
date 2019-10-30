package com.company;

import java.io.Serializable;

/**
 * The super class of Character and Monsters
 */
public abstract class Creature implements Serializable {
    int health;
    int damage;
    String damageInfo;
    String name;

    /**
     * <h1>Creature</h1>
     * Handles "Character" and "Monsters"
     *
     * @param health     Makes sure all monsters and characters has a health
     * @param damage     Makes sure all monsters and characters can deal damage
     * @param damageInfo All monsters and characters gets a damage info to know how much damage they deal
     * @param name       All monsters and characters can have a name
     */
    public Creature(int health, int damage, String damageInfo, String name) {
        this.health = health;
        this.damage = damage;
        this.damageInfo = damageInfo;
        this.name = name;
    }

    public abstract void information();

}
