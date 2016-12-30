/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge293.easy;

/**
 *
 * @author jason.robinson
 */
public class TheBomb {
    private boolean hasWhite;
    private boolean hasBlack;
    private boolean hasPurple;
    private boolean hasRed;
    private boolean hasGreen;
    private boolean hasOrange;

    private boolean whiteIsCut;
    private boolean blackIsCut;
    private boolean purpleIsCut;
    private boolean redIsCut;
    private boolean greenIsCut;
    private boolean orangeIsCut;
    
    private boolean rule1Triggered;
    private boolean rule2Triggered;
    private boolean rule3Triggered;
    private boolean rule4Triggered;
    private boolean rule5Triggered;
    private boolean rule6triggered;
    
    

    public void TheBomb(){
        this.hasWhite = true;
        this.hasBlack = true;
        this.hasPurple = true;
        this.hasRed = true;
        this.hasGreen = true;
        this.hasOrange = true;
        
        this.whiteIsCut = false;
        this.blackIsCut = false;
        this.purpleIsCut = false;
        this.redIsCut = false;
        this.greenIsCut = false;
        this.orangeIsCut = false;
        
    }

    public TheBomb(boolean hasWhite, boolean hasBlack, boolean hasPurple, boolean hasRed, boolean hasGreen, boolean hasOrange) {
        this.hasWhite = hasWhite;
        this.hasBlack = hasBlack;
        this.hasPurple = hasPurple;
        this.hasRed = hasRed;
        this.hasGreen = hasGreen;
        this.hasOrange = hasOrange;
        
        this.whiteIsCut = false;
        this.blackIsCut = false;
        this.purpleIsCut = false;
        this.redIsCut = false;
        this.greenIsCut = false;
        this.orangeIsCut = false;

    }
    

    
    
    public boolean hasWhite() {
        return hasWhite;
    }

    public void setHasWhite(boolean hasWhite) {
        this.hasWhite = hasWhite;
    }

    public boolean hasBlack() {
        return hasBlack;
    }

    public void setHasBlack(boolean hasBlack) {
        this.hasBlack = hasBlack;
    }

    public boolean hasPurple() {
        return hasPurple;
    }

    public void setHasPurple(boolean hasPurple) {
        this.hasPurple = hasPurple;
    }

    public boolean hasRed() {
        return hasRed;
    }

    public void setHasRed(boolean hasRed) {
        this.hasRed = hasRed;
    }

    public boolean hasGreen() {
        return hasGreen;
    }

    public void setHasGreen(boolean hasGreen) {
        this.hasGreen = hasGreen;
    }

    public boolean hsOrange() {
        return hasOrange;
    }

    public void setHasOrange(boolean hasorange) {
        this.hasOrange = hasorange;
    }

    public boolean isWhiteCut() {
        return whiteIsCut;
    }

    public void setWhiteIsCut(boolean whiteIsCut) {
        this.whiteIsCut = whiteIsCut;
    }

    public boolean isBlackCut() {
        return blackIsCut;
    }

    public void setBlackIsCut(boolean blackIsCut) {
        this.blackIsCut = blackIsCut;
    }

    public boolean isPurpleCut() {
        return purpleIsCut;
    }

    public void setPurpleIsCut(boolean purpleIsCut) {
        this.purpleIsCut = purpleIsCut;
    }

    public boolean isRedCut() {
        return redIsCut;
    }

    public void setRedIsCut(boolean redIsCut) {
        this.redIsCut = redIsCut;
    }

    public boolean isGreenCut() {
        return greenIsCut;
    }

    public void setGreenIsCut(boolean greenIsCut) {
        this.greenIsCut = greenIsCut;
    }

    public boolean isOrangeCut() {
        return orangeIsCut;
    }

    public void setOrangeIsCut(boolean orangeIsCut) {
        this.orangeIsCut = orangeIsCut;
    }

    /**
     * If you cut a white cable you can't cut white or black cable.
     * @return 
     */
    public boolean isRule1Triggered() {
        return rule1Triggered;
    }

    public void setRule1Triggered(boolean rule1Triggered) {
        this.rule1Triggered = rule1Triggered;
    }

    /**
     * If you cut a red cable you have to cut a green one
     * @return 
     */
    public boolean isRule2Triggered() {
        return rule2Triggered;
    }

    public void setRule2Triggered(boolean rule2Triggered) {
        this.rule2Triggered = rule2Triggered;
    }

    /**
     * If you cut a black cable it is not allowed to cut a white, green or orange one
     * @return 
     */
    public boolean isRule3Triggered() {
        return rule3Triggered;
    }

    public void setRule3Triggered(boolean rule3Triggered) {
        this.rule3Triggered = rule3Triggered;
    }

    /**
     * If you cut a orange cable you should cut a red or black one
     * @return 
     */
    public boolean isRule4Triggered() {
        return rule4Triggered;
    }

    public void setRule4Triggered(boolean rule4Triggered) {
        this.rule4Triggered = rule4Triggered;
    }

    /**
     * If you cut a green one you have to cut a orange or white one
     * @return 
     */
    public boolean isRule5Triggered() {
        return rule5Triggered;
    }

    public void setRule5Triggered(boolean rule5Triggered) {
        this.rule5Triggered = rule5Triggered;
    }

    /**
     * If you cut a purple cable you can't cut a purple, green, orange or white cable
     * @return 
     */
    public boolean isRule6triggered() {
        return rule6triggered;
    }

    public void setRule6triggered(boolean rule6triggered) {
        this.rule6triggered = rule6triggered;
    }

    
    
    
    
}
