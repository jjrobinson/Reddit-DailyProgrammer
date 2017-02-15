/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge302.easy;

import common.ChallengeInput;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import sun.rmi.runtime.Log;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class PeriodicTable {
    private TreeMap<String, Element> table = null;

    
    public PeriodicTable(){
        table = new TreeMap();
        assembleTable();
    }
    
    private void assembleTable(){
        String inFile="/data/tableOfElements.txt";
        ArrayList<String> input = null;
        ChallengeInput in = new ChallengeInput();
        input = in.getInputByLines(PeriodicTable.class, inFile);
        
        for(String s: input){
            
            
            try{
                //System.out.println("Before Parsing: "+s);
                String[] splitLine = s.trim().split(";");

                Element e = null;
                String name = splitLine[0];
                String symbol = splitLine[1];
                int num = Integer.parseInt(splitLine[2]);
                float w = 0;
                float pEvalue = 0;
                w = Float.parseFloat(splitLine[3]);

                if(splitLine.length==4)
                    pEvalue = Float.parseFloat("0.0");
                else 
                    pEvalue=Float.parseFloat(splitLine[4]);
                    
                //put parts of string into new Element.
                e = new Element(name,symbol,num,w,pEvalue);
//                System.out.println("Element: "+name+","+e.getName()+","+e.getSymbol()+","+
//                    e.getNumber()+","+e.getWeight()+","+e.getElectroNegativitiy());
                this.table.put(e.getSymbol(), e);
            
            } catch(Exception e){
                System.out.println(e+":"+s);
            }
        }
    }


    public String hasElementWithSymbol(String s){
        //System.out.print("\tChecking \""+s+"\" against...");
        for(Map.Entry<String,Element> e : this.table.entrySet()){
            //System.out.print("\""+e.getValue().getSymbol()+"\",");
            if(s.equalsIgnoreCase(e.getValue().getSymbol())){
                //System.out.println();
                return e.getValue().getSymbol();
            }
        }
        //System.out.println();
        return "";
    }
}
