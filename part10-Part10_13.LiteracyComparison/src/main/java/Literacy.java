/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reroy
 */
public class Literacy implements Comparable<Literacy>{
    
    private String country;
    private String year;
    private String gender;
    private double literacy;

    public Literacy(String country, String year, String gender, double literacy) {
        this.country = country;
        this.year = year;
        String[] genderData = gender.split(" ");
        this.gender = genderData[1];
        this.literacy = literacy;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getLiteracy() {
        return literacy;
    }

    public void setLiteracy(double literacy) {
        this.literacy = literacy;
    }
    
    @Override
    public String toString(){
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacy;
    }
    
    @Override
    public int compareTo(Literacy country){
        return (int) (this.getLiteracy() - country.getLiteracy());
    }
    
}
