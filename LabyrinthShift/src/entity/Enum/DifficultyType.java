package entity.Enum;


// DifficultyType enum
public enum DifficultyType {
    EASY(5, 2, 1),
    MEDIUM(7, 5, 3),
    HARD(10, 10, 5),
    EXTREME(15, 20, 10);

    private final int size;
    private final int obstacles;
    private final int enemies;

    DifficultyType(int size, int obstacles, int enemies) {
        this.size = size;
        this.obstacles = obstacles;
        this.enemies = enemies;
    }

    public int getSize() {
        return size;
    }

    public int getObstacles() {
        return obstacles;
    }

    public int getEnemies() {
        return enemies;
    }
}
