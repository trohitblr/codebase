package LoggerLowLevel;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level){
        this.level=level;
    }

    @Override
    public void doMessage(String msg,Subject sub) {
        String s1 = "Debug : "+msg;
        //System.out.println("Debug : "+msg);
        sub.notifyObserver(3,s1);
    }
}
