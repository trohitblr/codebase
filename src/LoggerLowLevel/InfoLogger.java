package LoggerLowLevel;

public class InfoLogger extends AbstractLogger{


    public InfoLogger(int level){
        this.level=level;
    }

    @Override
    public void doMessage(String msg,Subject sub) {

        String s1 = "Info : "+msg;
        //System.out.println("Debug : "+msg);
        sub.notifyObserver(1,s1);
    }
}
