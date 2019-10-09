package com.company;

public abstract class Creature {
    public int health;
    public int damage;
    public String damageInfo;
    public Creature(int health, int damage, String damageInfo){
        this.health = health;
        this.damage = damage;
        this.damageInfo = damageInfo;
    }

    public abstract void information();

}
