package entity;

class Enemy extends Tile {
    public Enemy() {
        this.walkable = true;
    }

    @Override
    public String getSymbol() {
        return "E"; // Simbolo per un nemico
    }
}