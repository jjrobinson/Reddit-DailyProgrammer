package common;

/*
 * 
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    
    public ChallengeInput(Class c, String file){
        this.resourceName = file;
        input = new ArrayList<String>();
        headerLine = new String();
        getFileAsResource(c);
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
     * project's jar / inside the '/src' directory.
     * 
     * @param c 
     */
    private void getFileAsResource(Class c){
        try{
            s = new Scanner(c.getResourceAsStream(resourceName)); 
            while (s.hasNext())
                this.input.add(s.next());

            setHeaderLine(this.input.get(0));
            
        } catch(Exception e){
            e.printStackTrace();
        }
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
