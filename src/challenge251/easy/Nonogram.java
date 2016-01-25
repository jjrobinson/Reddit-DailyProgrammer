/*
 * 
 */
package challenge251.easy;

import java.util.ArrayList;

/**
 *
 * @author JasonRobinson
 */
public class Nonogram {
    private int size;
    private ArrayList<String> puzzle;
    
    public Nonogram(){
        this.puzzle = new ArrayList<String>();
        this.size= 0;
    }
    
    public Nonogram(ArrayList<String> p){
        this.puzzle = p;
        this.size = this.puzzle.size();
    }

    public int getSize() {
        return size;
    }

    public ArrayList<String> getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(ArrayList<String> puzzle) {
        this.puzzle = puzzle;
        this.size = this.puzzle.size();
    }
    
    public void addLine(String s){
        this.puzzle.add(s);
        this.size = this.puzzle.size();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append((this.size+1)/5).append("\n");
        for(String s: this.puzzle)
            sb.append(s).append("\n");
        return sb.toString();
    }
    
    /**
     * Returns the count of entries in the row x
     * @param x
     * @return 
     */
    public int countInRow(int x){
        int count = 0;
        if(x < this.puzzle.size()){
            char[] charRow = this.puzzle.get(x).toCharArray();
            //increment across colums (y)
            for(int y=0;y<charRow.length;y++){
                char c = charRow[y];
                if(!Character.isSpaceChar(c))
                    count++;
            }
        }
        return count;
    }
    
    /**
     * Returns the count of entries in column Y
     * @param y
     * @return 
     */
    public int countInColumnY(int y){
        int count = 0;
        if(y < this.puzzle.size()){
            char[] column = new char[this.size];
            //iterate through rows to build the column
            for(int x=0;x<this.size;x++){
                column[x]=this.puzzle.get(x).charAt(y);
            }
            for(int i=0;i<column.length;i++){
                char c = column[i];
                if(!Character.isSpaceChar(c))
                    count++;
            }
        }
        return count;
    }
    
    public String getRow(int x){
        if(x < this.size){
            return this.puzzle.get(x);
        } else 
            return null;
    }
}
