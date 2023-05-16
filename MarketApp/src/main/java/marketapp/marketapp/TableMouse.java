/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketapp.marketapp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author 이영근
 */
public class TableMouse implements MouseListener {

    public static String name;
    public static String desc;
    public static String price;
<<<<<<< HEAD
    public static ImageIcon img;
=======
    public static  ImageIcon img;
>>>>>>> e0e24efe2105e38101ecc95523afccf45a0a57df

    public static ImageIcon getImg() {
        return img;
    }

    public static String getName() {
        return name;
    }

    public static String getDesc() {
        return desc;
    }

    public static String getPrice() {
        return price;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {

            int r = ProductListScreen.productList.getSelectedRow();
            //int c = Tableicon.table.getSelectedColumn();
            Object o[] = new Object[ProductListScreen.productList.getColumnCount()];
            for (int col = 0; col < ProductListScreen.productList.getColumnCount(); col++) {
                o[col] = ProductListScreen.productList.getValueAt(r, col);
            }
            this.img = (ImageIcon) o[0];
            this.name = (String) o[1];
            this.desc = (String) o[2];
            this.price = (String) o[3];

            ProductDetailScreen detail = new ProductDetailScreen();
            //detail.setVisible(true);
        } // 더블클릭

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
