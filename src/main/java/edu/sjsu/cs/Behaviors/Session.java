package edu.sjsu.cs.Behaviors;

import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Order;

public class Session {
    private static Session instance = null;
    private Customer currentCustomer;
    private Order currentOrder;

    private Session() {}

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // getters and setters for currentCustomer and currentOrder
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer customer) {
        currentCustomer = customer;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order order) {
        currentOrder = order;
    }
}
