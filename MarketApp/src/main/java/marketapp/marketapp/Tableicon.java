package marketapp.marketapp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;

public class Tableicon extends JPanel {

    String filePath = "src\\main\\java\\marketapp\\marketapp\\productListPattern\\ProductList.json";
    Object[][] contents;
    public static JTable table;

    public static ImageIcon tableImage;
    public static String pName;
    public static String pPrice;
    public static String pDesc;

    public static ImageIcon getTableImage() {
        return tableImage;
    }

    public Tableicon() {
        // 테이블에 JSON 파일에 저장된 데이터  넣기
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
                contents[i][0] = tableImage;
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
            table.setRowHeight(100);
            //table.setSize(1440, 960);
            //table.setPreferredScrollableViewportSize(table.getPreferredSize());

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(1440, 960));

            add(scrollPane);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
