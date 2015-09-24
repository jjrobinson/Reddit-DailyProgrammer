/*
 * 
 */
package com.boiseitoncall.redditDailyProgrammer.common;

import java.util.ArrayList;

/**
 *
 * @author JasonRobinson
 */
public interface ConwayGameOfLifeInterface {
    public boolean setGrid(ArrayList<ArrayList<Character>> newGrid);
    public ArrayList<ArrayList<Character>> getGrid();
    public ArrayList<ArrayList<Character>> playAGeneration();
    public ArrayList<ArrayList<Character>> playSeveralGenerations(int numGenerations);
    
}
