package javaproject02.engine;

public class Fight {
    private Player player;
    private Character enemy;
    private Menu menu = Menu.getInstance();
    public Fight(Player a, Character b) {
        this.player = a;
        this.enemy = b;
    }

    public boolean getResults() {
        System.out.println(player.getName() + ": " + player.getHP() + "/" + player.getMaxStats().hp);
        System.out.println(enemy.getName() + ": " + enemy.getHP() + "/" + enemy.getMaxStats().hp);

        menu.ask(new String[]{"Attack", "Items"});


        return false;

    }

}
