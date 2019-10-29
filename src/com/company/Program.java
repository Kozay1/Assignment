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

    Wizard wizard = new Wizard(25, 0, 1, 50, "4-7", "Wizard", "");

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    private int numOfCharacters = 0;
    private int numOfHealthPotions = 1;
    private int numOfManaPotions = 1;
    private int manaAmount = 25;
    private int manaPotionDropChance = 50;
    private int healAmount = 20;
    private int healthPotionDropChance = 50;
    private ArrayList<Character> characters = new ArrayList<>();
    private ArrayList<Monsters> monsters = new ArrayList<>();
    private String name;
    private int monsterHealth;
    private int monsterDamage;
    private String monsterName;
    private String monsterDamageInfo;

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

        while (rat.health > 0 && wizard.getHealth() > 0 && wizard.level < 2.5) {
            System.out.println("Health: " + wizard.health + "            " + "Enemy Health: " + rat.health + "\n" +
                    "Mana: " + wizard.mana + "             " + "Enemy Damage: " + rat.damageInfo + "\n" +
                    "Health potions: " + numOfHealthPotions + "\n" +
                    "Mana potions: " + numOfManaPotions + "\n");
            System.out.println("You are fighting a rat\n" +
                    "1: Attack\n" +
                    "2: Fireball\n" +
                    "3: Use health potion (20hp)\n" +
                    "4: Use mana potion (25mana)\n" +
                    "0: Leave dungeon");
            String userInput = scan.nextLine();
            int wizardDamage = wizard.getDamage();
            int ratDamage = rat.getRatDamage();

            switch (userInput) {
                case "1":
                    rat.health -= wizard.getDamage();
                    wizard.health -= ratDamage;

                    System.out.println("You attack the rat for " + wizardDamage + " damage");
                    System.out.println("The rat attacks you for " + ratDamage + " damage");

                    if (wizard.health <= 0) {
                        System.out.println("You lost the fight and your character is dead");
                        characters.remove(0);
                        showMainMenu();
                    } else if (rat.health <= 0) {
                        System.out.println("You won the fight");
                        wizard.level += 0.5;
                        System.out.println("Your level is now " + wizard.level + " and your strength is growing");
                        rat.health = 10;
                        dropChanceManaAndHealth();
                    }
                    break;

                case "2":
                    if(wizard.mana < 25){
                        System.out.println("You don't have enough mana");
                    }
                    int fireball = rand.nextInt(20 - 15 + 1) + 15;
                    wizard.mana -= 25;

                    rat.health -= fireball;
                    wizard.health -= ratDamage;

                    System.out.println("You shoot a fireball that deals " + fireball + " damage");
                    if (wizard.health <= 0) {
                        System.out.println("You lost the fight and your character is dead");
                        characters.remove(0);
                        showMainMenu();
                    }
                    else if (rat.health <= 0) {
                        System.out.println("You won the fight");
                        wizard.level += 0.5;
                        System.out.println("Your level is now " + wizard.level + " and your strength is growing\n");
                        rat.health = 10;
                        dropChanceManaAndHealth();
                    }
                    break;

                case "3":
                  useHealthPotion();
                    break;

                case "4":
                    useManaPotion();
                    break;

                case "0":
                    System.out.println("You manage to escape");
                    showMainMenu();
                    break;
            }
        }

        wizard.setHealth(40);
        wizard.mana = 100;
        getRandomMonster();
        while (monsterHealth > 0 && wizard.getHealth() > 0 && wizard.level < 10) {
            System.out.println("Health: " + wizard.health + "            " + "Enemy Health: " + monsterHealth + "\n" +
                    "Mana: " + wizard.mana + "             " + "Enemy Damage: " + monsterDamageInfo + "\n" +
                    "Health potions: " + numOfHealthPotions + "\n" +
                    "Mana potions: " + numOfManaPotions + "\n");
            System.out.println("You are fighting a " + monsterName +"\n"+
                    "1: Attack\n" +
                    "2: Fireball\n" +
                    "3: Use health potion (20hp)\n" +
                    "4: Use mana potion (25mana)\n" +
                    "0: Leave dungeon");
            String userInput = scan.nextLine();
            int wizardDamage = rand.nextInt(10 - 7 + 1) + 7;;
            int randomDamage = monsterDamage;

            switch (userInput) {
                case "1":
                    monsterHealth -= wizard.getDamage();
                    wizard.health -= randomDamage;

                    System.out.println("You attack the rat for " + wizardDamage + " damage");
                    System.out.println("The rat attacks you for " + randomDamage + " damage");

                    if (wizard.health <= 0) {
                        System.out.println("You lost the fight and your character is dead");
                        characters.remove(0);
                        showMainMenu();
                    } else if (monsterHealth <= 0) {
                        System.out.println("You won the fight");
                        wizard.level += 0.5;
                        System.out.println("Your level is now " + wizard.level + " and your strength is growing");
                        getRandomMonster();
                        dropChanceManaAndHealth();
                    }
                    break;

                case "2":
                    if(wizard.mana < 25){
                        System.out.println("You don't have enough mana");
                    }
                    int fireball = rand.nextInt(28 - 20 + 1) + 20;
                    wizard.mana -= 25;

                    monsterHealth -= fireball;
                    wizard.health -= monsterDamage;

                    System.out.println("You shoot a fireball that deals " + fireball + " damage");
                    if (wizard.health <= 0) {
                        System.out.println("You lost the fight and your character is dead");
                        characters.remove(0);
                        showMainMenu();
                    }
                    else if (rat.health <= 0) {
                        System.out.println("You won the fight");
                        wizard.level += 0.5;
                        System.out.println("Your level is now " + wizard.level + " and your strength is growing\n");
                        getRandomMonster();
                        dropChanceManaAndHealth();
                    }
                    break;

                case "3":
                    useHealthPotion();
                    break;

                case "4":
                    useManaPotion();
                    break;

                case "0":
                    System.out.println("You manage to escape");
                    showMainMenu();
                    break;
            }
        }
    }

    public void useHealthPotion(){
        if (numOfHealthPotions == 0) {
            System.out.println("You are out of health potions\n" +
                    "Kill monsters for a chance to get more");
        }
        else if (wizard.health == 25) {
            System.out.println("You already have full health");

        }
        else if (wizard.health + healAmount > 25){
            wizard.setHealth(25);
            numOfHealthPotions--;
        }
        else{
            wizard.health += healAmount;
            numOfHealthPotions--;
        }
    }

    public void useManaPotion(){
        if (numOfManaPotions == 0) {
            System.out.println("You are out of mana potions\n" +
                    "Kill monsters for a chance to get more");
        }
        else if (wizard.mana == 50) {
            System.out.println("You already have full mana");

        }
        else if (wizard.mana + manaAmount > 50){
            wizard.mana = 50;
            numOfManaPotions--;
        }
        else{
            wizard.mana += manaAmount;
            numOfManaPotions--;
        }
    }

    public void dropChanceManaAndHealth(){
        if (rand.nextInt(100) > healthPotionDropChance) {
            numOfHealthPotions++;
            System.out.println("You got a health potion, you now have " + numOfHealthPotions + " health potions");
        }
        if (rand.nextInt(100) > manaPotionDropChance) {
            numOfManaPotions++;
            System.out.println("You got a mana potion, you now have " + numOfManaPotions + " mana potions");
        }
    }

    public void getRandomMonster(){
        int randomNumber = rand.nextInt(3) + 1;
        if(randomNumber == 1){
            monsterHealth = spider.health;
            monsterDamage = spider.getSpiderDamage();
            monsterName = spider.name;
            monsterDamageInfo = spider.damageInfo;
        }
        else if(randomNumber == 2){
            monsterHealth = troll.health;
            monsterDamage = troll.getTrollDamage();
            monsterName = troll.name;
            monsterDamageInfo = troll.damageInfo;
        }
        else if(randomNumber == 3) {
            monsterHealth = bear.health;
            monsterDamage = bear.getBearDamage();
            monsterName = bear.name;
            monsterDamageInfo = bear.damageInfo;
        }
    }

    public void createCharacter() {
        if (numOfCharacters < MAX_CHARACTERS) {
            System.out.println("Enter the name of you character: ");
            name = scan.nextLine();

            numOfCharacters++;
            wizard.name = name;
            characters.add(wizard);
            System.out.println("You created a wizard called " + name);
            showMainMenu();
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
                System.out.println(character + " " + wizard.level);
            showMainMenu();
        }
    }

    public void classInformation() {
                    wizard.information();
                    showMainMenu();
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
                    }
                    else {
                        FileUtils.writeObject("characterSave.ser", characters);
                        System.out.println("You saved your character");
                        showMainMenu();
                    }
                    break;

                case "2":
                    if (numOfCharacters >= MAX_CHARACTERS) {
                        System.out.println("You already have a character");
                        saveAndLoadCharacter();
                    }
                    numOfCharacters++;
                    ArrayList<Character> charactersFromFile = FileUtils.readObject("characterSave.ser");
                    for (Character character : charactersFromFile) {
                            characters.add(character);
                            wizard.level = character.level;
                            wizard.name = character.name;
                            wizard.role = character.role;
                            wizard.health = character.health;
                            wizard.mana = character.mana;
                            System.out.println("Successfully loaded your saved wizard");
                            showMainMenu();
                    }
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