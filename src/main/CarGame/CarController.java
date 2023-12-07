package main.CarGame;
import javax.swing.*;

import main.Settings;
import main.CarModel.*;
import main.CarModel.Vehicles.Car;
import main.CarModel.Vehicles.Saab95;
import main.CarModel.Vehicles.Scania;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int DELAY = 25;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;
    private CarView frame;
    
    // The frame that represents this instance View of the MVC pattern

    // A list of cars, modify if needed
    private CarComposite composite = new CarComposite();

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    public CarController(){
        timer = new Timer(DELAY, new TimerListener(this,composite));
    }

    public void passFrame(CarView frame){
        this.frame = frame;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        composite.gas(amount);
    }

     // Calls the gas method for each car once
    void brake(int amount) {
        composite.brake(amount);
    }

    void startCars(){
        composite.startEngine();
    }

    void stopCars(){
        composite.stopEngine();
    }

    void turboOn(){
        for (Car car : composite.getChildren()){
            if (car instanceof Saab95){
                ((Saab95)car).setTurboOn();
            }
        }
    }
    
    void turboOff(){
        for (Car car : composite.getChildren()){
            if (car instanceof Saab95){
                ((Saab95)car).setTurboOff();
            }
        }
    }

    void lowerBed(){
        for (Car car : composite.getChildren()){
            if (car instanceof Scania){
                ((Scania)car).LowerTrailer(70f);
            }
        }
    }

    void raiseBed(){
        for (Car car : composite.getChildren()){
            if (car instanceof Scania){
                ((Scania)car).RaiseTrailer(70f);
            }
        }
    }

    void addCar(Car c){
        addCarToArr(c);
    }

    void removeCar(){
        if(composite.getSize() > 0){
            composite.removeCar(composite.getSize()-1);
            frame.removeCarFromArrays();
        }
    }

    void moveCar(int index, int x, int y){
        frame.drawPanel.setPoint(index,x,y);
    }

    public void addCarToArr(Car car){
        if(composite.getSize() < Settings.getMaxNrCars()) {
            composite.addCar(car);
            frame.initiateCarToArr(car);
        }
    }
    
    public Timer getTimer(){
        return timer;
    }

    public void triggerRepaint(){
        frame.drawPanel.repaint();
    }
}