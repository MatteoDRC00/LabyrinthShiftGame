package entity;

import entity.Enum.DifficultyType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level {


    private int idLevel;
    private List<MiniMaze> miniMazeList;
    private int finalScore;
    private DifficultyType difficulty;
    private Character character;

    public Level(int idLevel, DifficultyType difficulty) {
        this.idLevel = idLevel;
        this.difficulty = difficulty;
        this.miniMazeList = generateMiniMazes(difficulty);
        this.finalScore = 0;
    }

    public static List<Level> generateLevels() {
        return Arrays.asList(
                new Level(1, DifficultyType.EASY),
                new Level(2, DifficultyType.MEDIUM),
                new Level(3, DifficultyType.HARD),
                new Level(4, DifficultyType.EXTREME)
        );
    }


    private List<MiniMaze> generateMiniMazes(DifficultyType difficulty) {
        List<MiniMaze> mazes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mazes.add(new MiniMaze(GameMap.generateMaze(difficulty)));
        }
        return mazes;
    }

    public int calculateAverageStars() {
        int totalStars = 0;
        for (MiniMaze maze : miniMazeList) {
            totalStars += maze.getStarsEarned();
        }
        return totalStars / miniMazeList.size();
    }


    public int getIdLevel() {
        return idLevel;
    }

    public List<MiniMaze> getMiniMazeList() {
        return miniMazeList;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public void setMiniMazeList(List<MiniMaze> miniMazeList) {
        this.miniMazeList = miniMazeList;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public DifficultyType getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyType difficulty) {
        this.difficulty = difficulty;
    }

    public Character getCharacter() {
        return character;
    }
}
