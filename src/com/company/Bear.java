package com.company;

import java.util.Random;

public class Bear extends Monsters {
    Random rand = new Random();

    public Bear(int health, int damage, String damageInfo, String name){
        super(health,damage, damageInfo, name);
    }

    @Override
    public void information() {
        System.out.println("The bear has " + health + " health and can hit for 18-25 damage");
        System.out.println("The special ability is called Bleed and it deals 4 damage/turn");
    }
}
