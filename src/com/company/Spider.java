package com.company;

import java.util.Random;

public class Spider extends Monsters {
    Random rand = new Random();
    public Spider(int health, int damage, String damageInfo, String name){
        super(health, damage, damageInfo, name);
    }

    @Override
    public void information() {
        System.out.println("The spider has " + health + " health and can hit for 5-7 damage");
        System.out.println("The special ability is called Poison and it deals 2 damage/turn");
    }
}
