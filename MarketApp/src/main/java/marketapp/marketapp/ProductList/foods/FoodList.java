package marketapp.marketapp.ProductList.Foods;

import marketapp.marketapp.ProductList.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;

public class FoodList extends Product {

    private static final String FILEPATH = "src\\main\\java\\Data\\ProductList.json";
    File fileP = new File(FILEPATH);

    public static Boolean checkSameProduct = false;

    public static Boolean getCheckSameProduct() {
        return checkSameProduct;
    }

    public FoodList(String name, String crud) {
        productName = name;
        CRUDType = crud;
        if (CRUDType.equals("read")) {
            readProduct();
        } else if (CRUDType.equals("delete")) {
            deleteProduct();
        }
    }

    public FoodList(String name, String price, String desc, ImageIcon image, String type, String crud) {
        productName = name;
        productPrice = price;
        productDesc = desc;
        productImage = image;
        productCategory = type;
        CRUDType = crud;
        if (CRUDType.equals("add")) {
            addProduct();
        } else if (CRUDType.equals("edit")) {
            editProduct();
        }
    }

    public void addProduct() {
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
                JSONArray productInfoArr = (JSONArray) loadJsonObj.get("상품목록");

                if (productInfoArr.size() > 0) {
                    for (int i = 0; i < productInfoArr.size(); i++) {
                        JSONObject productObj = (JSONObject) productInfoArr.get(i);
                        String productInfo = (String) productObj.get("상품명");
                        if (productName.equals(productInfo)) {
                            checkSameProduct = true;
                            break;
                        }
                    }
                }
                if (checkSameProduct == true) {
                    JOptionPane.showMessageDialog(null, "같은 상품이 존재합니다.");
                } else {
                    JSONObject productInfo = new JSONObject();
                    productInfo.put("상품명", productName);
                    productInfo.put("가격", productPrice);
                    productInfo.put("상품정보", productDesc);
                    productInfo.put("이미지", image);
                    productInfo.put("카테고리", productCategory);

                    productInfoArr.add(productInfo);
                    try {
                        FileWriter file = new FileWriter(FILEPATH);
                        file.write(loadJsonObj.toJSONString());
                        file.flush();
                    } catch (IOException ae) {
                        ae.printStackTrace();
                    }
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

    public void readProduct() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileP));
            if (br.readLine() == null) {
                System.out.println("상품 리스트에 상품이 없습니다.");
            } else {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(FILEPATH));
                JSONObject loadJsonObj = (JSONObject) obj;
                JSONArray productInfoArr = (JSONArray) loadJsonObj.get("상품목록");

                if (productInfoArr.size() > 0) {
                    for (int i = 0; i < productInfoArr.size(); i++) {
                        JSONObject productObj = (JSONObject) productInfoArr.get(i);
                        String productInfo = (String) productObj.get("상품명");
                        if (productName.equals(productInfo)) {
                            String p = (String) productObj.get("가격");
                            String d = (String) productObj.get("상품정보");
                            String c = (String) productObj.get("카테고리");
                            String im = (String) productObj.get("이미지");
                            System.out.println("상품명: " + productInfo + ", " + "가격: " + p + ", " + "상품정보: " + d + ", " + "카테고리: " + c + ", " + "이미지: " + im);
                            break;
                        }
                    }
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

    public void editProduct() {
        String image = productImage.toString();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileP));
            if (br.readLine() == null) {
                System.out.println("상품 리스트에 상품이 없습니다.");
            } else {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(FILEPATH));
                JSONObject loadJsonObj = (JSONObject) obj;
                JSONArray productInfoArr = (JSONArray) loadJsonObj.get("상품목록");

                if (productInfoArr.size() > 0) {
                    for (int i = 0; i < productInfoArr.size(); i++) {
                        JSONObject productObj = (JSONObject) productInfoArr.get(i);
                        String productInfo = (String) productObj.get("상품명");
                        if (productName.equals(productInfo)) {
                            checkSameProduct = true;
                            break;
                        }
                    }
                }
                if (checkSameProduct == true) {
                    JOptionPane.showMessageDialog(null, "같은 상품이 존재합니다.");
                } else {
                    if (productInfoArr.size() > 0) {
                        for (int i = 0; i < productInfoArr.size(); i++) {
                            JSONObject productObj = (JSONObject) productInfoArr.get(i);
                            String productInfo = (String) productObj.get("상품명");
                            if (productName.equals(productInfo)) {
                                productObj.remove("상품명");
                                productObj.remove("상품정보");
                                productObj.remove("카테고리");
                                productObj.remove("이미지");
                                productObj.remove("가격");
                                productObj.put("상품명", productName);
                                productObj.put("상품정보", productDesc);
                                productObj.put("카테고리", productCategory);
                                productObj.put("이미지", image);
                                productObj.put("가격", productPrice);
                                try {
                                    FileWriter file = new FileWriter(FILEPATH);
                                    file.write(loadJsonObj.toJSONString());
                                    file.flush();
                                } catch (IOException ae) {
                                    ae.printStackTrace();
                                }
                                break;
                            }
                        }
                    }
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

    public void deleteProduct() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileP));
            if (br.readLine() == null) {
                System.out.println("상품 리스트에 상품이 없습니다.");
            } else {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(FILEPATH));
                JSONObject loadJsonObj = (JSONObject) obj;
                JSONArray productInfoArr = (JSONArray) loadJsonObj.get("상품목록");

                if (productInfoArr.size() > 0) {
                    for (int i = 0; i < productInfoArr.size(); i++) {
                        JSONObject productObj = (JSONObject) productInfoArr.get(i);
                        String productInfo = (String) productObj.get("상품명");
                        if (productName.equals(productInfo)) {
                            productInfoArr.remove(i);
                            try {
                                FileWriter file = new FileWriter(FILEPATH);
                                file.write(loadJsonObj.toJSONString());
                                file.flush();
                            } catch (IOException ae) {
                                ae.printStackTrace();
                            }
                            break;
                        }
                    }
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
