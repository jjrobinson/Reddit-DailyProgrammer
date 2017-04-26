/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge303.easy;

import java.util.ArrayList;
import java.util.Arrays;
import org.jjrobinson.util.fileio.ChallengeInput;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class Ricochet {
    public static void main(String[] args){
        String inFile="/data/challenge303easy.txt";
        
        ArrayList<String> input = new ChallengeInput()
                .getInputByLines(Ricochet.class, inFile);
//take first line as the chart bounds and create new BarChart with those bounds
        int h, w, v;
        
        int[] box = stringArrayToIntArray(input.get(0).split(" "));
        if (box.length != 3)
            System.out.println("ERROR: first line doesn't contain 3 separate ints.");
        h = box[0];
        w = box[1];
        v = box[2];
        
        System.out.println("Box Height="+h);
        System.out.println("Box Width="+w);
        System.out.println("Particle Velocity="+v);
        

    }//end main
    
    
    private static int[] stringArrayToIntArray(String[] s){
//        System.out.println("Size="+s.length);
        int[] asInts = new int[s.length];
        try{
        for(int i=0;i<s.length;i++){
//            System.out.println("Parsing: "+s[i]);
            asInts[i]= Integer.parseInt(s[i]);
            }
        } catch(Exception e){
            System.out.println("ERROR: NumberFormatException: "+e
                    +"\n"+Arrays.toString(s));
        }
        return asInts;
    }
}
