package main.CarModel;

import main.Position;

import java.awt.*;
import java.util.ArrayList;

public class TransportTruck extends Car{
    private boolean bedDown;
    private int maxNrCars;
    private ArrayList<Car> carLoad;

    public TransportTruck(int maxNrCars, float x, float y) {
        super(2, Color.magenta, 100, "TransportTruck", 1000, x, y);
        bedDown = false; 
        this.maxNrCars = maxNrCars;
        carLoad = new ArrayList<>(maxNrCars);
    }

    public int getMaxNrCars(){
        return maxNrCars;
    }

    public ArrayList<Car> getLoad(){
        return carLoad;
    }

    public boolean getBedState() {
        return bedDown;
    }
    
    public void RaiseBed() {
        bedDown = false;
    }

    public void LowerBed() {
        if(getCurrentSpeed() == 0) {
            bedDown = true;
        }
    }

    private boolean canBeLoaded(Car car) {
        boolean _canBeLoaded = true;

        boolean _isNotNear = Position.calcDistance(this.getPosition(),car.getPosition()) > 1f;
        boolean _isNotMoving = this.getCurrentSpeed() > 0;
        boolean _carTooBig = car.getCarSize() > 100;

        if (_isNotNear || !bedDown || _carTooBig || _isNotMoving) {
            _canBeLoaded = false;
        }
        return _canBeLoaded;
    }
    
    public void loadCar(Car car) {
        
        boolean _canBeLoaded = canBeLoaded(car);

        if (_canBeLoaded && carLoad.size() < maxNrCars) {
            carLoad.add(car);
        }
    }
    
    public void unloadCar() {
        if(carLoad.size() > 0 || this.getCurrentSpeed() == 0) {
            Car car = carLoad.get((carLoad.size() - 1));
            carLoad.remove((carLoad.size() - 1));

            car.setPosition(car.getPosition().getX(), this.getPosition().getY() - 1);
        }
    }
    
    public void unloadCars(int amount) {
        if(amount <= carLoad.size()) {
            for (int i = 0; i < amount; i++) {
                if(carLoad.size() > 0) {
                    Car car = carLoad.get((carLoad.size() - 1));
                    carLoad.remove((carLoad.size() - 1));

                    car.setPosition(this.getPosition().getX(), this.getPosition().getY() - 1);
                }
            }
        }
    }
    
    @Override
    public void move() {
        super.move();
        for (Car car : carLoad) {
            car.setPosition(this.getPosition().getX(), this.getPosition().getY());
        }
    }

    @Override
    float getSpeedFactor() {
        if(bedDown) {
            return 0;
        } 
        else {
            return (0.01f*getEnginePower());
        }
    }
}
