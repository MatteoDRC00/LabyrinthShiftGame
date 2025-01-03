
package utilities;

import dataBaseManager.DatabaseManager;
import java.util.List;
import java.util.Scanner;
import entity.Character;
import entity.Level;
import entity.MiniMaze;

public class LabyrinthShiftGame {

    private static LabyrinthShiftGame instance;

    private LabyrinthShiftGame() {}

    public static LabyrinthShiftGame getInstance() {
        if (instance == null) {
            instance = new LabyrinthShiftGame();
        }
        return instance;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto in LabyrinthShift!");

        boolean playing = true;
        while (playing) {
            System.out.println("Seleziona una modalita' di gioco:");
            System.out.println("1. Modalita' Classica");
            System.out.println("0. Esci");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playClassicMode(scanner);
                    break;
                case 0:
                    playing = false;
                    System.out.println("Grazie per aver giocato a LabyrinthShift!");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }
        scanner.close();
    }

    private void playClassicMode(Scanner scanner) {
        System.out.println("Modalita' Classica selezionata!");
        DatabaseManager db = DatabaseManager.getInstance();


//FARE UN METODO PER SCELTA PERSONAGGIO
        // Selezione del personaggio
        System.out.println("Seleziona un personaggio:");
        List<Character> characters = Character.generateCharacters();
        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ". " + characters.get(i).getName() + " - Abilità: " + characters.get(i).getSpecialAbility());
        }
        int characterChoice = scanner.nextInt();
        Character selectedCharacter = characters.get(characterChoice - 1);


//FARE METODO PER SCELTA LIVELLO
        // Selezione del livello
        System.out.println("Livelli disponibili:");
        List<Level> levels = db.getLevels(); // Recupera i livelli dal database
        for (int i = 0; i < levels.size(); i++) {
            System.out.println((i + 1) + ". Livello " + levels.get(i).getIdLevel() + " - Difficoltà: " + levels.get(i).getDifficulty());
        }
        System.out.println("Seleziona un livello:");
        int levelChoice = scanner.nextInt();
        Level selectedLevel = levels.get(levelChoice - 1);
        selectedLevel.setCharacter(selectedCharacter);

        System.out.println("Livello selezionato: " + selectedLevel.getIdLevel());


// Gioco per i MiniMazes
        for (int i = 0; i < selectedLevel.getMiniMazeList().size(); i++){
            System.out.println("MiniLabirinto " + (i + 1));
            MiniMaze maze = selectedLevel.getMiniMazeList().get(i);

            // Visualizza il labirinto per 15 secondi
            System.out.println("Visualizzazione del labirinto...");
            maze.displayFullMap();
            try {
                Thread.sleep(15000); // 15 secondi
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            boolean completed = false;
            long startTime = System.currentTimeMillis(); // Definizione startTime, all'inizio del mini-labirinto

            while (!completed) {
                maze.displayLimitedMap();
                System.out.println("Inserisci comando (w: su, s: giù, a: sinistra, d: destra):");
                String move = scanner.next();

                // Timer logica
                long elapsedTime = (System.currentTimeMillis() - startTime) / 1000; // Tempo trascorso in secondi
                if (elapsedTime >= 60) {
                    System.out.println("Tempo scaduto! Rigenerazione del labirinto...");
                    maze.regenerateMaze();
                    startTime = System.currentTimeMillis(); // Reset startTime
                } else {
                    completed = maze.movePlayer(move);
                    if (completed) {
                        maze.calculateStar(elapsedTime); // Calcola le stelle alla fine del MiniMaze
                        System.out.println("Checkpoint raggiunto! Prossimo mini-labirinto...");
                    }
                }

            }

            System.out.println("MiniLabirinto completato!");
        }

        int averageStars = selectedLevel.calculateAverageStars();
        System.out.println("Punteggio medio del livello: " + averageStars + " stelle.");

        db.saveLevelScore(selectedLevel.getIdLevel(), averageStars);
    }
}



