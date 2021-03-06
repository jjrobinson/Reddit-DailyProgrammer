/*
 * 
 */
package challenge235.easy;

import org.jjrobinson.util.fileio.ChallengeInput;
import org.jjrobinson.util.EncapsulatedDataParser;
import org.jjrobinson.util.FactorFinder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * Description - [2015-10-05] Challenge #235 [Easy] Ruth-Aaron Pairs
 * 
 * In mathematics, a Ruth–Aaron pair consists of two consecutive integers
 * (e.g. 714 and 715) for which the sums of the distinct prime factors of each
 * integer are equal. For example, we know that (714, 715) is a valid Ruth-Aaron
 * air because its distinct prime factors are:
 * 
 * 714 = 2 * 3 * 7 * 17
 * 715 = 5 * 11 * 13
 * and the sum of those is both 29:
 * 2 + 3 + 7 + 17 = 5 + 11 + 13 = 29
 * 
 * The name was given by Carl Pomerance, a mathematician at the University of
 * Georgia, for Babe Ruth and Hank Aaron, as Ruth's career regular-season home
 * run total was 714, a record which Aaron eclipsed on April 8, 1974, when he
 * hit his 715th career home run. A student of one of Pomerance's colleagues
 * noticed that the sums of the distinct prime factors of 714 and 715 were
 * equal.
 * 
 * For a little more on it, see MathWorld - 
 * http://mathworld.wolfram.com/Ruth-AaronPair.html
 * Your task today is to determine if a pair of numbers is indeed a valid
 * Ruth-Aaron pair.
 * 
 * Input Description
 * 
 * You'll be given a single integer N on one line to tell you how many pairs to
 * read, and then that many pairs as two-tuples. For example:
 * 3
 * (714,715)
 * (77,78)
 * (20,21)
 * 
 * Output Description
 * 
 * Your program should emit if the numbers are valid Ruth-Aaron pairs. Example:
 * (714,715) VALID
 * (77,78) VALID
 * (20,21) NOT VALID
 * 
 * Challenge Input
 * 4
 * (5,6) 
 * (2107,2108) 
 * (492,493) 
 * (128,129) 
 * 
 * Challenge Output
 * 
 * (5,6) VALID
 * (2107,2108) VALID
 * (492,493) VALID
 * (128,129) NOT VALID
 * 
 * @author JasonRobinson
 */
public class RuthAaronPairs {
    static ArrayList<String> input;
    
    public static void main(String args[]) {
        
        ChallengeInput in = new ChallengeInput();
        FactorFinder factorFinder = new FactorFinder();
        
        input = in.getInputByWords(
                RuthAaronPairs.class,"/data/challenge235Easy.txt");
        
        //pop off the top entry which is the problem set size
        input.remove(0);
        int header = Integer.parseInt(in.getHeaderLine());
        ArrayList<String> inputLineData = null;
        EncapsulatedDataParser p = new EncapsulatedDataParser();
        for(String line : input) {
            //for each input line
            inputLineData = p.getPairs(line);
try{
    if (inputLineData.size() == 2) {
        FactorFinder fr = new FactorFinder();
        FactorFinder fl = new FactorFinder();
        ArrayList<Long> leftFactors = fr.findTheFactors(
                Long.parseLong(inputLineData.get(0)));
        ArrayList<Long> rightFactors = fr.findTheFactors(
                Long.parseLong(inputLineData.get(1)));
        System.out.print("("+inputLineData.get(0)+","+inputLineData.get(1) + ")");
        
//        //toss the 1
//        if(leftFactors.get(0) == 1) leftFactors.remove(0);
//        if(rightFactors.get(0) == 1) rightFactors.remove(0);
//        //toss the item at the end of the list if it is the number
//        if(leftFactors.get(leftFactors.size()-1) 
//                == Long.parseLong(inputLineData.get(0)))
//        {
//            leftFactors.remove(leftFactors.size()-1);
//        }
//        if(rightFactors.get(rightFactors.size()-1) 
//                == Long.parseLong(inputLineData.get(1)))
//        {
//            rightFactors.remove(rightFactors.size()-1);
//        }
//        

        long sumLeft = sum(leftFactors);
        long sumRight = sum(rightFactors);

        System.out.println("\nFactors for " + inputLineData.get(0));
            printFactors(leftFactors);

        System.out.println("\nFactors for " + inputLineData.get(1));
            printFactors(rightFactors);

        if (sumLeft == sumRight)
            System.out.print(" VALID\r\n");
        else 
            System.out.print(" NOT VALID\r\n");
    } else {
        //didnt' get exactly 2 values per row... something is wrong.
        System.exit(-1);
    }
}catch(Exception e){
    e.printStackTrace();
}//end try

        }//end loop on each line of input
        
        
    }//end public static void main
    
    
    public static long sum(ArrayList<Long> t){
        long sum = 0;
        for(Long L: t)
            sum = sum + L;
        return sum;
    }
    
    public static void printFactors(ArrayList<Long> f){
        for (Long L : f)
            System.out.print(L + " ");
    }
    
    
    
}//end class
