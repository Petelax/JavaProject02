package javaproject02.engine;

import java.io.Serializable;

public class Inventory implements Serializable {
    public int potions = 0;
    public int throwingKnives = 0;

    public Inventory() {

    }

    public Inventory(int potions, int throwingKnives) {
        this.potions = potions;
        this.throwingKnives = throwingKnives;
    }

}
