package main;

public class Settings {

    static private int windowWidth = 800;
    static private int windowHeight = 800;
    static private int carWidth = 100;
    static private int carHeight = 60;
    static private int controllerHeight = 200;
    static private int distanceConstantY = carWidth + 100;

    static public int getWindowHeight(){
        return windowHeight;
    }

    static public int getWindowWidth() {
        return windowWidth;
    }

    static public int getCarWidth(){
        return carWidth;
    }

    static public int getCarHeight(){
        return carHeight;
    }
    
    static public int getControllerHeight(){
        return controllerHeight;
    }

    static public int getDistanceConstantY(){
        return distanceConstantY;
    }
}