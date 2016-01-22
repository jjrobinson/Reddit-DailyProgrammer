/*
 * 
 */
package challenge245.easy;

import java.util.Calendar;

/**
 *
 * @author JasonRobinson
 */
public class RelativeDate {
    private int days;
    private int weeks;
    private int months;
    private int years;
    private Calendar cal;

    public RelativeDate() {
        this.days = 0;
        this.weeks = 0;
        this.months = 0;
        this.years = 0;
    }

    public RelativeDate(int newDays, int newWeeks, int newMonths, int newYears) {
        this.days = newDays;
        this.weeks = newWeeks;
        this.months = newMonths;
        this.years = newYears;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Calendar getCal() {
        return cal;
    }

    public void setCal(Calendar cal) {
        this.cal = cal;
    }
    
    
}
