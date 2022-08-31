package com.intute.profile.dao.respository;

import com.intute.profile.dao.entity.ApproverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApproverRepository extends JpaRepository<ApproverEntity, String> {

    List<ApproverEntity> findByProductIdentifier(String s);

    @Query(value = "select a from ApproverEntity a where a.userUpdateRequestEntity.requestId = ?1")
    List<ApproverEntity> findByRequestIdd(String id);
}
