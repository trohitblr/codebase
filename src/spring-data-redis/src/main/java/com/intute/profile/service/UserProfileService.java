package com.intute.profile.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intute.profile.Model.Address;
import com.intute.profile.Model.ProfileUpdate;
import com.intute.profile.Model.UserProfile;
import com.intute.profile.constant.ApplicationMessage;
import com.intute.profile.dao.entity.ProfileUpdateRequestEntity;
import com.intute.profile.dao.entity.UserProfileEntity;
import com.intute.profile.exception.ApiException;
import com.intute.profile.dao.respository.redis.ProfileUpdateRepository;
import com.intute.profile.dao.respository.UserProfileEntityRepository;
import com.intute.profile.dao.respository.redis.UserProfileRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ProfileUpdateRepository profileUpdateRepository;


    @Autowired
    private UserProfileEntityRepository userProfileDbRepository;

    @Autowired
    private ProfileUpdateService profileUpdateService;

    public String createUserProfile(UserProfile userProfile){
            UserProfile cachedProfile = getUserProfileRedis(userProfile.getTaxIdentifier());
            if(cachedProfile == null){
                return profileUpdation(userProfile);
            }else{
                throw new ApiException((ApplicationMessage.ALREADY_EXIST+cachedProfile.getTaxIdentifier()));
            }
    }

    public String saveUserProfileUpdateRequest(UserProfile updatedUserProfile){
        UserProfile userProfile =  getUserProfileRedis(updatedUserProfile.getTaxIdentifier());
        return  profileUpdateService.saveUserProfileUpdateRequest(userProfile,updatedUserProfile);
    }


    public void updateProfileStatus(ProfileUpdate profileUpdate){
        profileUpdateRepository.save(profileUpdate);
    }

    public String profileUpdation(UserProfile userProfile){
        userProfileRepository.save(userProfile);
        Runnable r2 = () -> {
            dbPersister(userProfile);
        };
        new Thread(r2).start();
        return ApplicationMessage.CREATED;
    }

    @Transactional
    public void dbPersister(UserProfile userProfile){
        UserProfileEntity userProfileEntity = modelMapper.map(userProfile, UserProfileEntity.class);
        userProfileDbRepository.save(userProfileEntity);
    }


    //@Cacheable("userIdentifier")
    public UserProfile getUserProfile(String userIdentifier){
        System.out.println("Data from Cache");
        System.out.println(userProfileRepository.getUserProfile(userIdentifier));

        UserProfile userProfile = userProfileRepository.getUserProfile(userIdentifier);

        if(userProfile == null){
            UserProfileEntity userProfileEntity = getDbUserProfile(userIdentifier);
            userProfile = modelMapper.map(userProfileEntity, UserProfile.class);

            try {
                userProfile.setBusinessAddress(new ObjectMapper().readValue(userProfileEntity.getBusinessAddress(),Address.class));
                userProfile.setLegalAddress(new ObjectMapper().readValue(userProfileEntity.getLegalAddress(),Address.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("userProfile from DB");
            System.out.println(userProfile);

        }
        return userProfile;

    }

    public UserProfileEntity getDbUserProfile(String userIdentifier){
       // System.out.println("Data from Cache");
       // System.out.println(userProfileRepository.getUserProfile(id));
        Optional<UserProfileEntity> uu = userProfileDbRepository.findById(userIdentifier);
        System.out.println("Data from DB");

        System.out.println(uu.isPresent() ? uu.get() : null);
        return uu.get();

    }


    //@Cacheable("requestId")
    public ProfileUpdate getPendingRequest(String requestId){
        ProfileUpdate profileUpdate = profileUpdateRepository.getProfileUpdate(requestId);
        System.out.println("Data from cache");
        System.out.println(profileUpdate);
        if(profileUpdate == null){
            profileUpdate =profileUpdateService.getProfileUpdateRequest(requestId);
            System.out.println("Data from DB");
            System.out.println(profileUpdate);
        }

        return profileUpdate;

    }

    public UserProfile getUserProfileRedis(String id){
        System.out.println("Data from Cache");
        System.out.println(userProfileRepository.getUserProfile(id));
        return userProfileRepository.getUserProfile(id);
    }


}
