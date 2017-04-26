/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge304.easy;

import java.io.Console;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.jjrobinson.util.fileio.ChallengeInput;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class AccountantsAssistant {
    public static void main(String[] args){
        String accountsFile="/data/challenge304_accounting_accounts.txt";
        String journalFile="/data/challenge304_accounting_journal.txt";
        
        ArrayList<String> accountsFileLines = new ChallengeInput()
                .getInputByLines(AccountantsAssistant.class, accountsFile);
        ArrayList<String> journalFileLines = new ChallengeInput()
                .getInputByLines(AccountantsAssistant.class, journalFile);
//take first line as the labels


        //throw away the first line in each because it is a headers
        accountsFileLines.remove(0);
        //throw away the first line in each because it is a headers
        journalFileLines.remove(0);
        
        AccountsList accts = parseAndStoreAccounts(accountsFileLines);
        ArrayList<JournalEntry> journal = parseAndStoreJournal(journalFileLines);
        
        printReadInData(accts, journal);
        
        
        Console console = System.console();
        if (console != null){
            System.out.println("Input command in the form: AAAA BBBB CCC-XX DDD-XX EEE");
            parseAndDoCmd(console.readLine(), accts, journal);
        }
    }//end main
    
    
    private static void parseAndDoCmd(String s, AccountsList accts, ArrayList<JournalEntry> journal){
//AAA is the starting account '*' means first account of source file
//BBB is the ending account, '*' means last account of source file
//CCC-YY is the first period, '*' means first period of source file
//DDD-YY is the last period, '*' means last period of source file
//EEE is output format (values can be TEXT or CSV).
        Map.Entry startAcct = null;
        Map.Entry endAcct = null;
        

        try{
            Integer lowKey = null;
            Integer highKey = null;
            
            String[] input = s.trim().split(" ");
            if (input.length <5){
                System.out.println("Incorrect number of input items."+s);
                System.exit(-1);
            }
            if(input[0].equalsIgnoreCase("*")){
                startAcct = accts.getLowestAccount();
                System.out.println("Using lowest account function:"+input[0]+"="+startAcct.getKey());
                lowKey = (Integer)startAcct.getKey();
            } else {
                lowKey = Integer.parseInt(input[0]);
                startAcct = new AbstractMap.SimpleEntry<Integer,String>(lowKey
                        ,accts.getEntry(lowKey));
            }
            System.out.println("Lowest Account# =\""+lowKey+"\"");
            
            if(input[1].equalsIgnoreCase("*")){
                endAcct = accts.getHighestAccount();
                System.out.println("Using highest account function:"+input[1]+"="+endAcct.getKey());
                highKey = (Integer)endAcct.getKey();
            } else {
                highKey = Integer.parseInt(input[0]);
                endAcct = new AbstractMap.SimpleEntry<Integer,String>(highKey
                        ,accts.getEntry(highKey));
            }
            System.out.println("Highest Account# =\""+highKey+"\"");
            
            
            
            
            
            
        } catch (Exception e){
            System.out.println("ERROR: unable to parse input into correctly formatted command:"+s);
        }
        
    }
    
    
    
    private static void printReadInData(AccountsList accts, ArrayList<JournalEntry> journal){
        for(Entry<Integer, String> e : accts.getAccounts()){
            System.out.println("Account: "+e.getKey()+"; Name: "+e.getValue());
        }
        
        for(JournalEntry je : journal){
            System.out.println("JournalEntry: "+je.getAccount()+";"+je.getDate()
                +";"+je.getDebit()+";"+je.getCredit());
        }
        
    }
    
    private static ArrayList<JournalEntry> parseAndStoreJournal(ArrayList<String> lines){
        ArrayList<JournalEntry> journal = new ArrayList<JournalEntry>();
        
        for(String s: lines){
            String[] data = s.trim().split(";");
            
            if(data.length != 4)
                System.out.println("ERROR: invalid # of entries on input line."+s);
            else {
                try{
                    JournalEntry je = new JournalEntry(
                            Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2])
                            ,Integer.parseInt(data[3]));
                    journal.add(je);
                } catch (Exception e){
                    System.out.println("Unable to parse to data: "+s);
                }
                
            }            
        }
        return journal;
    }
    
    private static AccountsList parseAndStoreAccounts(ArrayList<String> lines){
        AccountsList accts = new AccountsList();
        for(String s: lines){
            String[] data = s.trim().split(";");
//even though 3 ; are expected, if ; is the last 
//char, the split() will not create an empty string[] entry for it
            if(data.length != 2)
                System.out.println("Invalid account line: "+s);
            else{
                try{//try to parse
                    accts.addAccount(Integer.parseInt(data[0]),data[1]);   
                } catch(Exception e){
                    System.out.println("Unable to parse the line: "+s);
                }
            }//end parsing
        }//end for each line of input
        return accts;
    }

}
