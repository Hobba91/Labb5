package Labb5.state;

import Labb5.state.Customer;

public class CustomerFactory {
    private int id = 0;

    public CustomerFactory(int id){
        this.id = id;
    }
    int customers =id;
    public Customer createCustomer () {
        Customer customer = new Customer(customers);
        customers++;
        return customer;
    }
}
