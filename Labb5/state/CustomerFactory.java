package Labb5.state;

import Labb5.state.Customer;

/*
*@authors Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/

/*
Class that keeps track on the number of customers created.
*/
public class CustomerFactory {
    private int id = 0;

    /*
    sets the customer id
    @param id, id of the customer
    */
    public CustomerFactory(int id){
        this.id = id;
    }
    int customers =id;
    /*
    @return customer, creates and returns a customer with its own ID.
    */
    public Customer createCustomer () {
        Customer customer = new Customer(customers);
        customers++;
        return customer;
    }
}
