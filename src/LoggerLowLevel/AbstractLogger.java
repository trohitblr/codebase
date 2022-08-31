package LoggerLowLevel;

public abstract class AbstractLogger {

    protected int level;

    protected AbstractLogger nextChain;



    public void logMessage(int level, String msg,Subject sub){

        if(this.level == level){
            doMessage(msg,sub);
        }

        if(this.nextChain != null){
            this.nextChain.logMessage(level,msg,sub);
        }

    }


    public abstract void doMessage(String msg,Subject sub);



}
