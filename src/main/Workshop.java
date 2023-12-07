package main;
import java.util.ArrayList;

import main.CarModel.Vehicles.Car;

public class Workshop<T extends Car> {
    
    private int maxNrOfCars;
    private ArrayList<T> carsInWorkshop;

    public Workshop(int MaxNrOfCars){
        maxNrOfCars = MaxNrOfCars;
        carsInWorkshop = new ArrayList<>(MaxNrOfCars);
    }

    public void loadCar (T car){
        if(carsInWorkshop.size() < maxNrOfCars){
            carsInWorkshop.add(car);
        }
    }

    public void unloadCar(T car) {
        if(carsInWorkshop.contains(car)) {
            carsInWorkshop.remove(car);
        }
    }

    public ArrayList<T> getStorage() {
        return carsInWorkshop;
    }
}
