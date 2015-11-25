/*
 * 
 */
package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author JasonRobinson
 */
public class BagOfLetters implements BagOf {
    private ArrayList<Character> theBag;
    private ArrayList<Integer> uses;
    private boolean allowRepeats;
    private boolean allowNonAlphaNumeric;
    private boolean allowNumbers;

    
    public void BagOfLetters(){
        theBag = new ArrayList<Character>();
        uses = new ArrayList<Integer>();
        allowRepeats = false;
    }
    
    /**
     * Parses a string in to characters, including any punctuation or spaces
     * Allows repeats.
     * @param s 
     */
    public void BagOfLetters(String s){
        allowRepeats = true;
        theBag = new ArrayList<Character>();
        uses = new ArrayList<Integer>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            theBag.add(chars[i]);
        }
    }
    

    /**
     * Parses a string s in to characters, along with boolean flags for if
     * repeated characters should be allowed, if numbers should be allowed
     * and if punctuation (including spaces) should be allowed.
     * should be allowed.
     * @param s
     * @param repeats
     * @param nonAlpha 
     */
    public void BagOfLetters(String s, boolean repeats
            , boolean allowPunct, boolean allowNumbers){
        this.allowRepeats = repeats;
        this.allowNumbers = allowNumbers;
        this.allowNonAlphaNumeric = allowPunct;
        theBag = new ArrayList<Character>();
        resetTheBagFromString(s);
    }
    
       
    /**
     * Returns theBag of Characters
     * @return 
     */
    public List getBag(){
        return this.theBag;
    }
    
    
    /**
     * Sets theBag to the provided list of Characters.
     * @param l 
     */
    public void setBag(List l){
        this.theBag.clear();
        this.uses.clear();
        this.theBag.addAll(l);
        for(int i = 0; i<this.theBag.size();i++)
            this.uses.add(0);
    }
    
    
    /**
     * Removes the item at the given index, if the index exists.  Otherwise
     * returns null.  Removes the use count for that index in the uses list.
     * @param index
     * @return 
     */
    public Object removeItem(int index){
        if(this.theBag.size()< index){
            this.uses.remove(index);
            return theBag.remove(index);
        }
        return null;
    }
    
    
    /**
     * Returns a list containing the number of uses of each item.
     * @return 
     */
    public List getUseCounts(){
        return this.uses;
    }
    
    
    /**
     * If an index exists, returns the number of uses +1 for that index.
     * If no item exists at that index or if the bag is smaller than that index
     * then returns -1.
     * @param index
     * @return 
     */
    public int useItem(int index){
        if(this.theBag.size()<index)
            return -1;
        else if (this.theBag.get(index) == null )
            return -1;
        else
            this.uses.set(index, this.uses.get(index)+1);
        return this.uses.get(index);
    }
    
    
    /**
     * Adds an item to the end of the list and returns the position of the item,
     * which is also the size -1. Does not pay attention to what kind of item 
     * has been added or if repeats are allowed.
     * @param c
     * @return index int also size -1
     */
    public int addItem(Object c){
        this.theBag.add((Character)c);
        this.uses.add(0);//adding a zero use for the new item.
        return (this.theBag.size()-1);
    }
    
    
    /**
     * Attempts to add an item to a list at a specific index.  If the list
     * isn't long enough to add at that position, then returns false.
     * @param c
     * @param index
     * @return 
     */
    public boolean addItem(Object c, int index){
        if(this.theBag.size()<index)
            return false;
        else {
            this.theBag.add(index, (Character)c);
            this.uses.add(index, 0);
        }
        return true;
    }
    
    
    /**
     * Adds an item to the end of the list.
     * @param c 
     */
    public void addItemToEnd(Object c){
        this.theBag.add((Character)c);
        this.uses.add(0);
    }
    
    
    /**
     * Returns the item at the bottom of the list. Removes that items use count.
     * @return 
     */
    public Object removeLastItem(){
        if(this.theBag.size() < 1)
            return null;
        else {
            this.uses.remove(this.uses.size()-1);
            return this.theBag.remove(this.theBag.size()-1);
        }
    }
    
    
    /**
     * Returns the item at the top of the list
     * @return 
     */
    public Object removeFirstItem(){
        if(this.theBag.size() < 1)
            return null;
        else {
            this.uses.remove(0);
            return this.theBag.remove(0);
        }
    }
    
    /**
     * TODO: not implemented yet.
     */
    public void randomizeTheBag(){
        
        
    }
    
    public boolean isInTheBag(Object o){
        for (Character c: this.theBag){
            if(c.compareTo((Character)o)==0)
                return true;
        }
        return false;
    }
    
    
    /**
     * Private method to test if a character is found in the bag
     * @param testChar char
     * @return boolean
     */
    private boolean isInTheBagOfLetters(char testChar){
        for(Character c: this.theBag){
            if(c.compareTo(testChar)==0)
                return true;
        }
        return false;
    }

    public boolean areRepeatsAllowed() {
        return allowRepeats;
    }

    public void setRepeatsAllowed(boolean repeatsAllowed) {
        this.allowRepeats = repeatsAllowed;
    }

    public boolean areNumbersAllowed() {
        return this.allowNumbers;
    }

    public void setNumbersAllowed(boolean numbersAllowed) {
        this.allowNonAlphaNumeric = numbersAllowed;
    }
    
    public void setNonAlphaNumericsAllowed(boolean nonAlphaAllowed){
        this.allowNonAlphaNumeric = nonAlphaAllowed;
    }
    
    public boolean areNonAlphaNumericsAllowed(){
        return this.allowNonAlphaNumeric;
    }
    
    
    /**
     * Private method to set the contents of theBag and uses to a new
     * set of letters.
     * @param s String
     */
    private void resetTheBagFromString(String s){
        char[] chars = s.toCharArray();
        for(int i = 0; i<chars.length;i++){
            Character c = (Character)chars[i];
            if(isInTheBagOfLetters(c)){
                //found a repeated character
                if(this.allowRepeats)
                    addLogic(c);
                else
                    break;//break out of this char's loop
            } else { // not a repeated character
                addLogic(c);
            }
        }
    }
    
    
    private void addLogic(char c){
        //is letter?
            //no... 
            //is Number?
                if(this.allowNumbers)
                //no... allow NonAlphaNumerics?
                    if(this.allowNonAlphaNumeric){
                        //yes... 
                        this.addItem((Object)c);
                    } else { //no
                    
                        return;
                    }
                    
                        
    }
                    
}
