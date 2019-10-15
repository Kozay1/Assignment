package com.company;

import java.util.*;

public class Program {

    private static final int MAX_CHARACTERS = 1;
    Rat rat = new Rat(10, 0, "1-3", "Rat");
    Spider spider = new Spider(15, 0, "5-7", "Spider");
    Troll troll = new Troll(25, 0, "10-15", "Troll");
    Bear bear = new Bear(50, 0, "18-25", "Bear");
    Orc orc = new Orc(85, 0, "20-35", "Orc");
    Dragon dragon = new Dragon(150, 0, "40-65", "Dragon");

    Wizard wizard = new Wizard(25, 0, 1, "4-7", "Wizard", "");
    Warrior warrior = new Warrior(35, 0, 1, "3-5", "Warrior", "");
    Hunter hunter = new Hunter(25, 0, 1, "4-7", "Hunter", "");

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    private int numOfCharacters = 0;
    private int numOfHealthPotions = 1;
    private int healAmount = 20;
    private int healthPotionDropChance = 50;
    private ArrayList<Character> characters = new ArrayList<>();
    private ArrayList<Monsters> monsters = new ArrayList<>();
    private String name;
    private String getCharacter;

    public Program() {

    }

    public void showMainMenu() {
        System.out.println("1: Play the game\n" +
                "2: Create new character\n" +
                "3: View character\n" +
                "4: Class information\n" +
                "5: View monsters\n" +
                "6: Save and load character\n" +
                "7: Remove character\n" +
                "0: Exit");
        System.out.println("Enter your menu choice:");
        String menuChoice = scan.nextLine();

        do {
            switch (menuChoice) {
                case "1":
                    playTheGame();
                    break;

                case "2":
                    createCharacter(); //Done
                    break;

                case "3":
                    viewCharacters(); //Done
                    break;

                case "4":
                    classInformation(); //Done
                    break;

                case "5":
                    viewMonsters(); //Done
                    break;

                case "6":
                    saveAndLoadCharacter();
                    break;

                case "7":
                    removeCharacter(); //Done
                    break;

                case "0":
                    exit(); //Done
                    break;
            }
        } while (!menuChoice.equals("0"));
    }

    public void playTheGame() {
        if (characters.size() == 0) {
            System.out.println("You need to create a character");
            showMainMenu();
        }

        if (wizard.role.equalsIgnoreCase("wizard")) {
            System.out.println("You are now entering the dungeon, if you die you lose your character!");
            while (rat.health > 0 && wizard.health > 0 && wizard.level < 2.5) {
                System.out.println("You are fighting a rat\n" +
                        "1: Attack\n" +
                        "2: Use health potion (20hp)\n" +
                        "0: Leave dungeon");
                String userInput = scan.nextLine();
                int wizardDamage = rand.nextInt(7 - 4 + 1) + 4;
                int ratDamage = rand.nextInt(3 - 1 + 1) + 1;

                switch (userInput) {
                    case "1":
                        System.out.println("You attack the rat for " + wizardDamage + " damage");
                        System.out.println("The rat attacks you for " + ratDamage + " damage");

                        rat.health -= wizardDamage;
                        wizard.health -= ratDamage;
                        System.out.println("Your health: " + wizard.health);
                        System.out.println("Enemy health: " + rat.health);

                        if (wizard.health <= 0) {
                            System.out.println("You lost the fight and your character is dead");
                            characters.remove(0);
                            showMainMenu();
                        } else if (rat.health <= 0) {
                            System.out.println("You won the fight");
                            wizard.level += 0.5;
                            System.out.println("Your level is now " + wizard.level + " and your strength is growing");
                            rat.health = 10;
                            if (rand.nextInt(100) > healthPotionDropChance) {
                                numOfHealthPotions++;
                                System.out.println("You got a health potion, you now have " + numOfHealthPotions + " health potions");
                            }
                        }
                        break;

                    case "2":
                        if (numOfHealthPotions == 0) {
                            System.out.println("You are out of health potions\n" +
                                    "Kill monsters for a chance to get more");
                        } else {
                            if (wizard.health == 25) {
                                System.out.println("You already have full health");
                            } else if (5 <= wizard.health) {
                                System.out.println("You consume a health potion");
                                wizard.setHealth(25);
                                numOfHealthPotions--;
                                System.out.println("You have " + numOfHealthPotions + " left");
                            } else {
                                System.out.println("You consume a health potion");
                                wizard.health += healAmount;
                                numOfHealthPotions--;
                                System.out.println("You have " + numOfHealthPotions + " left");
                            }
                        }
                        break;

                    case "0":
                        System.out.println("You manage to escape the rat");
                        showMainMenu();
                        break;
                }

            }



        if (wizard.level == 2.5) {
            System.out.println("You encounter a troll");
            wizard.setHealth(35);
            while (troll.health > 0 && wizard.health > 0 && wizard.level < 2.5) {
                System.out.println("You are fighting a troll\n" +
                        "1: Attack\n" +
                        "2: Use health potion (20hp)\n" +
                        "0: Leave dungeon");
                String userInput = scan.nextLine();
                int wizardDamage = rand.nextInt(7 - 4 + 1) + 4;
                int ratDamage = rand.nextInt(3 - 1 + 1) + 1;
                switch (userInput) {
                    case "1":
                        System.out.println("You attack the rat for " + wizardDamage + " damage");
                        System.out.println("The rat attacks you for " + ratDamage + " damage");

                        rat.health -= wizardDamage;
                        wizard.health -= ratDamage;
                        System.out.println("Your health: " + wizard.health);
                        System.out.println("Enemy health: " + rat.health);

                        if (wizard.health <= 0) {
                            System.out.println("You lost the fight and your character is dead");
                            characters.remove(0);
                            showMainMenu();
                        } else if (rat.health <= 0) {
                            System.out.println("You won the fight");
                            wizard.level += 0.5;
                            System.out.println("Your level is now " + wizard.level + " and your strength is growing");
                            rat.health = 10;
                            if (rand.nextInt(100) > healthPotionDropChance) {
                                numOfHealthPotions++;
                                System.out.println("You got a health potion, you now have " + numOfHealthPotions + " health potions");
                            }
                        }
                        break;

                    case "2":
                        if (numOfHealthPotions == 0) {
                            System.out.println("You are out of health potions\n" +
                                    "Kill monsters for a chance to get more");
                        } else {
                            if (wizard.health == 25) {
                                System.out.println("You already have full health");
                            } else if (5 <= wizard.health) {
                                System.out.println("You consume a health potion");
                                wizard.setHealth(25);
                                numOfHealthPotions--;
                                System.out.println("You have " + numOfHealthPotions + " left");
                            } else {
                                System.out.println("You consume a health potion");
                                wizard.health += healAmount;
                                numOfHealthPotions--;
                                System.out.println("You have " + numOfHealthPotions + " left");
                            }
                        }
                        break;

                    case "0":
                        System.out.println("You manage to escape the rat");
                        showMainMenu();
                        break;
                }

            }

        }
        showMainMenu();

        } else if (warrior.role.equalsIgnoreCase("warrior")) {
            System.out.println("You are now entering the dungeon with " + warrior.name + " the " + warrior.role);
            showMainMenu();
        } else if (hunter.role.equalsIgnoreCase("hunter")) {
            System.out.println("You are now entering the dungeon with " + hunter.name + " the " + hunter.role);
            showMainMenu();
        }

    }

    public void createCharacter() {
        if (numOfCharacters < MAX_CHARACTERS) {
            System.out.println("Enter the name of you character: ");
            wizard.name = scan.nextLine();

            System.out.println("What character do you want to play?\n" +
                    "1: Wizard\n" +
                    "2: Warrior\n" +
                    "3: Hunter\n" +
                    "0: Main menu");
            getCharacter = scan.nextLine();
            switch (getCharacter) {
                case "1":
                    numOfCharacters++;
                    characters.add(wizard);
                    System.out.println("You created a wizard called " + wizard.name);
                    showMainMenu();
                    break;
                case "2":
                    numOfCharacters++;
                    characters.add(warrior);
                    System.out.println("You created a warrior called " + wizard.name);
                    showMainMenu();
                    break;
                case "3":
                    numOfCharacters++;
                    characters.add(hunter);
                    System.out.println("You created a hunter called " + wizard.name);
                    showMainMenu();
                    break;
                case "0":
                    showMainMenu();
                    break;
            }
        }
        else {
            System.out.println("You already have a character");
            showMainMenu();
        }
    }

    public void viewCharacters() {

        if (characters.size() == 0) {
            System.out.println("You need to create a character");
            showMainMenu();
        }
        for (Character character : characters) {
            System.out.println(wizard.name + " " + character);
        }
        showMainMenu();
    }

    public void classInformation() {
        System.out.println("1: Wizard information\n" +
                "2: Warrior information\n" +
                "3: Hunter information\n" +
                "0: Main menu");

        String userInput = scan.nextLine();
        do {
            switch (userInput) {
                case "1":
                    wizard.information();
                    break;

                case "2":
                    warrior.information();
                    break;

                case "3":
                    hunter.information();
                    break;

                case "0":
                    showMainMenu();
                    break;
            }
        } while (userInput.equals("0"));
    }

    public void viewMonsters() {
        monsters.add(orc);
        monsters.add(rat);
        monsters.add(spider);
        monsters.add(dragon);
        monsters.add(bear);
        monsters.add(troll);
        System.out.println("This is the list of all the monsters in the game:");
        for (Monsters monster : monsters) {
            System.out.println(monster);
        }

        String userInput = "";
        while (!userInput.equals("0")) {
            System.out.println("1: Sort by name\n" +
                    "2: Sort by health and damage\n" +
                    "0: Main menu");
            userInput = scan.nextLine();

            switch (userInput) {
                case "1":
                    SortMonstersName sortMonstersName = new SortMonstersName();

                    Collections.sort(monsters, sortMonstersName);

                    for (Monsters monster : monsters) {
                        System.out.println(monster);
                    }
                    break;

                case "2":
                    SortMonstersHealth sortMonstersHealth = new SortMonstersHealth();

                    Collections.sort(monsters, sortMonstersHealth);

                    for (Monsters monster : monsters) {
                        System.out.println(monster);
                    }
                    break;

                case "0":
                    monsters.clear();
                    showMainMenu();
                    break;
            }
        }
    }

    public void saveAndLoadCharacter() {

        String userInput = "";
        while (!userInput.equals("0")) {
            System.out.println("1: Save your current character(This will override any other saved character)\n" +
                    "2: Load a character that you have saved\n" +
                    "0: Main menu");
            userInput = scan.nextLine();
            switch (userInput) {
                case "1":
                    if (numOfCharacters < MAX_CHARACTERS) {
                        System.out.println("You need to create a character before you can save.");
                        saveAndLoadCharacter();
                    } else {
                        FileUtils.writeObject("characterSave.ser", characters);
                        System.out.println("You saved your character");
                    }
                    break;

                case "2":
                    numOfCharacters++;
                    ArrayList<Character> charactersFromFile = FileUtils.readObject("characterSave.ser");
                    for (Character character : charactersFromFile) {
                        System.out.println(character);
                    }
                    saveAndLoadCharacter();
                    break;


                case "0":
                    showMainMenu();
                    break;
            }

        }
    }

    public void removeCharacter() {
        if (characters.size() == 0) {
            System.out.println("You need to create a character");
            showMainMenu();
        } else {
            System.out.println("This is your current character");
            for (Character character : characters) {
                System.out.println("1: " + character);
            }
            System.out.println("Write 1 to remove your character");
            System.out.println("Write 0 to go back to main menu");
            String userInput = scan.nextLine();

            if (userInput.equals("1")) {
                characters.remove(0);
                numOfCharacters--;
                System.out.println("Character successfully removed");
            } else if (userInput.equals("0")) {
                showMainMenu();
            } else {
                System.out.println("Wrong input, try again");
                removeCharacter();
            }
        }


    }

    public void exit() {
        System.out.println("Thanks for playing my game.");
        System.exit(0);
    }
}