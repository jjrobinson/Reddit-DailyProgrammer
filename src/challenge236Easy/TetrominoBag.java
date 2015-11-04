/*
 * 
 */
package challenge236Easy;

import java.util.Random;

/**
 * Description
 * 
 * Contrary to popular belief, the tetromino pieces you are given in a game of 
 * Tetris are not randomly selected. Instead, all seven pieces are placed into a
 * "bag." A piece is randomly removed from the bag and presented to the player 
 * until the bag is empty. When the bag is empty, it is refilled and the process
 * is repeated for any additional pieces that are needed.
 * 
 * In this way, it is assured that the player will never go too long without seeing
 *  a particular piece. It is possible for the player to receive two identical
 *  pieces in a row, but never three or more. Your task for today is to implement
 *  this system.
 * 
 * Input Description
 * None.
 * 
 * Output Description
 * 
 * Output a string signifying 50 tetromino pieces given to the player using the
 *  random bag system. This will be on a single line.
 *  
 * The pieces are as follows:
 * O
 * I
 * S
 * Z
 * L
 * J
 * T
 * Sample Inputs
 * 
 * None.
 * Sample Outputs
 * 
 * LJOZISTTLOSZIJOSTJZILLTZISJOOJSIZLTZISOJTLIOJLTSZO
 * OTJZSILILTZJOSOSIZTJLITZOJLSLZISTOJZTSIOJLZOSILJTS
 * ITJLZOSILJZSOTTJLOSIZIOLTZSJOLSJZITOZTLJISTLSZOIJO
 * Note
 * 
 * Although the output is semi-random, you can verify whether it is likely to be
 *  correct by making sure that pieces do not repeat within chunks of seven.
 * Credit
 * 
 * This challenge was developed by /u/chunes on /r/dailyprogrammer_ideas. If you 
 * have any challenge ideas please share them there and there's a chance we'll use 
 * them.
 * Bonus
 * 
 * Write a function that takes your output as input and verifies that it is a valid
 *  sequence of pieces.
 *   * @author JasonRobinson
 */
public class TetrominoBag {
    static char[] letters = "OISZLJT".toCharArray();
    static int max = 50;
    static Random r = new Random();
    
    public static void main(String args[]){

        //System.out.println("String of 50 tetromino characters: ");
        char[] chars = new char[50];
        char prevChar = ' ';

        
        for (int i = 0; i <max;i++) {
            chars[i] = getAChar(prevChar);
            prevChar = chars[i];
        }
        System.out.println(String.valueOf(chars));
        
            
    }
    
    public static char getAChar(char c){
        int Low = 0;
        int High = 7;
        char newChar = c;
        int R = r.nextInt(High-Low) + Low;
        while(letters[R] == c) {
            R = r.nextInt(High-Low) + Low;
            }
        return letters[R];
    }
}
