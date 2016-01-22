/*
 * 
 */
package challenge236.easy;

import java.util.Random;

/**
 * Description
 * 
 * Contrary to popular belief, the tetromino pieces you are given in a game of 
 * Tetris are not randomly selected. Instead, all seven pieces are placed into a
 "bag." A piece is randomly removed from the bag and presented to the player 
 until the bag is empty. When the bag is empty, it is refilled and the process
 is repeated for any additional pieces that are needed.
 
 In this way, it is assured that the player will never go too long without seeing
  a particular piece. It is possible for the player to receive two identical
  pieces in a row, but never three or more. Your task for today is to implement
  this system.
 
 Input Description
 None.
 
 Output Description
 
 Output a string signifying 50 tetromino pieces given to the player using the
  random bag system. This will be on a single line.
  
 The pieces are as follows:
 O
 I
 S
 Z
 L
 J
 T
 Sample Inputs
 
 None.
 Sample Outputs
 
 LJOZISTTLOSZIJOSTJZILLTZISJOOJSIZLTZISOJTLIOJLTSZO
 OTJZSILILTZJOSOSIZTJLITZOJLSLZISTOJZTSIOJLZOSILJTS
 ITJLZOSILJZSOTTJLOSIZIOLTZSJOLSJZITOZTLJISTLSZOIJO
 Note
 
 Although the output is semi-random, you can verify whether it is likely to be
  correct by making sure that pieces do not repeat within chunks of seven.
 Credit
 
 This challenge was developed by /u/chunes on /rand/dailyprogrammer_ideas. If you 
 have any challenge ideas please share them there and there's a chance we'll use 
 them.
 Bonus
 
 Write a function that takes your output as input and verifies that it is a valid
  sequence of pieces.
   * @author JasonRobinson
 */
public class TetrominoBag {
    static final char[] chars = {'O','I','S','Z','L','J','T'};
    static Random rand = new Random();
    static char[] bag;

    public static void main(String args[]){
        char[] cs = new char[50];
        char prevChar = ' ';
        bag = chars.clone();

        for (int i = 0; i <50;i++) {
            if(isEmpty()) bag = chars.clone();
            cs[i] = get(prevChar);
            prevChar = cs[i];
        }
        System.out.println(String.valueOf(cs));
    }
    
    public static char get(char c){
        int R = rand.nextInt(7);
        while(bag[R] == ' ') {
            R = rand.nextInt(7);}
        char ret = bag[R];
        bag[R] = ' ';
        return ret;
    }

    public static boolean isEmpty(){
        char l = ' ';
        for(char c: bag)
            if (c != ' ') l = c;
        if (l == ' ') return true;
        else return false;
    }
}
