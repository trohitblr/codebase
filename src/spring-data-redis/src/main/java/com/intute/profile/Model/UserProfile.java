package com.intute.profile.Model;


import lombok.*;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@RedisHash("UserProfile")
public class UserProfile  implements Serializable, Diffable<UserProfile> {

    private static final long serialVersionUID = 1234590L;


    @Id
    private  String taxIdentifier;


    private  String email;


    private  String companyName;


    private  String legalName;


    private  String website;


    private Address businessAddress;


    private Address legalAddress;

    @Override
    public DiffResult diff(UserProfile userProfile) {
        return new DiffBuilder(this, userProfile, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("email", this.email, userProfile.email)
                .append("companyName", this.companyName, userProfile.companyName)
                .append("legalName", this.legalName, userProfile.legalName)
                .append("website", this.website, userProfile.website)
                .append("businessAddress", this.businessAddress, userProfile.businessAddress)
                .append("legalAddress", this.legalAddress, userProfile.legalAddress)
                .build();
    }
}
