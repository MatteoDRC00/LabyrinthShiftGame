package entity;

import entity.Enum.DirectionType;

public class Direction {

    private DirectionType directionType;

    public Direction() {}

    public void move(int x, int y) {}



    public DirectionType getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
    }
}
