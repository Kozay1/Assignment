package com.company;

import java.io.Serializable;
import java.util.Random;
public class Wizard extends Character implements Serializable {

    int health;
    public Wizard(int health, int damage, double level, String damageInfo, String role, String name){
        super(health, damage, level, damageInfo, role, name);
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

    public void setHealth(int wizardMaxHealth) {
        this.health = wizardMaxHealth;
    }
}
