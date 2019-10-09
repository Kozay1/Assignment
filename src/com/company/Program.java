package com.company;

import java.util.*;

public class Program {

    private static final int MAX_CHARACTERS = 1;
    private int numOfCharacters = 0;
    private int numOfHealthPotions = 1;
    private int healAmount = 20;
    private int healthPotionDropChance = 50;
    private ArrayList<String> characters = new ArrayList<>();
    private ArrayList<Monsters> monsters = new ArrayList<>();
    private String role;
    private String name;

    Rat rat = new Rat(10,0, "1-3","Rat");
    Spider spider = new Spider(15,0, "5-7","Spider");
    Troll troll = new Troll(25, 0, "10-15","Troll");
    Bear bear = new Bear(50,0, "18-25","Bear");
    Orc orc = new Orc(85,0, "20-35","Orc");
    Dragon dragon = new Dragon(150,0, "40-65","Dragon");


    Wizard wizard = new Wizard(25,1,1,"4-7");
    Warrior warrior = new Warrior(35,1,1,"3-5");
    Hunter hunter = new Hunter(25,1,1,"4-7");
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    public Program(){

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
        }while (!menuChoice.equals("0"));
    }

    public void playTheGame(){
        if(characters.size() == 0){
            System.out.println("You need to create a character");
            showMainMenu();
        }

        if(role.equalsIgnoreCase("wizard")) {
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
                                if(rand.nextInt(100) > healthPotionDropChance){
                                    numOfHealthPotions++;
                                    System.out.println("You got a health potion, you now have " + numOfHealthPotions + " health potions");
                                }
                            }
                            break;

                        case "2":
                            if (numOfHealthPotions == 0) {
                                System.out.println("You are out of health potions\n" +
                                        "Kill monsters for a chance to get more");
                            }
                            else {
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
                                if(rand.nextInt(100) > healthPotionDropChance){
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
        }

        else if(role.equalsIgnoreCase("warrior")){
            System.out.println("You are now entering the dungeon with " + name + " the " + role);
            showMainMenu();
        }
        else if(role.equalsIgnoreCase("hunter")){
            System.out.println("You are now entering the dungeon with " + name + " the " + role);
            showMainMenu();
        }

    }

    public void createCharacter(){
        if(numOfCharacters < MAX_CHARACTERS){
            System.out.println("Enter the name of you character: ");
            name = scan.nextLine();

            System.out.println("Write what role you want to play\n" +
                    "Wizard, (Write \"Wizard\" to play the class)\n" +
                    "Warrior, (Write \"Warrior\" to play the class)\n" +
                    "Hunter, (Write \"Hunter\" to play the class)");
            role = scan.nextLine();

            if(role.equalsIgnoreCase("wizard") || role.equalsIgnoreCase("warrior") || role.equalsIgnoreCase("hunter")){
                System.out.println("New character created: " + name + " the " + role.toLowerCase());
                numOfCharacters++;
                characters.add(name + " the " + role);
                showMainMenu();
            }
            else {
                System.out.println("Please enter a role that exists");
                createCharacter();
            }
        }
        else {
            System.out.println("You already have a characters");
            showMainMenu();
        }
    }

    public void viewCharacters(){

        if(characters.size() == 0){
            System.out.println("You need to create a character");
            showMainMenu();
        }
        if(role.equalsIgnoreCase("wizard")) {
            System.out.println("Here is information about your character:");
            System.out.println("Name: " + name + "\n" +
                    "Class: " + role + "\n" +
                    "Damage: " + wizard.damageInfo + "\n" +
                    "Level: " + wizard.level);
        }

        else if(role.equalsIgnoreCase("warrior")) {
            System.out.println("Here is information about your character:");
            System.out.println("Name: " + name + "\n" +
                    "Class: " + role + "\n" +
                    "Damage: " + warrior.damageInfo + "\n" +
                    "Level: " + warrior.level);
        }

        else if(role.equalsIgnoreCase("hunter")) {
            System.out.println("Here is information about your character:");
            System.out.println("Name: " + name + "\n" +
                    "Class: " + role + "\n" +
                    "Damage: " + hunter.damageInfo + "\n" +
                    "Level: " + hunter.level);
        }

        System.out.println("");
        showMainMenu();
    }

    public void classInformation(){
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
        }while (userInput.equals("0"));
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
        while (!userInput.equals("0")){
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

    public void saveAndLoadCharacter(){

        String userInput = "";
        while(!userInput.equals("0")){
            System.out.println("1: Save your current character(This will override any other saved character)\n" +
                    "2: Load a character that you have saved\n" +
                    "3: Main menu");
            userInput = scan.nextLine();
            switch (userInput){
                case "1":

                    if(role.equalsIgnoreCase("wizard")){
                        characters.add(name);
                        characters.add(role);
                        characters.add(Double.toString(wizard.level));
                        FileUtils.writeObject("wizardSave.ser", characters);
                    }

                    else if(role.equalsIgnoreCase("warrior")){
                        characters.add(name);
                        characters.add(role);
                        characters.add(Double.toString(warrior.level));
                        FileUtils.writeObject("warriorSave.ser", characters);

                    }

                    else if(role.equalsIgnoreCase("hunter")){
                        characters.add(name);
                        characters.add(role);
                        characters.add(Double.toString(hunter.level));
                        FileUtils.writeObject("hunterSave.ser", characters);
                    }
                    else {
                        System.out.println("Please enter a valid input");
                    }
                    break;

                case "2":

                    break;

                case "0":
                    showMainMenu();
                    break;
            }

        }
    }

    public void removeCharacter(){
        if(characters.size() == 0){
            System.out.println("You need to create a character");
            showMainMenu();
        }
        else {
            System.out.println("This is your current character");
            for (String i : characters) {
                System.out.println("1: " + i);
            }
            System.out.println("Write 1 to remove your character");
            System.out.println("Write 0 to go back to main menu");
            String userInput = scan.nextLine();

            if(userInput.equals("1")){
                characters.remove(0);
                numOfCharacters--;
                System.out.println("Character successfully removed");
            }
            else if(userInput.equals("0")){
                showMainMenu();
            }
            else {
                System.out.println("Wrong input, try again");
                removeCharacter();
            }
        }
    }

    public void exit(){
        System.out.println("Thanks for playing my game.");
        System.exit(0);
    }
}