package entity;

import entity.Enum.DifficultyType;
import java.util.Random;

public class GameMap {

    private Tile[][] map;
    private DifficultyType difficulty;

    public GameMap(Tile[][] map, DifficultyType difficulty) {
        this.map = map;
        this.difficulty = difficulty;
    }



    public static GameMap generateMaze(DifficultyType difficulty) {
        int size = difficulty.getSize();
        Tile[][] map = new Tile[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = random.nextBoolean() ? new Wall() : new Hallway();
            }
        }

        return new GameMap(map, difficulty);
    }



    public void displayFullMap(int playerX, int playerY) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == playerX && j == playerY) {
                    // Posizione del giocatore
                    System.out.print("G"); // Verde
                } else if (i == 0 && j == 0) {
                    // Partenza
                    System.out.print("P"); // Blu
                } else if (i == map.length - 1 && j == map[i].length - 1) {
                    // Arrivo
                    System.out.print("A"); // Rosso
                } else if (map[i][j] != null) {
                    System.out.print(map[i][j].getTileType().charAt(0) + " ");
                } else {
                    System.out.print(". "); // Cella vuota
                }
            }
            System.out.println();
        }
    }

    public void displayLimitedMap(int playerX, int playerY) {
        for (int i = Math.max(0, playerX - 1); i <= Math.min(map.length - 1, playerX + 1); i++) {
            for (int j = Math.max(0, playerY - 1); j <= Math.min(map[i].length - 1, playerY + 1); j++) {
                if (i == playerX && j == playerY) {
                    // Posizione del giocatore
                    System.out.print("G");
                } else if (i == 0 && j == 0) {
                    // Partenza
                    System.out.print("P");
                } else if (i == map.length - 1 && j == map[i].length - 1) {
                    // Arrivo
                    System.out.print("A ");
                } else if (map[i][j] != null) {
                    System.out.print(map[i][j].getTileType().charAt(0) + " ");
                } else {
                    System.out.print(". "); // Cella vuota
                }
            }
            System.out.println();
        }
    }


    public boolean movePlayer(String direction, int playerX, int playerY) {
        // Logica di movimento del giocatore
        return playerX == map.length - 1 && playerY == map[0].length - 1;
    }

    public Tile[][] getMap() {
        return map;
    }

    public int getSize() {
        return map.length;
    }

    public DifficultyType getDifficulty() {
        return difficulty;
    }
}
