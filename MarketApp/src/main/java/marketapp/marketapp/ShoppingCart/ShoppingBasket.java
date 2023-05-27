package marketapp.marketapp.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ShoppingBasket extends JFrame {

    String cartfilePath = "src\\main\\java\\Data\\cartData.json";
    private JPanel p;
    private DefaultTableModel model;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField productNameField;
    private JTextField productDescriptionField;
    private JTextField priceField;
    private JTextField quantityField;

    public ShoppingBasket() {
        p = new JPanel();
        p.setSize(800, 500);
        p.setLayout(null);
        setTitle("장바구니");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        JButton KeepShop = new JButton("계속 쇼핑하기");
        KeepShop.setBackground(Color.WHITE);
        KeepShop.setLocation(500, 700);
        KeepShop.setSize(200, 30);
        KeepShop.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        p.add(KeepShop);

        String[] arr = {"상품명", "상품설명", "가격", "수량"};

        model = new DefaultTableModel(arr, 0) {
            public boolean isCellEditable(int r, int c) {
                return (c != 0) ? true : false;
            }
        };

        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(240, 130, 800, 350);
        p.add(scroll);

        KeepShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Tableicon();
                setVisible(false);
            }
        });

        JButton Buy = new JButton("구매하기");
        Buy.setBackground(Color.WHITE);
        Buy.setLocation(700, 700);
        Buy.setSize(200, 30);
        Buy.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        p.add(Buy);

        Buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new input();
                setVisible(false);
            }
        });
        JButton Add = new JButton("상품 추가");
        Add.setBackground(Color.WHITE);
        Add.setLocation(700, 500);
        Add.setSize(200, 30);
        Add.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = productNameField.getText();
                String productDescription = productDescriptionField.getText();
                String price = priceField.getText();
                String quantity = quantityField.getText();

                DefaultTableModel tableModel = (DefaultTableModel) table.getModel(); // tableModel 선언 및 초기화
                tableModel.addRow(new Object[]{productName, productDescription, price, quantity});

                // 입력 필드 초기화
                productNameField.setText("");
                productDescriptionField.setText("");
                priceField.setText("");
                quantityField.setText("");
            }
        });

        p.add(Add);

        JButton Update = new JButton("수량 변경");
        Update.setBackground(Color.WHITE);
        Update.setLocation(500, 500);
        Update.setSize(200, 30);
        Update.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String quantity = JOptionPane.showInputDialog(null, "변경할 수량을 입력하세요:");
                    int newQuantity = Integer.parseInt(quantity);

                    // 기존 가격 가져오기
                    Object currentPriceObj = table.getValueAt(selectedRow, 2); // 가격 열의 인덱스가 2라고 가정함
                    double currentPrice = Double.parseDouble(currentPriceObj.toString());

                    // 기존 수량 가져오기
                    Object currentQuantityObj = table.getValueAt(selectedRow, 3); // 수량 열의 인덱스가 3라고 가정함
                    int currentQuantity = Integer.parseInt(currentQuantityObj.toString());

                    // 가격 조정
                    double newPrice = currentPrice / currentQuantity * newQuantity;

                    // 수량 및 가격 업데이트
                    table.setValueAt(quantity, selectedRow, 3); // 수량 열의 인덱스가 3라고 가정함
                    table.setValueAt(newPrice, selectedRow, 2); // 가격 열의 인덱스가 2라고 가정함
                } else {
                    JOptionPane.showMessageDialog(null, "수량을 변경할 상품을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        p.add(Update);

        JButton Del = new JButton("상품 삭제");
        Del.setBackground(Color.WHITE);
        Del.setLocation(300, 500);
        Del.setSize(200, 30);
        Del.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        Del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel(); // tableModel 선언 및 초기화
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "삭제할 상품을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        p.add(Del);

        // 텍스트 필드 생성 및 설정
        productNameField = new JTextField();
        productNameField.setBounds(20, 130, 200, 30);
        p.add(productNameField);

        productDescriptionField = new JTextField();
        productDescriptionField.setBounds(20, 180, 200, 30);
        p.add(productDescriptionField);

        priceField = new JTextField();
        priceField.setBounds(20, 230, 200, 30);
        p.add(priceField);

        quantityField = new JTextField();
        quantityField.setBounds(20, 280, 200, 30);
        p.add(quantityField);

        add(p);
        setSize(1440, 800);
        setVisible(true);

        loadProductFromCart();
    }

    private void loadProductFromCart() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(cartfilePath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) JsonObj.get("쇼핑카트");
            
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject cartProduct = (JSONObject) jsonArray.get(i);
                String productName = (String) cartProduct.get("Product");
                String productDetails = (String) cartProduct.get("Details");
                String productPrice = (String) cartProduct.get("Price");
                String productCount = (String) cartProduct.get("Count");

                this.model.addRow(new Object[]{productName, productDetails, productPrice, productCount});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
