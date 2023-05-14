/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package marketapp.marketapp;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author 이영근
 */
public class ProductDetailScreen extends javax.swing.JFrame {

    /**
     * Creates new form ProductDetailScreen
     */
    public static String pName;
    public static String pDesc;
    public static String pPrice;
    public static String[] pInfo;
    public static ImageIcon img;
    
    public ProductDetailScreen() {

        imgPane = new JPanel() {
            ImageIcon aa = Tableicon.getTableImage();
            ImageIcon testimg = new ImageIcon(aa.getImage());

            public void paint(Graphics g) {
                g.drawImage(testimg.getImage(), 0, 0, null);
            }
        };
        imgPane.setSize(350, 300);
        imgPane.setLocation(110, 60);
        this.add(imgPane);

        //setLabel();
        initComponents();
        this.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLabel = new javax.swing.JLabel();
        imgPane = new javax.swing.JPanel();
        pNameLabel = new javax.swing.JLabel();
        pDescLabel = new javax.swing.JLabel();
        pPriceLabel = new javax.swing.JLabel();
        pCountLabel = new javax.swing.JLabel();
        basketButt = new javax.swing.JButton();
        buyButt = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("상품 상세");
        setResizable(false);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        imgLabel.setFont(new java.awt.Font("맑은 고딕", 0, 24)); // NOI18N
        imgLabel.setText("이미지");

        javax.swing.GroupLayout imgPaneLayout = new javax.swing.GroupLayout(imgPane);
        imgPane.setLayout(imgPaneLayout);
        imgPaneLayout.setHorizontalGroup(
            imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );
        imgPaneLayout.setVerticalGroup(
            imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );

        pNameLabel.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        pNameLabel.setText("상품명 : ");

        pDescLabel.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        pDescLabel.setText("상품설명 :");

        pPriceLabel.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        pPriceLabel.setText("가격 : ");

        pCountLabel.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        pCountLabel.setText("수량 : ");

        basketButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        basketButt.setText("장바구니");
        basketButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basketButtActionPerformed(evt);
            }
        });

        buyButt.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        buyButt.setText("구매하기");
        buyButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("맑은 고딕", 0, 16)); // NOI18N
        nameLabel.setText("상품명");
        nameLabel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                nameLabelPropertyChange(evt);
            }
        });

        descLabel.setFont(new java.awt.Font("맑은 고딕", 0, 16)); // NOI18N
        descLabel.setText("상품설명");
        descLabel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                descLabelPropertyChange(evt);
            }
        });

        priceLabel.setFont(new java.awt.Font("맑은 고딕", 0, 16)); // NOI18N
        priceLabel.setText("상품가격");

        jTextField1.setFont(new java.awt.Font("맑은 고딕", 0, 16)); // NOI18N
        jTextField1.setText("수량");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgLabel)
                .addGap(204, 204, 204))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(imgPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(basketButt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(buyButt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceLabel)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buyButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(basketButt, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void basketButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basketButtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basketButtActionPerformed

    private void buyButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyButtActionPerformed

    private void nameLabelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nameLabelPropertyChange
        // TODO add your handling code here:
        this.nameLabel.setText(TableMouse.getName());
    }//GEN-LAST:event_nameLabelPropertyChange

    private void descLabelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_descLabelPropertyChange
        // TODO add your handling code here:
        this.descLabel.setText(TableMouse.getDesc());

    }//GEN-LAST:event_descLabelPropertyChange

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
        this.priceLabel.setText(TableMouse.getPrice());
    }//GEN-LAST:event_formPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton basketButt;
    private javax.swing.JButton buyButt;
    private javax.swing.JLabel descLabel;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JPanel imgPane;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel pCountLabel;
    private javax.swing.JLabel pDescLabel;
    private javax.swing.JLabel pNameLabel;
    private javax.swing.JLabel pPriceLabel;
    private javax.swing.JLabel priceLabel;
    // End of variables declaration//GEN-END:variables
}