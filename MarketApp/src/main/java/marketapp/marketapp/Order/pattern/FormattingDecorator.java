package marketapp.marketapp.Order.pattern;

/**
 *
 * @author 이영근
 */
// FormattingDecorator 클래스
public class FormattingDecorator extends AddressDecorator {

    public FormattingDecorator(Address decoratedAddress) {
        super(decoratedAddress);
    }

    public String getAddress() {
        String address = decoratedAddress.getAddress();

        // 주소 포맷 변환 로직을 추가한다.
        String formattedAddress = formatAddress(address);

        return formattedAddress;
    }

    private String formatAddress(String address) {
        // 주소를 원하는 형식으로 변환하는 로직을 구현한다.
        // 예를 들어, 주소에 "-"를 추가하거나 대문자로 변환하는 등의 작업을 수행할 수 있다.
        return address.toUpperCase();
    }
}
