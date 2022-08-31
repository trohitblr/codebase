package LoggerLowLevel;

import java.io.Serializable;

public class Logger implements Serializable {


    private static Logger instance = null;

    private static AbstractLogger logger = null;

    private static Subject sub = null;


    private Logger() throws IllegalAccessException {
        if(instance != null){
            throw new IllegalAccessException("not possible");
        }
    }

    public static Logger getInstance() throws IllegalAccessException {
        if(instance == null){
            instance = new Logger();
            logger = LoggerManager.buildChain();
            sub = LoggerManager.buildObservers();
        }
        return instance;
    }


    protected Object readResolve(){
        return instance;
    }



    private void createLog(int level , String msg){
        logger.logMessage(level, msg,sub);
    }

    public void info(String msg){

        createLog(1, msg);
        // createLog(msg);
    }

    public void error(String msg){
        createLog(2, msg);
    }

    public void debug(String msg){
        createLog(3, msg);
    }

}
