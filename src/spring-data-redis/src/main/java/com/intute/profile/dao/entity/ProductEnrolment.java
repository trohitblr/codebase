package com.intute.profile.dao.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="product_enrolment")
public class ProductEnrolment extends BaseEntity {

    @Id
    private Long productIdentifier;

    @Column(name="product_name")
    private String productName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_profile_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserProfileEntity userProfileEntity;

}
