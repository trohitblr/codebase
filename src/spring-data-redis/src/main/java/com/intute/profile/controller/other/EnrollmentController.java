package com.intute.profile.controller.other;

import com.intute.profile.Model.other.EnrolledProduct;
import com.intute.profile.service.EnrolledProductService;
import com.intute.profile.dao.entity.ProductEnrolment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enroll/")
public class EnrollmentController {

    @Autowired
    EnrolledProductService enrolledProductService;

    @PostMapping
    public String saveProfile(@RequestBody EnrolledProduct enrolledProductDto){
        ProductEnrolment enrolledProduct = enrolledProductService.subscribed(enrolledProductDto);
        System.out.println(enrolledProduct);
        return "success";
    }


    @GetMapping(value = "{Id}")
    public List<EnrolledProduct> getStatus(@PathVariable String Id){
        return enrolledProductService.getSubscribedProducts(Id);
    }
}
