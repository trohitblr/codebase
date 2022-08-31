package com.intute.profile.listner;

import com.intute.profile.Model.other.ApprovalRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApprovalListner {


    public void sentForApproval(ApprovalRequest ppprovalRequest, List<String> listners){
        System.out.println("Request has been sent to all the listner against request_id  " + ppprovalRequest.getRequestId() + " -" +listners);
        System.out.println(ppprovalRequest.toString());
    }


}
