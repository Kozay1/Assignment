package com.company;

import java.io.Serializable;

public abstract class Character extends Creature implements Serializable {
    double level;
    public Character(int health, int damage, double level, String damageInfo){
        super(health, damage, damageInfo);
        this.level = level;

    }
}
