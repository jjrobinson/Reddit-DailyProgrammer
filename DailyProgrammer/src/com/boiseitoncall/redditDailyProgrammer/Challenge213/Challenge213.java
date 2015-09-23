/*
 * 
 */
package com.boiseitoncall.redditDailyProgrammer.Challenge213;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Cellular Automata: Rule 90
 * The development of cellular automata (CA) systems is typically attributed to 
 * Stanisław Ulam and John von Neumann, who were both researchers at the Los 
 * Alamos National Laboratory in New Mexico in the 1940s. Ulam was studying the 
 * growth of crystals and von Neumann was imagining a world of self-replicating 
 * robots. That’s right, robots that build copies of themselves. Once we see 
 * some examples of CA visualized, it’ll be clear how one might imagine modeling 
 * crystal growth; the robots idea is perhaps less obvious. Consider the design 
 * of a robot as a pattern on a grid of cells (think of filling in some squares 
 * on a piece of graph paper). Now consider a set of simple rules that would 
 * allow that pattern to create copies of itself on that grid. This is 
 * essentially the process of a CA that exhibits behavior similar to biological 
 * reproduction and evolution. (Incidentally, von Neumann’s cells had twenty-
 * nine possible states.) Von Neumann’s work in self-replication and CA is 
 * conceptually similar to what is probably the most famous cellular automaton: 
 * Conways “Game of Life,” sometimes seen as a screen saver. CA has been pushed 
 * very hard by Stephen Wolfram (e.g. Mathematica, Worlram Alpha, and "A New 
 * Kind of Science").
CA has a number of simple "rules" that define system behavior, like "If my 
* neighbors are both active, I am inactive" and the like. The rules are all 
* given numbers, but they're not sequential for historical reasons.
The subject rule for this challenge, Rule 90, is one of the simplest, a simple 
* neighbor XOR. That is, in a 1 dimensional CA system (e.g. a line), the next 
* state for the cell in the middle of 3 is simply the result of the XOR of its 
* left and right neighbors. E.g. "000" becomes "1" "0" in the next state, "100" 
* becomes "1" in the next state and so on. You traverse the given line in 
* windows of 3 cells and calculate the rule for the next iteration of the 
* following row's center cell based on the current one while the two outer cells 
* are influenced by their respective neighbors. Here are the rules showing the 
* conversion from one set of cells to another:
"111"	"101"	"010"	"000"	"110"	"100"	"011"	"001"
* 0	0	0	0	1	1	1	1
* 
* Input Description
* You'll be given an input line as a series of 0s and 1s. Example:
* 1101010
* Output Description
* 
* Your program should emit the states of the celular automata for 25 steps. 
* Example from above, in this case I replaced 0 with a blank and a 1 with an X:
* xx x x
* xx    x
* xxx  x
* x xxx x
* x x
* x   x

 * @author JasonRobinson
 */
public class Challenge213 {
    public static void main(String[] args) {
        int iterations = 25;
        if (args.length > 0) {
            for(String a : args) {

                File f = new File(a);

                if(f.exists()){
                    System.out.println("File exists: \"" + f.getPath().toString() + "\"");
//main body of program inside args loop
    try {

        ArrayList<ArrayList<Character>> input = getChallengeInput(f);

        //loop through each input line / aka individual Game of Life
        for (ArrayList<Character> game: input) {
            System.out.print("New Game Of Life: Starting With:\n\"");
            for(Character C : game){
                System.out.print(C);
            }System.out.println("\"\n\n");
                
            //plays the game for 25 generations
            playTheGameOfLife(game, 25);

        }//end looping on each line of input

    } catch (IOException e) {
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
        
    }//end main(String args[])


    public static ArrayList<ArrayList<Character>> getChallengeInput(File f) throws IOException{
        BufferedReader br = null;
        ArrayList<ArrayList<Character>> input = new ArrayList();
        String sCurrentLine;
        br = new BufferedReader(new FileReader(f));


        if ((sCurrentLine = br.readLine()) != null) {
            //we have a first line
            int numLines = Integer.parseInt(sCurrentLine);
            if (numLines > 0) {
                System.out.println("Number of Games Of Life To Play: " + numLines);
            
                //get the rest of the words
                int lineNumber = 0;
                while (lineNumber < numLines) {
                    if ((sCurrentLine = br.readLine()) != null) {
                        ArrayList<Character> charList = new ArrayList<Character>();

                        for (Character c : sCurrentLine.toCharArray()) {
                            charList.add(c);
                        }
                        input.add(charList);
                        lineNumber++;
                    } else {
                        //EOF before we expected.
                        System.out.println("ERROR: came to the end of the file before we expected at line#:" +lineNumber);
                        }
                    //
                    }//end while loop on counter < numHouses
                }//done with expected # of lines.
            }//end if first line of input file is null
        return input;
        }
 
    public static void playTheGameOfLife(ArrayList<Character> newGame, int iterations){
        //System.out.println("Inside \"playTheGameOfLife\". Playing the Game Of Life: " + newGame.toString());
        ArrayList<Character> iteration = new ArrayList<Character>();
        //put the current game into the new structure
        iteration.addAll(newGame);
        //System.out.println("Current Iteration: "+iteration.toString());

        printIteration(iteration,0);//the first time this is not changed
        //loop through till max iterations reached
        for(int i = 0; i<iterations;i++) {

            ArrayList<Character> thisLoop = new ArrayList<Character>();
            thisLoop = computeGeneration(iteration);
            printIteration(thisLoop, i);
            iteration.clear();iteration.addAll(thisLoop);
            thisLoop.clear();
        }
    }
    
    

    public static void printIteration(ArrayList<Character> iter, int iteration) {
        if (iteration < 10)
            System.out.print("Generation #0" + iteration + ": ");
        else
            System.out.print("Generation #" + iteration + ": ");
        for(Character c : iter) {
            if (c== '0')
                System.out.print(" ");
            else
                System.out.print("X");
        }
        System.out.println();
    }
        
        
    public static ArrayList<Character> computeGeneration(ArrayList<Character> input){
        int width = input.size();
        //store next generation of Game Of Life in output
        ArrayList<Character> output = new ArrayList<Character>(); 

        //sliding window for loop
        for(int i = 0; i< width ; i++){
            Character c = null;
            char[] window = new char[3];
            StringBuilder sb = new StringBuilder();
            if (width<3){ //width of game is too small
                System.exit(-1);
            } else {//start wide enough
                //are we at the edges? if so we need to pad either side of the window
                if((i<1) || (i> (width-2))) {
                    if(i==0) { //low edge case
                        c = calcWindow(sb.append("0").append(input.get(i)).append(input.get(i+1)).toString());
                    } else if (i> width-2) {//high edge case
                        c = calcWindow(sb.append(input.get(i-1)).append(input.get(i)).append("0").toString());
                    }//end edge cases

                //end of section where we need to pad the ends
                } else {//end where we are at the edges
                //normal comparisons here
                c = calcWindow(sb.append(input.get(i-1)).append(input.get(i)).append(input.get(i+1)).toString());
                }
            }//end wide enough
            output.add(c);
        }//end for loop
        return output;
    }//end method
        
    public static Character calcWindow(String window) {
        Character ret = null;
        switch(window) {
            case "111" : ret = '0';break;
            case "101" : ret = '0';break;
            case "010" : ret = '0';break;
            case "000" : ret = '0';break;
            case "110" : ret = '1';break;
            case "100" : ret = '1';break;
            case "011" : ret = '1';break;
            case "001" : ret = '1';break;
            default: ret = '0';break;

        }
        return ret;
    }
        
}
