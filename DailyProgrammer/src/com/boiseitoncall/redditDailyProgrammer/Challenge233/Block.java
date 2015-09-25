/*
 * 
 */
package com.boiseitoncall.redditDailyProgrammer.Challenge233;

import java.util.Random;

/**
 *
 * @author JasonRobinson
 */
public class Block {
    private boolean hasBlockOnTop;
    private boolean hasBlockOnRight;
    private boolean hasBlockOnBottom;
    private boolean hasBlockOnLeft;
    private boolean hasWindow;
    private boolean hasDoor;
    private Random r;

       
    public void Block(){
        this.hasBlockOnTop = false;
        this.hasBlockOnLeft = false;
        this.hasBlockOnRight = false;
        this.hasBlockOnBottom = false;
        this.hasWindow = false;
        this.hasDoor = false;
    }

    public void Block(boolean hasTop, boolean hasRight, boolean hasBottom, 
            boolean hasLeft, boolean hasDoor){
        if(!hasDoor){
            this.hasWindow = r.nextBoolean();
        }
    }
    
    
    
    public boolean isHasBlockOnTop() {
        return hasBlockOnTop;
    }

    public void setHasBlockOnTop(boolean hasBlockOnTop) {
        this.hasBlockOnTop = hasBlockOnTop;
    }

    public boolean isHasBlockOnLeft() {
        return hasBlockOnLeft;
    }

    public void setHasBlockOnLeft(boolean hasBlockOnLeft) {
        this.hasBlockOnLeft = hasBlockOnLeft;
    }

    public boolean isHasBlockOnRight() {
        return hasBlockOnRight;
    }

    public void setHasBlockOnRight(boolean hasBlockOnRight) {
        this.hasBlockOnRight = hasBlockOnRight;
    }

    public boolean isHasBlockOnBottom() {
        return hasBlockOnBottom;
    }

    public void setHasBlockOnBottom(boolean hasBlockOnBottom) {
        this.hasBlockOnBottom = hasBlockOnBottom;
    }

    public boolean isHasWindow() {
        return hasWindow;
    }

    public void setHasWindow(boolean hasWindow) {
        this.hasWindow = hasWindow;
    }

    public boolean isHasDoor() {
        return hasDoor;
    }

    public void setHasDoor(boolean hasDoor) {
        this.hasDoor = hasDoor;
    }
    
}
