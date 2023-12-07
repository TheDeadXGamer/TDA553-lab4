package main.CarGame;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image
    private Image volvoImage;
    private Image saabImage;
    private Image scaniaImage;
    // To keep track of a singel cars position
    
    private ArrayList<Image> images = new ArrayList<>();
    private ArrayList<Point> points = new ArrayList<>();
    
    void addPosition(Point point){
        this.points.add(point);
    }

    void removePosition() {
        points.remove(points.size()-1);
    }

    void removeImage() {
        images.remove(images.size()-1);
    }

    void addImage(Image image){
        this.images.add(image);
    }

    void setPoint(int index, int x, int y){
        points.set(index,new Point(x, y));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\pics\\Scania.jpg"));

            
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }//Constructor

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(points.size() != 0){
            for(int k = 0; k < images.size(); k++){
                g.drawImage(images.get(k), points.get(k).x, points.get(k).y, null);
            }
        }
    }

    Image getVolvo240Image() {
        return volvoImage;
    }

    Image getSaab95Image() {
        return saabImage;
    }

    Image getScaniaImage() {
        return scaniaImage;
    }
}
