package com.company;

import java.util.Random;

/**
 * Creates the monster "Orc"
 */
public class Orc extends Monsters {

    /**
     * <h1>Orc</h1>
     * This will create the monster "orc"
     *
     * @param health     The health of orc
     * @param damage     The damage of orc
     * @param damageInfo Info about how much damages the orc deals
     * @param name       The name of the monster so user knows who he is fighting
     */
    public Orc(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The orc has " + health + " health and can hit for 15-22 damage");
    }

    public int getOrcDamage() {
        return damage = rand.nextInt(22 - 15 + 1) + 15;
    }
}
