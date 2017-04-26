/*
 * 
 */
package challenge243.easy;

import org.jjrobinson.util.FactorFinder;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 *  * Description
 * 
 * In number theory, a deficient or deficient number is a number n for which
 * the sum of divisors sigma(n)<2n, or, equivalently, the sum of proper
 * divisors (or aliquot sum) s(n)<n. The value 2n - sigma(n) (or n - s(n)) is
 * called the number's deficiency. In contrast, an abundant number or excessive
 * number is a number for which the sum of its proper divisors is greater than
 * the number itself
 * 
 * As an example, consider the number 21. Its divisors are 1, 3, 7 and 21, and
 * their sum is 32. Because 32 is less than 2 x 21, the number 21 is deficient.
 * 
 * Its deficiency is 2 x 21 - 32 = 10.
 * The integer 12 is the first abundant number. Its proper divisors are 1, 2,
 * 3, 4 and 6 for a total of 16. The amount by which the sum exceeds the number
 * is the abundance. The number 12 has an abundance of 4, for example. The
 * integer 12 is the first abundant number. Its divisors are 1, 2, 3, 4, 6, and
 * 12, and their sum is 28. Because 28 is greater than 2 x 12, the number 12 is
 * abundant. It's abundant by is 28 - 24 = 4. (Thanks /u/Rev0lt_ for the
 * correction.)
 * 
 * Input Description
 * You'll be given an integer, one per line. Example:
 * 18
 * 21
 * 9
 * 
 * Output Description
 * Your program should emit if the number if deficient, abundant (and its
 * abundance), or neither. 
 * 
 * Example:
 * 18 abundant by 3
 * 21 deficient
 * 9 deficient
 * 
 * Challenge Input
 * 111  
 * 112 
 * 220 
 * 69 
 * 134 
 * 85 
 * 
 * Challenge Output
 * 
 * 111 deficient 
 * 112 abundant by 24
 * 220 abundant by 64
 * 69 deficient
 * 134 deficient
 * 85 deficient
 * 
 * @author JasonRobinson
 */
public class AbundantNumbers {
    
    
    public static void main(String[] args){
        Integer[] input = {9,21,18,111, 112, 220, 69, 134, 85 };
        FactorFinder ff = new FactorFinder();
        
        for (int i = 0; i< input.length ; i++){
            ArrayList<Long> results = ff.findTheFactors((long)input[i]);
            Collections.sort(results);
            long sum = 0;
            for(Long l : results){
                sum += l;
            }
            
            boolean isDeficient = false;
            boolean isPerfect = false;
            long diff = 0;
            if((input[i]*2) < sum){
                diff = (sum - ((input[i])*2));
            } else if ((input[i]*2) > sum){
                isDeficient = true;
                diff = ((input[i]*2) - sum);
            } else if ((input[i]*2) == sum){
                isPerfect = true;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(input[i]).append(" is ");
            if (!isPerfect){
                if (isDeficient){
                    sb.append("Deficient by ").append(diff);
                }else //is Abundant
                    sb.append("Abundant by ").append(diff);
            } else {//is perfect!
                sb.append("Perfect!");
            }
            System.out.println(sb.toString());
        }
        
    }
    
}
