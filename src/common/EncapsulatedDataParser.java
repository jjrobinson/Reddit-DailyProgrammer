/*
 * 
 */
package common;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Takes a string contain data inside parenthesis
 * @author JasonRobinson
 */
public class EncapsulatedDataParser {
    private String input;
    private ArrayList<String> data;
    private String[] inputParsed;

    public void EncapsulatedDataParser(){
        input = new String();
        data = new ArrayList<String>();
    }
    
    
    public ArrayList<String> EncapsulatedDataParser(String s){
        input = s;
        this.data = new ArrayList<String>();
        parse();
        return this.data;
    }
    

    private void parse(){
        this.inputParsed = input.replaceAll("[()]", "").split(",");
        if(inputParsed.length > 0){
            this.data.addAll(Arrays.asList(this.inputParsed));
        }
    }
    
    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
        data.clear();
        parse();
    }

    public ArrayList<String> getPairs() {
        return data;
    }

    public ArrayList<String> getPairs(String s) {
        this.data = new ArrayList<String>();
        this.input = s;
        parse();
        return data;
    }

    public void setPairs(ArrayList<String> pairs) {
        this.data = pairs;
        parse();
    }
    
}
