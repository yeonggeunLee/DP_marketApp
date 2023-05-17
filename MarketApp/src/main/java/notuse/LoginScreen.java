/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package notuse;

import marketapp.marketapp.ProductList.TableMouse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

    public static class Tableicon extends JPanel {

        String filePath = "src\\main\\java\\marketapp\\marketapp\\productListPattern\\Data\\ProductList.json";
        Object[][] contents;
        public static JTable table;

        public static ImageIcon tableImage;
        public static String pName;
        public static String pPrice;
        public static String pDesc;

        public static ImageIcon getTableImage() {
            return tableImage;
        }

        public Tableicon() {
            // 테이블에 JSON 파일에 저장된 데이터  넣기
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
                    Image changedImage = needChangeImage.getScaledInstance(300,200, Image.SCALE_SMOOTH);
                    ImageIcon changedImageIcon = new ImageIcon(changedImage);
                    contents[i][0] = changedImageIcon;
                    contents[i][1] = jObj.get("상품명");
                    contents[i][2] = jObj.get("상품정보");
                    contents[i][3] = jObj.get("가격");

                    this.pName = (String) jObj.get("상품명");
                    this.pPrice = (String) jObj.get("가격");
                    this.pDesc = (String) jObj.get("상품정보");
                }

                DefaultTableModel model = new DefaultTableModel(contents, header) {
                    //  Returning the Class of each column will allow different
                    //  renderers to be used based on Class
                    public Class getColumnClass(int column) {
                        return getValueAt(0, column).getClass();
                    }
                };

                table = new JTable(model) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                table.addMouseListener(new TableMouse());
                table.setRowHeight(150);
                //table.setSize(1440, 960);
                //table.setPreferredScrollableViewportSize(table.getPreferredSize());

                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setPreferredSize(new Dimension(1440, 960));

                add(scrollPane);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
