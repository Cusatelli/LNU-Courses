package assignment_2;
/*
 * File:	Main.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti (modified by Kostiantyn Kucher)
 * Date: 	November 2019
 */

import java.util.ArrayList;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException, InterruptedException {
    	DiningPhilosopher dp = new DiningPhilosopher(); // create an instance of the DiningPhilosopher class
    	dp.DEBUG = true;
        int simulationTime = 10000;
        int seed = 100;
        if(args.length > 0) // check if the parameter is passed as an argument
        	simulationTime = Integer.parseInt(args[0]); // the first parameter is the simulation time
        
    	dp.initialize(simulationTime, seed); // initialize the required objects
    	dp.start(); // start the simulation process

    	dp.printTable();
    }
}