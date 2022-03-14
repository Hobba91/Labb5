package Labb5.simulator;

/** 
A abstract class that determines how all events should "behave".
*@author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/
 
public abstract class Event {

    protected double time;
    
    abstract public void doMe(EventQueue queue, SimState state);    //utför eventet
    abstract public double getTime(); //få fram tiden händelsen ska inträffa
    abstract public String getName();

    
}
