package javaproject02.engine;

public class Character {
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

    public int attack(int dmg) {
        return currentStats.atk;
    }

}
