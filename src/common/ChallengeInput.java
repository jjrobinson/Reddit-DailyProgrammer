package common;

/*
 * 
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JasonRobinson
 */
public class ChallengeInput {
    private String headerLine;
    private ArrayList<String> input;
    private File f;
    private Scanner s;
    private String resourceName;
    
    
    public ChallengeInput(){
        this.headerLine = null;
        this.input = null;
        this.f = null;
        this.s = null;
        this.resourceName = null;
    }
    
    /**
     * Returns the input file as an ArrayList of char arrays (char[]).
     * @param c
     * @param file
     * @return 
     */
    public ArrayList<char[]> getInputByCharacters(Class c, String file){
        this.resourceName = file;
        return getFileAsResourceByCharsNewLineDelineated(c);
    }
    
    
    /**
     * Gets the input from the resources as an arraylsit of strings, space 
     * delineated
     * @param c
     * @param file 
     */
    public ArrayList<String> getInputByWords(Class c, String file){
        this.resourceName = file;
        input = new ArrayList<String>();
        headerLine = new String();
        getFileAsResourceSpaceDelineated(c);
        return this.input;
    }
    
    /**
     * Gets the input from the resources as an arraylsit of strings, newline 
     * delineated
     * @param c
     * @param file 
     */
    public ArrayList<String> getInputByLines(Class c, String file){
        this.resourceName = file;
        input = new ArrayList<String>();
        headerLine = new String();
        getFileAsResourceNewLineDelineated(c);
        return this.input;
    }
    
    
    public ChallengeInput(File inputFile){
        this.headerLine = null;
        this.input = new ArrayList<String>();
        this.f = inputFile;
        try {
            getChallengeInput(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Private function to take input contents from a resource in the 
     * project's jar and separate them by spaces
     * 
     * @param c 
     */
    private void getFileAsResourceSpaceDelineated(Class c){
        try{
            s = new Scanner(c.getResourceAsStream(resourceName)); 
            while (s.hasNext())
                this.input.add(s.next());

            setHeaderLine(this.input.get(0));
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }


  
    /**
     * Private function to take input contents from a resource in the 
     * project's jar separate them by newLines.
     * 
     * @param c 
     */
    private void getFileAsResourceNewLineDelineated(Class c){
        try{
            s = new Scanner(c.getResourceAsStream(resourceName)); 
            while (s.hasNextLine())
                this.input.add(s.nextLine());

            setHeaderLine(this.input.get(0));
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }


  
    /**
     * Private function to take input contents from a resource in the 
     * project's jar separate them by newLines.
     * 
     * @param c 
     */
    private ArrayList<char[]> getFileAsResourceByCharsNewLineDelineated(Class c){
        ArrayList<char[]> charLines = new ArrayList<char[]>();
        try{
            s = new Scanner(c.getResourceAsStream(resourceName)); 
            while (s.hasNextLine()){
                char[] line = s.nextLine().toCharArray();
                charLines.add(line);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return charLines;
    }


    
    private void getChallengeInput(File f) throws IOException{
        BufferedReader br = null;
        String sCurrentLine;
        
        br = new BufferedReader(new FileReader(f));


        if ((sCurrentLine = br.readLine()) != null) {
            //we have a first line
            this.headerLine = sCurrentLine;
                
            //get the rest of the words
            while ((sCurrentLine = br.readLine()) != null) {
                input.add(sCurrentLine);
            }//end while loop
            //done with expected # of lines.
        }
    }



    public String getHeaderLine() {
        return this.headerLine;
    }

    private void setHeaderLine(String headerLine) {
        this.headerLine = headerLine;
    }

    public ArrayList<String> getInput() {
        return this.input;
    }
    
}
