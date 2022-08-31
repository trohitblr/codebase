package com.intute.profile.dao.respository.redis;

import com.intute.profile.Model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserProfileRepository {


    public static final String HASH_KEY = "UserProfile";

    @Autowired
    private RedisTemplate template;

    @Transactional
    public UserProfile save(UserProfile userProfile){
        template.opsForHash().put(HASH_KEY,userProfile.getTaxIdentifier(),userProfile);
     return userProfile;
    }


    public UserProfile getUserProfile(String taxIdentifier){

        return (UserProfile) template.opsForHash().get(HASH_KEY,taxIdentifier);
    }

}
