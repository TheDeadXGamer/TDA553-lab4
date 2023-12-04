package main;

import main.CarGame.CarButtonListener;
import main.CarGame.CarController;
import main.CarGame.CarView;
import main.CarModel.Saab95;
import main.CarModel.Scania;
import main.CarModel.Volvo240;

public class Main {
    public static void main(String[] args) {
        int distanceConstantY = Settings.getDistanceConstantY();

        //Create controller and pass it to CarView
        CarController cc = new CarController();
        CarButtonListener cb = new CarButtonListener(cc);
        cc.passFrame(new CarView("CarSim 1.0",cb));

        cc.addCarToArr(new Volvo240(0,0));
        cc.addCarToArr(new Saab95(0,distanceConstantY));
        cc.addCarToArr(new Scania(0,2*distanceConstantY));

        // Start the timer
        cc.getTimer().start();
    }
}
