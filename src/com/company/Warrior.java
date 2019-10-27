package com.company;

import java.io.Serializable;
import java.util.Random;
public class Warrior extends Character implements Serializable {

    Random rand = new Random();
    public Warrior(int health, int damage, double level, String damageInfo, String role, String name){
        super(health, damage, level, damageInfo, role, name);
    }

    @Override
    public void information() {
        System.out.println("The Warrior uses a sword to kill their targets");
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damageInfo);
    }

    public int getDamage(){
        Random rand = new Random();
        return damage = rand.nextInt(7 - 4 + 1) + 4;
    }
}
