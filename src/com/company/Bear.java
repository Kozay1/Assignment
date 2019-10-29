package com.company;

import java.util.Random;

public class Bear extends Monsters {
    Random rand = new Random();

    public Bear(int health, int damage, String damageInfo, String name){
        super(health,damage, damageInfo, name);
    }

    @Override
    public void information() {
        System.out.println("The bear has " + health + " health and can hit for 13-20 damage");
    }

    public int getBearDamage() {
        return damage = rand.nextInt(20 - 13 + 1) + 13;
    }
}
