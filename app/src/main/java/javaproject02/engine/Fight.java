package javaproject02.engine;

import java.util.Random;
import java.util.ArrayList;

public class Fight {
    private Player player;
    private Character enemy;
    private Menu menu = Menu.getInstance();
    private Random random;
    public Fight(Player a, Character b) {
        this.player = a;
        this.enemy = b;
        this.random = new Random();
    }

    /**
     * fight an enemy
     * @return true when alive, false when dead
     */
    public boolean getResults() {
        do {
            System.out.println("==================");
            System.out.println(player.getName() + ": " + player.getHP() + "/" + player.getMaxStats().hp + "HP");
            System.out.println(enemy.getName() + ": " + enemy.getHP() + "/" + enemy.getMaxStats().hp + "HP" + "\n");

            double rand = random.nextDouble();
            
            int ans = menu.ask(new String[]{"Attack", "Items"});
            System.out.println();
            switch (ans) {
                case 0:
                    int dmg = 0;
                    if (rand < 0.1) {
                        System.out.println("Critical Hit!");
                        dmg = (player.attack() * 2);
                    } else {
                        dmg = (player.attack());
                    }
                    rand = random.nextDouble();
                    System.out.println("You attack " + enemy.getName() + " dealing " + dmg + " dmg");
                    enemy.receiveAttack(dmg);
                    break;
            
                case 1:
                    var inv = player.getInventory();
                    ArrayList<String> prompt = new ArrayList<String>();
                    if (inv.potions > 0) {
                        prompt.add("Potions x " + inv.potions);
                    }
                    if (inv.throwingKnives > 0) {
                        prompt.add("Throwing knives x " + inv.throwingKnives);
                    }

                    if (prompt.isEmpty()) {
                        System.out.println("Inventory is empty!");
                    } else {
                        String[] arr = prompt.toArray(new String[prompt.size()]);
                        int ans1 = menu.ask(arr);

                        if (arr[ans1].contains("Potions")) {
                            System.out.println("You used a potion!");
                            player.setInventory(new Inventory(inv.potions-1, inv.throwingKnives));
                            player.heal(2);
                        } else if (arr[ans1].contains("Throwing")) {
                            System.out.println("You threw a knife!");
                            player.setInventory(new Inventory(inv.potions, inv.throwingKnives-1));
                            enemy.receiveAttack(3);
                        }

                    }

                    break;
                default:
                    break;
            }

            if (enemy.getHP() <= 0) {
                System.out.println(enemy.getName() + " died!");
                return true;
            }

            int dmg = 0;
            if (rand < 0.1) {
                System.out.println("Critical Hit!");
                dmg = (enemy.attack() * 2);
            } else {
                dmg = (enemy.attack());
            }
            System.out.println(enemy.getName() + " deals " + dmg + " dmg");
            player.receiveAttack(dmg);
            
            if (player.getHP() <= 0) {
                return false;
            }
        } while (true);

    }

}
