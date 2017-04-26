/**
 * 
 * [2016-11-07] Challenge #291 [Easy] Goldilocks' Bear Necessities
 * submitted 1 month ago by Blackshell2 0
 * Once upon a time, there lived an adventurous little girl called Goldilocks. 
 * She explored the world with abandon, having a lot of fun. During her latest 
 * foray into the woods, she found another bear home -- though this one is home
 * to many more bears. Having learned from her previous experiences, Goldilocks 
 * knows that trial and error is not an efficient way of finding the right chair
 * and porridge to help herself to.
 * The task falls to you: given descriptions of Goldilocks' needs and of the 
 * available porridge/chairs at the dinner table, tell Goldilocks which chair to
 * sit in so the chair does not break, and the porridge is at an edible 
 * temperature.
 * Formal Input
 * 
 * The input begins with a line specifying Goldilocks' weight (as an integer in 
 * arbitrary weight-units) and the maximum temperature of porridge she will 
 * tolerate (again as an arbitrary-unit integer). This line is then followed by 
 * some number of lines, specifying a chair's weight capacity, and the 
 * temperature of the porridge in front of it.
 * Sample input:
 * 100 80
 * 30 50
 * 130 75
 * 90 60
 * 150 85
 * 120 70
 * 200 200
 * 110 100
 * Interpreting this, Goldilocks has a weight of 100 and a maximum porridge 
 * temperature of 80. The first seat at the table has a chair with a capacity of
 * 30 and a portion of porridge with the temperature of 50. The second has a 
 * capacity of 130 and temperature of 60, etc.
 * Formal Output
 * 
 * The output must contain the numbers of the seats that Goldilocks can sit down
 * at and eat up. This number counts up from 1 as the first seat.
 * Sample output:
 * 2 5
 * Seats #2 and #5 have both good enough chairs to not collapse under 
 * Goldilocks, and porridge that is cool enough for her to eat.
 * Challenge Input
 * 
 * 100 120
 * 297 90
 * 66 110
 * 257 113
 * 276 191
 * 280 129
 * 219 163
 * 254 193
 * 86 153
 * 206 147
 * 71 137
 * 104 40
 * 238 127
 * 52 146
 * 129 197
 * 144 59
 * 157 124
 * 210 59
 * 11 54
 * 268 119
 * 261 121
 * 12 189
 * 186 108
 * 174 21
 * 77 18
 * 54 90
 * 174 52
 * 16 129
 * 59 181
 * 290 123
 * 248 132
 */
package challenge291;

import challenge251.easy.Nonogram;
import static challenge293.easy.DefusingTheBomb.printTotals;
import org.jjrobinson.util.fileio.ChallengeInput;
import java.util.ArrayList;

/**
 *
 * @author robinsj1
 */
public class BearNecessities {

    public static boolean debug = false;
    
    public static void main(String[] args){
        ChallengeInput in = new ChallengeInput();
        ArrayList<Integer> goodChairs = new ArrayList<Integer>();            
        ArrayList<String> input = in.getInputByLines(BearNecessities.class, "/data/challenge291easy.txt");

        if (input.size()> 1) {
            ArrayList<Chair> chairs = parseToChairs(input);
            Chair g = chairs.remove(0);
            int herWeight = g.getWeight();
            int herTemp = g.getTemp();
            int i = 0;
            for (Chair c : chairs){
                i++;
                if(canSitAndEat(g,c))
                    goodChairs.add(i);
                    
            }//end chairs loop
            StringBuilder sb = new StringBuilder();
            for (Integer I: goodChairs){
                sb.append(I+ " ");
            }
            System.out.println(sb.toString());
        }
        else {
            if(debug)System.out.println("ERROR: less than 2 lines of input.");
        }
        
        
    }//end main
    
    
    public static ArrayList<Chair> parseToChairs(ArrayList<String> in){
        ArrayList<Chair> allChairs = new ArrayList<Chair>();
        
        for(int i =0;i< in.size();i++){
            String s = in.get(i);
            if(debug)System.out.println("Line "+i+": "+ s);
            int seatNum = 0;
            String[] chair = s.split("\\s");
            if (chair.length != 2)
                if(debug)System.out.println("ERROR: input line not only 2 ints:"
                        +debugChair(chair));
            if(isNumeric(chair[0]) && isNumeric(chair[1])){
                Chair newSeat = new Chair(Integer.parseInt(chair[0]), 
                        Integer.parseInt(chair[1]));
                allChairs.add(newSeat);
            }
        }
        return allChairs;
    }
        
    
    public static boolean isNumeric(String str){  
        try  
        {  
            int i = Integer.parseInt(str);
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;
        }  
        return true;  
    }
    
    
    
    private static String debugChair(String[] s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length ; i++){
            sb.append(s[i]);
            if (i < (s.length - 1)) sb.append(" ");
        }
        return sb.toString();
    }

    public static boolean canSitAndEat(Chair g, Chair c){
        if (g.getWeight() <= c.getWeight() && 
                g.getTemp() >= c.getTemp())
            return true;
        else return false;
    }
    
}
