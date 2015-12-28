/*
 * 
 */
package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author JasonRobinson
 */
public class BagOfWords implements BagOf {
    private ArrayList<String> theBag = new ArrayList<String>();
    private ArrayList<Integer> uses = new ArrayList<Integer>();
    private boolean allowRepeats;

        
    public void BagOfWords(){
        this.theBag = new ArrayList<String>();
        this.uses = new ArrayList<Integer>();
        this.allowRepeats = false;
    }
  
    public void BagOfLetters(String line){
        allowRepeats = true;
        theBag = new ArrayList<String>();
        uses = new ArrayList<Integer>();
        theBag.addAll(Arrays.asList(line.split(" ")));
        for(int i=0;i<theBag.size();i++){
            uses.add(0);
        }
    }
    
    public List getBag(){
        return this.theBag;
    }
    
    public void setBag(List l){
        this.theBag.clear();
        this.uses.clear();
        this.theBag.addAll(l);
        for(int i = 0; i<this.theBag.size();i++)
            this.uses.add(0);
    }
    
    public String removeItem(int index){
        if(this.theBag.size()< index){
            this.uses.remove(index);
            return theBag.remove(index);
        }
        return null;
    }
    
    
    public List getUseCounts(){
        return this.uses;
    }
        
    
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
     * @param s
     * @return index int also size -1
     */
    public int addItem(Object s){
        this.theBag.add((String)s);
        this.uses.add(0);//adding a zero use for the new item.
        return (this.theBag.size()-1);
    }
      
    
    /**
     * Attempts to add an item to a list at a specific index.  If the list
     * isn't long enough to add at that position, then returns false.
     * @param s
     * @param index
     * @return 
     */
    public boolean addItem(Object s, int index){
        if(this.theBag.size()<index)
            return false;
        else {
            this.theBag.add(index, (String)s);
            this.uses.add(index, 0);
        }
        return true;
    }
        
       
    /**
     * Adds an item to the end of the list.
     * @param c 
     */
    public void addItemToEnd(Object c){
        this.theBag.add((String)c);
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
        for (String s: this.theBag){
            if(s.equalsIgnoreCase((String)o))
                return true;
        }
        return false;
    }
        
    
    /**
     * Removes a random Character from the bag. Also removes the uses reference
     * for that character. if the bag is empty returns null;
     * @return c Character
     */
    public String removeRandomWord(){
        if (this.theBag.size() == 1){
            this.uses.remove(0);
            return this.theBag.remove(0);
        } else if(this.theBag.size()>2) {
            Random r = new Random(System.currentTimeMillis());
            int index = r.nextInt(this.theBag.size()-1);
            this.uses.remove(index);
            return theBag.remove(index);
        } else { //empty bag
            return null;
        }
    }
    
        
    
    /**
     * Removes a random Character from the bag. Also removes the uses reference
     * for that character. if the bag is empty returns null;
     * @return c Character
     */
    public String useRandomWord(){
        if (this.theBag.size() == 1){
            this.uses.remove(0);
            return this.theBag.remove(0);
        } else if(this.theBag.size()>1) {
            Random r = new Random(System.currentTimeMillis());
            int index = r.nextInt(this.theBag.size()-1);
            this.uses.remove(index);
            return theBag.remove(index);
        } else { //empty bag
            return null;
        }
    }
    
    /**
     * Private method to test if a character is found in the bag
     * @param testWord String
     * @return boolean
     */
    private boolean isInTheBagOfLetters(String testWord){
        for(String s: this.theBag){
            if(s.equalsIgnoreCase(testWord))
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

    public int getSizeOfBag(){
        return this.theBag.size();
    }
    
    public int getUsesOfItem(int i){
        if (this.uses.size()-1 >= i)
            return this.uses.get(i);
        else return -1;
    }
    
    
    public void setUsesOfItem(int index, int value){
        this.uses.set(index, value);
    }
    
    
    public String getWordAtIndex(int index){
        return this.theBag.get(index);
    }
    
    @Override
    public BagOfWords clone(){
        BagOfWords copy = new BagOfWords();
        ArrayList<String> words = new ArrayList<String>();
        for(String s : this.theBag){
            words.add(s);
        }
        copy.setBag(words);

        for(int i=0;i<uses.size()-1;i++){
            copy.setUsesOfItem(i, this.getUsesOfItem(i));
        }
        return copy;
    }
    
}
