package com.intute.profile.Model.other;

import com.intute.profile.constant.ProfileStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateStatusResponse {

    private Long requestId;

    private ProfileStatus status = ProfileStatus.IN_PROGRESS;

    private Date create_at = new Date();
}
