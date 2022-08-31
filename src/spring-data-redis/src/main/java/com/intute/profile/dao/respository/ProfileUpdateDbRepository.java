package com.intute.profile.dao.respository;

import com.intute.profile.dao.entity.ProfileUpdateRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileUpdateDbRepository extends JpaRepository<ProfileUpdateRequestEntity, String> {
}
