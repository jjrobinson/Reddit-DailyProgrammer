/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge302.easy;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class Element {
    private String name;
    private String symbol;
    private int number;
    private float weight;
    private float electroNegativitiy;
    
    public Element(){
        
    }
    
    public Element(String n, String sym, int num, Float w, Float elec){
        this.name = n;
        this.symbol = sym;
        this.number = num;
        this.weight = w;
        this.electroNegativitiy = elec;   
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getElectroNegativitiy() {
        return electroNegativitiy;
    }

    public void setElectroNegativitiy(Float electroNegativitiy) {
        this.electroNegativitiy = electroNegativitiy;
    }
    
    
}
