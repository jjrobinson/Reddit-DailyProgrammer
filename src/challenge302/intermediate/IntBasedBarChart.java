/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge302.intermediate;

import java.util.ArrayList;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class IntBasedBarChart {
    private int numDataPoints;
    private GraphBounds gBounds;
    private ArrayList<int[]> data;
    
    public IntBasedBarChart(){
        this.data = new ArrayList<int[]>();
        this.numDataPoints = 0;
        this.gBounds = new GraphBounds(0,0,0,0);
    }
    
    public IntBasedBarChart(String[] bounds){
        this.data = new ArrayList<int[]>();
        this.gBounds = new GraphBounds(bounds);
    }
    
    public IntBasedBarChart(String[] bounds, ArrayList<int[]> newData){
        this.data = newData;
        this.gBounds = new GraphBounds(bounds);
    }
    
    
    public GraphBounds getBounds(){
        return this.gBounds;
    }
    
    public void setBounds(GraphBounds GB){
        this.gBounds = GB;
    }
    
    public void setBounds(int mX, int MX, int mY, int MY){
        this.gBounds.setAll(mX, MX, mY, MY);
    }
    
    public int getMinX(){
        return gBounds.getMinX();
    }
    
    public int getMinY(){
        return gBounds.getMinY();
    }
    
    public int getMaxX(){
        return gBounds.getMaxX();
    }
    
    public int getMaxY(){
        return gBounds.getMaxY();
    }
    
    public ArrayList<int[]> getData(){
        return data;
    }

    /**
     * Data must be added in an assumed sequential order
     * @param d 
     */    
    public void addData(int[] d){
        if (d == null)
            System.out.println("ERROR: Tried to add null line.");
        else 
            data.add(d);
    }
    
    public void setData(ArrayList<int[]> d){
        this.data.addAll(d);
    }

}
