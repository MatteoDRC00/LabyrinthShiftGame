package entity;

class Wall extends Tile {
    public Wall() {
        this.walkable = false;
    }

    @Override
    public String getSymbol() {
        return "█"; // Simbolo per un muro
    }
}
