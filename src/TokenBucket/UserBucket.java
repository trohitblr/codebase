package TokenBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucket {

    private Map<String,TokenBucket> users = new HashMap<String, TokenBucket>();

    public UserBucket(String userId){
        users.put(userId, new TokenBucket(10,10));
    }

    public UserBucket(String userId, int capacity, int refreshRate){
        users.put(userId, new TokenBucket(capacity,refreshRate));
    }

    public boolean accessApplication(String userId){
     if(users.get(userId).grantAccess())  {
         System.out.println("Permisson granted");
         return true;
     }else {
         System.out.println("Permisson Denied too many request");
         return false;
     }
    }
}
