package Labb5.main;

import Labb5.state.StoreState;
import Labb5.events.Close;
import Labb5.events.Start;
import Labb5.events.Stop;
import Labb5.simulator.*;

/**
* Runs The simulation calculating the the least amount of cashiers required to get the most amount of customers
* @author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*
*/

import java.util.Random;

public class Optimize {

    // Ex 1: (som sim1)
//  public static final int M = 5;
//   public static final double L = 1;
//  public static final double LOW_COLLECTION_TIME = 0.5d;
//  public static final double HIGH_COLLECTION_TIME = 1d;
//  public static final double LOW_PAYMENT_TIME = 2d;
//  public static final double HIGH_PAYMENT_TIME = 3d;
//  public static final int SEED = 1234;
//  public static final double END_TIME = 10.0d;
//  public static final double STOP_TIME = 999.0d;
// Ex 2: 
   public static final int M = 7;
   public static final double L = 2;

   public static final double LOW_COLLECTION_TIME = 0.5d;
   public static final double HIGH_COLLECTION_TIME = 1d;

   public static final double LOW_PAYMENT_TIME = 2d;
   public static final double HIGH_PAYMENT_TIME = 3d;

   public static final int SEED = 1234;
   public static final double END_TIME = 10.0d;
   public static final double STOP_TIME = 999.0d;
  
// Ex 3: (som sim2)
//  public static final int M = 7;
//  public static final double L = 3;

//  public static final double LOW_COLLECTION_TIME = 0.6d;
//  public static final double HIGH_COLLECTION_TIME = 0.9d;

//  public static final double LOW_PAYMENT_TIME = 0.35d;
//  public static final double HIGH_PAYMENT_TIME = 0.6d;

//  public static final int SEED = 13;
//  public static final double END_TIME = 8.0d;
//  public static final double STOP_TIME = 999.0d;
  
// Ex 4
//    public static final int M = 100;
//    public static final double L = 50;

//    public static final double LOW_COLLECTION_TIME = 0.45d;
//    public static final double HIGH_COLLECTION_TIME = 0.65d;

//    public static final double LOW_PAYMENT_TIME = 0.2d;
//    public static final double HIGH_PAYMENT_TIME = 0.3d;

//    public static final int SEED = 42;
//    public static final double END_TIME = 20.0d;
//    public static final double STOP_TIME = 999.0d;
    // Ex 5
    
//    public static final int M = 1400;
//    public static final double L = 100;

//    public static final double LOW_COLLECTION_TIME = 0.45d;
//    public static final double HIGH_COLLECTION_TIME = 0.65d;

//    public static final double LOW_PAYMENT_TIME = 0.2d;
//    public static final double HIGH_PAYMENT_TIME = 0.3d;

//    public static final int SEED = 42;
//    public static final double END_TIME = 20.0d;
//    public static final double STOP_TIME = 999.0d;
    
// Ex 6
    
//    public static final int M = 1400;
//    public static final double L = 700;

//    public static final double LOW_COLLECTION_TIME = 0.45d;
//    public static final double HIGH_COLLECTION_TIME = 0.65d;

//    public static final double LOW_PAYMENT_TIME = 0.2d;
//    public static final double HIGH_PAYMENT_TIME = 0.3d;

//    public static final int SEED = 42;
//    public static final double END_TIME = 20.0d;
//    public static final double STOP_TIME = 999.0d;
// Ex 7
//    public static final int M = 1400;
//    public static final double L = 2000;
//
//    public static final double LOW_COLLECTION_TIME = 0.45d;
//    public static final double HIGH_COLLECTION_TIME = 0.65d;
//
//    public static final double LOW_PAYMENT_TIME = 0.2d;
//    public static final double HIGH_PAYMENT_TIME = 0.3d;
//
//    public static final int SEED = 42;
//    public static final double END_TIME = 20.0d;
//    public static final double STOP_TIME = 999.0d;
    public static void main(String[] args) {
        //System.out.print(RequiredCheckout(SEED));
        RandomRun(SEED);
        //OptimizeRun(4,SEED);

    }

    /**
     * runs the simulator with the decided parameters
    @param cash  the amount of cashiers used in the store
    @param seed  The seed tha gives all the random values.
    @return state of the created simulation
    */ 
    private static StoreState OptimizeRun(int cash, long seed)  {

        //variabler
        

       // final int M = 7;
        //final double L = 3;
        final double[] PICK_TIME = { LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME};
        
        final double[] PAY_TIME = {LOW_PAYMENT_TIME,HIGH_PAYMENT_TIME};
       // final double END_TIME = 8.0d;   // 
        //final double STOP_TIME = 999.0d; //
        


        //skapar en state referens
        StoreState specificstate = new StoreState(cash, M, L, PICK_TIME, PAY_TIME, seed);

        
        EventQueue queue = new EventQueue();
        SimState state = new SimState();
        //skaper ingen StoreView

        Start start = new Start(specificstate);
        Close close = new Close(END_TIME, specificstate);
        Stop stop = new Stop(STOP_TIME, specificstate);

        queue.add(start);
        queue.add(close);
        queue.add(stop);

        Simulator sim = new Simulator(queue, state);

        sim.Run();

        return specificstate;



    }

    /**
     * runs a loop with a set seed and tests what amount of cashierss are the optimal number
    @param  seed seed that gives all the random values.
    @return optimal number of cashiers
    */

    private static int RequiredCheckout(long seed){
        StoreState state;
        int miss = 999999;
        int registeramount = 0;

        //cash är antalet kassor vi går igenom
        for (int cash = M; cash > 1; cash--){
            state = OptimizeRun(cash, seed);

            if (state.getMissed() > miss){
                break;
            }
            miss = state.getMissed();
            registeramount = cash;

        }
        //System.out.print("vi missar " + miss);
        //System.out.println("");

        return registeramount;
    }
    
    /**
     * Creates multiple random nuber and sets them as seeds in RequiredCheckout, after that we svae what amount of cashiers was the best
    @param seed that gives all the random values.
    */
    private static void RandomRun(int seed){
        Random random = new Random(seed);
        int count = 0;
        int registeramount = 1;

        while (true) {
            int kort = random.nextInt();
            int kortas = RequiredCheckout(kort);
            if (kortas > registeramount) {
                count = 0;
                registeramount = kortas;
            }else{
                count++;
            }

            if (count >= 100){
                break;
            }

        }

        //prints out the best amount of cashiers for the set parimiters
        System.out.print("Bästa kassaantal är : " + registeramount);

    }



    
}