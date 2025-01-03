package entity.ostacoli;

import utilities.Player;

// Ostacolo: Thorns
public class Thorns extends Obstacle {
    @Override
    public void activate(Player player) {
        System.out.println("Hai attivato Thorns! Velocità ridotta del 50% per 5 secondi.");
        player.setSpeedModifier(0.5, 5000); // Modifica velocità per 5 secondi
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException("TO");
    }
}