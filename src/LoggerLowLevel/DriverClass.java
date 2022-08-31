package LoggerLowLevel;

public class DriverClass {

    public static void main(String[] args) throws IllegalAccessException {
        Logger log = Logger.getInstance();

         log.info("info");

        // log.error("Error");

        //log.debug("Debug");
    }
}
