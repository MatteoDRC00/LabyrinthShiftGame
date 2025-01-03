package entity;

class Wall extends Tile {
    public Wall() {
        super("Wall",false);
    }

    @Override
    public String getSymbol() {
        return "█"; // Simbolo per un muro
    }
}
