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
import java.util.Random;

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
    ArrayList<BagOfWords> families = new ArrayList<BagOfWords>();
    HashMap map = new HashMap();
    
    public static void main(String[] args){
        ChallengeInput in = new ChallengeInput();
        ArrayList<String> input = in.getInputByLines(SecretSanta.class, "/data/challenge247easy.txt");
        ArrayList<BagOfWords> families = new ArrayList<BagOfWords>();
        HashMap map = new HashMap();
        
        
        for(String s : input){
            List<String> words = Arrays.asList(s.split(" "));
            BagOfWords bag = new BagOfWords();
            bag.setBag(words);
            families.add(bag);
        }

        
        for(BagOfWords b: families){
            List<String> peeps = b.getBag();
            System.out.print("Family:");
            Iterator i = peeps.iterator();
            while(i.hasNext()){
                System.out.print(" \"" + i.next() + "\"");
                if(i.hasNext())
                    System.out.print(",");
            }
            System.out.println();
        }
        
        assign(families, map);
        
    }//end main(String[] args)
    
    private static void assign(ArrayList<BagOfWords> families, HashMap map){
        ArrayList<BagOfWords> recipients = new ArrayList<BagOfWords>();
        //clone our families to a recipients list
        for(BagOfWords bow : families)
            recipients.add(bow.clone());

        Random r = new Random(System.currentTimeMillis());
        for (int f = 0; f <= families.size()-1;f++){
            int index = 0;
            while(r.nextInt(families.size()-1) != f){
                r.nextInt(families.size()-1);
            }
            BagOfWords family = families.get(index);
            
            if(family.getSizeOfBag() > 0){
                String giver = null;
                String recipient = null;
                for(int p =0; p<=family.getSizeOfBag()-1;p++){
                    giver = family.getWordAtIndex(p);
                    
                    recipient = getRecipientForGiver(recipients, f);

                }
                    
            }
                

        }
    }
    
    
    private static String getRecipientForGiver(ArrayList<BagOfWords> recipients, int ownFamily){
        Random r = new Random(System.currentTimeMillis());
        int f = r.nextInt(recipients.size()-1);
        boolean foundRecipient = false;
        //choose a family
        while(f != ownFamily && !foundRecipient ){
            if(f == ownFamily && !foundRecipient){
                f = r.nextInt(recipients.size()-1);
                break;//exit this family and move to next
            } else {//different family or already found a recipient
                BagOfWords family = recipients.get(f);
                List<Integer> uses = family.getUseCounts();
                int p = r.nextInt(family.getSizeOfBag()-1);
                //choose random person
            
                
            }
        }
        return "";
    }
}
