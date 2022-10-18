package ru.vk;


public class ConsoleLogger implements Logger {
    private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("");
    @Override
    public void doLog(String message) {
        logger.info(LoggerDetails.getId() + " " + message);
    }
}
