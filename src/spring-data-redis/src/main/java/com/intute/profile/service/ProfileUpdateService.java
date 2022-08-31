package com.intute.profile.service;

import com.intute.profile.Model.ProfileUpdate;
import com.intute.profile.Model.UserProfile;
import com.intute.profile.Model.other.EnrolledProduct;
import com.intute.profile.constant.ApplicationMessage;
import com.intute.profile.constant.ProfileStatus;
import com.intute.profile.dao.entity.ApproverEntity;
import com.intute.profile.dao.entity.ProfileUpdateRequestEntity;
import com.intute.profile.exception.ApiException;
import com.intute.profile.dao.respository.ApproverRepository;
import com.intute.profile.dao.respository.ProfileUpdateDbRepository;
import com.intute.profile.dao.respository.redis.ProfileUpdateRepository;
import com.intute.profile.util.ProfileUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileUpdateService {

    @Autowired
    ProfileUpdateDbRepository profileUpdateDbRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EnrolledProductService enrolledProductService;

    @Autowired
    private ProfileUpdateRepository profileUpdateRepository;

    @Autowired
    ApproverRepository approverRepository;

    @Autowired
    UserProfileService userProfileService;

    public void dbUpdate(UserProfile cachedUserProfile, UserProfile requestedUserProfile, ProfileUpdate pu) {
        ProfileUpdateRequestEntity profileUpdateEntity = new ProfileUpdateRequestEntity();
        profileUpdateEntity.setRequestId(pu.getRequestId());
        profileUpdateEntity.setChanges(ProfileUtil.geneRateChange(cachedUserProfile,requestedUserProfile));
        List<EnrolledProduct> enrolledProductDtos = enrolledProductService.getSubscribedProducts(requestedUserProfile.getTaxIdentifier());
        Type listType = new TypeToken<List<ApproverEntity>>(){}.getType();
        List<ApproverEntity> approvers = modelMapper.map(enrolledProductDtos,listType);

        for(ApproverEntity approverEntity :approvers){
            approverEntity.setUserUpdateRequestEntity(profileUpdateEntity);
        }
        dbUpdateRequest(profileUpdateEntity);
        approverRepository.saveAll(approvers);
    }

    @CacheEvict(value = "requestId", allEntries=true)
    public void checkForFinalUpdate(String requestId){

       boolean flag = approverRepository.findByRequestIdd(requestId).stream()
                .anyMatch( a -> (a.getCurrentStatus().equals(ProfileStatus.REQUESTED) || a.getCurrentStatus().equals(ProfileStatus.REJECT)));
     if(!flag) {
       updateStatus(requestId, ProfileStatus.APPROVED);
     }else if(approverRepository.findByRequestIdd(requestId).stream()
             .anyMatch( a -> (a.getCurrentStatus().equals(ProfileStatus.REJECT)))){
         updateStatus(requestId, ProfileStatus.REJECT);
     }
    }

    public void updateStatus(String requestId, ProfileStatus status){
        ProfileUpdate profileUpdate = userProfileService.getPendingRequest(requestId);
        profileUpdate.setStatus(status);
        UserProfile userProfile  = profileUpdate.getUserProfile();

        System.out.println("userProfile");
        System.out.println(userProfile);
        if(!status.equals(ProfileStatus.REJECT)) {
            userProfileService.profileUpdation(userProfile);
        }
        userProfileService.updateProfileStatus(profileUpdate);
        System.out.println("profileUpdate");
        System.out.println(profileUpdate);
        ProfileUpdateRequestEntity profileUpdateRequestEntity =  getProfileUpdate(requestId);
        profileUpdateRequestEntity.setStatus(status);
        System.out.println("updated profileUpdateRequestEntity");
        System.out.println(profileUpdateRequestEntity);
        dbUpdateRequest(profileUpdateRequestEntity);


    }

    @Transactional
    public void dbUpdateRequest(ProfileUpdateRequestEntity profileUpdateRequestEntity) {
        profileUpdateDbRepository.save(profileUpdateRequestEntity);
    }


    public ProfileUpdateRequestEntity getProfileUpdate(String requestId) {
        return profileUpdateDbRepository.findById(requestId).get();
    }

    public ProfileUpdate getProfileUpdateRequest(String requestId){
        return modelMapper.map(getProfileUpdate(requestId), ProfileUpdate.class);
    }

    public String saveUserProfileUpdateRequest(UserProfile cachedUserProfile, UserProfile requestedUserProfile){

        List<ProfileUpdate> profileInprogress = profileUpdateRepository.findAll();
        System.out.println("profileInprogress");
        System.out.println(profileInprogress);

        if(profileInprogress != null){
           Optional<ProfileUpdate>   profileUpdate =profileInprogress.stream().filter(pip -> pip.getUserProfile().getTaxIdentifier().equals(requestedUserProfile.getTaxIdentifier())
                    && pip.getStatus().equals(ProfileStatus.IN_PROGRESS)  ).findFirst();
           if(profileUpdate.isPresent()){
               throw new ApiException(ApplicationMessage.ALREADY_EXIST + "with Request id : "+profileUpdate.get().getRequestId());
           }
        }

        ProfileUpdate profileUpdate = new ProfileUpdate();
        profileUpdate.setRequestId(ProfileUtil.getUniqueId());
        profileUpdate.setUserProfile(modelMapper.map(requestedUserProfile, UserProfile.class));
        profileUpdateRepository.save(profileUpdate);
        Runnable r2 = () -> {
            dbUpdate(cachedUserProfile,requestedUserProfile,profileUpdate);
        };
        new Thread(r2).start();
        return (ApplicationMessage.ACCEPTED +profileUpdate.getRequestId());
    }

}
