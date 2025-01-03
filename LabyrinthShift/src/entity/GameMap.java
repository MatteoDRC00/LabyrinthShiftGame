package entity;

import entity.Enum.DifficultyType;
import entity.nemici.*;
import entity.ostacoli.*;
import java.util.Random;



public class GameMap {

    private Tile[][] map;
    private DifficultyType difficulty;

    public GameMap(Tile[][] map, DifficultyType difficulty) {
        this.map = map;
        this.difficulty = difficulty;
    }

    public DifficultyType getDifficulty() {
        return difficulty;
    }

    public static GameMap generateMaze(DifficultyType difficulty) {

        int size = difficulty.getSize();
        Tile[][] map = new Tile[size][size];
        Random random = new Random();

        // Inizializza il labirinto con percorsi vuoti (HallWay) e muri casuali (Wall)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = random.nextBoolean() ? new Wall() : new Hallway();
            }
        }

//        // Inizializza il labirinto con muri
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//            map[i][j] = new Wall();
//            }
//        }


        // Genera almeno un percorso al checkpoint
        for (int i = 0; i < size; i++) {
            map[i][0] = new Hallway(); //Percorso verticale
        }

        for (int j = 0; j < size; j++) {
            map[size - 1][j] = new Hallway(); //Percorso orizzontale
        }

        // Imposta la partenza e l'arrivo
        map[0][0] = new Hallway(); // Partenza
        map[size - 1][size - 1] = new Hallway(); // Arrivo


        // Aggiungi ostacoli casuali
        int numObstacles = difficulty.getObstacles();
        int obstaclesPlaced = 0;
        while (obstaclesPlaced < numObstacles) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (isValidPositionForObstacleOrEnemy(map, x, y)) {
                map[x][y] = switch (random.nextInt(4)) {
                    case 0 -> new Thorns();
                    case 1 -> new FreezingFog();
                    case 2 -> new Slime();
                    case 3 -> new TimeVortex();
                    default -> new Hallway(); // Fallback
                };
                obstaclesPlaced++;

            }
        }



        // Aggiungi nemici casuali
        int numEnemies = difficulty.getEnemies();
        int enemiesPlaced = 0;
        while (enemiesPlaced < numEnemies) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (isValidPositionForObstacleOrEnemy(map, x, y)) {
                map[x][y] = switch (random.nextInt(3)) {
                    case 0 -> new PhantomHorses();
                    case 1 -> new ShadowDemons();
                    case 2 -> new IceCyclops();
                    default -> new Hallway(); // Fallback
                };
                enemiesPlaced++;

            }
        }

        return new GameMap(map, difficulty);
    }

    // Metodo per verificare se la posizione è valida per ostacoli o nemici
    private static boolean isValidPositionForObstacleOrEnemy(Tile[][] map, int x, int y) {
        // Verifica che la posizione sia una HallWay e non sia né la partenza né l'arrivo
        return (map[x][y] instanceof Hallway) && !(x == 0 && y == 0) && !(x == map.length - 1 && y == map[0].length - 1);
    }



    public void displayFullMap(int playerX, int playerY) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("G "); // Giocatore
                } else if (i == 0 && j == 0) {
                    System.out.print("P "); // Partenza
                } else if (i == map.length - 1 && j == map[i].length - 1) {
                    System.out.print("A "); // Arrivo
                } else if (map[i][j] instanceof Thorns) {
                    System.out.print("T "); // Ostacolo: Thorns
                } else if (map[i][j] instanceof FreezingFog) {
                    System.out.print("F "); // Ostacolo: Freezing Fog
                } else if (map[i][j] instanceof Slime) {
                    System.out.print("S "); // Ostacolo: Slime
                } else if (map[i][j] instanceof TimeVortex) {
                    System.out.print("V "); // Ostacolo: Time Vortex
                } else if (map[i][j] instanceof PhantomHorses) {
                    System.out.print("H "); // Nemico: Phantom Horses
                } else if (map[i][j] instanceof ShadowDemons) {
                    System.out.print("D "); // Nemico: Shadow Demons
                } else if (map[i][j] instanceof IceCyclops) {
                    System.out.print("I "); // Nemico: Ice Cyclops
                } else if (map[i][j] instanceof Hallway) {
                    System.out.print(". "); // Percorso
                } else if (map[i][j] instanceof Wall) {
                    System.out.print("# "); // Muro
                } else {
                    System.out.print("? "); // Per celle sconosciute
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
                    System.out.print("G "); // Verde
                } else if (i == 0 && j == 0) {
                    // Partenza
                    System.out.print("P "); // Blu
                } else if (i == map.length - 1 && j == map[i].length - 1) {
                    // Arrivo
                    System.out.print("A "); // Rosso
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
}
