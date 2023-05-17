/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package marketapp.marketapp.ProductList;

import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static marketapp.marketapp.ProductList.ProductListScreen.tableImage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 이영근
 */
public class AdminPage extends javax.swing.JFrame {

    DefaultTableModel model;
    String filePath = "src\\main\\java\\marketapp\\marketapp\\productListPattern\\Data\\ProductList.json";
    Object[][] contents;

    public static ImageIcon tableImage;
    public static String pName;
    public static String pPrice;
    public static String pDesc;
    String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public AdminPage() {
        initComponents();
        adminProductTable.addMouseListener(new TableMouse());
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        imageChooser = new javax.swing.JFileChooser();
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
        addProductFrame.setPreferredSize(new java.awt.Dimension(650, 635));
        addProductFrame.setSize(new java.awt.Dimension(650, 635));
        addProductFrame.setType(java.awt.Window.Type.POPUP);

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("이미지");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("상품명");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("상품상세");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("가격");

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

        jButton1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jButton1.setText("상품 추가");

        jButton2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jButton2.setText("취소");

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
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addProductFrameLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imgSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addProductFrameLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addProductFrameLayout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        addProductFrameLayout.setVerticalGroup(
            addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductFrameLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(addProductFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        imageChooser.setCurrentDirectory(new java.io.File("E:\\DP_marketApp\\MarketApp\\src\\main\\java\\image\\productimage"));

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

        editButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        editButt.setText("수정");

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

    private void nameInputTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputTFActionPerformed

    private void addButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtActionPerformed
        // TODO add your handling code here:
        addProductFrame.setVisible(true);
    }//GEN-LAST:event_addButtActionPerformed

    private void imgSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgSelectorActionPerformed
        // TODO add your handling code here:
        imageChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("PNG Images", "png");

        imageChooser.setFileFilter(filter);
        imageChooser.setFileFilter(filter2);

        int returnVal = imageChooser.showOpenDialog(null);
        if (returnVal == imageChooser.APPROVE_OPTION) {
            String filepath = imageChooser.getSelectedFile().getPath();
            this.imgPath = filepath;
            imgInputTF.setText(imgPath);
        }
        //imageChooser.setVisible(true);
    }//GEN-LAST:event_imgSelectorActionPerformed

    private void imgInputTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgInputTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgInputTFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButt;
    private javax.swing.JFrame addProductFrame;
    private javax.swing.JScrollPane adminProductList;
    private javax.swing.JTable adminProductTable;
    private javax.swing.JButton deleteButt;
    public static javax.swing.JTextField detailInputTF;
    private javax.swing.JButton editButt;
    private javax.swing.JFileChooser imageChooser;
    public static javax.swing.JTextField imgInputTF;
    private javax.swing.JButton imgSelector;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton memberManageButt;
    public static javax.swing.JTextField nameInputTF;
    private javax.swing.JButton orderManageButt;
    public static javax.swing.JTextField priceInputTF;
    private javax.swing.JButton productManageButt;
    private javax.swing.JPanel productManagePanel;
    private javax.swing.JButton searchButt;
    private javax.swing.JTextField searchTF;
    // End of variables declaration//GEN-END:variables
}