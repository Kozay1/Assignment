package com.company;

import java.util.Random;
public class Warrior extends Character{

    Random rand = new Random();
    public Warrior(int health, int damage, double level, String damageInfo){
        super(health, damage, level, damageInfo);
    }

    @Override
    public void information() {
        System.out.println("The Warrior uses a sword to kill their targets");
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damageInfo);
    }
}
