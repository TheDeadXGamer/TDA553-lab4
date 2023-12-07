package main;

import main.CarGame.CarButtonListener;
import main.CarGame.CarController;
import main.CarGame.CarView;
import main.CarModel.*;

public class Main {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        //Create controller and pass it to CarView
        CarController cc = new CarController();
        CarButtonListener cb = new CarButtonListener(cc);
        cc.passFrame(new CarView("CarSim 1.0",cb));

        cc.addCarToArr(factory.CreateSaab95(0, 0));
        cc.addCarToArr(factory.CreateVolvo240(0, Settings.getDistanceConstantY()));
        cc.addCarToArr(factory.CreateScania(0, Settings.getDistanceConstantY() *2));

        // Start the timer
        cc.getTimer().start();
    }
}
