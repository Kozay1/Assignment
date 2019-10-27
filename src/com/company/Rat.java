package com.company;
import java.util.Random;

public class Rat extends Monsters{
    Random rand = new Random();

    public Rat(int health, int damage, String damageInfo, String name){
        super(health, damage, damageInfo, name);
    }

    @Override
    public void information() {
        System.out.println("The rat has " + health + " health and can hit for 1-3 damage");
        System.out.println("The special ability is called Bite and it deals 4 damage");
    }

    public int getRatDamage() {
        return damage = rand.nextInt(3 - 1 + 1) + 1;
    }
}
