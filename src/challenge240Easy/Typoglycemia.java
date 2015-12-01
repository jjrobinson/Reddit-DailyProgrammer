/*
 * 
 */
package challenge240Easy;

import common.BagOf;
import common.BagOfLetters;
import common.ChallengeInput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *  * Description - [2015-11-09] Challenge #240 [Easy] Typoglycemia
 * 
 * Typoglycemia is a relatively new word given to a purported recent discovery
 * about how people read written text. As wikipedia puts it:
 * The legend, propagated by email and message boards, purportedly demonstrates
 * that readers can understand the meaning of words in a sentence even when the
 * interior letters of each word are scrambled. As long as all the necessary
 * letters are present, and the first and last letters remain the same, readers
 * appear to have little trouble reading the text.
 * Or as Urban Dictionary puts it:
 * Typoglycemia
 * The mind's ability to decipher a mis-spelled word if the first and last
 * letters of the word are correct.
 * The word Typoglycemia describes Teh mdin's atbiliy to dpeihecr a msi-selpeld
 * wrod if the fsirt and lsat lteetrs of the wrod are cerorct.
 * 
 * Input Description 
 * Any string of words with/without punctuation.
 * 
 * Output Description
 * A scrambled form of the same sentence but with the word's first and last
 * letter's positions intact.
 * 
 * Sample Inputs
 * 
 * According to a research team at Cambridge University, it doesn't matter in
 * what order the letters in a word are, the only important thing is that the
 * first and last letter be in the right place. 
 * The rest can be a total mess and you can still read it without a problem.
 * This is because the human mind does not read every letter by itself, but the
 * word as a whole. Such a condition is appropriately called Typoglycemia.
 * 
 * Sample Outputs
 * 
 * Aoccdrnig to a rseearch taem at Cmabrigde Uinervtisy, it deosn't mttaer in
 * waht oredr the ltteers in a wrod are, the olny iprmoatnt tihng is taht the
 * frist and lsat ltteer be in the rghit pclae. 
 * The rset can be a taotl mses and you can sitll raed it wouthit a porbelm. 
 * Tihs is bcuseae the huamn mnid deos not raed ervey lteter by istlef, but the
 * wrod as a wlohe. 
 * 
 * Scuh a cdonition is arppoiatrely cllaed Typoglycemia.
 * 
 * @author JasonRobinson
 */
public class Typoglycemia {
    public static List<String> inputLines;
    public static BagOf letters;
    
    
    public static void main(String args[]) {
        ChallengeInput in = new ChallengeInput(
        Typoglycemia.class,"/data/challenge240Easy.txt");
        List<String> input = in.getInput();
        BagOfLetters punct = new BagOfLetters();
        ArrayList<String> output = new ArrayList<String>();
        
        for (String s : input){
            BagOfLetters bag = new BagOfLetters();
            bag.setRepeatsAllowed(true);
            Character lastChar = null;
            Character startChar = null;
            System.out.println("Word: \"" + s + "\"");
            if(s.length()>=4){
                
                //find out if last char is a punctuation
                //if so, store it separately
                lastChar = s.charAt(s.length()-1);
                startChar = s.charAt(0);
//                Pattern punctPattern = Pattern.compile("\\p{Punct}");
//                Matcher m = punctPattern.matcher(s);
                if(lastChar.toString().matches("\\p{Punct}")){
                    //add the rest of the string minus the punctuation
                    System.out.println("Found punctuation char \"" + lastChar + "\"");
                    bag.setBag(s.substring(0, s.length()-2));
                } else {
                    
                }
                
                
                Character C = s.charAt(s.length()-2);
                if(C.compareTo('\'')==0){
//store the char before the apostrophe, the apostrophe, and the last char
                    String endOfString = s.substring(s.length()-3);
//found an apostrophe, send the bag all the other chars, then 
//tack the last two on at the end.
                    
                } else {
                    bag.setBag(s);
                    
                    }
                
//                System.out.print(s);
//                System.out.print(" ");
            } else {
                // smaller than 4 characters, we can't scramble the middle
                // and have that be a different string. So just add it.
                output.add(s);
            }// end of string length check.
        //TODO do something with the output
            
            
            output.
            
        }//end looping on input
        
        for(String s: output){
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
}
