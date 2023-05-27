package marketapp.marketapp.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author 김경태
 */
public class input extends JFrame {

    
    public input() {
        
        setTitle("결제창");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼 활성화
       /* setContentPane(new ShoppingPanel());*/
        Container contentPane = getContentPane(); // 컨텐트팬 알아내기
        
        // <뒤로가기 버튼>
        JButton bk = new JButton("이전");
        bk.setBackground(Color.WHITE);
        bk.setLocation(1080, 20);
        bk.setSize(200, 30);
        bk.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        contentPane.add(bk);
        
        //<뒤로가기 버튼 눌렸을때 장바구니로 감>
        bk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShoppingBasket();
                setVisible(false);  
            }
        });
        
        setSize(1440, 800);
        setVisible(true);
        
    }
}