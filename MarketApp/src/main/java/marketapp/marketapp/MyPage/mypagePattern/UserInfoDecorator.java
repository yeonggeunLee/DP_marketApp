package marketapp.marketapp.MyPage.mypagePattern;

import static marketapp.marketapp.MyPage.MyPageScreen.*;

/**
 *
 * @author 이영근
 */
public class UserInfoDecorator implements MyPage {

    private MyPage myPage;

    public UserInfoDecorator(MyPage myPage) {
        this.myPage = myPage;
    }

    @Override
    public void display() {
        orderHistoryPane.setVisible(false);
        userInfoPanel.setVisible(true);
        userInfoPanel.repaint();
        userInfoPanel.revalidate();
    }

}
