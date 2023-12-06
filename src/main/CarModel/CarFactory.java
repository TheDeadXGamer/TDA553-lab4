package main.CarModel;

import java.util.ArrayList;
import java.util.Random;

public class CarFactory {

    ArrayList<Car> createdCars = new ArrayList<>();

    public Scania CreateScania(float x, float y) {
        Scania scania = new Scania(x, y);
        createdCars.add(scania);
        return scania;
    }

    public Volvo240 CreateVolvo240(float x, float y) {
        Volvo240 volvo240 = new Volvo240(x ,y);
        createdCars.add(volvo240);
        return volvo240;
    }

    public Saab95 CreateSaab95(float x, float y) {
        Saab95 saab95 = new Saab95(x, y);
        createdCars.add(saab95);
        return saab95;
    }

    public TransportTruck CreateTransportTruck(int maxNrCars,float x, float y) {
        TransportTruck transportTruck = new TransportTruck(maxNrCars,x,y);
        createdCars.add(transportTruck);
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