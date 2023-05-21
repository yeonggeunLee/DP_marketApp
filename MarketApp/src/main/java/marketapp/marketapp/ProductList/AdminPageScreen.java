/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package marketapp.marketapp.ProductList;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import marketapp.marketapp.Order.Payment;

import marketapp.marketapp.ProductList.books.BookList;
import marketapp.marketapp.ProductList.books.Books;
import marketapp.marketapp.ProductList.elec.ElectronicList;
import marketapp.marketapp.ProductList.elec.Electronics;
import marketapp.marketapp.ProductList.foods.FoodList;
import marketapp.marketapp.ProductList.foods.Foods;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 이영근
 */
public class AdminPageScreen extends javax.swing.JFrame {

    DefaultTableModel model;
    String filePath = "src\\main\\java\\Data\\ProductList.json";
    Object[][] contents;

    public static ImageIcon tableImage;
    public static String pName;
    public static String pPrice;
    public static String pDesc;
    String imgPath;

    // 상품 변수
    public static String InputImgPath;
    public static String InputProductName;
    public static String InputProductDesc;
    public static String InputProductPrice;
    public static String InputProductCategory;

    public static String SelectedProductName;
    public static String SelectedProductCategory;

    public static String getSelectedProductName() {
        return SelectedProductName;
    }

    public static String getSelectedProductCategory() {
        return SelectedProductCategory;
    }

    public static void setSelectedProductName(String SelectProductName) {
        AdminPageScreen.SelectedProductName = SelectProductName;
    }

    public static void setSelectedProductCategory(String SelectProductCategory) {
        AdminPageScreen.SelectedProductCategory = SelectProductCategory;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public AdminPageScreen() {
        initComponents();
        adminProductTable.addMouseListener(new Mouse());
        adminProductTable.setRowHeight(150);
        adminProductTable.getTableHeader().setFont(new java.awt.Font("맑은 고딕", 1, 20));
        setVisible(true);
    }

    public DefaultTableModel Setting() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("상품목록");

            String[] header = {"상품 이미지", "상품명", "상품정보", "가격"};
            contents = new Object[productInfoArr.size()][4];
            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                this.tableImage = new ImageIcon((String) jObj.get("이미지"));
                Image needChangeImage = tableImage.getImage();
                Image changedImage = needChangeImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                ImageIcon changedImageIcon = new ImageIcon(changedImage);
                contents[i][0] = changedImageIcon;
                contents[i][1] = jObj.get("상품명");
                contents[i][2] = jObj.get("상품정보");
                contents[i][3] = jObj.get("가격");

                this.pName = (String) jObj.get("상품명");
                this.pPrice = (String) jObj.get("가격");
                this.pDesc = (String) jObj.get("상품정보");
            }

            this.model = new DefaultTableModel(contents, header) {
                //  Returning the Class of each column will allow different
                //  renderers to be used based on Class
                public Class getColumnClass(int column) {
                    return getValueAt(0, column).getClass();
                }
            };
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return model;
    }

    public DefaultTableModel SearchSetting() {
        String checkName = "";
        String searchName = searchTF.getText();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("상품목록");

            String[] header = {"상품 이미지", "상품명", "상품정보", "가격"};
            contents = new Object[productInfoArr.size()][4];
            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                checkName = (String) jObj.get("상품명");
                if (checkName.equals(searchName)) {
                    this.tableImage = new ImageIcon((String) jObj.get("이미지"));
                    Image needChangeImage = tableImage.getImage();
                    Image changedImage = needChangeImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                    ImageIcon changedImageIcon = new ImageIcon(changedImage);
                    contents[i][0] = changedImageIcon;
                    contents[i][1] = jObj.get("상품명");
                    contents[i][2] = jObj.get("상품정보");
                    contents[i][3] = jObj.get("가격");
                    /*
                    this.pName = (String) jObj.get("상품명");
                    this.pPrice = (String) jObj.get("가격");
                    this.pDesc = (String) jObj.get("상품정보");
                     */
                    break;
                }
            }

            this.model = new DefaultTableModel(contents, header);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return model;
    }

    public void refreshProductList() {
        adminProductTable.setModel(Setting());
        adminProductTable.revalidate();
        adminProductTable.repaint();
        adminProductList.revalidate();
        adminProductList.repaint();
        adminProductList.setVisible(true);

    }

    public String getCategoryFromList(String productName) {
        String checkName = "";
        String searchName = productName;
        String searchCategory = "";

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("상품목록");

            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                checkName = (String) jObj.get("상품명");
                if (searchName.equals(checkName)) {
                    searchCategory = (String) jObj.get("카테고리");
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminPageScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminPageScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminPageScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchCategory;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addProductFrame = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        imgInputTF = new javax.swing.JTextField();
        nameInputTF = new javax.swing.JTextField();
        priceInputTF = new javax.swing.JTextField();
        detailInputTF = new javax.swing.JTextField();
        imgSelector = new javax.swing.JButton();
        addProductButt = new javax.swing.JButton();
        cancelButt = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        categoryCBox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        categoryCBox2 = new javax.swing.JComboBox<>();
        imageChooser = new javax.swing.JFileChooser();
        editProductFrame = new javax.swing.JFrame();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        imgEditTF = new javax.swing.JTextField();
        nameEditTF = new javax.swing.JTextField();
        priceEditTF = new javax.swing.JTextField();
        detailEditTF = new javax.swing.JTextField();
        imgEditSelector = new javax.swing.JButton();
        editProductButt = new javax.swing.JButton();
        cancelEditButt = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        categoryEditCBox = new javax.swing.JComboBox<>();
        categoryEditCBox2 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        memberManageButt = new javax.swing.JButton();
        productManageButt = new javax.swing.JButton();
        orderManageButt = new javax.swing.JButton();
        adminProductList = new javax.swing.JScrollPane();
        adminProductTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        productManagePanel = new javax.swing.JPanel();
        addButt = new javax.swing.JButton();
        deleteButt = new javax.swing.JButton();
        editButt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();
        searchButt = new javax.swing.JButton();

        addProductFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addProductFrame.setTitle("상품추가 입력폼");
        addProductFrame.setSize(new java.awt.Dimension(650, 700));
        addProductFrame.setType(java.awt.Window.Type.POPUP);

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("이미지");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("상품명");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("상품정보");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("가격");

        imgInputTF.setEditable(false);
        imgInputTF.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        imgInputTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgInputTFActionPerformed(evt);
            }
        });

        nameInputTF.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        nameInputTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputTFActionPerformed(evt);
            }
        });

        priceInputTF.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N

        detailInputTF.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N

        imgSelector.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        imgSelector.setText("파일선택");
        imgSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgSelectorActionPerformed(evt);
            }
        });

        addProductButt.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        addProductButt.setText("상품 추가");
        addProductButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtActionPerformed(evt);
            }
        });

        cancelButt.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        cancelButt.setText("취소");
        cancelButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("카테고리");
        jLabel7.setMaximumSize(new java.awt.Dimension(54, 25));
        jLabel7.setPreferredSize(new java.awt.Dimension(54, 25));

        categoryCBox.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        categoryCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "전자제품", "도서", "식품" }));
        categoryCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCBoxActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel13.setText("대분류");

        jLabel14.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel14.setText("소분류");

        categoryCBox2.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        categoryCBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "카메라", "휴대폰", "컴퓨터", "etc" }));
        categoryCBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCBox2ActionPerformed(evt);
            }
        });
        categoryCBox2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                categoryCBox2PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout addProductFrameLayout = new javax.swing.GroupLayout(addProductFrame.getContentPane());
        addProductFrame.getContentPane().setLayout(addProductFrameLayout);
        addProductFrameLayout.setHorizontalGroup(
            addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductFrameLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addProductFrameLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detailInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addProductFrameLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(priceInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addProductFrameLayout.createSequentialGroup()
                                .addComponent(addProductButt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelButt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addProductFrameLayout.createSequentialGroup()
                        .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addProductFrameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(addProductFrameLayout.createSequentialGroup()
                                        .addComponent(imgInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(imgSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addProductFrameLayout.createSequentialGroup()
                                        .addComponent(categoryCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(categoryCBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(addProductFrameLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel13)
                                .addGap(168, 168, 168)
                                .addComponent(jLabel14)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        addProductFrameLayout.setVerticalGroup(
            addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductFrameLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryCBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductButt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        editProductFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editProductFrame.setTitle("상품추가 입력폼");
        editProductFrame.setSize(new java.awt.Dimension(650, 700));
        editProductFrame.setType(java.awt.Window.Type.POPUP);

        jLabel8.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("이미지");

        jLabel9.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("상품명");

        jLabel10.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("상품정보");

        jLabel11.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("가격");

        imgEditTF.setEditable(false);
        imgEditTF.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        imgEditTF.setText(InputImgPath);
        imgEditTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgEditTFActionPerformed(evt);
            }
        });

        nameEditTF.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        nameEditTF.setText(InputProductName);
        nameEditTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameEditTFActionPerformed(evt);
            }
        });

        priceEditTF.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        priceEditTF.setText(InputProductPrice);

        detailEditTF.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        detailEditTF.setText(InputProductDesc);

        imgEditSelector.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        imgEditSelector.setText("파일선택");
        imgEditSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgEditSelectorActionPerformed(evt);
            }
        });

        editProductButt.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        editProductButt.setText("상품 수정");
        editProductButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductButtActionPerformed(evt);
            }
        });

        cancelEditButt.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        cancelEditButt.setText("취소");
        cancelEditButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditButtActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("카테고리");
        jLabel12.setMaximumSize(new java.awt.Dimension(54, 25));
        jLabel12.setPreferredSize(new java.awt.Dimension(54, 25));

        categoryEditCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "전자제품", "도서", "식품" }));
        categoryEditCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryEditCBoxActionPerformed(evt);
            }
        });

        categoryEditCBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "카메라", "휴대폰", "컴퓨터", "etc" }));

        jLabel15.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel15.setText("대분류");

        jLabel16.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel16.setText("소분류");

        javax.swing.GroupLayout editProductFrameLayout = new javax.swing.GroupLayout(editProductFrame.getContentPane());
        editProductFrame.getContentPane().setLayout(editProductFrameLayout);
        editProductFrameLayout.setHorizontalGroup(
            editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProductFrameLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProductFrameLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detailEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editProductFrameLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(priceEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editProductFrameLayout.createSequentialGroup()
                                .addComponent(editProductButt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelEditButt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(editProductFrameLayout.createSequentialGroup()
                        .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editProductFrameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(editProductFrameLayout.createSequentialGroup()
                                        .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editProductFrameLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(categoryEditCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(categoryEditCBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(imgEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(imgEditSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(editProductFrameLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel15)
                                .addGap(148, 148, 148)
                                .addComponent(jLabel16)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        editProductFrameLayout.setVerticalGroup(
            editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProductFrameLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgEditSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryEditCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryEditCBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(editProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProductButt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelEditButt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("관리자 페이지");
        setPreferredSize(new java.awt.Dimension(1640, 1050));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 22)); // NOI18N
        jLabel1.setText("Cououpang");
        jLabel1.setToolTipText("");

        memberManageButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        memberManageButt.setText("회원관리");

        productManageButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        productManageButt.setText("물건관리");
        productManageButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productManageButtActionPerformed(evt);
            }
        });

        orderManageButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        orderManageButt.setText("주문");
        orderManageButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderManageButtActionPerformed(evt);
            }
        });

        adminProductTable.setModel(Setting());
        adminProductTable.setRowSelectionAllowed(false);
        adminProductTable.getTableHeader().setReorderingAllowed(false);
        adminProductList.setViewportView(adminProductTable);

        addButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        addButt.setText("추가");
        addButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtActionPerformed(evt);
            }
        });

        deleteButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        deleteButt.setText("삭제");
        deleteButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtActionPerformed(evt);
            }
        });

        editButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        editButt.setText("수정");
        editButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 20)); // NOI18N
        jLabel2.setText("검색");

        searchTF.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        searchTF.setText("상품명");
        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });

        searchButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        searchButt.setText("검색");
        searchButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productManagePanelLayout = new javax.swing.GroupLayout(productManagePanel);
        productManagePanel.setLayout(productManagePanelLayout);
        productManagePanelLayout.setHorizontalGroup(
            productManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productManagePanelLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(addButt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editButt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(searchButt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        productManagePanelLayout.setVerticalGroup(
            productManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productManagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(productManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(productManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editButt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(searchButt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(productManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteButt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(orderManageButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productManageButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(memberManageButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminProductList)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(productManagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(memberManageButt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(productManageButt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(orderManageButt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adminProductList, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productManagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTFActionPerformed

    private void productManageButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productManageButtActionPerformed
        // TODO add your handling code here:
        adminProductList.setVisible(true);
        productManagePanel.setVisible(true);
    }//GEN-LAST:event_productManageButtActionPerformed

    private void addButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtActionPerformed
        // TODO add your handling code here:
        imgInputTF.setText("");
        nameInputTF.setText("");
        priceInputTF.setText("");
        detailInputTF.setText("");

        addProductFrame.setVisible(true);
    }//GEN-LAST:event_addButtActionPerformed

    private void cancelButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtActionPerformed
        // TODO add your handling code here:
        addProductFrame.dispose();
    }//GEN-LAST:event_cancelButtActionPerformed

    private void addProductButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtActionPerformed
        // TODO add your handling code here:
        //같은이름 상품있는지 확인 코드 패턴에 넣던지 추가하기
        String inputTest1 = imgInputTF.getText();
        String inputTest2 = nameInputTF.getText();
        String inputTest3 = detailInputTF.getText();
        String inputTest4 = priceInputTF.getText();

        /*String sameProduct = "";
        Boolean sameProductCheck = false;
        
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("상품목록");
            
            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                sameProduct = (String) jObj.get("상품명");
                if(inputTest1.equals(sameProduct)){
                    sameProductCheck = true;
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminPageScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminPageScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminPageScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(sameProductCheck == true){
            JOptionPane.showMessageDialog(null, "같은 상품이 존재합니다.");
        }*/
        if ((inputTest1.equals(null) || inputTest1.equals("")) || (inputTest2.equals(null) || inputTest2.equals("")) || (inputTest3.equals(null) || inputTest3.equals("")) || (inputTest4.equals(null) || inputTest4.equals(""))) {
            JOptionPane.showMessageDialog(null, "상품 정보를 입력해주세요.");
        } else {
            this.InputImgPath = imgInputTF.getText();
            this.InputProductName = nameInputTF.getText();
            this.InputProductDesc = detailInputTF.getText();
            this.InputProductPrice = priceInputTF.getText();
            this.InputProductCategory = categoryCBox.getSelectedItem().toString();

            ImageIcon addInputImg = new ImageIcon(InputImgPath);
            if (ElectronicList.getCheckSameProduct() == false || BookList.getCheckSameProduct() == false || FoodList.getCheckSameProduct() == false) {
                if (InputProductCategory.equals("전자제품")) {
                    ProductList elecList = new Electronics();
                    Product eProduct = elecList.addProductList(InputProductName, InputProductPrice, InputProductDesc, addInputImg, InputProductCategory);
                    refreshProductList();
                    addProductFrame.dispose();
                } else if (InputProductCategory.equals("도서")) {
                    ProductList bookList = new Books();
                    Product bProduct = bookList.addProductList(InputProductName, InputProductPrice, InputProductDesc, addInputImg, InputProductCategory);
                    refreshProductList();
                    addProductFrame.dispose();
                } else if (InputProductCategory.equals("식품")) {
                    ProductList foodList = new Foods();
                    Product fProduct = foodList.addProductList(InputProductName, InputProductPrice, InputProductDesc, addInputImg, InputProductCategory);
                    refreshProductList();
                    addProductFrame.dispose();
                }
            } else {
                addProductFrame.setVisible(true);
            }
        }
    }//GEN-LAST:event_addProductButtActionPerformed

    private void imgSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgSelectorActionPerformed
        // TODO add your handling code here:
        imageChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");

        imageChooser.setFileFilter(filter);

        int returnVal = imageChooser.showOpenDialog(null);
        if (returnVal == imageChooser.APPROVE_OPTION) {
            String filepath = imageChooser.getSelectedFile().getPath();
            this.imgPath = filepath;
            imgInputTF.setText(imgPath);
        }
        //imageChooser.setVisible(true);
    }//GEN-LAST:event_imgSelectorActionPerformed

    private void nameInputTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputTFActionPerformed

    private void imgInputTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgInputTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgInputTFActionPerformed

    private void deleteButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtActionPerformed
        // TODO add your handling code here:
        //System.out.println("선택된 상품의 상품명 : " +getDeleteSelectProductName());
        //System.out.println("선택된 상품의 카테고리 : " + getDeleteSelectProductCategory());

        String selectPName = getSelectedProductName();
        String selectPCategory = getSelectedProductCategory();

        if (getSelectedProductCategory().equals("전자제품")) {
            ProductList elecList = new Electronics();
            Product eProduct = elecList.deleteProductList(getSelectedProductName());
            refreshProductList();
        } else if (getSelectedProductCategory().equals("도서")) {
            ProductList bookList = new Books();
            Product bProduct = bookList.deleteProductList(getSelectedProductName());
            refreshProductList();
        } else if (getSelectedProductCategory().equals("식품")) {
            ProductList foodList = new Foods();
            Product fProduct = foodList.deleteProductList(getSelectedProductName());
            refreshProductList();
        }
    }//GEN-LAST:event_deleteButtActionPerformed

    private void imgEditTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgEditTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgEditTFActionPerformed

    private void nameEditTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameEditTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameEditTFActionPerformed

    private void imgEditSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgEditSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgEditSelectorActionPerformed

    private void editProductButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductButtActionPerformed
        // TODO add your handling code here:
        this.InputImgPath = imgEditTF.getText();
        this.InputProductName = nameEditTF.getText();
        this.InputProductDesc = detailEditTF.getText();
        this.InputProductPrice = priceEditTF.getText();
        this.InputProductCategory = categoryEditCBox.getSelectedItem().toString();

        String selectPName = getSelectedProductName();
        String selectPCategory = getSelectedProductCategory();

        ImageIcon addInputImg = new ImageIcon(InputImgPath);
        if (ElectronicList.getCheckSameProduct() == false || BookList.getCheckSameProduct() == false || FoodList.getCheckSameProduct() == false) {
            if (getSelectedProductCategory().equals("전자제품")) {
                ProductList elecList = new Electronics();
                Product eProduct = elecList.editProductList(InputProductName, InputProductPrice, InputProductDesc, addInputImg, InputProductCategory);
                refreshProductList();
            } else if (getSelectedProductCategory().equals("도서")) {
                ProductList bookList = new Books();
                Product bProduct = bookList.editProductList(InputProductName, InputProductPrice, InputProductDesc, addInputImg, InputProductCategory);
                refreshProductList();
            } else if (getSelectedProductCategory().equals("식품")) {
                ProductList foodList = new Foods();
                Product fProduct = foodList.editProductList(InputProductName, InputProductPrice, InputProductDesc, addInputImg, InputProductCategory);
                refreshProductList();
            }
        }
    }//GEN-LAST:event_editProductButtActionPerformed

    private void cancelEditButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditButtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelEditButtActionPerformed

    private void editButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtActionPerformed
        // TODO add your handling code here:
        editProductFrame.setVisible(true);
    }//GEN-LAST:event_editButtActionPerformed

    private void categoryCBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryCBox2ActionPerformed

    private void categoryCBox2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_categoryCBox2PropertyChange
        // TODO add your handling code here:


    }//GEN-LAST:event_categoryCBox2PropertyChange

    private void categoryCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBoxActionPerformed
        // TODO add your handling code here:
        if (categoryCBox.getSelectedItem().equals("전자제품")) {
            categoryCBox2.removeAllItems();
            categoryCBox2.addItem("카메라");
            categoryCBox2.addItem("휴대폰");
            categoryCBox2.addItem("컴퓨터");
            categoryCBox2.addItem("etc");
            categoryCBox2.revalidate();
            categoryCBox2.repaint();
            categoryCBox2.setVisible(true);
        } else if (categoryCBox.getSelectedItem().equals("도서")) {
            categoryCBox2.removeAllItems();
            categoryCBox2.addItem("소설");
            categoryCBox2.addItem("수험서");
            categoryCBox2.addItem("문제집");
            categoryCBox2.addItem("etc");
            categoryCBox2.revalidate();
            categoryCBox2.repaint();
            categoryCBox2.setVisible(true);
        } else if (categoryCBox.getSelectedItem().equals("식품")) {
            categoryCBox2.removeAllItems();
            categoryCBox2.addItem("신선식품");
            categoryCBox2.addItem("가공식품");
            categoryCBox2.addItem("음료");
            categoryCBox2.addItem("etc");
            categoryCBox2.revalidate();
            categoryCBox2.repaint();
            categoryCBox2.setVisible(true);
        }
    }//GEN-LAST:event_categoryCBoxActionPerformed

    private void categoryEditCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryEditCBoxActionPerformed
        // TODO add your handling code here:
        if (categoryEditCBox.getSelectedItem().equals("전자제품")) {
            categoryEditCBox2.removeAllItems();
            categoryEditCBox2.addItem("카메라");
            categoryEditCBox2.addItem("휴대폰");
            categoryEditCBox2.addItem("컴퓨터");
            categoryEditCBox2.addItem("etc");
            categoryEditCBox2.revalidate();
            categoryEditCBox2.repaint();
            categoryEditCBox2.setVisible(true);
        } else if (categoryEditCBox.getSelectedItem().equals("도서")) {
            categoryEditCBox2.removeAllItems();
            categoryEditCBox2.addItem("소설");
            categoryEditCBox2.addItem("수험서");
            categoryEditCBox2.addItem("문제집");
            categoryEditCBox2.addItem("etc");
            categoryEditCBox2.revalidate();
            categoryEditCBox2.repaint();
            categoryEditCBox2.setVisible(true);
        } else if (categoryEditCBox.getSelectedItem().equals("식품")) {
            categoryEditCBox2.removeAllItems();
            categoryEditCBox2.addItem("신선식품");
            categoryEditCBox2.addItem("가공식품");
            categoryEditCBox2.addItem("음료");
            categoryEditCBox2.addItem("etc");
            categoryEditCBox2.revalidate();
            categoryEditCBox2.repaint();
            categoryEditCBox2.setVisible(true);
        }
    }//GEN-LAST:event_categoryEditCBoxActionPerformed

    private void searchButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtActionPerformed
        // TODO add your handling code here:
        String searchInput = searchTF.getText();

        if (getCategoryFromList(searchInput).equals("전자제품")) {
            ProductList elecList = new Electronics();
            Product eProduct = elecList.readProductList(searchInput);
        } else if (getCategoryFromList(searchInput).equals("도서")) {
            ProductList bookList = new Books();
            Product bProduct = bookList.readProductList(searchInput);
        } else if (getCategoryFromList(searchInput).equals("식품")) {
            ProductList foodList = new Foods();
            Product fProduct = foodList.readProductList(searchInput);
        }

        adminProductTable.setModel(SearchSetting());
        adminProductTable.revalidate();
        adminProductTable.repaint();
        adminProductList.revalidate();
        adminProductList.repaint();
        adminProductList.setVisible(true);
    }//GEN-LAST:event_searchButtActionPerformed

    private void orderManageButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderManageButtActionPerformed
        // TODO add your handling code here:
        //payment order = new payment();
    }//GEN-LAST:event_orderManageButtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButt;
    private javax.swing.JButton addProductButt;
    public static javax.swing.JFrame addProductFrame;
    private javax.swing.JScrollPane adminProductList;
    public static javax.swing.JTable adminProductTable;
    private javax.swing.JButton cancelButt;
    private javax.swing.JButton cancelEditButt;
    private javax.swing.JComboBox<String> categoryCBox;
    private javax.swing.JComboBox<String> categoryCBox2;
    private javax.swing.JComboBox<String> categoryEditCBox;
    private javax.swing.JComboBox<String> categoryEditCBox2;
    private javax.swing.JButton deleteButt;
    public static javax.swing.JTextField detailEditTF;
    public static javax.swing.JTextField detailInputTF;
    private javax.swing.JButton editButt;
    private javax.swing.JButton editProductButt;
    private javax.swing.JFrame editProductFrame;
    private javax.swing.JFileChooser imageChooser;
    private javax.swing.JButton imgEditSelector;
    public static javax.swing.JTextField imgEditTF;
    public static javax.swing.JTextField imgInputTF;
    private javax.swing.JButton imgSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton memberManageButt;
    public static javax.swing.JTextField nameEditTF;
    public static javax.swing.JTextField nameInputTF;
    private javax.swing.JButton orderManageButt;
    public static javax.swing.JTextField priceEditTF;
    public static javax.swing.JTextField priceInputTF;
    private javax.swing.JButton productManageButt;
    private javax.swing.JPanel productManagePanel;
    private javax.swing.JButton searchButt;
    private javax.swing.JTextField searchTF;
    // End of variables declaration//GEN-END:variables
}
