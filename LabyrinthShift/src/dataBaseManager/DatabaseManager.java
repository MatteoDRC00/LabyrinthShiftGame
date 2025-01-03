package dataBaseManager;

import entity.Level;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager instance;

    public DatabaseManager() {
        // Simula la connessione al database
        System.out.println("Connessione al database...");
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public List<Level> getLevels() {
        // Simula il recupero dei livelli dal database
        return Level.generateLevels();
    }

    public void saveLevelScore(int levelId, int averageStars) {
        // Simula il salvataggio nel database
        System.out.println("Salvato punteggio per livello " + levelId + ": " + averageStars + " stelle.");
    }
}
