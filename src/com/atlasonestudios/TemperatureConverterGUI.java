/*
All code by AtlasOneCoding, A Part Of AtlasOneStudios
AtlasOneStudios by Atlas (screen name for [REDACTED])
Permission to use this code for ones own project, as long as it is not entirely copied and distributed, is granted.
*/



//set the package
package com.atlasstudios;

//import dependencies
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

//create the window class
public class TemperatureConverterGUI extends JFrame {

    //create variables
    static int cFB = 1;
    static int cTB = 1;
    private JPanel mainPanel;
    JTextField inputBox;
    private JComboBox convertFromBox;
    private JComboBox convertToBox;
    JLabel outputBox;

    public TemperatureConverterGUI(String title) {
        //build window
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        //listener for selected item in first drop down menu
        convertFromBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) convertFromBox.getItemAt(convertFromBox.getSelectedIndex());
                if (selectedItem == "C") {
                    cFB = 1;
                }
                if (selectedItem == "F") {
                    cFB = 2;
                }
                if (selectedItem == "K") {
                    cFB = 3;
                }
            }
        });
        //listener for selected item in second drop down menu
        convertToBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedItem = (String) convertToBox.getItemAt(convertToBox.getSelectedIndex());
                if (selectedItem == "C") {
                    cTB = 1;
                }
                if (selectedItem == "F") {
                    cTB = 2;
                }
                if (selectedItem == "K") {
                    cTB = 3;
                }

            }
        });
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //detect inputBox and outputBox answer
                //set text variable from inputBox

                double inputValue = Double.valueOf(inputBox.getText());

                //deny same-unit conversion
                if ((cFB == 1 && cTB == 1) || (cFB == 2 && cTB == 2) || (cFB == 3 && cFB == 3)) {
                    outputBox.setText("Cannot convert to same unit!");
                }

                //detect selected converters
                //celsius conversions
                if (cFB == 1 && cTB == 2) {
                    outputBox.setText(String.valueOf(((inputValue / 1.8) + 32)));
                }

                if (cFB == 1 && cTB == 3) {
                    outputBox.setText(String.valueOf((inputValue + 273.15)));
                }

                //fahrenheit conversions
                if (cFB == 2 && cTB == 1) {
                    outputBox.setText(String.valueOf((inputValue - 32) * 1.8));
                }

                if (cFB == 2 && cTB == 3) {
                    outputBox.setText(String.valueOf(((inputValue - 32) / 1.8) + 273.15));
                }
                // kelvin conversions
                if (cFB == 3 && cTB == 1) {
                    outputBox.setText(String.valueOf(inputValue - 273.15));
                }

                if (cFB == 3 && cTB == 2) {
                    outputBox.setText(String.valueOf(((inputValue - 273.15) * 1.8) + 32));
                }

            }
        });
    }


    public static void main(String[] args) {

        //initialize window
        JFrame frame = new TemperatureConverterGUI("Temperature Converter");

        URL iconURL = TemperatureConverterGUI.class.getResource("icon.png");
        // iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());

        frame.setVisible(true);
    }
}