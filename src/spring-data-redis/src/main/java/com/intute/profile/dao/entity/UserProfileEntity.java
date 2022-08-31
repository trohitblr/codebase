package com.intute.profile.dao.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intute.profile.Model.Address;
import lombok.*;


import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_profile")
public class UserProfileEntity extends BaseEntity{

    @Id
    @Column(name="user_profile_id")
    private String taxIdentifier;

    @Column(name="email")
    private  String email;

    @Column(name="org_name")
    private  String companyName;

    @Column(name="legal_name")
    private  String legalName;

    @Column(name="website")
    private  String website;

    @Column(name="business_address")
    private String businessAddress;

    @Column(name="legalAddress_address")
    private String legalAddress;

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(Address businessAddress) {
        try {
            this.businessAddress = new ObjectMapper().writeValueAsString(businessAddress);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(Address legalAddress) {
        try {
            this.legalAddress = new ObjectMapper().writeValueAsString(legalAddress);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



}
