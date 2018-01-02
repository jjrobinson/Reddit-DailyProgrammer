/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenege344.easy;

/**
 *
 * @author jarobinson
 */
public class BaumSweetSequence {
    public static void main(String args[]){
        System.out.println("Args="+args[0]);
        
        for (int i = 0; i <= Integer.parseInt(args[0]) ;i++ ){
        
            String binary = toBinary(i);
            if (isBaumSweet(binary))
                System.out.println("0");
            else 
                System.out.println("1");
        }
        
        BaumSweetSequence bss = new BaumSweetSequence();
        
        
        
    }
    
    static String toBinary(int num){
        String binary = Integer.toBinaryString(num);
        System.out.println("Num="+num+" in binary is: \""+binary+"\"");
        return binary;
    }
    
    static boolean isBaumSweet(String s){
        char[] bits = s.toCharArray();
        int runLength=0;
        for (int i = 0; i < bits.length; i++){
            char bit = bits[i];
            //System.out.println("\tTesting digit: "+bits[i]);
            if (bit == '1') {
                if (runLength%2 == 1)
                    return true;
                else 
                    runLength=0;
            }
            //char is a 0
            else {
                runLength++;
            }
        }//end loop on each bit
        if (runLength%2 == 1)
            return true;
        
        return false;
    }
    
}
