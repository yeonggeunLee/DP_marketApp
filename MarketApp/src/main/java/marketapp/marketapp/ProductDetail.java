/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketapp.marketapp;

import java.awt.*;

import static java.awt.SystemColor.menu;
import static javax.management.Query.plus;

import javax.swing.*;

/**
 *
 * @author 이영근
 */
public class ProductDetail extends JFrame {

    /**
     *
     * @author USER
     */
    public ProductDetail() {
        JFrame jf = new JFrame();
        jf.setBounds(200, 200, 500, 800); //width와 height를 조정하면 전체 창 크기가 변한다
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);  // 화면 크기 고정하는 작업
        jf.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치

        jf.setTitle("상세페이지");
        jf.setLayout(null);

        //이미지
        JLabel img = new JLabel("이미지");
        img.setSize(200, 30);
        img.setLocation(50, 10);
        img.setFont(new Font("맑은고딕", Font.BOLD, 20));

        JPanel imgPane = new JPanel(){
            ImageIcon aa = Tableicon.getTableImage();
            ImageIcon testimg = new ImageIcon(aa.getImage());
            public void paint(Graphics g){
                g.drawImage(testimg.getImage(),0,0,null);
            }

        };
        imgPane.setSize(310,200);
        imgPane.setLocation(10,20);
        jf.add(imgPane);
        jf.add(img);

        //상품명
        JLabel name = new JLabel("상품명: ");
        name.setSize(200, 30);
        name.setLocation(50, 330);
        name.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(name);

        JTextField nameField = new JTextField();
        nameField.setSize(140, 30);
        nameField.setLocation(200, 330);
        jf.add(nameField);

        //상품 설명
        JLabel details = new JLabel("상품설명: ");
        details.setSize(150, 30);
        details.setLocation(50, 400);
        details.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(details);

        JTextField detailsField = new JTextField();
        detailsField.setSize(140, 30);
        detailsField.setLocation(200, 400);
        jf.add(detailsField);

        //가격
        JLabel price = new JLabel("가격: ");
        price.setSize(200, 30);
        price.setLocation(50, 470);
        price.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(price);

        JTextField priceField = new JTextField();
        priceField.setSize(140, 30);
        priceField.setLocation(200, 470);
        jf.add(priceField);

        //수량
        JLabel count = new JLabel("수량");
        count.setSize(200, 30);
        count.setLocation(50, 540);
        count.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(count);

        //버튼
        JButton basket = new JButton("장바구니");
        basket.setBounds(80, 700, 150, 50);
        basket.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(basket);

        JButton buy = new JButton("구매하기");
        buy.setBounds(250, 700, 150, 50);
        buy.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(buy);

        jf.setVisible(true);    //이것은 항상 마지막
    }
}
