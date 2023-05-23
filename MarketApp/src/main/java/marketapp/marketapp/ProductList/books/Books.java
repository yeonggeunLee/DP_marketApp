package marketapp.marketapp.ProductList.Books;

import marketapp.marketapp.ProductList.Product;
import marketapp.marketapp.ProductList.ProductList;
import marketapp.marketapp.ProductList.Elec.ElectronicList;

import javax.swing.*;

public class Books extends ProductList {
    /**
     * @param name  전달되는 상품명
     * @param price 전달되는 상품가격
     * @param desc  전달되는 상품정보
     * @param image 전달되는 상품이미지 Path
     * @param type  전달되는 상품 카테고리
     * @return 도서 카테고리 객체 생성
     */
    public Product addProductList(String name, String price, String desc, ImageIcon image, String type) {
        if (type.equals("도서")) {
            return new BookList(name, price, desc, image, type, "add");
        } else {
            return null;
        }
    }

    public Product readProductList(String name) {
        return new BookList(name,"read");
    }

    public Product editProductList(String name, String price, String desc, ImageIcon image, String type) {
        if (type.equals("도서")) {
            return new BookList(name, price, desc, image, type, "edit");
        } else {
            return null;
        }
    }

    public Product deleteProductList(String name) {
        return new BookList(name, "delete");
    }
}