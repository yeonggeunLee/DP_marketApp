/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketapp.marketapp.Order;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 이영근
 */
public class ChangeShippingList {

    public static String filePath = "src\\main\\java\\Data\\ShippingList.json";
    public static DefaultTableModel model;
    public static Boolean checkList = false;

    public static void addShippingList() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            if (br.readLine() == null) {
                JSONObject productInfo = new JSONObject();
                productInfo.put("받는사람", ShippingList.getShipAddNameTF());
                productInfo.put("전화번호", ShippingList.getShipAddNumberTF());
                productInfo.put("주소", ShippingList.getShipAddAddressTF());
                productInfo.put("요청사항", ShippingList.getShipAddRequestTF());

                JSONArray productInfoArr = new JSONArray();
                productInfoArr.add(productInfo);

                JSONObject producPut = new JSONObject();
                producPut.put("배송지정보", productInfoArr);

                try {
                    FileWriter file = new FileWriter(filePath, true);
                    file.write(producPut.toJSONString());
                    file.flush();
                } catch (IOException ae) {
                    ae.printStackTrace();
                }
            } else {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(filePath));
                JSONObject loadJsonObj = (JSONObject) obj;
                JSONArray productInfoArr = (JSONArray) loadJsonObj.get("배송지정보");

                JSONObject productInfo = new JSONObject();
                productInfo.put("받는사람", ShippingList.getShipAddNameTF());
                productInfo.put("전화번호", ShippingList.getShipAddNumberTF());
                productInfo.put("주소", ShippingList.getShipAddAddressTF());
                productInfo.put("요청사항", ShippingList.getShipAddRequestTF());

                productInfoArr.add(productInfo);

                try {
                    FileWriter file = new FileWriter(filePath);
                    file.write(loadJsonObj.toJSONString());
                    file.flush();
                } catch (IOException ae) {
                    ae.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteShippingList() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject loadJsonObj = (JSONObject) obj;
            JSONArray shippingListArr = (JSONArray) loadJsonObj.get("배송지정보");
            

            for (int i = 0; i < shippingListArr.size(); i++) {
                JSONObject shippingList = (JSONObject) shippingListArr.get(i);
                String test = (String) shippingList.get("받는사람");
                String compare = ShippingList.getTableName();
                if (test.equals(compare)) {
                    JSONObject productInfo = new JSONObject();
                    shippingListArr.remove(i);
                    try {
                        FileWriter file = new FileWriter(filePath);
                        file.write(loadJsonObj.toJSONString());
                        file.flush();
                    } catch (IOException ae) {
                        ae.printStackTrace();
                    }
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void editShippingList() {
        String changeName = ShippingList.getShipAddNameTF();
        String changeNumber = ShippingList.getShipAddNumberTF();
        String changeAddress = ShippingList.getShipAddAddressTF();
        String changeRequest = ShippingList.getShipAddRequestTF();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject loadJsonObj = (JSONObject) obj;
            JSONArray shippingListArr = (JSONArray) loadJsonObj.get("배송지정보");

            for (int i = 0; i < shippingListArr.size(); i++) {
                JSONObject shippingList = (JSONObject) shippingListArr.get(i);
                String test = (String) shippingList.get("받는사람");
                String compare = ShippingList.getTableName();
                if (test.equals(compare)) {
                    JSONObject productInfo = new JSONObject();
                    shippingListArr.remove(i);
                    productInfo.put("받는사람", changeName);
                    productInfo.put("전화번호", changeNumber);
                    productInfo.put("주소", changeAddress);
                    productInfo.put("요청사항", changeRequest);
                    shippingListArr.add(productInfo);
                    
                    try {
                        FileWriter file = new FileWriter(filePath);
                        file.write(loadJsonObj.toJSONString());
                        file.flush();
                    } catch (IOException ae) {
                        ae.printStackTrace();
                    }
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
