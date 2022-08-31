package com.intute.profile.util;

import com.intute.profile.Model.UserProfile;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.UUID;

public class ProfileUtil {


public static String getUniqueId(){
    return UUID.randomUUID().toString();
}


public static String geneRateChange(UserProfile cachedUserProfile, UserProfile requestedUserProfile){
    DiffResult diff = requestedUserProfile.diff(cachedUserProfile);
    System.out.println(diff.getDiffs());
   StringBuilder sb = new StringBuilder();
    for(Diff<?> d: diff.getDiffs()) {
        sb.append( d.getFieldName()
                + "= NEW[" + d.getLeft() + "] OLD [" + d.getRight() + "]"+'\n');
    }
    return sb.toString();
}

    @CacheEvict(allEntries = true, cacheNames = { "KEYS" })
    @Scheduled(fixedDelay = 3000000)
    public void cacheEvict() {
    }

}
