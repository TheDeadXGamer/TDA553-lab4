package main.CarModel.Vehicles;

import main.Position;
import main.CarModel.Vehicles.Vehicle.Direction;

public class VehicleMovableState implements VehicleState{

    private Vehicle vehicle;

    public VehicleMovableState(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void move(){
        Position position = vehicle.getPosition();
        float currentSpeed = vehicle.getCurrentSpeed();
        switch (vehicle.getFacingDirection()) {
            case NORTH:
                vehicle.setPosition(position.getX(), position.getY() + currentSpeed);
                break;
            case WEST:
                vehicle.setPosition(position.getX() - currentSpeed, position.getY());
                break;
            case EAST:
                vehicle.setPosition(position.getX() + currentSpeed, position.getY());
                break;
            case SOUTH:
                vehicle.setPosition(position.getX(), position.getY() - currentSpeed);
                break;
        }
    }

    public void turnLeft(){
        switch (vehicle.getFacingDirection()) {
            case NORTH:
                vehicle.setFacingDirection(Direction.WEST);
                break;
            case EAST:
                vehicle.setFacingDirection(Direction.NORTH);
                break;
            case SOUTH:
                vehicle.setFacingDirection(Direction.EAST);
                break;
            case WEST:
                vehicle.setFacingDirection(Direction.SOUTH);
                break;
        }
    }

    public void turnRight(){
        switch (vehicle.getFacingDirection()) {
            case NORTH:
                vehicle.setFacingDirection(Direction.EAST);
                break;
            case EAST:
                vehicle.setFacingDirection(Direction.SOUTH);
                break;
            case SOUTH:
                vehicle.setFacingDirection(Direction.WEST);
                break;
            case WEST:
                vehicle.setFacingDirection(Direction.NORTH);
                break;
        }
    }
}
