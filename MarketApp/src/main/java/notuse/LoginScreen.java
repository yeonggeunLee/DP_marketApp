/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package notuse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
        
/**
 *
 * @author 이영근
 */


public class LoginScreen extends JFrame{
    LoginScreen(){
        
         //화면
        JFrame jf = new JFrame();
        jf.setBounds(200, 200, 600, 600); //width와 height를 조정하면 전체 창 크기가 변한다
	//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);  // 화면 크기 고정하는 작업
        jf.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치
        
        jf.setTitle("Cououpang");
        jf.setLayout(null);
        
        //회원가입 타이틀
        JLabel title = new JLabel("Cououpang");
        title.setForeground(Color.blue); //로그인화면 글자색
        title.setBounds(190, 10, 400, 100);
        title.setFont(new Font("맑은고딕", Font.BOLD, 40));
        jf.add(title);
        
        //로그인 정보 입력받기
        JLabel id = new JLabel("아이디 : ");
        id.setSize(100,30);
        id.setLocation(180,190);
        id.setFont(new Font("맑은고딕", Font.BOLD, 20));
        id.setHorizontalAlignment(JLabel.LEFT);

        jf.add(id); //JFrame에 JLabel를 추가

        JTextField idField = new JTextField();
        idField.setSize(140,30);
        idField.setLocation(280,190);

        jf.add(idField);//JFrame에 JTextField를 추가

        JLabel pw = new JLabel("비밀번호 : ");
        pw.setSize(150,30);
        pw.setLocation(180,240);
        pw.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(pw);

        JPasswordField pwField = new JPasswordField();
        pwField.setSize(140,30);
        pwField.setLocation(280,240);
        jf.add(pwField);
        
        //버튼
        JButton login = new JButton("로그인");
        login.setBounds(185, 350, 230, 50);
        login.setFont(new Font("맑은고딕", Font.BOLD, 20));
	jf.add(login);
        
        JButton join = new JButton("회원가입");
        join.setBounds(185, 450, 230, 50);
        join.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(join);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);  
		
	//로그인 버튼을 눌렀을때
	login.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
                String myId = idField.getText().replaceAll(" ", "");
                String myPwd = new String(pwField.getPassword());
                String login="";

                //텍스트 파일에 저장된 모든 글자를 가져온다 | 구분자로 아이디와 비번이 맞는게 있다면 로그인 시켜주면 된다.
				try{
					 BufferedReader reader = new BufferedReader(new FileReader("C:\\java_member\\member.txt"));
					
				        String str;
				        ArrayList<String> txtmember = new ArrayList<>();
				        while ((str = reader.readLine()) != null) {
				        	txtmember.add(str);
				        }   
				       
				        reader.close();
				        
				        //memberlist에 아이디와 비밀번호 저장하기
				        HashMap<String,String> memberlist = new HashMap<>();
				        
				        for(int i=0; i<txtmember.size(); i++) {
				        	// | 구분자 기준으로 잘라난 텍스트를 memberlist에 넣어주기.
				        	String[] tempresult = txtmember.get(i).toString().split("\\|");
				        	memberlist.put(tempresult[0],tempresult[1]);
				        }
				        		        
				        //txt 파일에서 가져온 아이디 비번과 입력한 아이디 비번이 맞는지 확인
				        for ( String key : memberlist.keySet() ) {
				            if(myId.equals(key.trim()) && myPwd.equals(memberlist.get(key))) {
				            	//로그인성공!
				            	login = "성공";
				            }
				        }				        
					
				}catch(Exception errmsg){
					errmsg.printStackTrace();
				}
				
				if(login.equals("성공")) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
					return;
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패", "계정 정보를 확인해 주세요.", JOptionPane.DEFAULT_OPTION);	
				}
        }
    });
		
		
	join.addActionListener(new ActionListener() {
			
	@Override
	public void actionPerformed(ActionEvent e) {
				
	new JoinScreen();
	jf.setVisible(false);
				
	}
    });

		
    }
}
