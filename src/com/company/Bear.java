package com.company;

import java.util.Random;

/**
 * Creates the monster "Bear"
 */
public class Bear extends Monsters {

    /**
     * <h1>Bear</h1>
     * This will create the monster "bear"
     * @param health The health of bear
     * @param damage The damage of bear
     * @param damageInfo Info about how much damages the bear deals
     * @param name The name of the monster so user knows who he is fighting
     */
    public Bear(int health, int damage, String damageInfo, String name){
        super(health,damage, damageInfo, name);
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The bear has " + health + " health and can hit for 13-20 damage");
    }

    public int getBearDamage() {
        return damage = rand.nextInt(20 - 13 + 1) + 13;
    }
}
