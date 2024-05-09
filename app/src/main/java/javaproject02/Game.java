package javaproject02;

import javaproject02.engine.*;

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
        player = new Player("player", new CharacterStats(10, 2));
    }

    public void run() {
        saveFile.writeSave(getSaveData());

        var answer = menu.ask(new String[]{"hi", "yo", "dab", "lol"});

        System.out.println(answer);

        saveFile.readSave("test");

    }

    private SaveData getSaveData() {
        return new SaveData("test", player);
    }
    
}
