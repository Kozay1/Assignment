package com.company;

import java.io.Serializable;

public abstract class Character extends Creature implements Serializable {
    double level;
    int mana;
    String role;
    public Character(int health, int damage, double level, int mana, String damageInfo, String role, String name){
        super(health, damage, damageInfo, name);
        this.role = role;
        this.level = level;
        this.mana = mana;
    }

    @Override
    public String toString() {
        return name + " the " + role + " has " + health + "hp and is level ";
    }
}
