package TokenBucket;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverClass {


    public static void main(String[] args) {
        UserBucket userBucket = new UserBucket("1");

        ExecutorService es = Executors.newFixedThreadPool(12);


        for(int i=0; i<12;i++){
            // userBucket.accessApplication("1");

            es.execute(() -> userBucket.accessApplication("1"));
        }
    }



}
