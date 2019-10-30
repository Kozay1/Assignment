package com.company;
import java.util.Random;

/**
 * Creates the monster "Rat"
 */
public class Rat extends Monsters{
    /**
     * <h1>Rat</h1>
     * This will create the monster "rat"
     * @param health The health of rat
     * @param damage The damage of rat
     * @param damageInfo Info about how much damages the rat deals
     * @param name The name of the monster so user knows who he is fighting
     */
    public Rat(int health, int damage, String damageInfo, String name){
        super(health, damage, damageInfo, name);
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The rat has " + health + " health and can hit for 1-3 damage");
    }

    public int getRatDamage() {
        return damage = rand.nextInt(3 - 1 + 1) + 1;
    }
}
