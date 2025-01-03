package entity.nemici;

import utilities.Player;

public class IceCyclops extends Enemy {
    @Override
    public void interact(Player player) {
        System.out.println("Un Ice Cyclops genera Freezing Fog! Movimenti rallentati.");
        player.setSpeedModifier(0.66, 5000); // Rallenta il giocatore per 5 secondi
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}