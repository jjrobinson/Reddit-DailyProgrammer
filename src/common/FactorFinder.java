/*
 * 
 */
package common;


import java.util.TreeSet;

/**
 *
 * @author JasonRobinson
 */
public class FactorFinder {
    private Long theNumber;
    private TreeSet<Long> factors;
    private boolean isPrime;

    public FactorFinder(){
        factors = new TreeSet<Long>();
    }
    
    public FactorFinder(Long num){
        this.theNumber = num;
        factors = new TreeSet<Long>();
        findTheFactors(num);
    }
    
    public TreeSet<Long> findTheFactors(Long n){
        factors.clear();
        factors.add(n);
        factors.add(1L);
        for(long test = n - 1; test >= Math.sqrt(n); test--)
            if(n % test == 0)
            {
                factors.add(test);
                factors.add(n / test);
            }
        return factors;
    }
    


    public Long getTheNumber() {
        return theNumber;
    }

    public void setTheNumber(Long theNumber) {
        this.theNumber = theNumber;
    }

    public boolean isIsPrime() {
        return isPrime;
    }

    
}
