package javaproject02.engine;

public class Player extends Character {
    private Inventory inventory;

    public Player(String name, CharacterStats c, Inventory inventory) {
        super(name, c);
        this.inventory = inventory;
    }

    public Player(String name, int hp, int atk, Inventory inventory) {
        super(name, hp, atk);
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }


}
