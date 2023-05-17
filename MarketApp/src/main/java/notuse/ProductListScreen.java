/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notuse;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import marketapp.marketapp.ProductList.TableMouse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 이영근
 */
public class ProductListScreen {

    JFrame productList = new JFrame("Table Icon");


    String filePath = "src\\main\\java\\marketapp\\marketapp\\productListPattern\\Data\\ProductList.json";
    public static JTable table;
    Object[][] contents;

    public static ImageIcon tableImage;
    public static String pName;
    public static String pPrice;
    public static String pDesc;

    public ProductListScreen() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("상품목록");

            String[] header = {"상품 이미지", "상품명", "상품정보", "가격"};
            contents = new Object[productInfoArr.size()][4];
            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                this.tableImage = new ImageIcon((String) jObj.get("이미지"));
                Image needChangeImage = tableImage.getImage();
                Image changedImage = needChangeImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                ImageIcon changedImageIcon = new ImageIcon(changedImage);
                contents[i][0] = changedImageIcon;
                contents[i][1] = jObj.get("상품명");
                contents[i][2] = jObj.get("상품정보");
                contents[i][3] = jObj.get("가격");

                this.pName = (String) jObj.get("상품명");
                this.pPrice = (String) jObj.get("가격");
                this.pDesc = (String) jObj.get("상품정보");
            }

            DefaultTableModel model = new DefaultTableModel(contents, header) {
                //  Returning the Class of each column will allow different
                //  renderers to be used based on Class
                public Class getColumnClass(int column) {
                    return getValueAt(0, column).getClass();
                }
            };

            table = new JTable(model) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            table.addMouseListener(new TableMouse());
            table.setRowHeight(150);
            //table.setSize(1440, 960);
            //table.setPreferredScrollableViewportSize(table.getPreferredSize());

            JScrollPane scrollPane = new JScrollPane(table);
            //scrollPane.setBounds(300,0,1360,1024);
            scrollPane.setPreferredSize(new Dimension(1440,1024));
            scrollPane.setSize(new Dimension(1440,1024));
            productList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            productList.setSize(1920, 1024);
            productList.add(scrollPane);

            productList.setResizable(false);
            productList.setVisible(true);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
