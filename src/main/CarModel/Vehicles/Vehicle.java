package main.CarModel.Vehicles;

import main.Movable;
import java.awt.*;
import main.Position;

abstract public class Vehicle implements Movable{

    public enum Direction {
    NORTH,
    EAST,
    WEST,
    SOUTH
    }
    
    private Position position;
    private Direction facingDirection;
    private float currentSpeed;
    private Color color;
    private VehicleState currentState;

    public Vehicle(float x ,float y, Color color) {
        position = new Position(x, y);
        facingDirection = Direction.EAST;
        this.color = color;
        currentSpeed = 0;
        setCurrentState(new VehicleStoppedState(this));
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
        currentState.turnLeft();
    }

    public void turnRight(){
        currentState.turnRight();
    }
    
    public void move(){
        currentState.move();
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

    public VehicleState getCurrentState(){
        return currentState;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    protected void setPosition(float x, float y) {
        position.setPosition(x, y);
    }

    void setCurrentState(VehicleState newState){
        currentState = newState;
    }

    void setFacingDirection(Direction direction){
        facingDirection = direction;
    }

    abstract void incrementSpeed(float amount);

    abstract void decrementSpeed(float amount);
}