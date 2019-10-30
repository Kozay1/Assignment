package com.company;

import java.io.Serializable;

public abstract class Creature implements Serializable {
    int health;
    int damage;
    String damageInfo;
    String name;
    public Creature(int health, int damage, String damageInfo, String name){
        this.health = health;
        this.damage = damage;
        this.damageInfo = damageInfo;
        this.name = name;
    }

    public abstract void information();

}
