package LeakyBucket;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LeakyBucket implements RateLimitor {

    BlockingDeque queue =null;
    AtomicLong lastUpdateTime;
    AtomicInteger currentCapacity ;


    public LeakyBucket(int capacity){
        queue = new LinkedBlockingDeque(capacity);
        lastUpdateTime = new AtomicLong(System.currentTimeMillis());
         currentCapacity = new AtomicInteger(capacity);
    }



    @Override
    public boolean getAccess() {
        freeBucket();
        if(queue.remainingCapacity() > 0){
            queue.add(1);
            currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }

    private void freeBucket(){

        long curreTime = System.currentTimeMillis();

        int current = (int)  ((curreTime - lastUpdateTime.get())/1000);

        if(current > 0){
            while(!queue.isEmpty()){
                queue.remove(1);
            }
        }
       // System.out.println("Capacity  is :- "+queue.remainingCapacity());
        lastUpdateTime.getAndSet(curreTime);



    }
}
