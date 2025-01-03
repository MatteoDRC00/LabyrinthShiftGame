package entity.ostacoli;

import utilities.Player;

public class FreezingFog extends Obstacle {
    @Override
    public void activate(Player player) {
        System.out.println("Hai attivato Freezing Fog! Movimenti rallentati e visibilità ridotta per 7 secondi.");
        player.setSpeedModifier(0.66, 7000); // Riduce velocità a 2/3 per 7 secondi
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException("FF");
    }
}
