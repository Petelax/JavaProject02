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
        System.out.println("What is your name?");
        var name = menu.nextString();
        player = new Player(name, new CharacterStats(10, 2), new Inventory(2, 1));
    }

    /**
     * start the game
     * @return true if won, false if died
     */
    public boolean run() {
        if (!levelOne()) return false; 
        checkpoint();

        if (!levelTwo()) return false;

        System.out.println("You have conquered the dungeon!");
        return true;
    }

    /**
     * first level
     * @return true if completed, false if failed
     */
    public boolean levelOne() {
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
                    return false;
                }
                
                break;
        
            case 1:
                System.out.println("You encountered a skeleton!");
                Fight skeleton = new Fight(player, new Character("Skeleton", 5, 3));
                var resultSkeleton = skeleton.getResults();
                if (!resultSkeleton) {
                    System.out.println("You died!");
                    return false;
                }

                break;

            default:
                break;
        }

        System.out.println("You enter the next room and find the wall inscribed with the text 'y=x²-2x+1'.");
        System.out.println("There are four doors that stand before you numbered -1, 0, 1, 2");

        int puzzle = menu.ask(new String[]{"Door numbered -1", "Door numbered 0", "Door numbered 1", "Door numbered 2"});

        if (puzzle != 2) {
            System.out.println("You enter the door and encounter a golem!");
            Fight golem = new Fight(player, new Character("Golem", 10, 1));
            var result = golem.getResults();
            if (!result) {
                System.out.println("You died!");
                return false;
            }
            
        }

        return true;
    }

    public boolean levelTwo() {
        System.out.println("As you push past the great slab of stone, you fall into a trap and can't go back!");
        System.out.println("You land in a cave appearing well inhabited");
        return true;
    }

    public void checkpoint() {
        int option = -1;
        while (option != 2) {
            System.out.println("You approach a large stone door with a campfire placed outside. You feel it's a good time to take a break");
            option = menu.ask(new String[]{"Rest at the campfire", "Upgrade your stats", "Exit camp and continue"});
            System.out.println("");

            switch (option) {
                case 0:
                    System.out.println("As you sit down by the warm fire, you feel your strength return to you (Health restored!)");
                    player.maxHeal();
                    break;

                case 1:
                    upgrade();
                    break;

                case 2:
                    
                    break;
            
                default:
                    break;
            }
        }

    }

    public void upgrade() {
        System.out.println("You have earned " + player.getExp() + " EXP");
        System.out.println("You may use an EXP to increase a stat");

        int option = -1;
        
        while (option != 2 && player.getExp() > 0) {
            System.out.println(player.getName() + "'s current stats:\nHP: " + player.getMaxStats().hp + "\tATK: " + player.getMaxStats().atk + "\tEXP remaining: " + player.getExp());
            option = menu.ask(new String[]{"Health", "Attack", "Cancel"});

            CharacterStats stats = player.getMaxStats();
            switch (option) {
                case 0:
                    player.setMaxStats(new CharacterStats(stats.hp+1, stats.atk));
                    player.decExp();
                    break;
            
                case 1:
                    player.setMaxStats(new CharacterStats(stats.hp, stats.atk+1));
                    player.decExp();
                    break;
            
                case 2:
                    break;
            
                default:
                    break;
            }
        }

    }

    private SaveData getSaveData() {
        return new SaveData("test", player);
    }
    
}
