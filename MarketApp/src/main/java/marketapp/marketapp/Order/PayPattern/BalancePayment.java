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
public class BalancePayment implements PaymentStrategy {
    public String orderListFilePath = "src\\main\\java\\Data\\OrderList.json";
    String memberfilePath = "src\\main\\java\\Data\\join.json";

    @Override
    public void pay(String price) {
        // 잔고 결제 코드 추가하기
        int calB1 = Integer.parseInt(currentPayBalanceTF.getText());
        int calB2 = Integer.parseInt(orderPriceTF.getText());
        String calFinal = price;
        String currentId = LoginPage.getLoginedID();
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (calB1 >= calB2) {
            try {
                JSONParser parser1 = new JSONParser();
                Object obj1 = parser1.parse(new FileReader(memberfilePath));
                JSONObject loadJsonObj1 = (JSONObject) obj1;

                JSONArray memberListArr = (JSONArray) loadJsonObj1.get("member");

                for (int i = 0; i < memberListArr.size(); i++) {
                    JSONObject memList = (JSONObject) memberListArr.get(i);
                    String checkId = (String) memList.get("ID");
                    if (checkId.equals(currentId)) {
                        memList.replace("Balance", calFinal);
                        break;
                    }
                }

                try {
                    FileWriter file1 = new FileWriter(memberfilePath);
                    file1.write(loadJsonObj1.toJSONString());
                    file1.flush();
                } catch (IOException ae) {
                    ae.printStackTrace();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

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
                orderList.put("결제방식", "잔고");
                orderList.put("결제상태", "결제완료");
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
}
