package marketapp.marketapp.MyPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import marketapp.marketapp.Login.LoginPage;
import marketapp.marketapp.MyPage.mypagePattern.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 이영근
 */
public class MyPageScreen extends javax.swing.JFrame {

    String orderHistoryPath = "src\\main\\java\\Data\\OrderList.json";
    String userInfoPath = "src\\main\\java\\Data\\join.json";
    Object[][] contents;
    DefaultTableModel model;
    String currentID = LoginPage.getLoginedID();
    String currentPW;
    String currentBalance;
    MyPage myP;

    public MyPageScreen() {
        initComponents();
        orderHistoryPane.setVisible(false);
        userInfoPanel.setVisible(false);
        myP = new BasicMyPage();
        setVisible(true);
    }

    public DefaultTableModel Setting() {
        String checkID;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(orderHistoryPath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("주문내역");

            String[] header = {"받는사람", "전화번호", "주소", "주문내역", "요청사항"};
            contents = new Object[productInfoArr.size()][5];
            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                checkID = (String) jObj.get("아이디");
                if (currentID.equals(checkID)) {
                    contents[i][0] = jObj.get("받는사람");
                    contents[i][1] = jObj.get("전화번호");
                    contents[i][2] = jObj.get("주소");
                    contents[i][3] = jObj.get("주문내역");
                    contents[i][4] = jObj.get("요청사항");
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

    public void mypageEditSetting() {
        String checkID;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(userInfoPath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("member");

            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                checkID = (String) jObj.get("ID");
                if (currentID.equals(checkID)) {
                    this.currentPW = (String) jObj.get("Password");
                    this.currentBalance = (String) jObj.get("Balance");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        mypageIDTF.setText(currentID);
        mypagePWTF.setText(currentPW);
        mypageBalanceTF.setText(currentBalance);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderHistoryButt = new javax.swing.JButton();
        userInfoButt = new javax.swing.JButton();
        orderHistoryPane = new javax.swing.JScrollPane();
        orderHistoryTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        userInfoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mypageIDTF = new javax.swing.JTextField();
        mypagePWTF = new javax.swing.JTextField();
        mypagePWEditTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mypageBalanceTF = new javax.swing.JTextField();
        mypageSaveButt = new javax.swing.JButton();
        mypageCancelButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("마이페이지");
        setResizable(false);

        orderHistoryButt.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        orderHistoryButt.setText("주문내역");
        orderHistoryButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderHistoryButtActionPerformed(evt);
            }
        });

        userInfoButt.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        userInfoButt.setText("사용자 정보");
        userInfoButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInfoButtActionPerformed(evt);
            }
        });

        orderHistoryTable.setModel(Setting());
        orderHistoryPane.setViewportView(orderHistoryTable);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("아이디");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("패스워드");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("패스워드 수정");

        mypageIDTF.setEditable(false);
        mypageIDTF.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        mypageIDTF.setToolTipText("");

        mypagePWTF.setEditable(false);
        mypagePWTF.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        mypagePWEditTF.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("현재 잔고");

        mypageBalanceTF.setEditable(false);
        mypageBalanceTF.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        mypageSaveButt.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        mypageSaveButt.setText("저장");
        mypageSaveButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mypageSaveButtActionPerformed(evt);
            }
        });

        mypageCancelButt.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        mypageCancelButt.setText("취소");
        mypageCancelButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mypageCancelButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userInfoPanelLayout = new javax.swing.GroupLayout(userInfoPanel);
        userInfoPanel.setLayout(userInfoPanelLayout);
        userInfoPanelLayout.setHorizontalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mypageIDTF)
                    .addComponent(mypagePWTF)
                    .addComponent(mypagePWEditTF)
                    .addComponent(mypageBalanceTF))
                .addGap(69, 69, 69))
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(mypageSaveButt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(mypageCancelButt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        userInfoPanelLayout.setVerticalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mypageIDTF)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mypagePWTF)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mypagePWEditTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(mypageBalanceTF))
                .addGap(136, 136, 136)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mypageSaveButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mypageCancelButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderHistoryPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(orderHistoryButt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userInfoButt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderHistoryButt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userInfoButt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderHistoryPane, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderHistoryButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderHistoryButtActionPerformed
        // TODO add your handling code here:
        myP = new OrderHistoryDecorator(myP);
        myP.display();
    }//GEN-LAST:event_orderHistoryButtActionPerformed

    private void userInfoButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInfoButtActionPerformed
        // TODO add your handling code here:
        mypageEditSetting();
        myP = new UserInfoDecorator(myP);
        myP.display();
    }//GEN-LAST:event_userInfoButtActionPerformed

    private void mypageCancelButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mypageCancelButtActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_mypageCancelButtActionPerformed

    private void mypageSaveButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mypageSaveButtActionPerformed
        String checkID;
        String changePW;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(userInfoPath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("member");

            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                checkID = (String) jObj.get("ID");
                if (currentID.equals(checkID)) {
                    changePW = mypagePWEditTF.getText().toString();
                    jObj.replace("Password", changePW);
                    break;
                }
            }
            try {
                FileWriter file = new FileWriter(userInfoPath);
                file.write(JsonObj.toJSONString());
                file.flush();
            } catch (IOException ae) {
                ae.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        dispose();
    }//GEN-LAST:event_mypageSaveButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField mypageBalanceTF;
    private javax.swing.JButton mypageCancelButt;
    private javax.swing.JTextField mypageIDTF;
    private javax.swing.JTextField mypagePWEditTF;
    private javax.swing.JTextField mypagePWTF;
    private javax.swing.JButton mypageSaveButt;
    private javax.swing.JButton orderHistoryButt;
    public static javax.swing.JScrollPane orderHistoryPane;
    private javax.swing.JTable orderHistoryTable;
    private javax.swing.JButton userInfoButt;
    public static javax.swing.JPanel userInfoPanel;
    // End of variables declaration//GEN-END:variables
}
