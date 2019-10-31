package com.company;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @org.junit.jupiter.api.Test
    void useHealthPotion() {
        Wizard wizard = new Wizard(25, 0, 1, 50, "4-7", "Wizard", "");
        int healAmount = 20;

        boolean result = (wizard.health + healAmount) == 25;
        assertFalse(result);

        result = ((wizard.health = 5) + healAmount) == 25;
        assertTrue(result);

        result = ((wizard.health = 4) + healAmount) == 24;
        assertTrue(result);

        result = ((wizard.health = 3) + healAmount) == 23;
        assertTrue(result);

        result = ((wizard.health = 2) + healAmount) == 22;
        assertTrue(result);

        result = ((wizard.health = 1) + healAmount) == 21;
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void useMediumHealthPotion() {
        Wizard wizard = new Wizard(45, 0, 5, 100, "4-7", "Wizard", "");
        int bigHealAmount = 30;

        boolean result = (wizard.health + bigHealAmount) == 45;
        assertFalse(result);

        result = ((wizard.health = 15) + bigHealAmount) == 45;
        assertTrue(result);

        result = ((wizard.health = 12) + bigHealAmount) == 42;
        assertTrue(result);

        result = ((wizard.health = 10) + bigHealAmount) == 40;
        assertTrue(result);

        result = ((wizard.health = 5) + bigHealAmount) == 35;
        assertTrue(result);

        result = ((wizard.health = 1) + bigHealAmount) == 31;
        assertTrue(result);

    }

    @org.junit.jupiter.api.Test
    void useManaPotion() {
        Wizard wizard = new Wizard(25, 0, 1, 50, "4-7", "Wizard", "");
        int manaAmount = 25;

        boolean result = (wizard.mana + manaAmount) == 50;
        assertFalse(result);

        result = ((wizard.mana = 0) + manaAmount) == 25;
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void useBigManaPotion() {
        Wizard wizard = new Wizard(45, 0, 5, 100, "4-7", "Wizard", "");
        int manaAmount = 50;

        boolean result = (wizard.mana + manaAmount) == 100;
        assertFalse(result);

        result = ((wizard.mana = 0) + manaAmount) == 50;
        assertTrue(result);

        result = ((wizard.mana = 50) + manaAmount) == 100;
        assertTrue(result);

    }

    @Test
    void dropChanceManaAndHealth() {
        int numOfBigManaPotions = 0;
        int manaPotionDropChance = 50;
        int randomNumber = 55;
        int numOfManaPotions = 0;
        int numOfBigHealthPotions = 0;
        int healPotionDropChance = 50;
        int numOfHealthPotions = 0;

        //Test drop chance for big mana potions
        if (randomNumber > manaPotionDropChance) {
            int resultDropChance = numOfBigManaPotions + 1;
            numOfBigManaPotions++;
            assertEquals(resultDropChance, numOfBigManaPotions);
        }
        if (randomNumber < manaPotionDropChance) {
            int resultDropChance = numOfBigManaPotions + 0;
            assertEquals(numOfBigManaPotions, resultDropChance);
        }

        //The drop chance for small mana potions
        if (randomNumber > manaPotionDropChance) {
            int resultDropChance = numOfManaPotions + 1;
            numOfManaPotions++;
            assertEquals(resultDropChance, numOfManaPotions);
        }
        if (randomNumber < manaPotionDropChance) {
            int resultDropChance = numOfManaPotions + 0;
            assertEquals(numOfManaPotions, resultDropChance);
        }

        //Drop chance for big health potions
        if (randomNumber > healPotionDropChance) {
            int resultDropChance = numOfBigHealthPotions + 1;
            numOfBigHealthPotions++;
            assertEquals(resultDropChance, numOfBigHealthPotions);
        }
        if (randomNumber < healPotionDropChance) {
            int resultDropChance = numOfBigHealthPotions + 0;
            assertEquals(numOfBigHealthPotions, resultDropChance);
        }

        //Drop chance for small health potions
        if (randomNumber > healPotionDropChance) {
            int resultDropChance = numOfHealthPotions + 1;
            numOfHealthPotions++;
            assertEquals(resultDropChance, numOfHealthPotions);
        }
        if (randomNumber < healPotionDropChance) {
            int resultDropChance = numOfHealthPotions + 0;
            assertEquals(numOfHealthPotions, resultDropChance);
        }
    }
}