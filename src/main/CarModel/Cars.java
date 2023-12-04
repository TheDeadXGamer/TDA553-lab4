package main.CarModel;

import main.Position;
import main.CarModel.Movable2D.Direction;

import java.awt.*;

public class Cars{
    
    private int carSize; //Size of car
    private int nrDoors; // Number of doors on the car
    private int enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private boolean carIsOn;
    private Movable2D moveHelper;
    
    public Cars(int nrDoors,Color color,int enginePower,String modelName, int carSize, float x, float y){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.carSize = carSize;
        moveHelper = new Movable2D(x, y);
        stopEngine();
    }
    
    public int getNrDoors(){
        return nrDoors;
    }

    public int getEnginePower(){
        return enginePower;
    }

    public Color getColor(){
        return color;
    }

    public String getModelName(){
        return modelName;
    }

    public int getCarSize() {
        return carSize;
    }

    public Position getPosition(){
        return moveHelper.getPosition();
    }

    public Direction getFacingDirection(){
        return moveHelper.getFacingDirection();
    }

    public void setPosition(float x, float y){
        moveHelper.setPosition(x,y);
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
        carIsOn = true;
    }

    public void stopEngine(){
	    moveHelper.setCurrentSpeed(0);;
        carIsOn = false;
    }
    
    float getSpeedFactor(){
        return enginePower * 0.01f;
    }

    private void incrementSpeed(float amount){
	    float incr = Math.min(moveHelper.getCurrentSpeed() + getSpeedFactor() * amount,enginePower);
        moveHelper.setCurrentSpeed(incr);
    }

    private void decrementSpeed(float amount){
        float decr = Math.max(moveHelper.getCurrentSpeed() - getSpeedFactor() * amount,0);
        moveHelper.setCurrentSpeed(decr);
    }

    public void gas(float amount){
        if(amount <= 1 && amount >= 0 && carIsOn) {
            incrementSpeed(amount);
        }
    }
    
    public void brake(float amount){
        if(amount <= 1 && amount >= 0 && carIsOn) {
            decrementSpeed(amount);
        }
    }

    public void turnLeft(){
        moveHelper.turnLeft();
    }

    public void turnRight(){
        moveHelper.turnRight();
    }

    public void move(){
        moveHelper.move();
    }

    public float getCurrentSpeed() {
        return moveHelper.getCurrentSpeed();
    }

    public float getX() {
        return moveHelper.getX();
    }

    public float getY() {
        return moveHelper.getY();
    }
}