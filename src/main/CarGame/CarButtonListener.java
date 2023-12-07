package main.CarGame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.Random;


import main.Settings;
import main.CarModel.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CarButtonListener {
    private JPanel controlPanel = new JPanel();
    private JPanel gasPanel = new JPanel();
    private CarFactory CF = new CarFactory();

    private JButton removeCarButton = new JButton("Remove Car");
    private JButton addCarButton = new JButton("Add Car");
    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");
    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

    private JLabel gasLabel = new JLabel("Amount of gas");

    private JList<String> dropList;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private String dropListValue = "Random";

    private JSpinner gasSpinner;
    private int gasAmount = 0;

    private ArrayList<JComponent> components = new ArrayList<>();

    public CarButtonListener(CarController carC){
        controlPanel.setLayout(new GridLayout(2,6));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(startButton,6);
        controlPanel.add(stopButton,7);
        controlPanel.add(addCarButton,8);
        controlPanel.add(removeCarButton,9);
        controlPanel.setPreferredSize(new Dimension((Settings.getWindowWidth()/2)-200, 200));

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        listModel.addElement("Saab95");
        listModel.addElement("Scania");
        listModel.addElement("Volvo240");
        listModel.addElement("Random");

        dropList = new JList<>(listModel);

        dropList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        addToComponents(controlPanel);
        addToComponents(gasPanel);
        addToComponents(new JScrollPane(dropList));

         // This actionListener is for the gas button only
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startCars();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopCars();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.raiseBed();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.lowerBed();
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int x = random.nextInt(Settings.getWindowWidth() - Settings.getCarWidth());
                int y = random.nextInt(Settings.getWindowHeight() - Settings.getCarHeight() - Settings.getControllerHeight());
                switch(dropListValue){
                    case "Random":
                        carC.addCarToArr(CF.CreateRandomCar(x,y));
                        break;
                    case "Volvo240":
                        carC.addCar(CF.CreateVolvo240(x,y));
                        break;
                    case "Saab95":
                        carC.addCar(CF.CreateSaab95(x,y));
                        break;
                    case "Scania":
                        carC.addCar(CF.CreateScania(x,y));
                        break;
                }
            }
        });

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.removeCar();
            }
        });

        dropList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    dropListValue = dropList.getSelectedValue();
                }
            }
        });
    }

    private void addToComponents(JComponent component){
        components.add(component);
    }

    public ArrayList<JComponent> getComponents(){
        return components;
    }
}
