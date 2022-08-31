package com.intute.profile.dao.entity;


import com.intute.profile.constant.ProfileStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="profile_update")
@EntityListeners(AuditingEntityListener.class)
public class ProfileUpdateRequestEntity extends BaseEntity{

    @Id
    @Column(name="profile_update_request_id")
    private String requestId;

    @Column(name="status")
    private ProfileStatus status = ProfileStatus.IN_PROGRESS;


    @Column(name="changes",columnDefinition = "TEXT")
    private String changes;

}
