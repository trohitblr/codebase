package com.intute.profile.Model.other;

//import com.sun.istack.NotNull;

import com.intute.profile.Model.Address;

public class UserProfile {

   // @NotNull
    private  String taxIdentifier;
    // @NotNull
    private  String email;
   // @NotNull
    private  String companyName;
  //  @NotNull
    private  String legalName;
   // @NotNull
    private  String website;

    private Address businessAddress;

    // @NotNull
    private Address legalAddress;

    public String getTaxIdentifier() {
        return taxIdentifier;
    }

    public void setTaxIdentifier(String taxIdentifier) {
        this.taxIdentifier = taxIdentifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(Address businessAddress) {
        this.businessAddress = businessAddress;
    }

    public Address getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(Address legalAddress) {
        this.legalAddress = legalAddress;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                " \"taxIdentifier:\"" + "\"" +taxIdentifier + "\"" +
                ", \"email:\"" +"\"" +email + "\"" +
                ", \"companyName:\"" +"\""+ companyName + "\""+
                ", \"legalName:\"" +"\""+ legalName + "\"" +
                ", \"website:\"" +"\""+ website + "\"" +
                ", \"businessAddress:\"" +"\""+ businessAddress +"\""+
                ", \"legalAddress:\"" +"\""+ legalAddress +"\""+
                '}';
    }

    public static void main(String[] args) {

        UserProfile up = new UserProfile();
        up.setEmail("abc.com");
        up.setCompanyName("Abc");
        up.setWebsite("abc.com");
        up.setLegalName("abc");
        up.setTaxIdentifier("123456");
        Address business = new Address();
        Address legalAddress = new Address();

        up.setLegalAddress(legalAddress);
        up.setBusinessAddress(business);
  System.out.println(up);

    }

}
