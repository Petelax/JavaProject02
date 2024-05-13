package javaproject02;

import java.util.Random;

import javaproject02.engine.*;
import javaproject02.engine.Character;

public class Game {
    private Menu menu;
    private Player player;
    private SaveFile saveFile;
    public Game() {
        init();
    }

    private void init() {
        menu = Menu.getInstance();
        saveFile = new SaveFile();
        player = new Player("Player", new CharacterStats(10, 2), new Inventory(2, 1));
    }

    public void run() {
        levelOne();

    }

    public void levelOne() {
        System.out.println("You have entered the dungeon.");
        System.out.println("Before you stands two doors: the left door appears as a normal door and the right door has skulls on it.");

        int door = menu.ask(new String[]{"Left door", "Right door"});

        switch (door) {
            case 0:
                System.out.println("You encountered a goblin!");
                Fight goblin = new Fight(player, new Character("Goblin", 5, 2));
                var result = goblin.getResults();
                if (!result) {
                    System.out.println("You died!");

                }
                
                break;
        
            case 1:

                break;

            default:
                break;
        }

    }

    private SaveData getSaveData() {
        return new SaveData("test", player);
    }
    
}
