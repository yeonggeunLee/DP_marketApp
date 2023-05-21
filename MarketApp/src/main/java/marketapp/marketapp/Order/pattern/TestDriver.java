package marketapp.marketapp.Order.pattern;

/**
 *
 * @author 이영근
 */
public class TestDriver {

    public static void main(String[] args) {
        // 기본 주소 객체 생성
        Address baseAddress = new BaseAddress("부산광역시", "동래구", "상세주소~~~");

        // 주소 유효성 검사 데코레이터 추가
        Address validatedAddress = new ValidationDecorator(baseAddress);

        // 주소 포맷 변환 데코레이터 추가
        Address formattedAddress = new FormattingDecorator(validatedAddress);

        // 주소를 얻어와 출력한다.
        System.out.println(formattedAddress.getAddress());
    }
}
