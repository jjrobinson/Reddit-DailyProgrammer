/*
 * 
 */
package common;


import java.util.ArrayList;

/**
 *
 * @author JasonRobinson
 */
public class FactorFinder {
    private Long theNumber;
    private ArrayList<Long> factors;
    private boolean isPrime;
    private boolean addSelf;

    public FactorFinder(){
        factors = new ArrayList<Long>();
        addSelf = true;
    }
    
    public FactorFinder(Long num){
        this.theNumber = num;
        factors = new ArrayList<Long>();
        findTheFactors(num);
    }
    
    public ArrayList<Long> findTheFactors(Long n){
        factors.clear();
        if(addSelf) factors.add(n);
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

    public boolean allowAddSelf() {
        return addSelf;
    }

    public void setAddSelf(boolean addSelf) {
        this.addSelf = addSelf;
    }

    
    
}
