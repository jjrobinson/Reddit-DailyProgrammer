/*
 * 
 */
package challenge245Easy;

import common.ChallengeInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 
 * Yesterday, Devon the developer made an awesome webform, which the sales
 * team would use to record the results from today's big new marketing
 * campaign, but now he realised he forgot to add a validator to the
 * "delivery_date" field! He proceeds to open the generated spreadsheet but,
 * as he expected, the dates are all but normalized... Some of them use M D Y
 * and others Y M D, and even arbitrary separators are used! Can you help him
 * parse all the messy text into properly ISO 8601 (YYYY-MM-DD) formatted
 * dates before beer o'clock?
 * 
 * Assume only dates starting with 4 digits use Y M D, and others use M D Y.
 * 
 * Sample Input
 * 2/13/15
 * 1-31-10
 * 5 10 2015
 * 2012 3 17
 * 2001-01-01
 * 2008/01/07
 * 
 * Sample Output
 * 2015-02-13
 * 2010-01-31
 * 2015-05-10
 * 2012-03-17
 * 2001-01-01
 * 2008-01-07
 * 
 * Extension challenge [Intermediate]
 * Devon's nemesis, Sally, is by far the best salesperson in the team, but her
 * writing is also the most idiosyncratic! Can you parse all of her dates?
 * 
 * Guidelines:
 * Use 2014-12-24 as the base for relative dates.
 * When adding days, account for the different number of days in each month;
 * ignore leap years.
 * When adding months and years, use whole units, so that:
 * one month before october 10 is september 10
 * one year after 2001-04-02 is 2002-04-02
 * one month after january 30 is february 28 (not march 1)
 * 
 * Sally's inputs:
 * tomorrow
 * 2010-dec-7
 * OCT 23
 * 1 week ago
 * next Monday
 * last sunDAY
 * 1 year ago
 * 1 month ago
 * last week
 * LAST MONTH
 * 10 October 2010
 * an year ago
 * 2 years from tomoRRow
 * 1 month from 2016-01-31
 * 4 DAYS FROM today
 * 9 weeks from yesterday
 * 
 * Sally's expected outputs:
 * 2014-12-25
 * 2010-12-01
 * 2014-10-23
 * 2014-12-17
 * 2014-12-29
 * 2014-12-21
 * 2013-12-24
 * 2014-11-24
 * 2014-12-15
 * 2014-11-24
 * 2010-10-10
 * 2013-12-24
 * 2016-12-25
 * 2016-02-28
 * 2014-12-28
 * 2015-02-25
 * 
 * Notes and Further Reading
 * 
 * https://en.wikipedia.org/wiki/ISO_8601
 * http://php.net/manual/en/function.strtotime.php
 * https://xkcd.com/1179/
 * Moderator note: If you would like to solve the general case to absolutely
 * work on all possible input dates, check out this video first:
 * https://www.youtube.com/watch?v=-5wpm-gesOY
 * PS: Using <?php echo strftime('%Y-%m-%d', strtotime($s)); is cheating! :^)
 * @author JasonRobinson
 */
public class DateDilemma {
    public static ArrayList<String> input;
    public static ArrayList<String> output;
    public static String[] daysFull = {"Monday","Tuesday","Wednesday",
            "Thursday","Friday","Saturday","Sunday"};
    public static String[] monthsFull = {"January","February","March","April",
            "May","June","July","August","September","October","November",
            "December"};
    
    
    public static void main(String[] args){

        ChallengeInput in = new ChallengeInput();
        ArrayList<String> input = in.getInputByLines(
                DateDilemma.class,"/data/DateDilemmaInput.txt");
        ArrayList<String> output = new ArrayList<String>();
        
        for(String s : input)
            System.out.println(s);
        
        parseToStandardDate();
        
    }
    
    
    //helper methods
    
    
    public static void parseToStandardDate(){
        for (String s : input){
            //get rid of punctuation and replace with a space
            String[] words = s.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase().split("\\s+");

            
            if(containsNonNumerics(s)){
                convertSimpleDate(s);
            }else{
                convertWrittenDates(words);
            }
            
            
        }//end loop through all input lines
    }
    
    
    private static boolean containsNonNumerics(String s){
        boolean containsLetters = false;
        for (int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i)))
                containsLetters = true;
        }
        return containsLetters;
    }
    
    
    private static void convertSimpleDate(String s){
        int year = 0,month = 0,day = 0;
        String[] items = s.split(" ");
        List<String> itemList = new ArrayList<String>(Arrays.asList(items));
        int number = Integer.parseInt(itemList.get(0));
        if(number > 999){
            year = number;
        }

    }
    
    
    private static int findYear(String[] words){
        for(String s : words){
            if 
        }
        return 0;
    }
    
    
    private static void convertWrittenDates(String[] words){
        int year = 0,month = 0,day = 0;

    }
    
    

    
    
    
    
}
