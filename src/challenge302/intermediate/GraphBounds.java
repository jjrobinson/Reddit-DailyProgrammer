/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge302.intermediate;

import java.util.Arrays;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class GraphBounds {
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    
    public GraphBounds(){
        this.minX = 0;
        this.maxX = 0;
        this.minY = 0;
        this.maxY = 0;        
    }
    
    public GraphBounds(int mX, int MX, int mY, int MY){
        this.minX = mX;
        this.maxX = MX;
        this.minY = mY;
        this.maxY = MY;        
    }

    public GraphBounds(String[] bounds){
        setAllFromStrings(bounds);
    }
    
    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
    
    /**
     * sets the bounds of the graph, returning true only if minX is less than maxX and if minY is less than maxY.  
     * @param mX int
     * @param MX int
     * @param mY int
     * @param MY int
     * @return 
     */
    public boolean setAll(int mX, int MX, int mY, int MY){
        this.minX = mX;
        this.maxX = MX;
        this.minY = mY;
        this.maxY = MY;
        if(mX<MX && mY < MY)
            return true;
        else 
            return false;
    }
    
    /**
     * Sets the bounds of a graph, returning true if minX is less than maxX and if minY is less than maxY.  The array input must have 4 int elements in this order: minX, maxX, minY, maxY
     * @param bounds int[]
     * @return pass boolean
     */
    public boolean setAll(int[] bounds){
        if(bounds.length == 4){
            this.minX = bounds[0];
            this.maxX = bounds[1];
            this.minY = bounds[2];
            this.maxY = bounds[3];
        } else {
            System.out.println("ERROR: provided array does not contain 4 entries: "+Arrays.toString(bounds));
            return false;
        }
        if(minX<maxX && minY < maxY)
            return true;
        else
            return false;
    }
    
    /**
     * parse a String[] into the individual int bounds, returning true if minX is less than maxX and if minY is less than maxY. The array input must have 4 String elements in this order: minX, maxX, minY, maxY
     * @param bounds
     * @return 
     */
    public boolean setAllFromStrings(String[] bounds) {
        int[] asInts = new int[bounds.length];
        try{
            for (int i = 0 ; i<bounds.length;i++){
                asInts[i]= Integer.parseInt(bounds[i]);
            }//finsihed parsing
            minX=asInts[0];
            maxX=asInts[1];
            minY=asInts[2];
            maxY=asInts[3];
        } catch (NumberFormatException e){
            System.out.println("ERROR: parsing String[] to int[]:"+Arrays.toString(bounds));
            System.out.println("NumberFormatException: "+e);
            return false;
        }
        return true;
    }
}
