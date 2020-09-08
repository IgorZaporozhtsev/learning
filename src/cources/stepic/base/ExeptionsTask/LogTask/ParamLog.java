package cources.stepic.base.ExeptionsTask.LogTask;

import java.util.logging.*;

public class ParamLog {

    private static void configureLogging() {
        Logger logger1 = Logger.getLogger("org.stepic.java.logging.ClassA");
        logger1.setLevel(Level.ALL);
        Logger logger2 = Logger.getLogger("org.stepic.java.logging.ClassB");
        logger2.setLevel(Level.WARNING);
        Logger logger3 = Logger.getLogger("org.stepic.java");
        logger3.setUseParentHandlers(false) ;
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger3.addHandler(handler);
        handler.setFormatter(new XMLFormatter());

    }
}
