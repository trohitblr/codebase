package com.intute.profile.dao.respository.redis;

import com.intute.profile.Model.ProfileUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileUpdateRepository {

    public static final String HASH_KEY = "ProfileUpdate";

    @Autowired
    private RedisTemplate template;

    public ProfileUpdate save(ProfileUpdate profileUpdate){
        template.opsForHash().put(HASH_KEY,profileUpdate.getRequestId(),profileUpdate);
        return profileUpdate;
    }


    public ProfileUpdate getProfileUpdate(String requestId){

        return (ProfileUpdate) template.opsForHash().get(HASH_KEY,requestId);
    }

    public List<ProfileUpdate> findAll(){
        return template.opsForHash().values("ProfileUpdate");
    }
}
