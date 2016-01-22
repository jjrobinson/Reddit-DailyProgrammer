/*
 * 
 */
package challenge238.easy;

import java.util.ArrayList;
import java.util.Random;

/**
 * Description
 * 
 * You were hired to create words for a new language. However, your boss wants
 * these words to follow a strict pattern of consonants and vowels. You are bad
 * at creating words by yourself, so you decide it would be best to randomly
 * generate them.
 * Your task is to create a program that generates a random word given a pattern
 * of consonants (c) and vowels (v).
 * Input Description
 * 
 * Any string of the letters c and v, uppercase or lowercase.
 * Output Description
 * 
 * A random lowercase string of letters in which
 * consonants = (bcdfghjklmnpqrstvwxyz) occupy the given 'c' indices and vowels
 * (aeiou) occupy the given 'v' indices.
 * Sample Inputs
 * 
 * cvcvcc
 * CcvV
 * cvcvcvcvcvcvcvcvcvcv
 * 
 * Sample Outputs
 * 
 * litunn
 * ytie
 * poxuyusovevivikutire
 * 
 * Bonus
 * 
 * Error handling: make your program react when a user inputs a pattern that
 * doesn't consist of only c's and v's.
 * When the user inputs a capital C or V, capitalize the letter in that index of
 * the output.
 * Credit
 * 
 * This challenge was suggested by /u/boxofkangaroos. If you have any challenge
 * ideas please share them on /r/dailyprogrammer_ideas and there's a good chance
 * we'll use them.
 * @author JasonRobinson
 */
public class NewLang {
    public static char[] consonants = "bcdfghjklmnpqrstvwxyz".toCharArray();
    public static char[] vowels = {'a','e','i','o','u'};
    public static ArrayList<char[]> input = new ArrayList<>();
    public static Random rand = new Random();

    public static void main(String[] args){
        
        input.add("cvcvcc".toCharArray());
        input.add("CcvV".toCharArray());
        input.add("cvcvcvcvcvcvcvcvcvcv".toCharArray());
        
        //for each input line
        for (char[] line : input) {
            //for each char in input line
            char[] outputLine = new char[line.length];
//            System.out.println("Input(" +line.length +") : \"" 
//                    +String.valueOf(line) + "\"");
            for (int i = 0; i < line.length ; i++){
                boolean isUpper = Character.isUpperCase(line[i]);
                char ret = ' ';
                if(Character.toLowerCase(line[i]) == 'v'){
                    ret = get(vowels);
                    if(isUpper)
                        ret = Character.toUpperCase(ret);
                } else {
                    ret = get(consonants);
                    if(isUpper) 
                        ret = Character.toUpperCase(ret);
                }
                if (ret != ' ' )
                    outputLine[i] = ret;
            }//end iterating through all chars in a line
            System.out.println(String.valueOf(outputLine));
        }//end iterating through each line
    }

    public static char get(char[] bag){
        int R = rand.nextInt(bag.length);
        char ret = bag[R];
        return ret;
    }
    
}
