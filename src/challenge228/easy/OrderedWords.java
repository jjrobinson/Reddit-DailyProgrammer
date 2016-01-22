/*
 * 
 */
package challenge228.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * * [2015-08-17] Challenge #228 [Easy] Letters in Alphabetical Order
 * submitted 5 months ago by jnazario2 0
 * Description
 * 
 * A handful of words have their letters in alphabetical order, that is nowhere
 * in the word do you change direction in the word if you were to scan along the
 * English alphabet. An example is the word "almost", which has its letters in
 * alphabetical order.
 * Your challenge today is to write a program that can determine if the letters
 * in a word are in alphabetical order.
 * As a bonus, see if you can find words spelled in reverse alphebatical order.
 * 
 * Input Description
 * 
 * You'll be given one word per line, all in standard English. Examples:
 * almost
 * cereal
 * 
 * Output Description
 *  * Your program should emit the word and if it is in order or not. 
 * 
 * Examples:
 * almost IN ORDER
 * cereal NOT IN ORDER
 * 
 * Challenge Input
 * billowy
 * biopsy
 * chinos
 * defaced
 * chintz
 * sponged
 * bijoux
 * abhors
 * fiddle
 * begins
 * chimps
 * wronged
 * Challenge Output
 * 
 * billowy IN ORDER
 * biopsy IN ORDER
 * chinos IN ORDER
 * defaced NOT IN ORDER
 * chintz IN ORDER
 * sponged REVERSE ORDER 
 * bijoux IN ORDER
 * abhors IN ORDER
 * fiddle NOT IN ORDER
 * begins IN ORDER
 * chimps IN ORDER
 * wronged REVERSE ORDER
 * @author JasonRobinson
 */
public class OrderedWords {
    public static ArrayList<String> input = new ArrayList<String>(
            Arrays.asList("billowy","biopsy","chinos","defaced","chintz",
                    "sponged","bijoux","abhors","fiddle","begins","chimps",
                    "wronged"));
    
    public static void main(String[] args){
        for (String s : input){
            String result = findOrder(s);
            System.out.println(s+" " + result);
        }
    }
    
    public static String findOrder(String s){
        char[] letters = s.toCharArray();
        boolean inOrder = true;
        boolean inReverseOrder = true;
        
        if(letters.length > 0){
            
            for(int i=0;i< letters.length;i++){
                char curr = letters[0];
                char next = letters[0];
                Character c = letters[i];
                if (i<letters.length-1){
                    curr = Character.toLowerCase(letters[i]);
                    next = Character.toLowerCase(letters[i+1]);
                    if(curr < next)
                        inReverseOrder = false;
                    if (curr > next)
                        inOrder = false;
                    
                }// on the last letter
            }
        }// more than a zero length word
        if (inOrder){
            return "IN ORDER";
        } else if (inReverseOrder){
            return "REVERSE ORDER";
        } else 
            return "NOT IN ORDER";
    }
}
