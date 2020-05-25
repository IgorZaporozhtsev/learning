package cources.stepic.base.tutorial.loging;

import java.util.logging.Logger;

public class ConfigLogTest {
    private static Logger logger = Logger.getLogger(ConfigLogTest.class.getName());

    public static void main(String[] args) {
        logger.info("my first message in log");
        logger.finest("finest");
    }


}
