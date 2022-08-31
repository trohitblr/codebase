package com.intute.profile.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    private  String line1;
    private  String line2;
    private  String city;
    private  String state;
    private  String country;

}
