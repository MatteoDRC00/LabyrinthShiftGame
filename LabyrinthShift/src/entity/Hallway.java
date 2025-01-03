package entity;

public class Hallway extends Tile {
    public Hallway() {
      super("Hallway", true);
    }

    @Override
    public String getSymbol() {
        return " "; // Simbolo per un passaggio
    }
}

