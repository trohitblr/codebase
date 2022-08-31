package com.intute.profile.service;

import com.intute.profile.Model.other.EnrolledProduct;
import com.intute.profile.dao.entity.ProductEnrolment;
import com.intute.profile.dao.entity.UserProfileEntity;
import com.intute.profile.dao.respository.SubscribedRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;

import java.util.List;

@Service
public class EnrolledProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SubscribedRepository subscribedRepository;

    @Autowired
    private UserProfileService userProfileService;


    public ProductEnrolment subscribed(EnrolledProduct enrolledProductDto) {
        UserProfileEntity up =userProfileService.getDbUserProfile(enrolledProductDto.getUserIdentifier());
        ProductEnrolment enrolledProduct = modelMapper.map(enrolledProductDto, ProductEnrolment.class);
        enrolledProduct.setUserProfileEntity(up);
        return subscribedRepository.save(enrolledProduct);
    }

    public List<EnrolledProduct> getSubscribedProducts(String id) {
        List<ProductEnrolment>  ent =  subscribedRepository.findByUserProfileId(id);
        System.out.println(ent);
        Type listType = new TypeToken<List<ProductEnrolment>>(){}.getType();
        List<EnrolledProduct> enrolledProduct = modelMapper.map(ent,listType);
        return enrolledProduct;
    }
}
