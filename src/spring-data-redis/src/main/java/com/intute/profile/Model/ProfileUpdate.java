package com.intute.profile.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intute.profile.constant.ProfileStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("ProfileUpdate")
public class ProfileUpdate implements Serializable {

    private static final long serialVersionUID = 1234567L;


    @Id
    private String requestId;

    @JsonIgnore
    private UserProfile userProfile;

    private ProfileStatus status = ProfileStatus.IN_PROGRESS;

    private Date create_at = new Date();

}
