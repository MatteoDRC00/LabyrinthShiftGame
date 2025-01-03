package entity.nemici;


import entity.Tile;
import utilities.Player;

// Classe base per nemici
public abstract class Enemy extends Tile {
    public Enemy() {
        super("Enemy", false);
    }
    public abstract void interact(Player player);
}