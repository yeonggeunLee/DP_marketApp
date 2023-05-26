package marketapp.marketapp.ProductList;

import javax.swing.ImageIcon;

public abstract class ProductList {

    public abstract Product addProductList(String name, String price, String desc, ImageIcon image, String type);

    public abstract Product readProductList(String name);

    public abstract Product editProductList(String name, String price, String desc, ImageIcon image, String type);

    public abstract Product deleteProductList(String name);
}
