package com.intute.profile.controller.other;

import com.intute.profile.constant.ProfileStatus;
import com.intute.profile.dao.entity.ApproverEntity;

import com.intute.profile.exception.ResourceNotFoundException;
import com.intute.profile.dao.respository.ApproverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.intute.profile.constant.ApplicationMessage.NOT_FOUND;

@RestController
@RequestMapping("/approvers/")
public class ProductController {


    @Autowired
    ApproverRepository approverRepository;

    @Autowired
    com.intute.profile.service.ProfileUpdateService profileUpdateService;

    @GetMapping(value = "test/all")
    public List<ApproverEntity> getPendingRequests(){

        //  new ModelMapper();
        List<ApproverEntity> arrovers =  approverRepository.findAll();

        System.out.println("All the approvers");
        System.out.println(arrovers);

        return arrovers.stream().filter(a -> a.getCurrentStatus().equals(ProfileStatus.REQUESTED)).collect(Collectors.toList());
        // return "Hello World";
    }


    @GetMapping(value = "test/{Id}")
    public List<ApproverEntity> getRequestsById(@PathVariable String Id){

        //  new ModelMapper();
        List<ApproverEntity> arrover =  approverRepository.findByRequestIdd(Id);

        return arrover.stream().filter(a -> a.getCurrentStatus().equals(ProfileStatus.REQUESTED)).collect(Collectors.toList());

        //return arrover;
        // return "Hello World";
    }

    @GetMapping(value = "product/{Id}")
    public  List<ApproverEntity> getRequestforProduct(@PathVariable String Id){

        //  new ModelMapper();
        List<ApproverEntity> arrover =  approverRepository.findByProductIdentifier(Id);
        if(arrover == null){
            throw new ResourceNotFoundException(NOT_FOUND);
        }

        return arrover.stream().filter(a -> a.getCurrentStatus().equals(ProfileStatus.REQUESTED)).collect(Collectors.toList());
        // return "Hello World";
    }

    @PostMapping(value = "update")
    public String updateStatus(@RequestBody ApproverEntity approverEntity){
        approverRepository.save(approverEntity);

        profileUpdateService.checkForFinalUpdate(approverEntity.getUserUpdateRequestEntity().getRequestId());

        return "success";
    }

}
