/*
 * 
 */
package com.boiseitoncall.redditDailyProgrammer.Challenge232;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author JasonRobinson
 */
public class Challenge232 {
    public static void main(String[] args) {
        if (args.length > 0) {
            for(String s : args) {

                File f = new File(s);

                if(f.exists()){
                    System.out.println("File exists: \"" + f.getPath().toString() + "\"");
//main body of program
    try {

        ArrayList<String> input = getChallengeInput(f);
        long start = System.currentTimeMillis();
        System.out.println("Line Character ArrayList: \""+input.toString() +"\"");

        ArrayList<Character> charArray = parseToChars(input);
        System.out.println("Character ArrayList: \""+charArray.toString() +"\"");

        if (isPalendrome(charArray)) {
            System.out.println("This is a palendrome.");
        } else {
            System.out.println("This is NOT a palendrome.");
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Completed in: " +(end-start) +"ms");


    } catch (IOException e) {
            e.printStackTrace();
    }
//main body of program


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
        System.out.println("Size: " + length);
        boolean isPalendrome = false;
        for (int i = 0; i < length; i++) {
            
            if (chars.get(i).compareTo(chars.get(length-i-1)) == 0)
                isPalendrome = true;
            else
                isPalendrome = false;
        }
        return isPalendrome;
    }

}
