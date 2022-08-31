package LeakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucket {

    Map<String, LeakyBucket> bucketMap ;

    UserBucket(String userId, int capacity){
        bucketMap = new HashMap<String, LeakyBucket>();
        bucketMap.put(userId, new LeakyBucket(10));
    }


    public void grantAccess(String userId){

        if(bucketMap.get(userId).getAccess()){
            System.out.println("Success");
        }else{
            System.out.println("Too many request");
        }

    }



}
