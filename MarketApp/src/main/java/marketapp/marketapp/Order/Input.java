package marketapp.marketapp.Order;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Input extends JFrame {//입력폼

    JLabel la_name, la_phone, la_address, la_require;
    public static JTextField tf_name, tf_phone, tf_address, tf_require;
    JButton bt_input, bt_cancel;

    public static String getTf_name() {
        return tf_name.getText();
    }

    public static String getTf_phone() {
        return tf_phone.getText();
    }

    public static String getTf_address() {
        return tf_address.getText();
    }

    public static String getTf_require() {
        return tf_require.getText();
    }


    
    public Input() {

        setTitle("입력폼");
        la_name = new JLabel("받는사람");
        la_phone = new JLabel("전화번호");
        la_address = new JLabel("주소");
        la_require = new JLabel("요청사항");

        tf_name = new JTextField();
        tf_phone = new JTextField();
        tf_address = new JTextField();
        tf_require = new JTextField();

        bt_input = new JButton("입력");
        bt_cancel = new JButton("취소");

        setLayout(null);
        la_name.setBounds(50, 30, 60, 30);//location+size
        la_phone.setBounds(50, 80, 60, 30);//location+size
        la_address.setBounds(50, 130, 60, 30);//location+size
        la_require.setBounds(50, 180, 60, 30);

        tf_name.setBounds(150, 30, 120, 30);
        tf_phone.setBounds(150, 80, 120, 30);
        tf_address.setBounds(150, 130, 500, 30);
        tf_require.setBounds(150, 180, 300, 30);

        bt_input.setBounds(50, 250, 60, 30);
        bt_cancel.setBounds(120, 250, 60, 30);

        add(la_name);
        add(la_phone);
        add(la_address);
        add(la_require);

        add(tf_name);
        add(tf_phone);
        add(tf_address);
        add(tf_require);

        add(bt_input);
        add(bt_cancel);

        setBounds(500, 500, 700, 400);
        setResizable(false);  //프레임 사이즈 변경 불가

    }//생성자

    public void initTF() {
        //텍스트필드 초기화
        setTitle("입력폼");
        tf_name.setText("");
        tf_phone.setText("");
        tf_address.setText("");
        tf_require.setText("");
    }

    public void initUp() {//수정폼 초기화
        setTitle("수정폼");
    }
}
