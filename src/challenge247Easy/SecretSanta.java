/*
 * 
 */
package challenge247Easy;

import common.BagOfWords;
import common.ChallengeInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/**
 *
 * Description
 * 
 * Every December my friends do a "Secret Santa" - the traditional gift
 * exchange where everybody is randomly assigned to give a gift to a friend. To
 * make things exciting, the matching is all random (you cannot pick your gift
 * recipient) and nobody knows who got assigned to who until the day when the
 * gifts are exchanged - hence, the "secret" in the name.
 * 
 * Since we're a big group with many couples and families, often a husband gets
 * his wife as secret santa (or vice-versa), or a father is assigned to one of
 * his children. This creates a series of issues:
 * 
 * If you have a younger kid and he/she is assigned to you, you might end up
 * paying for your own gift and ruining the surprise.
 * When your significant other asks "who did you get for Secret Santa", you
 * have to lie, hide gifts, etc.
 * The inevitable "this game is rigged!" commentary on the day of revelation.
 * 
 * To fix this, you must design a program that randomly assigns the Secret
 * Santa gift exchange, but prevents people from the same family to be assigned
 * to each other.
 * Input
 * 
 * A list of all Secret Santa participants. People who belong to the same
 * family are listed in the same line separated by spaces. Thus, "Jeff Jerry"
 * represents two people, Jeff and Jerry, who are family and should not be
 * assigned to each other.
 * 
 * Joe
 * Jeff Jerry
 * Johnson
 * Output
 * 
 * The list of Secret Santa assignments. As Secret Santa is a random assignment,
 * output may vary.
 * 
 * Joe -> Jeff
 * Johnson -> Jerry
 * Jerry -> Joe
 * Jeff -> Johnson
 * But not Jeff -> Jerry or Jerry -> Jeff!
 * 
 * Challenge Input
 * 
 * Sean
 * Winnie
 * Brian Amy
 * Samir
 * Joe Bethany
 * Bruno Anna Matthew Lucas
 * Gabriel Martha Philip
 * Andre
 * Danielle
 * Leo Cinthia
 * Paula
 * Mary Jane
 * Anderson
 * Priscilla
 * Regis Julianna Arthur
 * Mark Marina
 * Alex Andrea
 * 
 * Bonus
 * 
 * The assignment list must avoid "closed loops" where smaller subgroups get
 * assigned to each other, breaking the overall loop.
 * Joe -> Jeff
 * Jeff -> Joe # Closed loop of 2
 * Jerry -> Johnson
 * Johnson -> Jerry # Closed loop of `
* @author JasonRobinson
 */
public class SecretSanta {
    public static ArrayList<BagOfWords> families = new ArrayList<BagOfWords>();
    
    public static HashMap matches = new HashMap();
    public static boolean debug = false;
    public static Random r = new Random();

    
    public static void main(String[] args){
        ChallengeInput in = new ChallengeInput();
        ArrayList<String> input = in.getInputByLines(SecretSanta.class, "/data/challenge247easy.txt");
        
        for(String s : input){//split the lines into words
            List<String> words = Arrays.asList(s.split(" "));
            BagOfWords bag = new BagOfWords();
            bag.setBag(words);
            SecretSanta.families.add(bag);
        }

        for(BagOfWords b: SecretSanta.families){
            List<String> peeps = b.getBag();
            if (SecretSanta.debug) System.out.print("Family:");
            List<String> family = b.getBag();
            BagOfWords newBag = new BagOfWords();
            newBag.setBag(family);
            
            for(int i=0;i<family.size();i++){//for each person in the family
                String person = family.get(i);
                if (SecretSanta.debug) System.out.print(" \"" + person + "\"");
                if(i>family.size()-1)
                    if (SecretSanta.debug) System.out.print(",");
            }
            if (SecretSanta.debug) System.out.println();
        }

        
        assignMatches();
        printMatches();
        
            
        
        
    }//end main(String[] args)
    
    
    
    private static void assignMatches(){
        ArrayList<List<String>> recipients = new ArrayList<List<String>>();
        //copy Families into recipients
        for(int i=0;i<SecretSanta.families.size();i++){
            List<String> fam1 = SecretSanta.families.get(i).getBag();
            recipients.addAll(Arrays.asList(fam1));
        }
        
        for(List<String> b : recipients){
            System.out.print("Family: ");
            for(int i = 0; i< b.size();i++){
                System.out.print(b.get(i));
                if (i < b.size()-1) System.out.print(", ");
            }
            System.out.println();
                
        }
        
        if (SecretSanta.debug) System.out.println("Assigning Matches...");

        for (int fam = 0; fam < SecretSanta.families.size();fam++){
            //loop for each family
            BagOfWords givingFamily = SecretSanta.families.get(fam);

            if (SecretSanta.debug) {
                StringBuilder sb  = new StringBuilder();
                sb.append("\tFinding matches for family #").append(fam).append(":");
                List<String> peeps = givingFamily.getBag();
                for(String s: peeps){
                    sb.append(s).append(",");
                }
                System.out.println(sb.toString());
                
            }
            
            if(givingFamily.getSizeOfBag() > 0){
                String giver = "";
                String recipient = "";
                
                for(int person =0; person<givingFamily.getSizeOfBag();person++){
                    //loop for each person in a family
                    giver = givingFamily.getWordAtIndex(person);
                    if (SecretSanta.debug) System.out.println("\t\tFinding match for " + giver);
                    
                    boolean foundRecipient = false;

                    //get random family index
                    int randFam = r.nextInt(recipients.size());


                    //choose a family
                    while(!foundRecipient){
                        while(fam == randFam){
                            if (SecretSanta.debug) System.out.println("\t\t\tYou choose the same family! Trying again...");
                            randFam = r.nextInt(recipients.size());
                        }
                        
                        List<String> recievingFamily = recipients.get(randFam);
                        int receivingFamilySize = recievingFamily.size();
                    
                        if (SecretSanta.debug) System.out.println("\t\t\tChoosing random family #" + randFam + " with " +receivingFamilySize+" people");
                        if(receivingFamilySize != 1){
                            int randPerson = (int)(System.currentTimeMillis()% receivingFamilySize);
                            if (SecretSanta.debug) System.out.println(""
                                    + "\t\t\t\tChoosing random person #"
                                    +randPerson + " "
                                    +recievingFamily.get(randPerson)
                                    +" of family of #" 
                                    + recievingFamily.size());
                            recipient = recievingFamily.remove(randPerson);//remove a person from the family
                            recipients.remove(randFam);//remove the family from the master recipients list
                            recipients.add(recievingFamily);//add them to the end to ensure same person isn't reused
                            foundRecipient = true;
                        } else {//1 person family
                            recipient = recievingFamily.get(0);
                            recipients.remove(randFam);//remove the family from the master recipients list
                            foundRecipient = true;
                        }
                        
                    }//end loop to find a family
                    SecretSanta.matches.put(giver, recipient);
                    if (SecretSanta.debug) System.out.println("\t\t" + giver + "->" + recipient +"\r\n");
                }
            }
        }
    }
    
    
    private static void printMatches(){
        System.out.println("\r\nMatches...");
        
        // Get a set of the entries
        Set<Entry<String, String>> setMap = SecretSanta.matches.entrySet();
        // Get an iterator
        Iterator<Entry<String,  String>> i = setMap.iterator();
        
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }

}
