/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notuse;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import marketapp.marketapp.Order.ChangeShippingList;
import marketapp.marketapp.Order.Input;
import marketapp.marketapp.Order.Payment;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class deliveryList extends JFrame implements MouseListener, ActionListener {

    JTable table;
    Object[][] contents;
    JScrollPane scroll;
    JPanel northp, southp;
    JLabel label, la_search;
    JButton bt_add, bt_del, bt_up, bt_chk;

    Input form = new Input();
    int srow;

    String filePath = "src\\main\\java\\Data\\ShippingList.json";
    DefaultTableModel model;
    public static String tableName;
    public static String tableNumber;
    public static String tableAddress;
    public static String tableRequest;

    public static String getTableNumber() {
        return tableNumber;
    }

    public static String getTableAddress() {
        return tableAddress;
    }

    public static String getTableRequest() {
        return tableRequest;
    }

    public static String getTableName() {
        return tableName;
    }

    public DefaultTableModel Setting() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject JsonObj = (JSONObject) obj;
            JSONArray productInfoArr = (JSONArray) JsonObj.get("배송지정보");

            String[] header = {"받는사람", "전화번호", "주소", "요청사항"};
            Object[][] contents = new Object[productInfoArr.size()][4];
            for (int i = 0; i < productInfoArr.size(); i++) {
                JSONObject jObj = (JSONObject) productInfoArr.get(i);
                contents[i][0] = jObj.get("받는사람");
                contents[i][1] = jObj.get("전화번호");
                contents[i][2] = jObj.get("주소");
                contents[i][3] = jObj.get("요청사항");
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

    public deliveryList() {
        setTitle("배송");

        table = new JTable(Setting()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowSelectionAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(50);

        scroll = new JScrollPane(table);
        label = new JLabel("배송지 목록");
        northp = new JPanel();
        northp.add(label);

        bt_add = new JButton("추가");
        bt_del = new JButton("삭제");
        bt_up = new JButton("수정");
        bt_chk = new JButton("선택");

        southp = new JPanel();
        southp.add(bt_add);
        southp.add(bt_del);
        southp.add(bt_up);
        southp.add(bt_chk);

        //southp.add(la_search);
        //southp.add(searchField);
        add("Center", scroll);
        add("North", northp);
        add("South", southp);

        setBounds(400, 300, 1440, 300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        eventUp();
    }//생성자

    private void eventUp() {
        table.addMouseListener(this);

        bt_add.addActionListener(this);
        bt_del.addActionListener(this);
        bt_up.addActionListener(this);
        bt_chk.addActionListener(this);

        form.bt_input.addActionListener(this);
        form.bt_cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object ob = e.getSource();
        if (ob == bt_add) { //추가버튼 클릭시
            form.initTF();
            setVisible(true);
            form.setVisible(true);
        } else if (ob == form.bt_input) { //입력버튼 클릭시(입력폼, 수정폼)
            String name = form.tf_name.getText();
            String phone = form.tf_phone.getText();
            String address = form.tf_address.getText();
            String require = form.tf_require.getText();

            if (name.length() == 0) {
                JOptionPane.showMessageDialog(form, "이름 입력!!");
                form.tf_name.requestFocus();
                return;
            }

            if (phone.length() == 0) {
                //TextField에는 null값이 들어오지 않으므로 null체크 뺌.
                JOptionPane.showMessageDialog(form, "전화번호 입력!!");
                form.tf_phone.requestFocus();
                return;
            }

            if (address.length() == 0) {//입력된 문자가 없다면
                JOptionPane.showMessageDialog(form, "주소 입력!!");
                form.tf_address.requestFocus();
                return;
            }

            if (require.length() == 0) {
                JOptionPane.showMessageDialog(form, "요청사항 입력!!");
                form.tf_require.requestFocus();
                return;
            }

            if (form.getTitle().equals("입력폼")) {//입력폼이었을때
                ChangeShippingList.addShippingList();
                table.setModel(Setting());
                table.revalidate();
                table.repaint();
                table.setVisible(true);
            } else {//수정폼이였을때
                ChangeShippingList.editShippingList();
                table.setModel(Setting());
                table.revalidate();
                table.repaint();
                table.setVisible(true);
            }
            form.setVisible(true);
            setVisible(true);
            form.dispose();

        } else if (ob == form.bt_cancel) {
            form.dispose();
        } else if (ob == bt_del) {
            srow = table.getSelectedRow();
            //JTable에서 선택된 행이 없다면 -1값을 리턴.

            if (srow == -1) {
                JOptionPane.showMessageDialog(this, "삭제할 행선택!!");
                return;
            } else {
                ChangeShippingList.deleteShippingList();
                table.setModel(Setting());
                table.revalidate();
                table.repaint();
                table.setVisible(true);
            }

        } else if (ob == bt_up) {//수정버튼을 클릭했다면
            form.tf_name.setText(tableName);
            form.tf_phone.setText(tableNumber);
            form.tf_address.setText(tableAddress);
            form.tf_require.setText(tableRequest);

            form.setVisible(true);
        } else if (ob == bt_chk) {//선택버튼을 클릭했다면
            srow = table.getSelectedRow();
            //JTable에서 선택된 행이 없다면 -1값을 리턴.

            if (srow == -1) {
                JOptionPane.showMessageDialog(this, "선택할 행선택!!");
                return;
            } else {
                String name = (String) table.getValueAt(srow, 0);
                String phone = (String) table.getValueAt(srow, 1);
                String address = (String) table.getValueAt(srow, 2);
                String require = (String) table.getValueAt(srow, 3);

                Payment.tf_name.setText(name);
                Payment.tf_phone.setText(phone);
                Payment.tf_address.setText(address);
                Payment.tf_require.setText(require);
                JOptionPane.showMessageDialog(this, "배송지가 선택되었습니다.");
                dispose();
            }

            //form.initUp();
            //setVisible(true);
            //form.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            int row = table.getSelectedRow();
            Object o[] = new Object[table.getColumnCount()];
            for (int col = 0; col < table.getColumnCount(); col++) {
                o[col] = table.getValueAt(row, col);
            }
            this.tableName = (String) o[0];
            this.tableNumber = (String) o[1];
            this.tableAddress = (String) o[2];
            this.tableRequest = (String) o[3];
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
