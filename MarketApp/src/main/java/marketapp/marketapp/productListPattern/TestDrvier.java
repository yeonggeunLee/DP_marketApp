package marketapp.marketapp.productListPattern;

import marketapp.marketapp.productListPattern.elec.Electronics;
import marketapp.marketapp.productListPattern.foods.Foods;

import javax.swing.*;

public class TestDrvier {
    public static void main(String[] args) {
        ProductList elecList = new Electronics();
        ProductList foodList = new Foods();

        ImageIcon phone = new ImageIcon( "src\\main\\java\\marketapp\\marketapp\\productListPattern\\Galaxy s23.jpg");
        //Product eProduct = elecList.addProductList("갤럭시 s23","1000000","2023년 새로 출시한 갤럭시", phone, "전자제품");

        //Product fProduct = foodList.addProductList("황금사과","50000","황금색 사과", phone, "식품");
        Product frProduct = foodList.readProductList("갤럭시 s23");
        //Product feProduct = foodList.editProductList("황금사과","40000","가짜 사과", phone, "식품");
        Product fdProduct = foodList.deleteProductList("갤럭시 s23");
    }
}