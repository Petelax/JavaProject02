package javaproject02;

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
        player = new Player("player", new CharacterStats(10, 2), new Inventory(1));
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
                Fight goblin = new Fight(player, new Character("goblin", 5, 1));
                
                break;
        
            case 1:

                break;

            default:
                break;
        }
        System.out.println(door);

    }

    private SaveData getSaveData() {
        return new SaveData("test", player);
    }
    
}
