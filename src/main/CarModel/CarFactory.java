package main.CarModel;

import java.util.Random;

import main.CarModel.Vehicles.Car;
import main.CarModel.Vehicles.Saab95;
import main.CarModel.Vehicles.Scania;
import main.CarModel.Vehicles.TransportTruck;
import main.CarModel.Vehicles.Volvo240;

public class CarFactory {

    public Scania CreateScania(float x, float y) {
        Scania scania = new Scania(x, y);
        return scania;
    }

    public Volvo240 CreateVolvo240(float x, float y) {
        Volvo240 volvo240 = new Volvo240(x ,y);
        return volvo240;
    }

    public Saab95 CreateSaab95(float x, float y) {
        Saab95 saab95 = new Saab95(x, y);
        return saab95;
    }

    public TransportTruck CreateTransportTruck(int maxNrCars,float x, float y) {
        TransportTruck transportTruck = new TransportTruck(maxNrCars,x,y);
        return transportTruck;
    }

    public Car CreateRandomCar(float x, float y) {
        Random random = new Random();
        int num = random.nextInt(3);

        switch (num) {
            case 0: // Saab95
                return CreateSaab95(x,y);
            case 1: // Volvo240
                return CreateVolvo240(x,y);
            case 2: //Scania
                return CreateScania(x,y);
            default:
                return null;
        }
    }
}