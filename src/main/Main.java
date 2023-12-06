package main;

import main.CarGame.CarButtonListener;
import main.CarGame.CarController;
import main.CarGame.CarView;

public class Main {
    public static void main(String[] args) {
        //CarFactory factory = new CarFactory();

        //Create controller and pass it to CarView
        CarController cc = new CarController();
        CarButtonListener cb = new CarButtonListener(cc);
        cc.passFrame(new CarView("CarSim 1.0",cb));

        // Start the timer
        cc.getTimer().start();
    }
}
