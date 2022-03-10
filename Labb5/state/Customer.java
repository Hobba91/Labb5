package Labb5.state;

public class Customer{

    private int CustomerID;
    private String customerState = "";
    
    // Skapar en kund med egen ID.
    public void Customer (int ID){
        this.CustomerID = ID;
    }
    public int getID (){
        return this.CustomerID;
    }
    public void setCustomerState (String customerState){
        this.customerState = customerState;
    }
    public String getCustomerState(){
        return this.customerState;
    }



}
