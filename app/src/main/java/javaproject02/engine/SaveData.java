package javaproject02.engine;

import java.io.Serializable;

public class SaveData implements Serializable {
    public Player player;
    public String name;

    /**
     * create default save data
     * @param name name of save
     */
    public SaveData(String name) {
        player = new Player("player", new CharacterStats(10, 2));
    }

    /**
     * create save data from data
     * @param name name of save
     * @param player
     */
    public SaveData(String name, Player player) {
        this.player = player;
    }
    
}
