package com.intute.profile.service;

import com.intute.profile.Model.ProfileUpdate;
import com.intute.profile.Model.UserProfile;
import com.intute.profile.constant.ProfileStatus;
import com.intute.profile.dao.entity.ProfileUpdateRequestEntity;
import com.intute.profile.dao.respository.ApproverRepository;
import com.intute.profile.dao.respository.ProfileUpdateDbRepository;
import com.intute.profile.dao.respository.redis.ProfileUpdateRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProfileUpdateServiceTest {


    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ProfileUpdateDbRepository profileUpdateDbRepository;

    @Mock
    private ProfileUpdateRepository profileUpdateRepository;

    @Mock
    private ApproverRepository approverRepository;

    @InjectMocks
    private ProfileUpdateService profileUpdateService;

    ProfileUpdateRequestEntity profileUpdateRequestEntity;
    UserProfile userProfile;
    ProfileUpdate profileUpdate;

    @BeforeEach
    void setUp() {

        profileUpdateRequestEntity = ProfileUpdateRequestEntity.builder()
                .requestId("1234")
                .changes("diff")
                .status(ProfileStatus.IN_PROGRESS)
                .build();

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
    }


    @Test
    void updateStatus() {
        profileUpdateService.updateStatus("12345",ProfileStatus.APPROVED);
        verify(profileUpdateDbRepository,times(1)).save(profileUpdateRequestEntity);
    }

    @Test
    void dbUpdateRequest() {
        profileUpdateService.dbUpdateRequest(profileUpdateRequestEntity);
        verify(profileUpdateDbRepository,times(1)).save(profileUpdateRequestEntity);
    }

    @Test
    void getProfileUpdate() {
        when(profileUpdateDbRepository.findById("1234")).thenReturn(Optional.of(profileUpdateRequestEntity));
        Assert.assertEquals(profileUpdateRequestEntity, profileUpdateService.getProfileUpdate("1234"));
    }

    @Test
    void saveUserProfileUpdateRequest() {
        when(modelMapper.map(any(), any())).thenReturn(userProfile);
        when(profileUpdateRepository.findAll()).thenReturn(null);
        Assert.assertNotNull(profileUpdateService.saveUserProfileUpdateRequest(userProfile,userProfile));
    }
}