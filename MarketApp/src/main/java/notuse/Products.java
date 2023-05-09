/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notuse;

import javax.swing.JFrame;

/**
 *
 * @author 이영근
 */
public class Products {

    public Products() {
        JFrame frame = new JFrame("Table Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440, 960);
        frame.add(new Tableicon());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
    
}
