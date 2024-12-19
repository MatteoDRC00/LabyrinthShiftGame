package entity;

import entity.Enum.DifficultyType;

public abstract class Tile {
    protected boolean walkable; // Indica se la casella è calpestabile

    public boolean isWalkable() {
        return walkable;
    }

    public abstract String getSymbol(); // Rappresentazione simbolica per debug/stampa
}

