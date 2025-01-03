package entity;

// MiniMaze class

import entity.Enum.DifficultyType;

public class MiniMaze {
    private GameMap gameMap;
    private DifficultyType difficulty;
    private int playerX;
    private int playerY;
    private int checkpointX; //ArrivoX
    private int checkpointY; //ArrivoY
    private int starsEarned; // Stelle guadagnate per il mini-labirinto



    public MiniMaze(GameMap gameMap) {
        this.gameMap = gameMap;
        this.difficulty = gameMap.getDifficulty();
        this.playerX = 0;
        this.playerY = 0;
        // Genera un checkpoint raggiungibile
        this.checkpointX = gameMap.getSize() - 1;
        this.checkpointY = gameMap.getSize() - 1;
        ensurePathToCheckpoint();
    }

    public void displayFullMap() {
        gameMap.displayFullMap(playerX,playerY);
    }

    public void displayLimitedMap() {
        gameMap.displayLimitedMap(playerX, playerY);
    }

    public boolean movePlayer(String direction) {
        Tile[][] map = gameMap.getMap();

        // Calcola la nuova posizione del giocatore
        int newX = playerX;
        int newY = playerY;

        switch(direction.toLowerCase()) {
            case "w":
                newX = Math.max(0, playerX - 1); // Su
                break;
            case "s":
                newX = Math.min(map.length - 1, playerX + 1); // Giù
                break;
            case "a":
                newY = Math.max(0, playerY - 1); // Sinistra
                break;
            case "d":
                newY = Math.min(map[0].length - 1, playerY + 1); // Destra
                break;
            default:
                System.out.println("Comando non valido. Usa w, a, s, d.");
                return false;
        }

        // Verifica se la nuova posizione è percorribile
        if (map[newX][newY].isWalkable()) {
            playerX = newX;
            playerY = newY;


            //Controlla se il giocatore ha raggiunto il checkpoint
            if (playerX == checkpointX && playerY == checkpointY) {
                System.out.println("Hai raggiunto il checkpoint!");
                //calculateStar();
                return true; // MiniMaze completato
            }
        }
        else {
            System.out.println("Non puoi camminare su questa casella!");
        }
        return false; // Gioco ancora in corso
    }


    // Calcola le stelle in base al tempo impiegato
    public void calculateStar(long elapsedTime){
        if (elapsedTime <= 30) {
            starsEarned = 3;
        } else if (elapsedTime <= 40) {
            starsEarned = 2;
        } else {
            starsEarned = 1;
        }
        System.out.println("Stelle guadagnate in questo mini-labirinto: " + starsEarned);
    }

    public void regenerateMaze() {
        this.gameMap = GameMap.generateMaze(difficulty);
        this.playerX = 0;
        this.playerY = 0;
        ensurePathToCheckpoint();
    }

    private void ensurePathToCheckpoint() {
        // Logica per creare almeno un percorso dal punto di partenza al checkpoint
        for (int i = 0; i <= checkpointX; i++) {
            gameMap.getMap()[i][0] = new Hallway();
        }
        for (int j = 0; j <= checkpointY; j++) {
            gameMap.getMap()[checkpointX][j] = new Hallway();
        }

        // Segna il checkpoint come "Arrivo" e la partenza come "Partenza"
        gameMap.getMap()[0][0] = new Hallway(); // Partenza
        gameMap.getMap()[checkpointX][checkpointY] = new Hallway(); // Arrivo
    }

    public int getStarsEarned() {
        return starsEarned;
    }
}