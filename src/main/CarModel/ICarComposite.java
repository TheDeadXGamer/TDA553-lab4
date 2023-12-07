package main.CarModel;

import main.Movable;

public interface ICarComposite extends Movable{
    public void move();
    public void turnLeft();
    public void turnRight();
    public void gas(float amount);
    public void brake(float amount);
    public void startEngine();
    public void stopEngine();
}
