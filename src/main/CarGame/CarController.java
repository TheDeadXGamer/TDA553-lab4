package main.CarGame;
import javax.swing.*;

import main.Settings;
import main.CarModel.Cars;
import main.CarModel.Saab95;
import main.CarModel.Scania;
import main.CarModel.Movable2D.Direction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    
    // The frame that represents this instance View of the MVC pattern

    // A list of cars, modify if needed
    private ArrayList<Cars> cars = new ArrayList<>();

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    public void passFrame(CarView frame){
        timer = new Timer(DELAY, new TimerListener(frame));
    }

    private class TimerListener implements ActionListener {
        private CarView frame;

        TimerListener(CarView frame){
            this.frame = frame;
        }


        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                
                if(isDrivingIntoSurface(car)){
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                }

                inBounds(car, x, y,frame);
                moveCar(cars.indexOf(car),x,y,frame);
                
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        float gas = ((float) amount) / 100;
        for (Cars car : cars) {
            car.gas(gas);
        }
    }

     // Calls the gas method for each car once
    void brake(int amount) {
        float gas = ((float) amount) / 100;
        for (Cars car : cars) {
            car.brake(gas);
        }
    }

    void startCars(){
        for (Cars car : cars){
            car.startEngine();
        }
    }

    void stopCars(){
        for (Cars car : cars){
            car.stopEngine();
        }
    }

    void turboOn(){
        for (Cars car : cars){
            if (car instanceof Saab95){
                ((Saab95)car).setTurboOn();
            }
        }
    }
    
    void turboOff(){
        for (Cars car : cars){
            if (car instanceof Saab95){
                ((Saab95)car).setTurboOff();
            }
        }
    }

    void lowerBed(){
        for (Cars car : cars){
            if (car instanceof Scania){
                ((Scania)car).LowerTrailer(70f);
            }
        }
    }

    void raiseBed(){
        for (Cars car : cars){
            if (car instanceof Scania){
                ((Scania)car).RaiseTrailer(70f);
            }
        }
    }

    private void moveCar(int index, int x, int y, CarView frame){
        frame.drawPanel.setPoint(index,x,y);
    }

    private boolean isDrivingIntoSurface(Cars car){

        Direction direction = car.getFacingDirection();
        
        boolean _isTouchingRightSide = car.getX() > Settings.getWindowWidth() - Settings.getCarWidth();
        boolean _isTouchingLeftSide = car.getX() < 0;
        boolean _isTouchingBottom = car.getY() > Settings.getWindowHeight() - Settings.getControllerHeight() - Settings.getCarHeight();
        boolean _isTouchingTop = car.getY() < 0;

        boolean _driveIntoLeftSide = _isTouchingLeftSide && direction == Direction.WEST;
        boolean _driveIntoRightSide = _isTouchingRightSide && direction == Direction.EAST;
        boolean _driveIntoSide = _driveIntoLeftSide || _driveIntoRightSide;

        boolean _driveIntoTop = _isTouchingTop && direction == Direction.NORTH;
        boolean _driveIntoBottom = _isTouchingBottom && direction == Direction.SOUTH;
        boolean _driveIntoOpposites = _driveIntoTop || _driveIntoBottom;

        return (_driveIntoSide || _driveIntoOpposites) ? true : false;
    }

    /**
     * Keeps the Cars car from going out of bounds
     */
    private void inBounds(Cars car, int xPos, int yPos, CarView frame) {
        
        int _newXPos = xPos;
        int _newYPos = yPos;
        
        if (xPos + Settings.getCarWidth() > Settings.getWindowWidth()) {
            _newXPos = Settings.getWindowWidth() - Settings.getCarWidth() -1;
        }

        if (xPos < 0) {
            _newXPos = 0;
        }

        if (yPos + Settings.getCarHeight() > Settings.getWindowHeight()) {
            _newYPos = Settings.getWindowHeight() - Settings.getCarHeight();
        }

        if (yPos < 0) {
            _newYPos = 0;
        }

        moveCar(cars.indexOf(car),_newXPos, _newYPos, frame);
    }

    public void addCarToArr(Cars car){
        cars.add(car);
    }

    public Timer getTimer(){
        return timer;
    }

    
}