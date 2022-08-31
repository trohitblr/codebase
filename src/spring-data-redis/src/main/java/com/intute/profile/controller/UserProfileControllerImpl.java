package com.intute.profile.controller;




import com.intute.profile.service.UserProfileService;

import com.intute.profile.Model.ProfileUpdate;
import com.intute.profile.Model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/profile/")
public class UserProfileControllerImpl implements UserProfileController  {

    @Autowired
    UserProfileService userProfileService;

    @Override
    public ResponseEntity<UserProfile> getRequestStatus(@PathVariable String userIdentifier){
        return new ResponseEntity<UserProfile>(userProfileService.getUserProfile(userIdentifier),HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<String> createUserProfile(@RequestBody UserProfile userProfile){
        return new ResponseEntity<String>(userProfileService.createUserProfile(userProfile),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateUserProfile(@RequestBody UserProfile userProfile){
        return new ResponseEntity<String>( userProfileService.saveUserProfileUpdateRequest(userProfile),HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<ProfileUpdate> getPendingRequest(@PathVariable String Id){
        return new ResponseEntity<ProfileUpdate>(userProfileService.getPendingRequest(Id),HttpStatus.OK);
    }

}