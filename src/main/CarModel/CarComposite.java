package main.CarModel;

import java.util.ArrayList;

import main.CarModel.Vehicles.Car;

public class CarComposite implements ICarComposite{

	private ArrayList<Car> children = new ArrayList<>();
    
    public void addCar(Car car){
        children.add(car);
    }

    public void removeCar(Car car){
        children.remove(car);
    }

    public void removeCar(int index){
        children.remove(index);
    }

    public ArrayList<Car> getChildren() {
        return children;
    }

    public int getSize(){
        return children.size();
    }

    public void move(){
        for(Car child: children){
            child.move();
        }
    }

    public void turnLeft(){
        for(Car child: children){
            child.turnLeft();
        }
    }

    public void turnRight(){
        for(Car child: children){
            child.turnRight();
        }
    }

    @Override
    public void gas(float amount){
        float gasAmount = amount/100; 
        for(Car child: children){
            child.gas(gasAmount);
        }
    }

    @Override
    public void brake(float amount){
        float brakeAmount = amount/100; 
        for(Car child: children){
            child.brake(brakeAmount);
        }
    }

    @Override
    public void startEngine(){
        for(Car child: children){
            child.startEngine();
        }
    }

    @Override
    public void stopEngine(){
        for(Car child: children){
            child.stopEngine();
        }
    }
}
