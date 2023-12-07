package main.CarGame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.Settings;
import main.CarModel.CarComposite;
import main.CarModel.Vehicles.Car;
import main.CarModel.Vehicles.Vehicle.Direction;

public class TimerListener implements ActionListener{ 

    private CarComposite composite;
    private CarController carC;

    public TimerListener(CarController carC, CarComposite composite){
        this.composite = composite;
        this.carC = carC;
    }
    
    public void actionPerformed(ActionEvent e) {
        composite.move();
        for (Car car : composite.getChildren()) {
            int x = (int) Math.round(car.getPosition().getX());
            int y = (int) Math.round(car.getPosition().getY());
            
            if(isDrivingIntoSurface(car)){
                car.stopEngine();
                car.turnLeft();
                car.turnLeft();
                car.startEngine();
            }
            
            inBounds(car, x, y);
            carC.moveCar(composite.getChildren().indexOf(car),x,y);
        }
        carC.triggerRepaint();
    }

    private boolean isDrivingIntoSurface(Car car){

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
    private void inBounds(Car car, int xPos, int yPos) {
        
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

        carC.moveCar(composite.getChildren().indexOf(car),_newXPos, _newYPos);
    }
}
