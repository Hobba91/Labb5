package Labb5.main;

import Labb5.state.StoreState;
import Labb5.events.Close;
import Labb5.events.Start;
import Labb5.events.Stop;
import Labb5.simulator.*;

/**
* @author Simon Ruskola, Gabriel Sundblad, Elmer Tallgren, Rasmus Svedberg
*/
/** 
Runs The simulation calculating the the least amount of cashiers required to get the most amount of customers
*/

import java.util.Random;

public class Optimize {

    public static void main(String[] args) {
        //System.out.print(RequiredCheckout(1234));
        RandomRun(13);
        //OptimizeRun(4,1234);

    }

    /**
    @param runs the simulator with the decided parameters
    @return specificstate
    */ 
    private static StoreState OptimizeRun(int cash, long seed) {

        //variabler
        final int M = 7;
        final double L = 3;
        final double[] PICK_TIME = { 0.6d, 0.9d};
        
        final double[] PAY_TIME = {0.35d,0.6d};
        final double END_TIME = 8.0d;   // 
        final double STOP_TIME = 999.0d; //
        


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
    @param Runs a loop with a set seed and tests what amount of cashierss are the optimal nuber
    @return registeramount
    */

    private static int RequiredCheckout(long seed){
        StoreState state;
        int miss = 999999;
        int registeramount = 0;

        //cash är antalet kassor vi går igenom
        for (int cash = 100; cash > 1; cash--){
            state = OptimizeRun(cash, seed);

            if (state.getMissed() > miss){
                break;
            }
            miss = state.getMissed();
            registeramount = cash;

        }
        return registeramount;
    }
    
    /**
    @param Creates multiple random nuber and sets them as seeds in RequiredCheckout, after that we svae what amount of cashiers was the best
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
