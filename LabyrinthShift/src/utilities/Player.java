package utilities;

import java.util.*;

public class Player {
    private String name;
    private double speedModifier = 1.0; // Modificatore di velocità
    private boolean immobilized = false;

    public Player(String name) {
        this.name = name;
    }

    public void setSpeedModifier(double modifier, int duration) {
        speedModifier = modifier;
        System.out.println("Velocità modificata a " + (modifier * 100) + "% per " + (duration / 1000) + " secondi.");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                speedModifier = 1.0; // Ripristina la velocità
                System.out.println("Velocità ripristinata.");
            }
        }, duration);
    }

    public void setImmobilized(int duration) {
        immobilized = true;
        System.out.println("Sei immobilizzato per " + (duration / 1000) + " secondi.");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                immobilized = false; // Ripristina il movimento
                System.out.println("Ora puoi muoverti di nuovo.");
            }
        }, duration);
    }

    public void moveBack(int tiles) {
        System.out.println("Spostato indietro di " + tiles + " caselle.");
        // Gestione dello spostamento indietro (da implementare nella logica del MiniMaze)
    }

    public void setChased(int duration) {
        System.out.println("Stai venendo inseguito per " + (duration / 1000) + " secondi!");
        // Logica di inseguimento (da implementare)
    }
}
