package marketapp.marketapp.ProductList.Clothes;

import marketapp.marketapp.ProductList.Elec.*;
import marketapp.marketapp.ProductList.Product;
import marketapp.marketapp.ProductList.ProductList;
import marketapp.marketapp.ProductList.Foods.FoodList;

import javax.swing.*;

public class Clothes extends ProductList {
    /**
     * @param name  전달되는 상품명
     * @param price 전달되는 상품가격
     * @param desc  전달되는 상품정보
     * @param image 전달되는 상품이미지 Path
     * @param type  전달되는 상품 카테고리
     * @return 전자제품 카테고리 객체 생성
     */
    public Product addProductList(String name, String price, String desc, ImageIcon image, String type) {
        if (type.equals("의류")) {
            return new ElectronicList(name, price, desc, image, type, "add");
        } else {
            return null;
        }
    }

    public Product readProductList(String name) {
        return new ElectronicList(name, "read");
    }

    public Product editProductList(String name, String price, String desc, ImageIcon image, String type) {
        if (type.equals("의류")) {
            return new ElectronicList(name, price, desc, image, type, "edit");
        } else {
            return null;
        }
    }

    public Product deleteProductList(String name) {
        return new ElectronicList(name, "delete");
    }
}