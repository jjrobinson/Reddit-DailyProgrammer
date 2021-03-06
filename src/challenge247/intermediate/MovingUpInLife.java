/*
 * 
 */
package challenge247.intermediate;

import org.jjrobinson.util.fileio.ChallengeInput;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * * (Intermediate): Moving (diagonally) Up in Life
 * 
 * Imagine you live on a grid of characters, like the one below. For this
 * example, we'll use a 2*2 grid for simplicity.
 * . X
 * 
 * X .
 * You start at the X at the bottom-left, and you want to get to the X at the
 * top-right. However, you can only move up, to the right, and diagonally right
 * and up in one go. This means there are three possible paths to get from one
 * X to the other X (with the path represented by -, + and |):
 * 
 * +-X  . X  . X
 * |     /     |
 * X .  X .  X-+
 * What if you're on a 3*3 grid, such as this one?
 * . . X
 * 
 * . . .
 * 
 * X . .
 * Let's enumerate all the possible paths:
 * +---X   . +-X   . +-X   . +-X   . . X   . +-X   . . X
 * |        /        |       |        /      |         |
 * | . .   + . .   +-+ .   . + .   . / .   . | .   +---+
 * |       |       |        /       /        |     |    
 * X . .   X . .   X . .   X . .   X . .   X-+ .   X . .
 * 
 * 
 * 
 * . . X   . . X   . . X   . . X   . . X    . . X
 *    /        |       |       |       |       /   
 * . + .   . +-+   . . +   . . |   . +-+    +-+ .
 *   |       |        /        |    /       |
 * X-+ .   X-+ .   X-+ .   X---+   X . .    X . .
 * That makes a total of 13 paths through a 3*3 grid.
 * However, what if you wanted to pass through 3 Xs on the grid? Something like
 * this?
 * 
 * . . X
 * 
 * . X .
 * 
 * X . .
 * Because we can only move up and right, if we're going to pass through the
 * middle X then there is no possible way to reach the top-left and bottom-right
 * space on the grid:
 *   . X
 * 
 * . X .
 * 
 * X .  
 * Hence, this situation is like two 2*2 grids joined together end-to-end. This
 * means there are 32=9 possible paths through the grid, as there are 3 ways to
 * traverse the 2*2 grid. (Try it yourself!)
 * 
 * Finally, some situations are impossible. Here, you cannot reach all 4 Xs on
 * the grid - either the top-left or bottom-right X must be missed:
 * 
 * X . X
 * 
 * . . .
 * 
 * X . X
 * This is because we cannot go left or down, only up or right - so this
 * situation is an invalid one.
 * Your challenge today is, given a grid with a certain number of Xs on it,
 * determine first whether the situation is valid (ie. all Xs can be reached),
 * and if it's valid, the number of possible paths traversing all the Xs.
 * Formal Inputs and Outputs
 * 
 * Input Specification
 * 
 * You'll be given a tuple M, N on one line, followed by N further lines (of
 * length M) containing a grid of spaces and Xs, like this:
 * 5, 4
 * ....X
 * ..X..
 * .....
 * X....
 * 
 * Note that the top-right X need not be at the very top-right of the grid, same
 * for the bottom-left X. Also, unlike the example grids shown above, there are
 * no spaces between the cells.
 * Output Description
 * 
 * Output the number of valid path combinations in the input, or an error
 * message if the input is invalid. For the above input, the output is:
 * 65
 * @author JasonRobinson
 */
public class MovingUpInLife {
    public static ArrayList<char[]> input = new ArrayList<char[]>();
    public static ArrayList<GameBoard> games = new ArrayList<GameBoard>();
    
    public static void main(String[] args){
        ChallengeInput in = new ChallengeInput();
        input = in.getInputByCharacters(MovingUpInLife.class, "/data/challenge247intermediate.txt");
        games = new ArrayList<GameBoard>();

        ArrayList<char[]> temp = new ArrayList<char[]>();
        int challengeNum = 1;
        
        //parse input on "~" character
        for(int i = 0; i< input.size();i++){
            char[] line = input.get(i);
            String[] numbers = line.toString().split(",");
            Character c = line[0];
            
            
            
            if(c.charValue()!='~'){
                //continue putting into temp record
                
                if(Character.isDigit(c)){
                    System.out.println("Input " +challengeNum + ": " 
                            +" X,Y dimensions: "+numbers[0]+","+numbers[1]+ line);
                } else {//not a number, so it must be a line of input
                    temp.add(line);
                    
                }
            } else {//found a ~
                

                temp.clear();
            }
        }
        
        
        
        System.out.println("Spitting out parsed input:");
        
        
    }
    
}
