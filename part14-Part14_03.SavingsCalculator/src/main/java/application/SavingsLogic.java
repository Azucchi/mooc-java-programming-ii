/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author reroy
 */
public class SavingsLogic {
    
    private int savingsPerMonth;
    private int years;
    private int totalSavings; 
    private int interest;

    public SavingsLogic(int savingsPerMonth) {
        this.savingsPerMonth = savingsPerMonth;
        this.interest = 0;
    }

    public int getSavingsPerMonth() {
        return savingsPerMonth;
    }

    public void setSavingsPerMonth(int savingsPerMonth) {
        this.savingsPerMonth = savingsPerMonth;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getTotalSavings(int years) {
        return this.savingsPerMonth * 12 * years;
    }
    
    public double savingsWithInterest(int years){
        double returned = 0.0;
        if(years == 0){
                return returned;
        }
        for(int i = 0; i < years; i++){
            returned += this.savingsPerMonth * 12;
            returned *= (1.000 + (this.interest * 1.000 / 100.000));
        }
        System.out.println(returned);
        return returned;
    }
    
    public void setInterest(int interest){
        this.interest = interest;
    }
    
    public int getInterest(){
        return this.interest;
    }
    
    
    
}
