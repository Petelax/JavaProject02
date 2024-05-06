package javaproject02;

import javaproject02.engine.Menu;

public class Game {
    private Menu menu;
    public Game() {
        init();
        run();
    }

    public void init() {
        menu = Menu.getInstance();
    }

    public void run() {
        var answer = menu.ask(new String[]{"hi", "yo", "dab", "lol"});

        System.out.println(answer);

    }
    
}
