/*
 * 
 */
package common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JasonRobinson
 */
public class BagOfLetters implements BagOf {
    private ArrayList<Character> theBag;
    private ArrayList<Integer> uses;
    private boolean onlyUniqueEntries;
    
    
    public void BagOfLetters(){
        theBag = new ArrayList<Character>();
        uses = new ArrayList<Integer>();
    }
    
    
    
    public ArrayList getBag(){
        return this.theBag;
    }
    
    
    public void setBag(List l){
        theBag.clear();
        theBag.addAll(l);
    }
    
    
    public Object removeItem(int index){
        if(this.theBag.size()< index)
            return theBag.remove(index);
        return null;
    }
    
    
    public List getUseCounts(){
        return this.uses;
    }
    
    
    public int useItem(int index){
        if(this.theBag.size()<index)
            return -1;
        else
            this.uses.set(index, this.uses.get(index)+1);
        return this.uses.get(index);
    }
    
    
    public boolean addItem(Object c){
        this.theBag.add((Character)c);
        return true;
    }
    
    
    public boolean addItem(Object c, int index){
        if(this.theBag.size()<index)
            return false;
        else
            this.theBag.add(index, (Character)c);
        return true;
    }
    
    
    public boolean addItemToEnd(Object c){
        this.theBag.add((Character)c);
        return true;
    }
    
    
    public Object removeLastItem(){
        if(this.theBag.size() < 1)
            return null;
        else
            return this.theBag.remove(this.theBag.size()-1);
    }
    
    
    public Object removeFirstItem(){
        if(this.theBag.size() < 1)
            return null;
        else
            return this.theBag.remove(0);
    }
    
    public void randomizeTheBag(){
        
    }
    
}
