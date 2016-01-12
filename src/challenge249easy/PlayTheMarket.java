/*
 * 
 */
package challenge249easy;

import common.Price;
import common.ChallengeInput;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * [2016-01-11] Challenge #249 [Easy] Playing the Stock Market
 * 
 * Description
 * 
 * Let's assume I'm playing the stock market - buy low, sell high. I'm a day
 * trader, so I want to get in and out of a stock before the day is done, and I
 * want to time my trades so that I make the biggest gain possible.
 * The market has a rule that won't let me buy and sell in a pair of ticks - I
 * have to wait for at least one tick to go buy. And obviously I can't buy in
 * the future and sell in the past.
 * So, given a list of stock price ticks for the day, can you tell me what
 * trades I should make to maximize my gain within the constraints of the
 * market? Remember - buy low, sell high, and you can't sell before you buy.
 * Input Description
 * 
 * You'll be given a list of stock prices as a space separated list of 2 decimal
 * floats (dollars and cents), listed in chronological order. Example:
 * 19.35 19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98
 * Output Description
 * 
 * Your program should emit the two trades in chronological order - what you
 * think I should buy at and sell at. Example:
 * 18.88 19.03
 * Challenge Input
 * 
 * 9.20 8.03 10.02 8.08 8.14 8.10 8.31 8.28 8.35 8.34 8.39 8.45 8.38 8.38 8.32
 * 8.36 8.28 8.28 8.38 8.48 8.49 8.54 8.73 8.72 8.76 8.74 8.87 8.82 8.81 8.82
 * 8.85 8.85 8.86 8.63 8.70 8.68 8.72 8.77 8.69 8.65 8.70 8.98 8.98 8.87 8.71
 * 9.17 9.34 9.28 8.98 9.02 9.16 9.15 9.07 9.14 9.13 9.10 9.16 9.06 9.10 9.15
 * 9.11 8.72 8.86 8.83 8.70 8.69 8.73 8.73 8.67 8.70 8.69 8.81 8.82 8.83 8.91
 * 8.80 8.97 8.86 8.81 8.87 8.82 8.78 8.82 8.77 8.54 8.32 8.33 8.32 8.51 8.53
 * 8.52 8.41 8.55 8.31 8.38 8.34 8.34 8.19 8.17 8.16
 
 * Challenge Output
 * 
 * 8.03 9.34
 * @author JasonRobinson
 */
public class PlayTheMarket {
    public static boolean debug = false;
    
    public static void main(String[] args){
        ChallengeInput in = new ChallengeInput();
        ArrayList<String> input = in.getInputByLines(PlayTheMarket.class, "/data/challenge249easy.txt");
        ArrayList<Double> ticks = new ArrayList<Double>();

        for(String game : input){//each test will be an iteration
            String[] p1 = game.split(" ");
            ArrayList<String> p2 = new ArrayList<String>(Arrays.asList(p1));
            ArrayList<Double> smartTrades = null;
            for(String s : p2){//
                ticks.add(Double.parseDouble(s));
                double firstTrade = ticks.remove(0);
                smartTrades = processTrades(ticks, firstTrade, firstTrade, 0.0);
            }
        }
        
//        ArrayList<Integer> prices = parseToCents(input);//prices in cents
//        
//        for(Price p : prices){
//            if (debug) System.out.println("Price: "+p);
//        }
        
        
        
        
        
    }//end of main
    
//    private static ArrayList<Integer> parseToCents(ArrayList<String> in){
//        ArrayList<Integer> out = new ArrayList<Integer>();
//        try{
//            for(String s : in){
//                if (debug) System.out.println("Converting: \""+s+"\"");
//                int d = 0; int c = 0;int cents = 0;
//                String[] priceString = s.split("\\.");
//                if(priceString.length > 0) {
//                    d = Integer.parseInt(priceString[0]);
//                    c = Integer.parseInt(priceString[1]);
//                    cents = (d*100) + c;
//                } else {
//                    System.out.println("ERROR: not enough numbers in this string to parse into a price.");
//                }
//                out.add(cents);
//            }
//            //done looping through all input
//            
//        } catch (Exception e){
//            System.out.println("ERROR: Exception: " + e);
//        }
//        return out;
//    }
    
    
    private static ArrayList<Double> processTrades(ArrayList<Double> ticks, double high, double low, double diff){
        if (ticks.size()>1){
            //increase by 2
            double trade1 = ticks.remove(0);
            double trade2 = ticks.remove(0);
            if (trade1 > high)
        }
        return null;
    }

}
