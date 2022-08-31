package LeakyBucket;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

    public static void main(String[] args) {
        UserBucket userBucket = new UserBucket("abc",10);


        ExecutorService es = Executors.newFixedThreadPool(12);

        for(int i=0; i<12;i++){
            es.execute(() -> userBucket.grantAccess("abc"));
        }

        es.shutdown();
    }
}
