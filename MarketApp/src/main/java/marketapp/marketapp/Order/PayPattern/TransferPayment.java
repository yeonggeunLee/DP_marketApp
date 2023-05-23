/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketapp.marketapp.Order.PayPattern;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import marketapp.marketapp.LoginPage;
import static marketapp.marketapp.Order.Pay.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 이영근
 */
public class TransferPayment implements PaymentStrategy{
    public String orderListFilePath = "src\\main\\java\\Data\\OrderList.json";
    String memberfilePath = "src\\main\\java\\Data\\join.json";
    
    @Override
    public void pay(String price) {
        // 계좌이체 결제 코드 추가하기
        int calB1 = Integer.parseInt(currentPayBalanceTF.getText());
        int calB2 = Integer.parseInt(orderPriceTF.getText());
        String calFinal = price;
        String currentId = LoginPage.getLoginedID();
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        try {
                JSONParser parser = new JSONParser();
                Object obj2 = parser.parse(new FileReader(orderListFilePath));
                JSONObject loadJsonObj2 = (JSONObject) obj2;
                JSONArray orderListArr = (JSONArray) loadJsonObj2.get("주문내역");

                JSONObject orderList = new JSONObject();
                orderList.put("아이디", currentId);
                orderList.put("받는사람", shipNameTF.getText().toString());
                orderList.put("전화번호", shipNumberTF.getText().toString());
                orderList.put("주소", shipAddressTF.getText().toString());
                orderList.put("요청사항", shipRequestTF.getText().toString());
                orderList.put("주문내역", orderListTA.getText().toString());
                orderList.put("결제방식", "계좌이체");
                orderList.put("결제상태", "임금대기");
                orderList.put("결제시간", time.format(formatter));
                orderListArr.add(orderList);

                try {
                    FileWriter file = new FileWriter(orderListFilePath);
                    file.write(loadJsonObj2.toJSONString());
                    file.flush();
                } catch (IOException ae) {
                    ae.printStackTrace();
                }
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            } catch (ParseException ex) {
            }
    }
}
