package main.CarModel;

import main.Movable;
import main.Position;


/**
 * Movable2D
 */
public class Movable2D implements Movable{

    public enum Direction {
    NORTH,
    EAST,
    WEST,
    SOUTH
    }

    private Position position;
    private Direction facingDirection;
    private float currentSpeed;    

    Movable2D(float x ,float y) {
        position = new Position(x, y);
        facingDirection = Direction.EAST;
    }
    
    public float getCurrentSpeed(){
        return currentSpeed;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    void setCurrentSpeed(float currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public void turnLeft(){
        switch (facingDirection) {
            case NORTH:
                facingDirection = Direction.WEST;
                break;
            case EAST:
                facingDirection = Direction.NORTH;
                break;
            case SOUTH:
                facingDirection = Direction.EAST;
                break;
            case WEST:
                facingDirection = Direction.SOUTH;
                break;
        }
    }

    public void turnRight(){
        switch (facingDirection) {
            case NORTH:
                facingDirection = Direction.EAST;
                break;
            case EAST:
                facingDirection = Direction.SOUTH;
                break;
            case SOUTH:
                facingDirection = Direction.WEST;
                break;
            case WEST:
                facingDirection = Direction.NORTH;
                break;
        }
    }
    
    public void move(){
        switch (facingDirection) {
            case NORTH:
                this.setPosition(position.getX(), position.getY() + currentSpeed);
                break;
            case WEST:
                this.setPosition(position.getX() - currentSpeed, position.getY());
                break;
            case EAST:
                this.setPosition(position.getX() + currentSpeed, position.getY());
                break;
            case SOUTH:
                this.setPosition(position.getX(), position.getY() - currentSpeed);
                break;
        }
    }

    public Position getPosition(){
        return position;
    }

    public float getX() {
        return position.getX();
    }

    public float getY() {
        return position.getY();
    }

    void setPosition(float x, float y) {
        position.setPosition(x, y);
    }
}