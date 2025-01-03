package entity.ostacoli;

import utilities.Player;

public class TimeVortex extends Obstacle {
    @Override
    public void activate(Player player) {
        System.out.println("Hai attivato Time Vortex! Spostato indietro di 2 caselle.");
        player.moveBack(2); // Sposta il giocatore indietro di 2 caselle
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}