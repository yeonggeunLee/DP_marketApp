package marketapp.marketapp.Order.pattern;

/**
 *
 * @author 이영근
 */
// AddressDecorator 추상 클래스
public abstract class AddressDecorator implements Address {

    protected Address decoratedAddress;

    public AddressDecorator(Address decoratedAddress) {
        this.decoratedAddress = decoratedAddress;
    }
}
