package main.CarGame;
import javax.swing.*;

import main.Settings;

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

    private ArrayList<Color> colors = new ArrayList<>(); 

    DrawPanel drawPanel = new DrawPanel(windowWidth, windowHeight-240);
    
    

    // Constructor
    public CarView(String framename, CarButtonListener cb){
        initComponents(framename, cb.getComponents());
    }
    
    // Sets everything in place and fits everything
    private void initComponents(String title, ArrayList<JComponent> components) {

        colors.add(Color.blue);
        colors.add(Color.green);
        colors.add(Color.red);
        colors.add(Color.black);
        
        this.setTitle(title);
        this.setPreferredSize(new Dimension(windowWidth,windowHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        for(int k = 0; k < components.size(); k++){
            JComponent panel = components.get(k);
            if(panel.getLayout() == new GridLayout(2,4)){
                panel.setPreferredSize(new Dimension((windowWidth/2)+4, 200));
                this.add(panel);
                panel.setBackground(Color.CYAN);
                continue;
            }
            if(panel instanceof JButton){
                panel.setBackground(colors.get(k-1));
                panel.setForeground(colors.get(k));
                panel.setPreferredSize(new Dimension(windowWidth/5-15,200));
                this.add(panel);
            }
            else{
                this.add(panel);
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
}