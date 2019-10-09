package com.company;

import java.util.Random;
public class Hunter extends Character {

    Random rand = new Random();
    public Hunter(int health, int damage, double level, String damageInfo){
        super(health, damage, level, damageInfo);
    }

    @Override
    public void information() {
        System.out.println("The Hunter uses a bow to kill their targets");
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damageInfo);
    }

}
