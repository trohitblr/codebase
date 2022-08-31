package com.intute.profile.Model;

import lombok.Data;
import org.apache.commons.lang3.builder.Diffable;

import java.io.Serializable;
@Data
public class Address implements Serializable {

    private  String line1;
    private  String line2;
    private  String city;
    private  String state;
    private  String country;
    private  String zip;

    /*public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    private  String zip;

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }
*/
    @Override
    public String toString() {
        return "Address{" +
                "line1\":" + line1 + '\"' +
                ", line2\":" + line2 + '\"' +
                ", city\":" + city + '\"' +
                ", state\":" + state + '\"' +
                ", country\":" + country + '\"' +
                ", zip\":" + zip + '\"' +
                '}';


/*
                line1 + "," + "\n"+
                 line2 + "," + "\n"+
                 city + "," + "\n"+
                 state + "," + "\n"+
                country + "," + "\n"+
                 zip +";";*/
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static void main(String[] args) {
        Address address = new Address();
        address.setCity("Abc");
        address.setCountry("IN");
        address.setZip("560076");
        address.setState("KA");
        address.setLine1("a");
        address.setLine2("b");
        System.out.println(address);
    }
}
