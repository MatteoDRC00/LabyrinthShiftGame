package entity.nemici;

import utilities.Player;

public class ShadowDemons extends Enemy {
    @Override
    public void interact(Player player) {
        System.out.println("Sei stato avvistato da un Shadow Demon! Ti insegue per 7 secondi.");
        player.setChased(7000); // Il giocatore viene inseguito per 7 secondi
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
