package main.CarModel;

import main.Movable;
import java.awt.*;
import main.Position;

abstract public class Vehicle implements Movable{

    private Color color; // Color of the car

    public enum Direction {
    NORTH,
    EAST,
    WEST,
    SOUTH
    }
    
    private Position position;
    private Direction facingDirection;
    private float currentSpeed;

    Vehicle(float x ,float y, Color color) {
        position = new Position(x, y);
        facingDirection = Direction.EAST;
        this.color = color;
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

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    void setPosition(float x, float y) {
        position.setPosition(x, y);
    }

    abstract protected void incrementSpeed(float amount);

    abstract protected void decrementSpeed(float amount);
}