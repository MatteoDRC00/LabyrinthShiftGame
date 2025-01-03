package entity;

import entity.Enum.DifficultyType;

public abstract class Tile {
    protected String tileType;
    protected boolean walkable; // Indica se la casella è calpestabile

    public Tile(String tileType, boolean walkable) {
        this.tileType = tileType;
        this.walkable = walkable;
    }

    public String getTileType() {
        return tileType;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public abstract String getSymbol(); // Rappresentazione simbolica per debug/stampa
}

