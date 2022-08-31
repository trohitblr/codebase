package com.intute.profile.Model.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnrolledProduct {

    private  String userIdentifier;
    private String productIdentifier;

     private String productName;
}
