package marketapp.marketapp.Order.pattern;

/**
 *
 * @author 이영근
 */
// BaseAddress 클래스
public class BaseAddress implements Address {
    private String address;
    
    public BaseAddress(String address1, String address2, String address3) {
        String makeString = toString(address1,address2,address3);
        this.address = makeString;
    }

    public String getAddress() {
        return address;
    }
    
    public String toString(String address1, String address2, String address3){
        String sentence = address1 + " " + address2 + " " + address3;
        return sentence;
    }
}
