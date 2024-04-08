package org.example;

import java.io.*;

public class GameStateManager {
    public static void saveGameState(DrawingPanel gameState, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(gameState);
            System.out.println("Game state saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving game state.");
        }
    }

    public static DrawingPanel loadGameState(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            DrawingPanel gameState = (DrawingPanel) inputStream.readObject();
            System.out.println("Game state loaded successfully.");
            return gameState;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error loading game state.");
            return null;
        }
    }
}
