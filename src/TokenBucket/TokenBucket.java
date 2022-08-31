package TokenBucket;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimitor{


    private int bucketCapacity;
    private AtomicLong lastUpdatedTime;
    private AtomicInteger currentCapacity;
    private int refreshRate;




    public TokenBucket(int capacity, int refreshRate){
        this.bucketCapacity=capacity;
        this.refreshRate= refreshRate;
        lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
        currentCapacity = new AtomicInteger(capacity); //.set(capacity);
    }



    @Override
    public boolean grantAccess() {
        refillBucket();
        if(currentCapacity.get() > 0){
            currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refillBucket(){
        long current_time = System.currentTimeMillis();
        int additionalToken = (int) (current_time - lastUpdatedTime.get()) / 1000 * refreshRate ;
        if(additionalToken !=0 ) {
            currentCapacity.getAndSet(Math.min(additionalToken, bucketCapacity));
            lastUpdatedTime.getAndSet(current_time);
        }
    }
}
