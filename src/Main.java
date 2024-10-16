import java.io.FileWriter;
import java.io.IOException;


class Logger {
    Logger() {
    }

    private static Logger logger_ = null;
    private FileWriter writer;


    public static Logger GetInstanse() {
        if (logger_ == null) {
            logger_ = new Logger();
        }
        return logger_;
    }

    public void Log(String message, LogLevel level) {
        {
            try {
                writer = new FileWriter("LogLevel");
                writer.write(message + ": " + level);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}


enum LogLevel {
    INFO, WARNING, ERROR
}

public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger();
        logger.Log("Error", LogLevel.ERROR);
        Logger.GetInstanse();

        Logger logger1 = new Logger();
        logger1.Log("INFO", LogLevel.INFO);


    }
}

