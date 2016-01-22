/*
 * 
 */
package challenge233.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *Description

Christopher has always dreamed of living in a really fancy ASCII house, and he's
* finally decided to make it happen. He works in a hedge fund and has made a lot 
* of money in the Unicode markets (buying cheap Cyrillic code-points and selling
* them to Russia), and he feels like he's finally able to afford it.
* He hires Melinda the ASCII architect, who designs and delivers the following 
* asterisk blue-print:
*    *
*   ***
* ******
* To make this beautiful drawing into reality, he hires Lilly the ASCII contractor
* to build it. It takes a few months, but finally Lilly delivers this beautiful 
* creation:
*               A
*              / \
*     A     A +---+ A
*    / \   / \|   |/ \
*   /   \ +---+   +---+ A
*  /     \| o         |/ \
* +-------+           +---+
* |     o      | |      o | 
* +-----------------------+ 
* In case it isn't clear: the o's are windows, the A's are the tops of the roof, 
* and the | | is a door. Notice that each asterisk has been transformed into a
* box that is 5 characters wide and 3 characters tall (and notice that two 
* neighboring boxes share an edge).
* Today, you are to step into the shoes of Lilly the ASCII contractor! You are to
* be given an ASCII blueprint of a house, which you will then turn in to 
* glorious reality.
* Formal inputs & outputs
* Inputs

* On the first line, you will receive a number telling you how many lines the
* blueprint will occupy.
* After that, you will receive some number of lines containing the blueprint. 
* Each line is guaranteed to be less than 30 characters long. The only two 
* characters allowed in the lines are spaces and asterisks, and there are a two
* assumptions you can make regarding the asterisks:
* The bottom line of asterisks (i.e. the "bottom floor"), will be one continuous 
* line of asterisks.
* All asterisks on lines except for the bottom line are guaranteed to have an
* asterisk directly below it. That is, there are no "free hanging" asterisks. 
* So no balconies.
* Outputs
* 
* You will draw that the input asterisks describe.
* There are four essential features of the ASCII house:
* The outline: the basic outline of the house. The outline is just the shape you
* get by replacing the asterisks by 3x5 boxes made of +'s, -'s and |'s. (Edit:
* to make it more clear what I mean with "outline", read this comment)
* The door: One box has a door on it that looks like | |. The door should be 
* placed in a random box on the ground floor.
* The windows: the windows consist of a single o in the middle of the box. If a
* box doesn't have a door on it, there should be a 50% random chance of having
* a window on it.
* The roofs: Each asterisk that has no asterisk above it should have a roof over 
* it. The roof is made of /, \ and A characters. If there are two or more boxes
* next to each other which don't have any boxes above them, they should share a
* wider roof. In other words, if you have three boxes next to each other without
* any boxes on top, then this is right:
*       A 
*      / \ 
*     /   \ 
*    /     \  
*   /       \ 
*  /         \ 
* +-----------+
* |           | 
* +-----------+
* And this is wrong:
*   A   A   A
*  / \ / \ / \
* +-----------+
* |           | 
* +-----------+
* You are given large leeway in which of these features you choose to implement.
* At a minimum, you should make your program draw the outline of the house
* according to the blueprint, but if you don't want to implement the windows,
* doors and roofs, that's fine.
* Sample inputs and outputs
* 
* Given that there's a random component in this challenge (where the doors and
* windows are located), your outputs obviously don't have to match these 
* character-by-character.
* Input 1
* 
* 3
*    *
*   ***
* ******
* Output 1
* 
*               A
*              / \
*     A     A +---+ A
*    / \   / \|   |/ \
*   /   \ +---+   +---+ A
*  /     \| o         |/ \
* +-------+           +---+
* |     o      | |      o | 
* +-----------------------+ 
* Input 2
* 
* 7
*  *
* ***
* ***
* ***
* ***
* ***
* ***
* Output 2
* 
*       A
*      / \
*   A +---+ A
*  / \|   |/ \
* +---+   +---+
* |     o     |
* |           |
* | o       o |
* |           |
* |     o   o |
* |           |
* | o   o     |
* |           |
* | o       o |
* |           |
* |    | |    |
* +-----------+
* (it's ASCII Empire State Building!)
* ^ * @author JasonRobinson
 */
public class Challenge233 {
    public static void main(String[] args) {

         
         
         
         
        if (args.length > 0) {
            for(String s : args) {
                File f = new File(s);

                if(f.exists()){
                    System.out.println("File exists: \"" + f.getPath().toString() + "\"");
//main body of program inside args loop
    try {
 
        ArrayList<ArrayList<Character>> input = getChallengeInput(f);
        
        ArrayList<ArrayList<Character>> expanded = new ArrayList<ArrayList<Character>>();
        printItOut(input);

        
        
//        long start = System.currentTimeMillis();
//        System.out.println("Line Character ArrayList: \""+input.toString() +"\"");

        
//        long end = System.currentTimeMillis();
//        System.out.println("Completed in: " +(end-start) +"ms");


    } catch (Exception e) {
            e.printStackTrace();
    }
//main body of program inside args loop

                }else{
                    System.out.println("ERROR: Argument 1:" +args[0] +" is not a file, or file not found!");
                    System.exit(-1);
                }
            }
        } else {
            System.out.println("ERROR: must supply at least one argument at runtime.");
            System.exit(-1);
        }
     }

	 
	 

	/**
	* Reads in the file to an <tt>ArrayList<ArrayList<Character>></tt>
	* @param f
	* @return <tt>ArrayList<ArrayList<Character>></tt>
	* @throws IOException 
	*/
    public static ArrayList<ArrayList<Character>> getChallengeInput(File f) throws IOException{
        BufferedReader br = null;
        ArrayList<ArrayList<Character>> input = new ArrayList<ArrayList<Character>>();
        String sCurrentLine;
        
        br = new BufferedReader(new FileReader(f));


        if ((sCurrentLine = br.readLine()) != null) {
            //we have a first line
            int numLines = Integer.parseInt(sCurrentLine);
            if (numLines > 0) {
                //System.out.println("Number of Lines To Read In: " + numLines);
                
                //get the rest of the words
                int lineNumber = 0;
                while ((sCurrentLine = br.readLine()) != null) {
                    ArrayList<Character> line = new ArrayList<Character>();
                    
                    //System.out.println("New Line.");
                    char[] inputWords = sCurrentLine.toCharArray();
                    for(char c: inputWords) {
                        //System.out.println("Character: \"" + c + "\"");
                        line.add(new Character(c));
                    }

                    lineNumber++;
                    input.add(line);
                }//end while loop on counter < numHouses
                //done with expected # of lines.
            }
        
        }
        return input;
    }

	
    public static void printItOut(ArrayList<ArrayList<Character>> output){
        int lineNum = 0;
        for(ArrayList<Character> line : output) {
            lineNum++;
            for(Character c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    
    
}
