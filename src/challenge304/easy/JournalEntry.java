/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge304.easy;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class JournalEntry {
    private Integer account;
    private String date;
    private int debit;
    private int credit;
    
    public JournalEntry(Integer acct, String date, int debit, int credit){
        this.account = acct;
        this.date = date;
        this.debit = debit;
        this.credit = credit;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    

}
