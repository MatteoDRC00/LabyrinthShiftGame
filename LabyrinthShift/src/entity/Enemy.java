package entity;


class Enemy extends Tile {
    public Enemy() {
        super("Enemy", true);
    }

    @Override
    public String getSymbol() {
        return "E"; // Simbolo per un nemico
    }
}