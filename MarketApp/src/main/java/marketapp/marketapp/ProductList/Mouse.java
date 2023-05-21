/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketapp.marketapp.ProductList;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static marketapp.marketapp.ProductList.AdminPageScreen.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 이영근
 */
public class Mouse implements MouseListener {

    String filePath = "src\\main\\java\\Data\\ProductList.json";
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            int r = adminProductTable.getSelectedRow();
            Object o[] = new Object[adminProductTable.getColumnCount()];
            for (int col = 0; col < adminProductTable.getColumnCount(); col++) {
                o[col] = adminProductTable.getValueAt(r, col);
            }
            setSelectedProductName((String) o[1]);

            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(filePath));
                JSONObject JsonObj = (JSONObject) obj;
                JSONArray productInfoArr = (JSONArray) JsonObj.get("상품목록");

                for (int i = 0; i < productInfoArr.size(); i++) {
                    JSONObject jObj = (JSONObject) productInfoArr.get(i);
                    String dfoundName = (String) jObj.get("상품명");
                    if (SelectedProductName.equals(dfoundName)) {
                        setSelectedProductCategory((String) jObj.get("카테고리"));
                        break;
                    }
                }
            } catch (FileNotFoundException eeee) {
                eeee.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Mouse.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Mouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
