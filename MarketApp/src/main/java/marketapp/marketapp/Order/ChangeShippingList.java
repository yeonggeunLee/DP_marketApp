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
 * 배송지 정보를 추가, 삭제, 변경을 하기 위한 기능을 구현한 클래스
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
                productInfo.put("받는사람", ShippingListPage.getShipAddNameTF());
                productInfo.put("전화번호", ShippingListPage.getShipAddNumberTF());
                productInfo.put("주소", ShippingListPage.getShipAddAddressTF());
                productInfo.put("요청사항", ShippingListPage.getShipAddRequestTF());

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
                productInfo.put("받는사람", ShippingListPage.getShipAddNameTF());
                productInfo.put("전화번호", ShippingListPage.getShipAddNumberTF());
                productInfo.put("주소", ShippingListPage.getShipAddAddressTF());
                productInfo.put("요청사항", ShippingListPage.getShipAddRequestTF());

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
                String compare = ShippingListPage.getTableName();
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
        String changeName = ShippingListPage.getShipAddNameTF();
        String changeNumber = ShippingListPage.getShipAddNumberTF();
        String changeAddress = ShippingListPage.getShipAddAddressTF();
        String changeRequest = ShippingListPage.getShipAddRequestTF();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject loadJsonObj = (JSONObject) obj;
            JSONArray shippingListArr = (JSONArray) loadJsonObj.get("배송지정보");

            for (int i = 0; i < shippingListArr.size(); i++) {
                JSONObject shippingList = (JSONObject) shippingListArr.get(i);
                String test = (String) shippingList.get("받는사람");
                String compare = ShippingListPage.getTableName();
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
