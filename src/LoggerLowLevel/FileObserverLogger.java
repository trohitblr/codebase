package LoggerLowLevel;

public class FileObserverLogger implements LoggerObserver{

    @Override
    public void pushOperation(String msg) {

        System.out.println("FileObserverLogger : "+msg);

    }
}
