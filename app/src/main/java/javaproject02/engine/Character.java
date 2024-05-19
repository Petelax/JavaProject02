package javaproject02.engine;

import java.io.Serializable;

public class Character implements Serializable {
    private CharacterStats maxStats;
    private CharacterStats currentStats;
    private String name;
    public Character(String name, int hp, int atk) {
        this.name = name;
        maxStats = new CharacterStats(hp, atk);
        currentStats = new CharacterStats(maxStats);
    }

    public Character(String name, CharacterStats c) {
        this.name = name;
        maxStats = new CharacterStats(c);
        currentStats = new CharacterStats(c);
    }

    public CharacterStats getMaxStats() {
        return maxStats;
    }

    public void setMaxStats(CharacterStats stats) {
        this.maxStats = stats;
    }

    public CharacterStats getCurrentStats() {
        return currentStats;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return getCurrentStats().hp;
    }

    public boolean isAlive() {
        return currentStats.hp > 0;
    }

    public void receiveAttack(int dmg) {
        if (dmg > getHP()) {
            currentStats.hp = 0;
        } else {
            currentStats.hp = getHP() - dmg;
        }

    }

    /**
     * current attack stat
     * @return current attack stat
     */
    public int attack() {
        return currentStats.atk;
    }

    /**
     * increase current hp
     * @param hp amount to increase by
     */
    public void heal(int hp) {
        if (currentStats.hp + hp > maxStats.hp) {
            currentStats.hp = maxStats.hp;
        } else {
            this.currentStats.hp += hp;
        }
    }

    /**
     * increase current hp to max hp
     */
    public void maxHeal() {
        this.currentStats.hp = this.maxStats.hp;
    }

}
