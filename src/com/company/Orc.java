package com.company;

import java.util.Random;

public class Orc extends Monsters {

    Random rand = new Random();
    public Orc(int health, int damage, String damageInfo, String name){
        super(health, damage, damageInfo, name);
    }

    @Override
    public void information() {
        System.out.println("The orc has " + health + " health and can hit for 20-35 damage");
        System.out.println("The special ability is called Block and will block the attack");
    }
}
