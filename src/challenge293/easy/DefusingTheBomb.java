/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge293.easy;


import challenge251.easy.Nonogram;
import common.ChallengeInput;
import java.util.ArrayList;

/**
 *
 * Description
 *
 * To disarm the bomb you have to cut some wires. These wires are either white, 
 * black, purple, red, green or orange.
 *  The rules for disarming are simple:
 * If you cut a white cable you can't cut white or black cable.
 * If you cut a red cable you have to cut a green one
 * If you cut a black cable it is not allowed to cut a white, green or orange 
 * one
 * If you cut a orange cable you should cut a red or black one
 * If you cut a green one you have to cut a orange or white one
 * If you cut a purple cable you can't cut a purple, green, orange or white cable
 * If you have anything wrong, the bomb will explode.
 * Formal Inputs & Outputs
 * 
 * Input description
 * You will receive a sequence of wires that where cut in that order and you 
 * have to determine if the person was successful in disarming the bomb or that 
 * it blew up.
 * 
 * Input 1
 * white
 * red
 * green
 * white
 * 
 * Input 2
 * white
 * orange
 * green
 * white
 * 
 * 
 * Output description
 * Wheter or not the bomb exploded
 * 
 * Output 1
 * "Bomb defused"
 * Output 2
 * 
 * "Boom"
 * Notes/Hints
 * 
 * A state machine will help this make easy * @author jason.robinson
 */
public class DefusingTheBomb {
        public static boolean debug = true;
    
    public static void main(String[] args){
        ChallengeInput in = new ChallengeInput();
        ArrayList<String> input = in.getInputByLines(DefusingTheBomb.class, "/data/challenge293†easy.txt");
        
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
