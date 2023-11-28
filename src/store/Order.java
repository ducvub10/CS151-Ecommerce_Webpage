package store;
import User.Customer;

public class Order {
    private String orderID;
    private Customer user;

    public Order(String orderID, Customer user) {
        this.orderID = orderID;
        this.user = user;
    }

    public Order() {

    }

    public String getOrderID() {

        return orderID;
    }

    public void setOrderID(String orderID) {

        this.orderID = orderID;
    }

    public Customer getUser() {

        return user;
    }

    public void setUser(Customer user) {

        this.user = user;
    }

}