/*
 * 
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author JasonRobinson
 */
public class ChallengeInput {
    private String headerLine;
    private ArrayList<String> input;
    File f;
    

    public void ChallengeInput(File inputFile){
        this.headerLine = null;
        this.input = new ArrayList<String>();
        this.f = inputFile;
        try {
            getChallengeInput(inputFile);
        } catch (Exception e) {
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

    public void setHeaderLine(String headerLine) {
        this.headerLine = headerLine;
    }

    public ArrayList<String> getInput() {
        return this.input;
    }
    
}
