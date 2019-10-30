package com.company;

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
}