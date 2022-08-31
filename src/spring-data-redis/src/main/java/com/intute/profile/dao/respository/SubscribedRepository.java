package com.intute.profile.dao.respository;

import com.intute.profile.dao.entity.ProductEnrolment;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribedRepository extends JpaRepository<ProductEnrolment, String> {


    @Query(value = "select a from ProductEnrolment a where a.userProfileEntity.taxIdentifier = ?1")
    List<ProductEnrolment> findByUserProfileId(String id);
}
