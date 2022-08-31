package LoggerLowLevel;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level){
        this.level=level;
    }

    @Override
    public void doMessage(String msg,Subject sub) {
       // System.out.println("Error : "+msg);
        String s1 = "Error : "+msg;
        //System.out.println("Debug : "+msg);
        sub.notifyObserver(2,s1);
    }
}
