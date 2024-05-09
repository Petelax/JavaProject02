package javaproject02.engine;

import java.io.Serializable;

public class CharacterStats implements Serializable {
    public int hp = 0;
    public int atk = 0;
    public CharacterStats (int hp, int atk) {
        this.hp = hp;
        this.atk = atk;
    }
    public CharacterStats(CharacterStats c) {
        this.hp = c.hp;
        this.atk = c.atk;
    }
}