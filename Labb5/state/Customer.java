package Labb5.state;

public class Customer{

    private int customerID;
    private String customerState = "";
    
    // Skapar en kund med egen ID.
    public Customer (int ID){
        this.customerID = ID;
    }
    public int getID (){
        return this.customerID;
    }
    public void setCustomerState (String customerState){
        this.customerState = customerState;
    }
    public String getCustomerState(){
        return this.customerState;
    }



}
