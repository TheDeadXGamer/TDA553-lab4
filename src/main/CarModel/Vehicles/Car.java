package main.CarModel.Vehicles;

import java.awt.*;

public class Car extends Vehicle{
    
    private int carSize; //Size of car
    private int nrDoors; // Number of doors on the car
    private int enginePower; // Engine power of the car
    private String modelName; // The car model name
    private boolean carIsOn;

    public Car(int nrDoors,Color color,int enginePower,String modelName, int carSize, float x, float y){
        super(x, y, color);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.carSize = carSize;
        this.carIsOn = false;
        super.setCurrentSpeed(0);
    }
    
    public int getNrDoors(){
        return nrDoors;
    }

    public int getEnginePower(){
        return enginePower;
    }

    public String getModelName(){
        return modelName;
    }

    public int getCarSize() {
        return carSize;
    }

    public void startEngine(){
        carIsOn = true;
    }

    public void stopEngine(){
	    super.setCurrentSpeed(0);
        carIsOn = false;
    }
    
    float getSpeedFactor(){
        return enginePower * 0.01f;
    }

    @Override
    protected void incrementSpeed(float amount){
	    float incr = Math.min(getCurrentSpeed() + getSpeedFactor() * amount,enginePower);
        setCurrentSpeed(incr);
    }

    @Override
    protected void decrementSpeed(float amount){
        float decr = Math.max(getCurrentSpeed() - getSpeedFactor() * amount,0);
        setCurrentSpeed(decr);
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
} 