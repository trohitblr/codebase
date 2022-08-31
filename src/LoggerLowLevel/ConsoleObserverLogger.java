package LoggerLowLevel;

public class ConsoleObserverLogger implements LoggerObserver{

    @Override
    public void pushOperation(String msg) {

        System.out.println("ConsoleObserverLogger : "+msg);
    }
}
