/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notuse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author 조은지, 김경태
 */
public class JoinScreen extends JFrame {

    JoinScreen() {
        //화면
        JFrame jf = new JFrame();
        jf.setBounds(200, 200, 600, 600); //width와 height를 조정하면 전체 창 크기가 변한다
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);  // 화면 크기 고정하는 작업
        jf.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치

        jf.setTitle("회원가입");
        jf.setLayout(null);

        //회원가입 타이틀
        JLabel title = new JLabel("회원가입");
        title.setBounds(220, 10, 400, 100);
        title.setFont(new Font("맑은고딕", Font.BOLD, 40));
        jf.add(title);

        //라디오 버튼
        JRadioButton client = new JRadioButton("고객", true);
        JRadioButton manager = new JRadioButton("관리자");

        //라디오 그룹
        ButtonGroup groupRd = new ButtonGroup();

        //그룹에 라디오 버튼 포함
        groupRd.add(client);
        client.setBounds(200, 100, 100, 50);
        client.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(client);

        groupRd.add(manager);
        manager.setBounds(300, 100, 100, 50);
        manager.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(manager);

        //회원가입 정보 입력받기
        JLabel id = new JLabel("아이디 : ");
        id.setSize(100, 30);
        id.setLocation(180, 190);
        id.setFont(new Font("맑은고딕", Font.BOLD, 20));
        id.setHorizontalAlignment(JLabel.LEFT);

        jf.add(id); //JFrame에 JLabel를 추가

        JTextField idField = new JTextField();
        idField.setSize(140, 30);
        idField.setLocation(280, 190);

        jf.add(idField);//JFrame에 JTextField를 추가

        JLabel pw = new JLabel("비밀번호 : ");
        pw.setSize(150, 30);
        pw.setLocation(180, 240);
        pw.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(pw);

        JPasswordField pwField = new JPasswordField();
        pwField.setSize(140, 30);
        pwField.setLocation(280, 240);
        jf.add(pwField);

        JLabel name = new JLabel("이름 : ");
        name.setSize(200, 30);
        name.setLocation(180, 290);
        name.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(name);

        JTextField nameField = new JTextField();
        nameField.setSize(140, 30);
        nameField.setLocation(280, 290);
        jf.add(nameField);

        JLabel phone = new JLabel("전화번호 : ");
        phone.setSize(250, 30);
        phone.setLocation(180, 340);
        phone.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(phone);

        JTextField phoneField = new JTextField();
        phoneField.setSize(140, 30);
        phoneField.setLocation(280, 340);
        jf.add(phoneField);

        JButton join = new JButton("가입");
        join.setBounds(70, 450, 200, 50);
        join.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(join);

        JButton cancel = new JButton("취소");
        cancel.setBounds(320, 450, 200, 50);
        cancel.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jf.add(cancel);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);    //이것은 항상 마지막

        //가입하기 버튼을 눌렀을때
        join.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String myId = idField.getText().replaceAll(" ", "");
                System.out.println(myId.length());
                String myPwd = new String(pwField.getPassword());
                String myName = nameField.getText().replaceAll(" ", "");
                String myPhone = phoneField.getText().replaceAll(" ", "");
                String choice = "";


                    //값이 비어있는 경우
                    if (idField.getText().isEmpty()) { //만약 값이 비어있다면 값이 비어 있다면 확인하고 값을 넣어달라고 창을 띄운다.
                        JOptionPane.showMessageDialog(null, "아이디를 입력하시오");
                    } else if (myId.length() < 6 || myId.length() > 15) {
                        JOptionPane.showMessageDialog(null, "아이디는 6자리 이상, 15자리 이하만 가능 합니다.");
                    }
                    /*
                                else if(checkIDMethod(myId)==1){
					JOptionPane.showMessageDialog(null, "아이디는 특수문자 포함이 불가능합니다");
				}
                                else if {
                                    JOptionPane.showMessageDialog(null, "등록되어 있는 아이디 입니다");
				}
                     */
                    if (String.valueOf(pwField.getPassword()).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "비밀번호를 입력하시오");
                    } else if (myPwd.length() < 6 || myPwd.length() > 15) {
                        JOptionPane.showMessageDialog(null, "비밀번호는 6자리 이상, 15자리 이하만 가능 합니다.");
                    }

                    if (nameField.getText().isEmpty()) { //만약 값이 비어있다면
                        JOptionPane.showMessageDialog(null, "이름을 입력하시오");
                    } else if (phoneField.getText().isEmpty()) { //만약 값이 비어있다면
                        JOptionPane.showMessageDialog(null, "휴대폰 번호를 입력하시오");
                    }
                    /*
                                //라디오 박스에 체크가 안 되어있으면
                                else if(){
                                    JOptionPane.showMessageDialog(null, "고객/관리자 중에 선택해주세요");
                                }
                     */

                    if (client.isSelected()) { //고객에 체크되어 있으면
                        choice = "고객";
                    } else if (manager.isSelected()) { //관리자에 체크되어 있으면
                        choice = "관리자";
                    }
                
            
                
                // 회원가입 정보 저장
                JSONArray jsonArray = new JSONArray();
                
                ArrayList<String> joinData = new ArrayList<>();
                joinData.add(myId);
                joinData.add(myPwd);
                joinData.add(myName);
                joinData.add(myPhone);
                joinData.add(choice);
/*
                JSONObject obj = new JSONObject();
                obj.put("ID", myId);
                obj.put("PASSWORD", myPwd);
                obj.put("NAME", myName);
                obj.put("NUMBER", myPhone);
                obj.put("TYPE", choice);
*/
                int i =1;
                String a ="member";
                JSONObject obj = new JSONObject();
                obj.put(a+i, joinData);
                jsonArray.add(obj);
                
                try {
                    FileWriter file = new FileWriter("src\\main\\java\\data\\join.json");
                    file.write(jsonArray.toJSONString());
                    file.flush();
                    file.close();
                } catch (IOException ae) {
                    ae.printStackTrace();
                }

                //여기까지 왔다면 모든 값을 입력하고 선택하는 것이 완료되었으니 회원가입 과정이 완료.
                JOptionPane.showMessageDialog(null, "아이디 : " + myId + ", 비밀번호 : " + myPwd
                        + ", 이 름 : " + myName + ", 연락처 : " + myPhone + ", 가입유형 : " + choice);
                //회원가입후 다시 로그인 창으로 바로 넘어감
                jf.setVisible(false);
                //new LoginScreen();

                // 취소 버튼을 클릭했을 때 로그인 창으로 돌아감
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jf.setVisible(false);
                        //new LoginScreen();
                    }
                });
            }
        });
    }
}
