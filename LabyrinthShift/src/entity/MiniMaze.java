package entity;

public class MiniMaze {

    private GameMap gameMap;
    private int score;

    public MiniMaze(GameMap gameMap, int score) {
        this.gameMap = gameMap;
        this.score = score;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
