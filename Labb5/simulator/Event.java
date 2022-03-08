
package Labb5.simulator;
 

public abstract class Event {

    //EventQueue queue;
    protected double time;
    
    
    abstract public EventQueue doMe();    //utför eventet
    abstract public double getTime(); //få fram tiden händelsen ska inträffa
    
}
