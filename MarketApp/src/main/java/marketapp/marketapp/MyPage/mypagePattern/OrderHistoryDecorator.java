package marketapp.marketapp.MyPage.mypagePattern;

import static marketapp.marketapp.MyPage.MyPageScreen.*;

/**
 *
 * @author 이영근
 */
public class OrderHistoryDecorator implements MyPage {

    private MyPage myPage;

    public OrderHistoryDecorator(MyPage myPage) {
        this.myPage = myPage;
    }

    @Override
    public void display() {
        userInfoPanel.setVisible(false);
        orderHistoryPane.repaint();
        orderHistoryPane.revalidate();
        orderHistoryPane.setVisible(true);

    }
}
