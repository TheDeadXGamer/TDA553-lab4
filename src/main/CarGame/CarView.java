package main.CarGame;
import javax.swing.*;

import main.Settings;
import main.CarModel.Vehicles.Car;
import main.CarModel.Vehicles.Saab95;
import main.CarModel.Vehicles.Volvo240;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{

    //Import settings from WindowSettings
    private int windowHeight = Settings.getWindowHeight();
    private int windowWidth = Settings.getWindowWidth();

    DrawPanel drawPanel = new DrawPanel(windowWidth, windowHeight-240);
    
    // Constructor
    public CarView(String framename, CarButtonListener cb){
        initComponents(framename, cb.getComponents());
    }
    
    // Sets everything in place and fits everything
    private void initComponents(String title, ArrayList<JComponent> components) {
        
        this.setTitle(title);
        this.setPreferredSize(new Dimension(windowWidth,windowHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        
        for(JComponent component: components){
            if(component.getLayout() instanceof GridLayout){
                GridLayout layout = (GridLayout)component.getLayout();
                if(layout.getRows() == 2 && layout.getColumns() == 6){
                    component.setPreferredSize(new Dimension((windowWidth/2)+100, 200));
                    component.setBackground(Color.CYAN);
                    component.setForeground(Color.red);
                    this.add(component);
                }
            }
            else if(component instanceof JScrollPane){
                component.setPreferredSize(new Dimension(100,100));
                component.setBackground(Color.MAGENTA);
                this.add(component);
            }
            else{
                component.setPreferredSize(new Dimension(100, 100));
                component.setBackground(Color.CYAN);
                this.add(component);
            }
        }

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void initiateCarToArr(Car car) {
        if (car instanceof Volvo240) {
            drawPanel.addImage(drawPanel.getVolvo240Image());
            Point pos = new Point(Math.round(car.getPosition().getX()), Math.round(car.getPosition().getY()));
            drawPanel.addPosition(pos);
        }
        else if (car instanceof Saab95) {
            drawPanel.addImage(drawPanel.getSaab95Image());
            Point pos = new Point(Math.round(car.getPosition().getX()), Math.round(car.getPosition().getY()));
            drawPanel.addPosition(pos);
        }
        else {
            drawPanel.addImage(drawPanel.getScaniaImage());
            Point pos = new Point(Math.round(car.getPosition().getX()), Math.round(car.getPosition().getY()));
            drawPanel.addPosition(pos);
        }
    }

    void removeCarFromArrays() {
        drawPanel.removeImage();
        drawPanel.removePosition();
    }
}