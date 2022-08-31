package com.intute.profile.dao.entity;


import com.intute.profile.constant.ProfileStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="approvers")
@EntityListeners(AuditingEntityListener.class)
public class ApproverEntity extends BaseEntity{

    @Id
    private String productIdentifier;

    @Column(name="current_status")
    private ProfileStatus currentStatus = ProfileStatus.REQUESTED;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_update_request_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProfileUpdateRequestEntity userUpdateRequestEntity;

}
