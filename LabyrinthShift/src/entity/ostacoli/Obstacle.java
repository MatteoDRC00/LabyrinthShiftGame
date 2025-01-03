package entity.ostacoli;


import entity.Tile;
import utilities.Player;

// Classe base per ostacoli
public abstract class Obstacle extends Tile {
    public Obstacle() {
        super("Obstacle", false);
    }

    public abstract void activate(Player player);
}
