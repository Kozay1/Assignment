package com.company;

import java.util.Random;

public class Dragon extends Monsters {

    Random rand = new Random();
    public Dragon(int health, int damage, String damageInfo, String name){
        super(health, damage, damageInfo, name);
    }

    @Override
    public void information() {
        System.out.println("The dragon has " + health + " health and can hit for 40-65 damage");
        System.out.println("The special ability is called fireball and it deals 80 damage");
    }

}
