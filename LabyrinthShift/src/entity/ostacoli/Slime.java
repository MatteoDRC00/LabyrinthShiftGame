package entity.ostacoli;

import utilities.Player;

// Ostacolo: Slime
public class Slime extends Obstacle {
    @Override
    public void activate(Player player) {
        System.out.println("Hai attivato Slime! Immobilizzato per 2 secondi.");
        player.setImmobilized(2000); // Immobilizza per 2 secondi
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException("S");
    }

}