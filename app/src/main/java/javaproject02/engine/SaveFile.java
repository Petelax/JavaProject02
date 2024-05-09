package javaproject02.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javaproject02.Game;

public class SaveFile {
    private static final String path = "./app/src/main/resources";
    /**
     * Write a save file
     * @param name name of the save file
     * @param game save data from game
     */
    public void writeSave(SaveData game) {
        var fileName = new File(path, game.name);
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game);
            oos.close();
        } catch (IOException e) {
            System.out.println("Unable to write save");
            e.printStackTrace();
        }
    }

    /**
     * Read save data
     * @param name name of the save file
     * @return save data from file
     */
    public Game readSave(String name) {
        var fileName = "./saves/" + name;
        Game game = new Game();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
            ois.close();
            return game;
        } catch (IOException e) {
            System.out.println("Unable to read save");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Save does not exist");
            e.printStackTrace();
        }

        return game;
    }
}
