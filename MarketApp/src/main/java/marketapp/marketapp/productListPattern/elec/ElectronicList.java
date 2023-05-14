package marketapp.marketapp.productListPattern.elec;

import marketapp.marketapp.productListPattern.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;

public class ElectronicList extends Product {
    private static final String FILEPATH = "src\\main\\java\\marketapp\\marketapp\\productListPattern\\ProductList.json";
    File fileP = new File(FILEPATH);

    public ElectronicList(String name, String price, String desc, ImageIcon image, String type) {
        //super();
        productName = name;
        productPrice = price;
        productDesc = desc;
        productImage = image;
        productCategory = type;
        addToList();
    }

    public void addToList() {
        String image = productImage.toString();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileP));
            if (br.readLine() == null) {
                JSONObject productInfo = new JSONObject();
                productInfo.put("상품명", productName);
                productInfo.put("가격", productPrice);
                productInfo.put("상품정보", productDesc);
                productInfo.put("이미지", image);
                productInfo.put("카테고리", productCategory);

                JSONArray productInfoArr = new JSONArray();
                productInfoArr.add(productInfo);

                JSONObject producPut = new JSONObject();
                producPut.put("상품목록", productInfoArr);

                try {
                    FileWriter file = new FileWriter(FILEPATH, true);
                    file.write(producPut.toJSONString());
                    file.flush();
                } catch (IOException ae) {
                    ae.printStackTrace();
                }
            } else {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(FILEPATH));
                JSONObject loadJsonObj = (JSONObject) obj;

                JSONObject productInfo = new JSONObject();
                productInfo.put("상품명", productName);
                productInfo.put("가격", productPrice);
                productInfo.put("상품정보", productDesc);
                productInfo.put("이미지", image);
                productInfo.put("카테고리", productCategory);

                JSONArray productInfoArr = (JSONArray) loadJsonObj.get("상품목록");
                productInfoArr.add(productInfo);

                try {
                    FileWriter file = new FileWriter(FILEPATH);
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
}
