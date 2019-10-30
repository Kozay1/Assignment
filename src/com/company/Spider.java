package com.company;

import java.util.Random;

/**
 * Creates the monster "Spider"
 */
public class Spider extends Monsters {

    /**
     * <h1>Spider</h1>
     * This will create the monster "spider"
     * @param health The health of spider
     * @param damage The damage of spider
     * @param damageInfo Info about how much damages the spider deals
     * @param name The name of the monster so user knows who he is fighting
     */
    public Spider(int health, int damage, String damageInfo, String name){
        super(health, damage, damageInfo, name);
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The spider has " + health + " health and can hit for 3-5 damage");
    }

    public int getSpiderDamage() {
        return damage = rand.nextInt(5 - 3 + 1) + 3;
    }
}
