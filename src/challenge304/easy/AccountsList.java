/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge304.easy;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class AccountsList {
    private int size;    
    
    private TreeMap<Integer,String> accounts;
    
    
    public AccountsList(){
        accounts = new TreeMap<Integer,String>();
    }
    
    public void addAccount(Integer acctNum, String name){
        accounts.put(acctNum, name);
        this.size++;
    }
    
    public String getEntry(Integer key){
        if(hasEntry(key)){
            return this.accounts.get(key);
        } else
            return null;
    }
    
    public boolean hasEntry(Integer key){
        if(this.accounts.containsKey(key))
            return true;
        else return false;
    }
    
    public Set<Entry<Integer, String>> getAccounts(){
        return this.accounts.entrySet();
    }
    
    public Entry<Integer, String> getLowestAccount(){
        Entry<Integer,String> lowest = this.accounts.ceilingEntry(0);
        return lowest;
    }
    
    public Entry<Integer, String> getHighestAccount(){
        Entry<Integer,String> highest = this.accounts.lastEntry();
        return highest;
    }

}
