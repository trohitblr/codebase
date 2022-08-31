package LoggerLowLevel;

public class LoggerManager {



    public static AbstractLogger buildChain(){
        DebugLogger debugLogger = new DebugLogger(3);
        ErrorLogger errorLogger = new ErrorLogger(2);
        InfoLogger infoLogger = new InfoLogger(1);
        infoLogger.nextChain= errorLogger;
        errorLogger.nextChain=debugLogger;
        return infoLogger;
    }

    public static Subject buildObservers(){
        Subject s = new Subject();

        FileObserverLogger fo = new FileObserverLogger();
        ConsoleObserverLogger co = new ConsoleObserverLogger();

        s.addObserver(1,fo);
        s.addObserver(1,co);
        s.addObserver(2, co);
        return s;
    }
}
