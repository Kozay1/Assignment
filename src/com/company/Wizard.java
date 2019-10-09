package com.company;

import java.util.Random;

public class Wizard extends Character {

    int health;
    Random rand = new Random();
    public Wizard(int health, int damage, double level, String damageInfo){
        super(health, damage, level, damageInfo);
        this.health = health;
    }

    @Override
    public void information() {
        System.out.println("The Wizard uses a wand to kill their targets");
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damageInfo);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
