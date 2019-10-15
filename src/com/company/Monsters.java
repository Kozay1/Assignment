package com.company;

import java.util.ArrayList;

public abstract class Monsters extends Creature {

    String name;
    public Monsters(int health, int damage, String damageInfo, String name){
        super(health, damage, damageInfo, name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": Health: " + health + " Damage: " + damageInfo;
    }
}
