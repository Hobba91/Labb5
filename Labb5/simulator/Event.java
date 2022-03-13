package Labb5.simulator;

/** 
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/
 
/** 
A abstract class that determines how all events should "behave".
*/
public abstract class Event {

    protected double time;
    
    abstract public void doMe(EventQueue queue, SimState state);    //utför eventet
    abstract public double getTime(); //få fram tiden händelsen ska inträffa
    abstract public String getName();

    
}
