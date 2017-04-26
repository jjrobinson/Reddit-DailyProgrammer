/*
 * 
 */
package challenge251.easy;

import org.jjrobinson.util.fileio.ChallengeInput;
import java.util.ArrayList;

/**
 * [2016-01-25] Challenge #251 [Easy] Create Nonogram description
 * submitted 4 hours ago * by fvandepitte
 * Description
 * 
 * This week we are doing a challenge involving Nonograms
 * It is going to be a three parter:
 * Create Nonogram description ([Easy])
 * Solve Nonogram ([Intermediate/Hard])
 * Working with multiple colors/characters ([Hard])
 * Bonus: Make it an interactive game ([Intermediate])
 * 
 * What is a Nonogram?
 * 
 * Nonograms, also known as Hanjie, Picross or Griddlers, are picture logic
 * puzzles in which cells in a grid must be colored or left blank according to
 * numbers at the side of the grid to reveal a hidden picture. In this puzzle
 * type, the numbers are a form of discrete tomography that measures how many
 * unbroken lines of filled-in squares there are in any given row or column.
 * In a Nonogram you are given the number of elements in the rows and columns.
 * A row/column where containing no element has a '0' all other rows/columns
 * will have at least one number.
 * Each number in a row/column represent sets of elements next to each other.
 * If a row/column have multiple sets, the declaration of that row/column will
 * have multiple numbers. These sets will always be at least 1 cell apart.
 * An example
 * 2	1	1	
 * 1	1	1	2	1
 * 2		*	*		
 * 1	2		*		*	*
 * 0					
 * 2	1	*	*		*	
 * 2			*	*	
 * Formal Inputs & Outputs
 * 
 * Input description
 * 
 * Today you will recieve an image in ASCII with ' ' being empty and '*' being
 * full. The number of rows and columns will always be a multiple of 5.
 *     *
 *    **
 *   * *
 *  *  *
 * *****
 * Output description
 * 
 * Give the columns and rows for the input
 * Columns:
 *     1 1 
 * 1 2 1 1 5
 * 
 * Rows:
 *   1
 *   2
 * 1 1
 * 1 1
 *   5
 * Ins
 * 
 * 1
 *     *
 *    **
 *   * *
 *  *  *
 * *****
 * 2
 *     ** *  
 *    *****  
 *   ******  
 *  ******** 
 * **********
 *  *      * 
 *  * ** * * 
 *  * ** * * 
 *  * **   * 
 *  ******** 
 * 3
 *      ***       
 *   **** **      
 *  ****** ****** 
 *  * **** **    *
 *  ****** ***  **
 *  ****** *******
 * ****** ********
 *  *   **********
 *  *   **********
 *  *   **********
 *  * * ****  ****
 *  *** ****  ****
 *      ****  ****
 *      ****  ****
 *      ****  ****
 * Bonus
 * 
 * Place the columns and rows in a grid like you would give to a puzzler
 *         1 1 
 *     1 2 1 1 5
 *   1
 *   2
 * 1 1
 * 1 1
 *   5
 * @author JasonRobinson
 */
public class Nonograms {
    public static boolean debug = true;
    
    public static void main(String[] args){
        ChallengeInput in = new ChallengeInput();
        ArrayList<String> input = in.getInputByLines(Nonograms.class, "/data/challenge251easy.txt");
        
        ArrayList<Nonogram> puzzles = parseToPuzzles(input);
        printPuzzles(puzzles);
        
        printTotals(puzzles);
        
    }//end main
    
    
    public static ArrayList<Nonogram> parseToPuzzles(ArrayList<String> in){
        ArrayList<Nonogram> all = new ArrayList<Nonogram>();
        
        for(int i =0;i< in.size();i++){
            String s = in.get(i);
            if(debug)System.out.println("Line "+i+": "+ s);
            int puzzleNum = 0;
            if(isNumeric(s)){
                Nonogram newPuzzle = new Nonogram();
                puzzleNum = Integer.parseInt(s);
                for (int j = 1;j< puzzleNum*5;j++){
                    String line = in.get(i+j);
                    if(debug)System.out.println("Puzzle "+puzzleNum+" Line "+j+":"+line);
                    newPuzzle.addLine(line);
                }
                i = (i+puzzleNum*5);
                all.add(newPuzzle);
            }
        }
        return all;
    }
    
    
    public static boolean isNumeric(String str){  
        try  
        {  
            int i = Integer.parseInt(str);
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;
        }  
        return true;  
    }
    
    public static void printPuzzles(ArrayList<Nonogram> p){
        for(Nonogram n: p){
            System.out.println(n);
        }
    }
    
    public static void printTotals(ArrayList<Nonogram> p){
        for(Nonogram n : p){
            System.out.println("New Puzzle:");
            for(int x =0;x<n.getSize();x++){
                System.out.println("Row"+x + ": " + n.countInRow(x)+" :"+n.getRow(x));
            }
        }
        
    }
    
}
