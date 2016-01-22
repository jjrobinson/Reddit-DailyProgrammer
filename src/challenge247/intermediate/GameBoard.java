/*
 * 
 */
package challenge247.intermediate;

import java.util.ArrayList;

/**
 *
 * @author JasonRobinson
 */
public class GameBoard {
    int hDimension;
    int vDimension;
    ArrayList<ArrayList<Character>> theBoard;

    public void GameBoard(){
        hDimension = 0;
        vDimension = 0;
        theBoard = new ArrayList<ArrayList<Character>>();
    }
    
    
    /**
     * Returns the horizontal dimension (x). ONE indexed
     * @return int 
     */
    public int gethDimension() {
        return hDimension;
    }

    /**
     * Returns the vertical dimension (Y). ONE indexed
     * @return int 
     */
    public int getvDimension() {
        return vDimension;
    }
    
    
//    public void setDimensions(int x, int y){
//        this.hDimension = x;
//        this.vDimension = y;
//        
//    }

    /**
     * Adds a new line from top to bottom on theBoard.  Increments vDimension 
     * and checks to see if this line is longer than the longest previous line.
     * @param line 
     */
    public void addNewLine(String line){
        ArrayList<Character> newLine = new ArrayList<Character>();
        CharSequence cs = line.subSequence(0, line.length());
        for(int i = 0; i < line.length();i++){
            Character c = new Character(cs.charAt(i));
            newLine.add(c);
        }
        theBoard.add(newLine);
        this.vDimension=this.vDimension+1;
        if(newLine.size() > hDimension)
            hDimension = newLine.size();
    }
    
    
    public Character getGameBoardAt(int x, int y){
        if(theBoard.size()==0)
            return null;
        if(y > theBoard.size()-1){
            return null;//empty board or coords beyond board
        }else if(x > theBoard.get(x).size()-1){
            return null;//empty board or coords beyond board
        } else {
            return theBoard.get(x).get(y);
        }
    }
    
    /**
     * Returns an entire line of the game board. 
     * @param y vDimension
     * @return 
     */
    public String getGameBoardLine(int y){
        StringBuilder sb = new StringBuilder();
        if(this.vDimension > y)
        for(int i =0;i< this.theBoard.get(y).size();i++){
        }
        return "";
    }
    
}
