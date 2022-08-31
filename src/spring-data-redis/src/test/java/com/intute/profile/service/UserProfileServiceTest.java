package com.intute.profile.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intute.profile.Model.Address;
import com.intute.profile.Model.ProfileUpdate;
import com.intute.profile.Model.UserProfile;
import com.intute.profile.constant.ApplicationMessage;
import com.intute.profile.constant.ProfileStatus;
import com.intute.profile.dao.entity.UserProfileEntity;
import com.intute.profile.dao.respository.UserProfileEntityRepository;
import com.intute.profile.dao.respository.redis.ProfileUpdateRepository;
import com.intute.profile.dao.respository.redis.UserProfileRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ProfileUpdateRepository profileUpdateRepository;

    @Mock
    private UserProfileRepository userProfileRepository;

    @Mock
    private ProfileUpdateService profileUpdateService;

    @Mock
    private UserProfileEntityRepository userProfileDbRepository ;


    @InjectMocks
    private UserProfileService userProfileService;

    UserProfile userProfile;

    ProfileUpdate profileUpdate;

    UserProfileEntity userProfileEntity;
    @BeforeEach
    public void setup(){
        userProfile = UserProfile.builder()
                .taxIdentifier("1234")
                .email("test@gmail.com")
                .companyName("Fadatare")
                .legalName("Fadatare")
                .website("www.test.com")
                .build();
        profileUpdate = ProfileUpdate.builder()
                .requestId("12345")
                .build();

        ModelMapper modelMapper = new ModelMapper();
        userProfileEntity = modelMapper.map(userProfile, UserProfileEntity.class);
        userProfileEntity.setBusinessAddress(new Address());
        userProfileEntity.setLegalAddress(new Address());
    }

    @Test
    void createUserProfile() {
        Assert.assertEquals(ApplicationMessage.CREATED, userProfileService.createUserProfile(userProfile));
    }


    @Test
    void updateProfileStatus() {
        userProfileService.updateProfileStatus(profileUpdate);
        verify(profileUpdateRepository,times(1)).save(profileUpdate);
    }

    @Test
    void saveUserProfileupdateRequest() {
        when(profileUpdateService.saveUserProfileUpdateRequest(any(),any())).thenReturn(anyString());
        Assert.assertNotNull(userProfileService.saveUserProfileUpdateRequest(userProfile));
    }

    @Test
    void profileUpdation() {
        Assert.assertNotNull(userProfileService.profileUpdation(userProfile));
    }

    @Test
    void getUserProfile() {
        when(userProfileDbRepository.findById(any())).thenReturn(Optional.of(userProfileEntity));
        when(modelMapper.map(any(), any())).thenReturn(userProfile);
        Assert.assertEquals(userProfile, userProfileService.getUserProfile("1234"));
    }

    @Test
    void getDbUserProfile() {
        when(userProfileDbRepository.findById(any())).thenReturn(Optional.of(userProfileEntity));
        Assert.assertEquals(userProfileEntity,userProfileService.getDbUserProfile("1234"));
    }

    @Test
    void getPendingRequest() {
        when(profileUpdateRepository.getProfileUpdate(any())).thenReturn(profileUpdate);
        Assert.assertEquals(profileUpdate,userProfileService.getPendingRequest("12345"));
    }

    @Test
    void getUserProfileRedis() {
        when(userProfileRepository.getUserProfile(anyString())).thenReturn(userProfile);
        Assert.assertNotNull( userProfileService.getUserProfileRedis("1234"));

    }
}