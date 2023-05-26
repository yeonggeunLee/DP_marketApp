package marketapp.marketapp.Order;

public class ShippingInfo {

    private String Name;
    private String phone;
    private String address;
    private String Request;

    public ShippingInfo(String Name, String phone, String address, String Request) {
        this.Name = Name;
        this.phone = phone;
        this.address = address;
        this.Request = Request;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getRequest() {
        return Request;
    }

    public static class ShippingBuilder {

        private String Name;
        private String phone;
        private String address;
        private String Request;

        public ShippingBuilder setName(String Name) {
            this.Name = Name;
            return this;
        }

        public ShippingBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public ShippingBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ShippingBuilder setRequest(String Request) {
            this.Request = Request;
            return this;
        }

        public ShippingInfo build() {
            return new ShippingInfo(Name, phone, address, Request);
        }
    }
}
