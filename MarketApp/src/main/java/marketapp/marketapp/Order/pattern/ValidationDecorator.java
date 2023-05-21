package marketapp.marketapp.Order.pattern;

/**
 *
 * @author 이영근
 */
// ValidationDecorator 클래스
public class ValidationDecorator extends AddressDecorator {

    public ValidationDecorator(Address decoratedAddress) {
        super(decoratedAddress);
    }

    public String getAddress() {
        String address = decoratedAddress.getAddress();

        // 주소 유효성 검사를 수행하는 로직을 추가한다.
        if (!isValid(address)) {
            throw new IllegalArgumentException("유효하지 않은 주소입니다.");
        }

        return address;
    }

    private boolean isValid(String address) {
        // 주소 유효성 검사를 수행하는 로직을 구현한다.
        // 예를 들어, 주소가 비어있지 않고 특정 형식을 만족하는지 등을 확인할 수 있다.
        return !address.isEmpty();
    }
}
