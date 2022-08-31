package com.intute.profile.controller;

import com.intute.profile.Model.ProfileUpdate;
import com.intute.profile.Model.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/default/")
public interface UserProfileController {

    @PostMapping(value = "create")
    ResponseEntity<String> createUserProfile(@RequestBody UserProfile userProfile);

    @PutMapping(value = "update")
    ResponseEntity<String> updateUserProfile(@RequestBody UserProfile userProfile);

    @GetMapping(value = "request/{userIdentifier}")
    ResponseEntity<UserProfile> getRequestStatus(@PathVariable String userIdentifier);

    @GetMapping(value = "pending/{Id}")
    ResponseEntity<ProfileUpdate> getPendingRequest(@PathVariable String Id);


}