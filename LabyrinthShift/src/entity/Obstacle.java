package entity;


class Obstacle extends Tile {
    public Obstacle() {
       super("Obstacle", true);
    }

    @Override
    public String getSymbol() {
        return "O"; // Simbolo per un ostacolo
    }
}