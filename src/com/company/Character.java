package com.company;

import java.io.Serializable;

public abstract class Character extends Creature implements Serializable {
    double level;
    String role;
    public Character(int health, int damage, double level, String damageInfo, String role, String name){
        super(health, damage, damageInfo, name);
        this.level = level;
        this.role = role;
    }

    @Override
    public String toString() {
        return name + " the " + role + " has " + health + "hp and is level " + level;
    }
}
