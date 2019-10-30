package com.company;

import java.io.Serializable;
import java.util.Random;

/**
 * The wizard you play in the game
 */
public class Wizard extends Character implements Serializable {

    /**
     * <h1>Wizard</h1>
     * This will create your wizard that you play with in the game
     * @param health Shows the health of your wizard
     * @param damage The damage you deal to targets
     * @param level Indicates what level the wizard is
     * @param mana Shows how much mana the wizard has so you can shoot abilities
     * @param damageInfo Shows how much the wizard can deal
     * @param role Indicates that this is a wizard
     * @param name The name of the wizard
     */
    public Wizard(int health, int damage, double level, int mana, String damageInfo, String role, String name){
        super(health, damage, level, mana, damageInfo, role, name);


    }

    /**
     * Information about the character
     */
    @Override
    public void information() {
        System.out.println("The Wizard uses a wand to kill their targets");
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damageInfo);
    }

    /**
     * The health of wizard
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the wizards max health after he levels up
     * @param wizardMaxHealth The max health of the wizard
     */
    public void setHealth(int wizardMaxHealth) {
        this.health = wizardMaxHealth;
    }

    /**
     * The damage of the wizard
     * @return damage
     */
    public int getDamage(){
        Random rand = new Random();
        return damage = rand.nextInt(7 - 4 + 1) + 4;
    }
}
