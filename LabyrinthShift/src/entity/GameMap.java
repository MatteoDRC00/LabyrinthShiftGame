package entity;

import entity.Enum.DifficultyType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameMap {
    private Tile [][]map;
    private DifficultyType difficulty;
    private int num_percorsi;
    private int num_obstacles;
    private int num_enemy;

    protected static Random random = new Random();

    public GameMap(DifficultyType difficulty) {
        this.difficulty = difficulty;
    }

    public void generateMaze(){
        int length= 10;
        int width= 10;


        // Inizializza il labirinto con tutte celle come muri
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = new Wall();
            }}


        // Inizia dalla cella in alto a sinistra
        carvePath(map, 1, 1, width, length);
    }

    private void carvePath(Tile[][] maze, int x, int y, int width, int height) {
        maze[y][x] = new Hallway(); // Rendi la cella un passaggio

        // Ottieni una lista di direzioni casuali
        List<int[]> directions = new ArrayList<>();
        directions.add(new int[] {0, -2}); // Su
        directions.add(new int[] {2, 0});  // Destra
        directions.add(new int[] {0, 2});  // Giù
        directions.add(new int[] {-2, 0}); // Sinistra
        Collections.shuffle(directions, new Random());

        // Prova ogni direzione
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // Controlla se la cella successiva è valida
            if (nx > 0 && nx < width - 1 && ny > 0 && ny < height - 1 && maze[ny][nx] instanceof Wall) {
                // Rompi il muro tra le celle
                maze[y + dir[1] / 2][x + dir[0] / 2] = new Hallway();
                carvePath(maze, nx, ny, width, height); // Ricorsione
            }
        }
    }


    public Tile[][] getMap() {
        return map;
    }

    public void setMap(Tile[][] map) {
        this.map = map;
    }

    public DifficultyType getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyType difficulty) {
        this.difficulty = difficulty;
    }

    public int getNum_percorsi() {
        return num_percorsi;
    }

    public void setNum_percorsi(int num_percorsi) {
        this.num_percorsi = num_percorsi;
    }

    public int getNum_obstacles() {
        return num_obstacles;
    }

    public void setNum_obstacles(int num_obstacles) {
        this.num_obstacles = num_obstacles;
    }

    public int getNum_enemy() {
        return num_enemy;
    }

    public void setNum_anemy(int num_enemy) {
        this.num_enemy = num_enemy;
    }
}
