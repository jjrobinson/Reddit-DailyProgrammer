/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge291;

/**
 *
 * @author robinsj1
 */
public class Chair {
    private int weight;
    private int temp;

    public int getWeight() {
        return weight;
    }

    public Chair(int w, int t){
        this.weight = w;
        this.temp = t;
    }
    
    public void setWeight(int seat) {
        this.weight = seat;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
    
    
}
