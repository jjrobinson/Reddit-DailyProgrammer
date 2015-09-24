/*
 * 
 */
package com.boiseitoncall.redditDailyProgrammer.Challenge233;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author JasonRobinson
 */
public class Challenge233 {
     public static void main(String[] args) {
        if (args.length > 0) {
            for(String s : args) {
                File f = new File(s);

                if(f.exists()){
                    System.out.println("File exists: \"" + f.getPath().toString() + "\"");
//main body of program inside args loop
    try {
 
        ArrayList<char[]> input = getChallengeInput(f);
//        long start = System.currentTimeMillis();
//        System.out.println("Line Character ArrayList: \""+input.toString() +"\"");

        
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
     }
        
    
    
    public static void printIteration(ArrayList<char[]> iter, int iteration) {
        
    }
  
    
    
    public static ArrayList<char[]> getChallengeInput(File f) throws IOException {
        BufferedReader br = null;
        ArrayList<char[]> input = new ArrayList<char[]>();
        String sCurrentLine;
        
        br = new BufferedReader(new FileReader(f));


        if ((sCurrentLine = br.readLine()) != null) {
            //we have a first line
            int lineNumber = 0;
            if ((sCurrentLine = br.readLine()) != null) {
                char[] inputChars = sCurrentLine.toLowerCase().toCharArray();
                input.add(inputChars);

                lineNumber++;
            } else {
                //EOF before we expected.
                System.out.println("ERROR: came to the end of the file before we expected at line#:" +lineNumber);
                }
            //done with expected # of lines.
        }
        return input;
    }

}
