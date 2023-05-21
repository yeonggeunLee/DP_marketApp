package marketapp.marketapp.ProductList;
import javax.swing.*;

public abstract class ProductList {
    // CRUD
    public abstract Product addProductList(String name, String price, String desc, ImageIcon image, String type);
    public abstract Product readProductList(String name);
    public abstract Product editProductList(String name, String price, String desc, ImageIcon image, String type);
    public abstract Product deleteProductList(String name);



    // 여기에 JSON 파일로 CRUD 하는 내용을 만들어야 하는지 아니면 다른 클래스로 만들어서 해야하는지 고민
}
