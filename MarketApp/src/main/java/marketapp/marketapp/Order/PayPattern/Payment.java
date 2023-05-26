package marketapp.marketapp.Order.PayPattern;

/**
 *
 * @author 이영근
 */
public class Payment {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void performPayment(String price) {
        paymentStrategy.pay(price);
    }
}
