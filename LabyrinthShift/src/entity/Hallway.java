package entity;

public class Hallway extends Tile {
    public Hallway() {
        this.walkable = true;
    }

    @Override
    public String getSymbol() {
        return " "; // Simbolo per un passaggio
    }
}

