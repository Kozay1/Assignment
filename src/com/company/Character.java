package com.company;

public abstract class Character extends Creature {
    double level;
    public Character(int health, int damage, double level, String damageInfo){
        super(health, damage, damageInfo);
        this.level = level;

    }
}
