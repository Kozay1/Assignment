package com.company;

import java.util.Random;

/**
 * Creates the monster "Dragon"
 */
public class Dragon extends Monsters {

    /**
     * <h1>Dragon</h1>
     * This will create the monster "dragon"
     * @param health The health of dragon
     * @param damage The damage of dragon
     * @param damageInfo Info about how much damages the dragon deals
     * @param name The name of the monster so user knows who he is fighting
     */
    public Dragon(int health, int damage, String damageInfo, String name){
        super(health, damage, damageInfo, name);
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The dragon has " + health + " health and can hit for 17-25 damage");
    }

    public int getDragonDamage() {
        return damage = rand.nextInt(25 - 17 + 1) + 17;
    }
}
