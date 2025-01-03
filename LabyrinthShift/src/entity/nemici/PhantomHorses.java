package entity.nemici;

import utilities.Player;

public class PhantomHorses extends Enemy {
    @Override
    public void interact(Player player) {
        System.out.println("Un Phantom Horse ti ha colpito! Sei stato spinto indietro di 4 caselle.");
        player.moveBack(4); // Spinge il giocatore indietro di 4 caselle
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException("PH"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}