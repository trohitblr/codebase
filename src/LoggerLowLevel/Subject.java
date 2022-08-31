package LoggerLowLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {

    HashMap<Integer, List<LoggerObserver>> hm  = new HashMap<>();


    public void addObserver(int level, LoggerObserver loggerObserver){
        List<LoggerObserver> observers =  hm.getOrDefault(level, new ArrayList<>());
        observers.add(loggerObserver );
         hm.put(level,observers);
         System.out.println("Map :- "+hm);
    }


    public void notifyObserver(int level, String msg){



        for (Map.Entry<Integer, List<LoggerObserver>>  entry : hm.entrySet()){

            if(entry.getKey() == level){
                entry.getValue().forEach( o -> o.pushOperation(msg));
            }
        }

    }



}
