import java.util.logging.*;

class Main {
    //Stepik code: start
    public static void configureLogging() {
        // your implementation here
        Logger loggerClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerClassA.setLevel(Level.ALL);

        Logger loggerClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerClassB.setLevel(Level.WARNING);
    }
//Stepik code: end
}
