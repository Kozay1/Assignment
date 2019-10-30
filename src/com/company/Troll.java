package com.company;

import java.util.Random;

/**
 * Creates the monster "Troll"
 */
public class Troll extends Monsters {

    /**
     * <h1>Troll</h1>
     * This will create the monster "troll"
     *
     * @param health     The health of troll
     * @param damage     The damage of troll
     * @param damageInfo Info about how much damages the troll deals
     * @param name       The name of the monster so user knows who he is fighting
     */
    public Troll(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The troll has " + health + " health and can hit for 7-11 damage");
    }

    public int getTrollDamage() {
        return damage = rand.nextInt(11 - 7 + 1) + 7;
    }
}
