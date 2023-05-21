package marketapp.marketapp.Order;

import notuse.deliveryList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class Payment extends JFrame {

    JLabel title1, title2, la_name, la_phone, la_address, la_require;
    public static JTextField tf_name, tf_phone, tf_address, tf_require;
    public static JComboBox addressBox;
    public static JComboBox addressBox2;

    public static String getAddressBox() {
        return addressBox.getSelectedItem().toString();
    }

    public static String getAddressBox2() {
        return addressBox2.getSelectedItem().toString();
    }
    

    public void SelectDelivery(ActionEvent e) {
        deliveryList deliveryList = new deliveryList();
    }

    public void SelectComboBox(ActionEvent e) {
        if (addressBox.getSelectedItem().equals("서울특별시")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("부산광역시")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("대구광역시")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"남구", "달서구", "달성군", "동구", "북구", "서구", "수성구", "중구"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("인천광역시")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"강화군", "계양구", "남군", "남동구", "동구", "부평구", "서구", "연수구", "옹진군", "중구"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("대전광역시")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"대덕구", "동구", "서구", "유성구", "중구"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("대전광역시")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"남구", "동구", "북구", "울주군", "중구"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("경기도")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"가평군", "고양시", "고양시 덕양구", "고양시 일산동구", "고양시 일산서구", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "부천시 소사구", "부천시 오정구", "부천시 원미구", "성남시", "성남시 분당구", "성남시 수정구", "성남시 중원구", "수원시", "수원시 권선구", "수원시 영통구", "수원시 장안구", "수원시 팔달구", "시흥시", "안산시", "안산시 단원구", "안산시 상록구", "안성시", "안양시", "안양시 동안구", "안양시 만안구", "양주시", "양평군", "여주군", "연천군", "오산시", "용인시", "용인시 기흥구", "용인시 수지구", "용인시 처인구", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("강원도")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시", "인제군", "정선군", "철원군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("충청북도")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "제천시", "증평군", "진천군", "청원군", "청주시", "청주시", "상당구", "청주시", "흥덕구", "충주시"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("충청남도")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"계룡시", "공주시", "금산군", "논산시", "당진군", "보령시", "부여군", "서산시", "서천군", "아산시", "연기군", "예산군", "천안시", "천안시", "동남구", "천안시", "서북구", "청양군", "태안군", "홍성군"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("전라북도")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"고창군", "군산시", "김제시", "남원시", "무주군", "부안군", "순창군", "완주군", "익산시", "임실군", "장수군", "전주시", "덕진구", "전주시", "완산구", "정읍시", "진안군"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("전라남도")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"강진군", "고흥군", "곡성군", "광양시", "구례군", "나주시", "담양군", "목포시", "무안군", "보성군", "순천시", "신안군", "여수시", "영광군", "영암군", "완료도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("경상북도")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"경산시", "경주시", "고령군", "구미시", "군위군", "김천시", "문경시", "봉화군", "상주시", "성주군", "안동시", "영덕군", "영양군", "영주시", "영천시", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군", "포항시", "포항시 남구", "포항시 북구"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("경상남도")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"거제시", "거창군", "고성군", "김해시", "남해군", "밀양시", "사천시", "산청군", "양산시", "의령군", "진주시", "창녕군", "창원시", "창원시 마산합포구", "창원시 마산회원구", "창원시 성산구", "창원시 의창구 ", "창원시 진해구", "통영시", "하동군", "함안군", "함양군", "합천군"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        } else if (addressBox.getSelectedItem().equals("제주특별시")) {
            this.addressBox2.removeAllItems();
            this.addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"제주시", "서귀포시"}));
            addressBox2.revalidate();
            addressBox2.repaint();
            addressBox2.setVisible(true);
        }
    }

    public void CancelButton(ActionEvent e) {
        this.dispose();
    }

    public Payment() {

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        //setResizable(false);  // 화면 크기 고정하는 작업
        //setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치
        setTitle("주문/결제");
        setLayout(null);

        // 배송지 선택 버튼
        JButton bt_choice = new JButton("배송지 선택");
        bt_choice.setBounds(25, 80, 100, 50);
        add(bt_choice);

        // 결제 버튼
        JButton buttPay = new JButton("결제");
        buttPay.setBounds(900, 700, 100, 50);
        add(buttPay);

        // 취소 버튼
        JButton buttCancel = new JButton("취소");
        buttCancel.setBounds(1050, 700, 100, 50);
        add(buttCancel);

        buttCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CancelButton(e);
            }
        });

        // 주소 콤보박스
        addressBox = new JComboBox();
        addressBox.setBounds(230, 180, 150, 30);
        addressBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"서울특별시", "부산광역시", "대구광역시", "인천광역시", "광주광역시", "울산광역시", "대전광역시", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주특별시"}));
        add(addressBox);

        addressBox2 = new JComboBox();
        addressBox2.setBounds(450, 180, 150, 30);
        addressBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"}));

        addressBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectComboBox(evt);
            }
        });
        add(addressBox2);

        Font font1 = new Font("맑은고딕", Font.BOLD, 20); //버튼 폰트 설정

        title1 = new JLabel("배송정보");
        title2 = new JLabel("결제");

        title1.setFont(font1);
        title2.setFont(font1);

        la_name = new JLabel("받는사람");
        la_phone = new JLabel("전화번호");
        la_address = new JLabel("주소");
        la_require = new JLabel("요청사항");

        tf_name = new JTextField();
        tf_phone = new JTextField();
        tf_address = new JTextField();
        tf_require = new JTextField();

        title1.setBounds(30, 20, 100, 30);
        title2.setBounds(40, 350, 100, 30);

        la_name.setBounds(160, 80, 60, 30);
        la_phone.setBounds(160, 130, 60, 30);
        la_address.setBounds(160, 180, 60, 30);
        la_require.setBounds(160, 290, 60, 30);

        tf_name.setBounds(230, 80, 120, 30);
        tf_phone.setBounds(230, 130, 120, 30);
        tf_address.setBounds(230, 230, 450, 30);
        tf_require.setBounds(230, 290, 450, 30);

        add(title1);
        add(title2);
        add(la_name);
        add(la_phone);
        add(la_address);
        add(la_require);
        add(tf_name);
        add(tf_phone);
        add(tf_address);
        add(tf_require);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        bt_choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectDelivery(evt);
            }
        });

        setBounds(200, 200, 1200, 800);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
