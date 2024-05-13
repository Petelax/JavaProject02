package javaproject02.engine;

public class Player extends Character {
    private Inventory inventory;
    /** gained from winning battles */
    private int exp = 0;

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

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getExp() {
        return exp;
    }

    public void incExp() {
        ++exp;
    }

    public void decExp() {
        if (exp > 0) {
            --exp;
        }
    }

    public void setExp(int exp) {
        this.exp = exp;
    }


}
