package main;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private JPanel gasPanel = new JPanel();
    
    private JLabel gasLabel = new JLabel("Amount of gas");

   

    // Constructor
    public CarView(String framename, CarController cc){
        initComponents(framename);
    }
    
    // Sets everything in place and fits everything
    private void initComponents(String title, ArrayList<JComponent> panels) {
        
        this.setTitle(title);
        this.setPreferredSize(new Dimension(windowWidth,windowHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        for(JComponent panel: panels){
            if(panel instanceof )
        }

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);


        
        controlPanel.setPreferredSize(new Dimension((windowWidth/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(windowWidth/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(windowWidth/5-15,200));
        this.add(stopButton);

       
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        new Dimension(5,7);
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