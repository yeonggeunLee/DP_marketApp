package marketapp.marketapp.MyPage.mypagePattern;

/**
 *
 * @author 이영근
 */
public class UserInfoEditDecorator implements MyPage {

    private MyPage myPage;

    public UserInfoEditDecorator(MyPage myPage) {
        this.myPage = myPage;
    }

    @Override
    public void display() {
        myPage.display();
        System.out.println("사용자 정보 수정 표시");
    }
}
