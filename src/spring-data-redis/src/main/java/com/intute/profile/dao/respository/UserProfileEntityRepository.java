package com.intute.profile.dao.respository;


import com.intute.profile.dao.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileEntityRepository extends JpaRepository<UserProfileEntity, String> {


}
