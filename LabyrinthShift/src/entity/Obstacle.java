package entity;


class Obstacle extends Tile {
    public Obstacle() {
        this.walkable = true;
    }

    @Override
    public String getSymbol() {
        return "O"; // Simbolo per un ostacolo
    }
}