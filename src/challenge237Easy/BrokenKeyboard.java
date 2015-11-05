package challenge237Easy;

import java.util.ArrayList;
import java.util.Scanner;


/*
 * 
 */

/**
 * [2015-10-19] Challenge #237 [Easy] Broken Keyboard
 *
 * Description
 * 
 * Help! My keyboard is broken, only a few keys work any more. If I tell you
 * what keys work, can you tell me what words I can write?
 * (You should use the trusty enable1.txt file, or /usr/share/dict/words to
 * chose your valid English words from.)
 * Input Description
 * 
 * You'll be given a line with a single integer on it, telling you how many
 * lines to read. Then you'll be given that many lines, each line a list of
 * letters representing the keys that work on my keyboard. Example:
 * 3
 * abcd
 * qwer
 * hjklo
 * Output Description
 * 
 * Your program should emit the longest valid English language word you can
 * make for each keyboard configuration.
 * abcd = bacaba
 * qwer = ewerer
 * hjklo = kolokolo
 * Challenge Input
 * 
 * 4
 * edcf
 * bnik
 * poil
 * vybu
 * 
 * Challenge Output
 * 
 * edcf = deedeed
 * bnik = bikini
 * poil = pililloo
 * vybu = bubby
 * 
 * @author JasonRobinson
 */
public class BrokenKeyboard {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> possibleWords = new ArrayList<>();
        char[] bag;
        char[] wordInChars;

        try{

            
// below is in the src/data folder
            Scanner s = new Scanner(BrokenKeyboard.class.
                    getResourceAsStream("/data/english_word_list.txt")); 

            Scanner s2 = new Scanner(BrokenKeyboard.class.
                    getResourceAsStream("/data/challenge237Easy.txt")); 

            
            while (s.hasNext()){
                words.add(s.next());
            }
            
            while (s2.hasNext()){
                input.add(s2.next());
            }

                    
            
            int numLines = Integer.parseInt(input.remove(0));
            
            //process eash line
            for (String line : input) {
                possibleWords.clear();
                bag = line.toCharArray();
                int numChars = bag.length;
                
                for(String word : words) {
                    //for each word
                    wordInChars = word.toCharArray();
                    boolean canTypeThis = true;
                    //test each char in the word
                    for (int i=0;i<wordInChars.length;i++){
                        if(!keyThatWorks(bag, wordInChars[i]))
                            canTypeThis = false;
                    }
                    
                    if(canTypeThis){
                        possibleWords.add(word);
                    }
                }
                System.out.println(String.valueOf(bag));
                for(String w: possibleWords)
                    System.out.println("\t" + w);
                ArrayList<String> longestWords = findBiggestWord(possibleWords);
                
                if(longestWords.size() == 1)
                    System.out.println("Keyboard: \"" + String.valueOf(bag) + 
                        "\": Longest Word: " + longestWords.get(0));
                else if (longestWords.size() >1 ){
                    System.out.println("Keyboard: \"" + String.valueOf(bag) + 
                        "\": Longest Words: ");
                    for(String word : longestWords)
                        System.out.println("\t\t"+word);
                }
                    
                
            }//done checking each line in the dictionary
            
 

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//end public static main
    
    public static boolean keyThatWorks(char[] b, char c){
        for(int i=0;i<b.length;i++){
            if (b[i] == c)
                return true;
        }
        return false;
    }
    
    
    public static ArrayList<String> findBiggestWord(ArrayList<String> words){
        ArrayList<String> longestWords = new ArrayList<>();
        int max = 0;
        for(int i=0;i< words.size();i++){
            int length = words.get(i).length();
            if(max < length){
                max = length;
                longestWords.clear();
                longestWords.add(words.get(i));
            } else if (max == length){
                longestWords.add(words.get(i));
            }
        }
        
        return longestWords;
    }
    
    public static boolean findTheWord(ArrayList<String> words, String word){
        for(String w : words){
            if(word.equalsIgnoreCase(w))
                return true;
        }
        return false;
    }
    
    
}
