package Labb5.state;

import Labb5.state.Customer;

public class CustomerFactory {
    int customers =0;
    public Customer createCustomer () {
        Customer customer = new Customer(customers);
        customers++;
        return customer;
    }
}
