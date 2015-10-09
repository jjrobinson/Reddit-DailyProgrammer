/*
 * 
 */
package com.boiseitoncall.redditDailyProgrammer.Challenge232Intermediate;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * * Description
 * 
 * My grandmother and I are moving to a new neighborhood. The houses haven't 
 * yet been built, but the map has been drawn. We'd like to live as close 
 * together as possible. She makes some outstanding cookies, and I love visiting
 * her house on the weekend for delicious meals - my grandmother is probably 
 * my favorite cook!
 * Please help us find the two lots that are closest together so we can build 
 * our houses as soon as possible.
 * Example Input
 * 
 * You'll be given a single integer, N, on a line, then N lines of Cartesian 
 * coordinates of (x,y) pairs. Example:
 * 16 
 * (6.422011725438139, 5.833206713226367)
 * (3.154480546252892, 4.063265532639129)
 * (8.894562467908552, 0.3522346393034437)
 * (6.004788746281089, 7.071213090379764)
 * (8.104623252768594, 9.194871763484924)
 * (9.634479418727688, 4.005338324547684)
 * (6.743779037952768, 0.7913485528735764)
 * (5.560341970499806, 9.270388445393506)
 * (4.67281620242621, 8.459931892672067)
 * (0.30104230919622, 9.406899285442249)
 * (6.625930036636377, 6.084986606308885)
 * (9.03069534561186, 2.3737246966612515)
 * (9.3632392904531, 1.8014711293897012)
 * (2.6739636897837915, 1.6220708577223641)
 * (4.766674944433654, 1.9455404764480477)
 * (7.438388978141802, 6.053689746381798)
 * Example Output
 * 
 * Your program should emit the two points of (x,y) pairs that are closest 
 * together. Example:
 * (6.625930036636377,6.084986606308885) (6.422011725438139,5.833206713226367)
 * 
 * Bonus
 * 
 * A nearly 5000 point bonus set to really stress test your approach. 
 * http://hastebin.com/oyayubigof.lisp
 * @author JasonRobinson
 */
public class GrandmasHouseDistance {
    public static void main(String[] args) {
        if (args.length > 0) {
            for(String s : args) {

                File f = new File(s);

                if(f.exists()){
                    System.out.println("File exists: \"" + f.getPath().toString() + "\"");
//main body of program inside args loop
    try {

        ArrayList<String> input = getChallengeInput(f);
//        long start = System.currentTimeMillis();
//        System.out.println("Line Character ArrayList: \""+input.toString() +"\"");

        ArrayList<Character> charArray = parseToChars(input);
        System.out.println("Character ArrayList: \""+charArray.toString() +"\"");

        if (isPalendrome(charArray)) {
            System.out.println("Palendrome.");
        } else {
            System.out.println("Not a palendrome.");
        }
        
//        long end = System.currentTimeMillis();
//        System.out.println("Completed in: " +(end-start) +"ms");


    } catch (IOException e) {
            e.printStackTrace();
    }
//main body of program inside args loop

                }else{
                    System.out.println("ERROR: Argument 1:" +args[0] +" is not a file, or file not found!");
                    System.exit(-1);
                }
            }
        } else {
            System.out.println("ERROR: must supply at least one argument at runtime.");
            System.exit(-1);
        }
        
    }//end main(String args[])


    public static ArrayList<String> getChallengeInput(File f) throws IOException{
        BufferedReader br = null;
        ArrayList<String> words = new ArrayList();
        String sCurrentLine;
        
        br = new BufferedReader(new FileReader(f));


        if ((sCurrentLine = br.readLine()) != null) {
            //we have a first line
            int numLines = Integer.parseInt(sCurrentLine);
            if (numLines > 0)
                System.out.println("Number of Lines To Read In: " + numLines);
                
                //get the rest of the words
                int lineNumber = 0;
                while (lineNumber < numLines) {
                    if ((sCurrentLine = br.readLine()) != null) {
                        String[] inputWords = sCurrentLine.replaceAll("[^\\p{IsAlphabetic}]", "").split(" ");
                        for(String s: inputWords) {
                            words.add(s.toLowerCase());
                        }

                        lineNumber++;
                    } else {
                        //EOF before we expected.
                        System.out.println("ERROR: came to the end of the file before we expected at line#:" +lineNumber);
                        }
                    //
                }//end while loop on counter < numHouses
                //done with expected # of lines.
            }
        return words;
        }
 
	public static ArrayList<Character> parseToChars(ArrayList<String> words) {
            ArrayList<Character> returnChars = new ArrayList<Character>();
            for (String s : words) {
                char[] chars = new char[s.length()];
                s.getChars(0, s.length(), chars, 0);
                for(char c: chars) {
                    returnChars.add(c);
                }//push all chars into arrayList<Character>
            }//iterate through all the words stored in the incomming words list
            return returnChars;
	}

    public static boolean isPalendrome(ArrayList<Character> chars){
        int length = chars.size();
        //System.out.println("Size: " + length);
        boolean isPalendrome = false;
        
//only need to check first 1/2 against last half. N/2 comparisons.
        for (int i = 0; i < (length/2); i++) {
            if (chars.get(i).compareTo(chars.get(length-i-1)) == 0)
                isPalendrome = true;
            else
                return false;
        }
        return isPalendrome;
    }

}
